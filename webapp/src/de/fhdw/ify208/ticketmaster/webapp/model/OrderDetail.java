/**
 *  the model classes for the web application (MVC pattern)
 */

package de.fhdw.ify208.ticketmaster.webapp.model;

import de.fhdw.ify208.ticketmaster.webapp.webservices.OrderDTO;
import de.fhdw.ify208.ticketmaster.webapp.webservices.RatingDTO;
import de.fhdw.ify208.ticketmaster.webapp.webservices.TypeCodeDTO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Date;

/**
 * a model class holding the order information of the web app
 * @author appelgriebsch
 */
@ManagedBean
@SessionScoped
public class OrderDetail {

    /**
     *  the order information from the web service
     */
    private OrderDTO _order = null;

    /**
     *  the rating of the event belonging to this order and customer
     */
    private RatingDTO _eventRating = null;

    /**
     * constructs a new order object with the given order information from the web service
     *
     * @param orderDTO the order information from the web service
     */
    public OrderDetail(OrderDTO orderDTO) {

        _order = orderDTO;
        _eventRating = findRating();
    }

    /**
     * provides the user profile for this order
     *
     * @return the user profile for this order
     */
    public UserProfile getCustomerProfile() {

        return new UserProfile(_order.getCustomer());
    }

    /**
     * provides the event detail of this order
     *
     * @return the event detail of this order
     */
    public EventDetail getEventDetail() {

        return new EventDetail(_order.getEvent());
    }

    /**
     * provides the raw order data from the web service
     *
     * @return the raw order data from the web service
     */
    public OrderDTO getOrderData() {

        return _order;
    }

    /**
     * a convenience operation to check if the order is voidable (can be canceled after booking)
     *
     * @return TRUE/FALSE
     */
    public boolean isVoidable() {

        TypeCodeDTO status = _order.getOrderStatus();

        return (status != null &&
                !status.getName().equals("Voided") &&
                !status.getName().equals("Completed"));
    }

    /**
     * a convenience operation to check if the order can be rated (order must be completed, event date less than current date)
     *
     * @return TRUE/FALSE
     */
    public boolean isRatingAllowed() {

        EventDetail evt = getEventDetail();
        TypeCodeDTO orderStatus = _order.getOrderStatus();

        Date today = new Date();
        Date evtDate = evt.getEventData().getStartDate().toGregorianCalendar().getTime();

        return (evtDate.before(today) &&
                orderStatus.getName().equals("Completed"));
    }

    /**
     * a convenience operation to check if the order has been already rated
     *
     * @return TRUE/FALSE
     */
    public boolean isAlreadyRated() {

        return (isRatingAllowed() &&
                (_eventRating != null));
    }

    /**
     * provides the rating of the event for this order and customer (if available)
     *
     * @return the rating for the event of this order and customer
     */
    public RatingDTO getEventRating() {
        
        return _eventRating;
    }

    /**
     * internal operation to check all ratings on an event for the customer information of this order
     *
     * @return the rating of the event for the current order and customer (if available)
     */
    private RatingDTO findRating() {

        RatingDTO result = null;

        for (RatingDTO r : getEventDetail().getEventData().getRatings().getRating()) {

            if (r.getUserName().equals(_order.getCustomer().getUserName())) {

                result = r;
                break;
            }
        }

        return result;
    }
}
