/**
 *  the model classes for the web application (MVC pattern)
 */

package de.fhdw.ify208.ticketmaster.webapp.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Date;

/**
 *  a model class for holding the rating information of an event
 */
@ManagedBean
@SessionScoped
public class RatingDetail {

    /**
     *  the event belonging to this rating
     */
    private EventDetail _event = null;

    /**
     * the user profile belonging to this rating
     */
    private UserProfile _user = null;

    /**
     *  the comment for this rating
     */
    private String _comment = null;

    /**
     * the value for this rating
     */
    private double _rating = 0.0;

    /**
     *   the date/time this rating takes place
     */
    private Date _date = new Date();

    /**
     * constructs a new rating detail object for the given user and event
     *
     * @param user the user profile this rating is valid for
     * @param event the event information this rating is valid for
     */
    public RatingDetail(UserProfile user, EventDetail event) {

        _event = event;
        _user = user;
    }

    /**
     * provides access to the event information of this rating
     *
     * @return the event information of this rating
     */
    public EventDetail getEvent() {

        return _event;
    }

    /**
     * provides access to the user profile for this rating
     *
     * @return the user profile for this rating
     */
    public UserProfile getUser() {

        return _user;
    }

    /**
     * provides access to the date/time of this rating
     *
     * @return the date/time of this rating
     */
    public Date getDate() {

        return _date;
    }

    /**
     * provides access to the comment of this rating
     *
     * @return the comment of this rating
     */
    public String getComment() {

        return _comment;
    }

    /**
     * sets a new comment for this rating
     *
     * @param comment the new comment to store
     */
    public void setComment(String comment) {

        _comment = comment;
    }

    /**
     * provides access to the rating value
     *
     * @return   the rating value
     */
    public double getRating() {

        return _rating;
    }

    /**
     * sets a new rating value
     *
     * @param rating the value for this rating
     */
    public void setRating(double rating) {

        _rating = rating;
    }
}
