/**
 *
 */
package de.fhdw.ify208.ticketmaster.service;

import de.fhdw.ify208.ticketmaster.common.model.*;
import de.fhdw.ify208.ticketmaster.model.OrderManager;

import javax.jws.WebService;

/**
 * @author appelgriebsch
 */
@WebService(endpointInterface = "de.fhdw.ify208.ticketmaster.common.model.IOrderService")
public class OrderServiceImpl implements IOrderService {

    private OrderManager orderManager = OrderManager.getInstance();

    /* (non-Javadoc)
      * @see de.fhdw.ify208.ticketmaster.common.model.IOrderService#getCustomerOrders(de.fhdw.ify208.ticketmaster.common.model.Customer)
      */
    @Override
    public OrderListDTO GetCustomerOrders(CustomerDTO theCustomer) {
        return orderManager.getCustomerOrders(theCustomer);
    }

    /* (non-Javadoc)
      * @see de.fhdw.ify208.ticketmaster.common.model.IOrderService#PlaceOrder(de.fhdw.ify208.ticketmaster.common.model.Event, de.fhdw.ify208.ticketmaster.common.model.Customer, de.fhdw.ify208.ticketmaster.common.model.Address, de.fhdw.ify208.ticketmaster.common.model.Address, int)
      */
    @Override
    public OrderDTO PlaceOrder(EventDTO theEvent, CustomerDTO theCustomer,
                               AddressDTO shippingAddress, AddressDTO BillingAddress, int quantity) {
        return orderManager.placeOrder(theEvent, theCustomer, shippingAddress, BillingAddress, quantity);
    }

    /* (non-Javadoc)
      * @see de.fhdw.ify208.ticketmaster.common.model.IOrderService#CancelOrder(de.fhdw.ify208.ticketmaster.common.model.Order)
      */
    @Override
    public BaseDTO CancelOrder(OrderDTO theOrder) {
        // TODO Auto-generated method stub
        return orderManager.cancelOrder(theOrder);
    }

    /* (non-Javadoc)
      * @see de.fhdw.ify208.ticketmaster.common.model.IOrderService#GetOrderStatuses()
      */
    @Override
    public TypeCodeListDTO GetOrderStatuses() {
        return orderManager.getOrderStatuses();
    }

}
