package de.fhdw.ify208.ticketmaster.webapp.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RateEvent complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="RateEvent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{de.fhdw.ify208.ticketmaster.common.model}event" minOccurs="0"/>
 *         &lt;element ref="{de.fhdw.ify208.ticketmaster.common.model}customer" minOccurs="0"/>
 *         &lt;element name="rating" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RateEvent", propOrder = {
        "event",
        "customer",
        "rating",
        "comment"
})
public class RateEvent {

    protected EventDTO event;
    protected CustomerDTO customer;
    protected double rating;
    protected String comment;

    /**
     * Gets the value of the event property.
     *
     * @return possible object is
     *         {@link EventDTO }
     */
    public EventDTO getEvent() {
        return event;
    }

    /**
     * Sets the value of the event property.
     *
     * @param value allowed object is
     *              {@link EventDTO }
     */
    public void setEvent(EventDTO value) {
        this.event = value;
    }

    /**
     * Gets the value of the customer property.
     *
     * @return possible object is
     *         {@link CustomerDTO }
     */
    public CustomerDTO getCustomer() {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     *
     * @param value allowed object is
     *              {@link CustomerDTO }
     */
    public void setCustomer(CustomerDTO value) {
        this.customer = value;
    }

    /**
     * Gets the value of the rating property.
     */
    public double getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     */
    public void setRating(double value) {
        this.rating = value;
    }

    /**
     * Gets the value of the comment property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setComment(String value) {
        this.comment = value;
    }

}
