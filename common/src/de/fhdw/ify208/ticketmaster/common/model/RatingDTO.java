/**
 *
 */
package de.fhdw.ify208.ticketmaster.common.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * @author appelgriebsch
 */
@XmlRootElement(name = "rating")
public class RatingDTO extends BaseDTO {

    /**
     * the user that has made the rating
     */
    private String _userName;

    /**
     * the rating of the user (out of 5)
     */
    private double _rating;

    /**
     * an optional comment from the user
     */
    private String _comment;

    /**
     * the timestamp the user has made the rating
     */
    private Date _time;

    /**
     * @return the _userName
     */
    public String getUserName() {
        return _userName;
    }

    /**
     * @param _userName the _userName to set
     */
    public void setUserName(String _userName) {
        this._userName = _userName;
    }

    /**
     * @return the _rating
     */
    public double getRating() {
        return _rating;
    }

    /**
     * @param _rating the _rating to set
     */
    public void setRating(double _rating) {
        this._rating = _rating;
    }

    /**
     * @return the _comment
     */
    public String getComment() {
        return _comment;
    }

    /**
     * @param _comment the _comment to set
     */
    public void setComment(String _comment) {
        this._comment = _comment;
    }

    /**
     * @return the _time
     */
    public Date getTimestamp() {
        return _time;
    }

    /**
     * @param _time the _time to set
     */
    public void setTimestamp(Date _time) {
        this._time = _time;
    }
}
