/**
 *  the controller classes for the web application (MVC pattern)
 */
package de.fhdw.ify208.ticketmaster.webapp.controller;

import de.fhdw.ify208.ticketmaster.webapp.model.EventDetail;
import de.fhdw.ify208.ticketmaster.webapp.model.OrderDetail;
import de.fhdw.ify208.ticketmaster.webapp.model.UserProfile;
import de.fhdw.ify208.ticketmaster.webapp.webservices.*;
import org.primefaces.context.RequestContext;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * the order controller dealing with booking and cancellation of orders
 * @author appelgriebsch
 */

@ManagedBean
@SessionScoped
public class OrderController implements Serializable {

    /**
     *  a reference to the order web service
     */
    private OrderServiceImplService _orderWebService = null;

    /**
     *   the details of the current running order
     */
    private OrderDetail _newOrder = null;

    /**
     *  creates a new order controller and connects to the local order web service
     */
    public OrderController() {

        try {

            _orderWebService = new OrderServiceImplService(
                    new URL(String.format("http://%s/ticketmaster/orderservice?wsdl", SystemController.getHost())),
                    new QName("http://service.ticketmaster.ify208.fhdw.de/", "OrderServiceImplService"));

        } catch (MalformedURLException e) {
        }
    }

    /**
     * finish the current order in progress and stores it in the system
     *
     * @param actEvent contains information about the event that triggers the execution of this operation
     */
    public void BookEvent(ActionEvent actEvent) {

        RequestContext ctx = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        boolean bIsEventBooked = false;

        try {

            OrderDTO order = _orderWebService.getOrderServiceImplPort().placeOrder(
                    getCurrentOrder().getEventDetail().getEventData(),
                    getCurrentOrder().getCustomerProfile().getProfileData(),
                    getCurrentOrder().getOrderData().getShippingAddress(),
                    getCurrentOrder().getOrderData().getBillingAddress(),
                    getCurrentOrder().getOrderData().getOrderQuantity()
            );

            if (order.getReturncode() == 0) {

                bIsEventBooked = true;
                _newOrder = null;

                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Order accepted",
                        String.format("Order created: %s", order.getId()));                
            } else {

                bIsEventBooked = false;

                msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Order rejected",
                        order.getMessage());
            }

        } catch (Exception ex) {

            bIsEventBooked = false;

            msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error communicating with order web service!",
                    String.format("Unable to access order web service at %s: %s",
                            _orderWebService.getWSDLDocumentLocation(),
                            ex.getMessage()));
        }

        if (msg != null)
            FacesContext.getCurrentInstance().addMessage(null, msg);

        ctx.addCallbackParam("booked", bIsEventBooked);

        SystemController.redirectUrl(ctx, "index");
    }

    /**
     * cancel the booking of the current order and reset the internal state
     *
     * @param actEvent contains information about the event that triggers the execution of this operation
     */
    public void CancelBooking(ActionEvent actEvent) {

        RequestContext ctx = RequestContext.getCurrentInstance();

        _newOrder = null;

        SystemController.redirectUrl(ctx, "index");
    }

    /**
     * gets a list of orders that a specific customer has been booked in the system
     *
     * @param customer the customer who's orders should be returned
     * @return  a list of order details for the customer
     */
    public List<OrderDetail> getCustomerOrders(CustomerDTO customer) {

        List<OrderDetail> result = new ArrayList<OrderDetail>();

        OrderListDTO orders = _orderWebService.getOrderServiceImplPort().getCustomerOrders(customer);

        if ((orders != null) &&
                (orders.getReturncode() == 0)) {

            for (OrderDTO o : orders.getOrder())
                result.add(new OrderDetail(o));
        }

        return result;
    }

    /**
     *  prepares a new order configuration for the customer and event given
     *
     * @param userProfile the customer who is going to place the order
     * @param eventDetail the event for which the order is placed
     */
    public void PrepareNewOrder(UserProfile userProfile, EventDetail eventDetail) {

        RequestContext ctx = RequestContext.getCurrentInstance();
        GregorianCalendar calendar = (GregorianCalendar) GregorianCalendar.getInstance();
        calendar.setTime(new Date());

        XMLGregorianCalendar xCal = null;

        try {

            DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);

        } catch (DatatypeConfigurationException e) {

        }

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setCustomer(userProfile.getProfileData());
        orderDTO.setEvent(eventDetail.getEventData());
        orderDTO.setBillingAddress(userProfile.getBillingAddress());
        orderDTO.setShippingAddress(userProfile.getShippingAddress());
        orderDTO.setOrderDate(xCal);

        _newOrder = new OrderDetail(orderDTO);

        SystemController.redirectUrl(ctx, "checkout");
    }

    /**
     * cancels an order that has been booked as long as it's state has not been switched to COMPLETED
     *
     * @param order the order which should be canceled
     */
    public void CancelOrder(OrderDetail order) {

        RequestContext ctx = RequestContext.getCurrentInstance();
        FacesMessage msg = null;

        try {

            BaseDTO result = _orderWebService.getOrderServiceImplPort().cancelOrder(order.getOrderData());

            if (result.getReturncode() == 0) {

                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Order cancelled",
                        String.format("Your order no. %s has been cancelled successfully!", order.getOrderData().getId()));
            } else {

                msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Order not cancelled", result.getMessage());
            }

        } catch (Exception ex) {

            msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error communicating with event web service!",
                    String.format("Unable to access event web service at %s: %s",
                            _orderWebService.getWSDLDocumentLocation(),
                            ex.getMessage()));
        }

        if (msg != null)
            FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     * provides access to the current order that is in progress
     *
     * @return the order details of the currently prepared order
     */
    public OrderDetail getCurrentOrder() {

        return _newOrder;
    }
}
