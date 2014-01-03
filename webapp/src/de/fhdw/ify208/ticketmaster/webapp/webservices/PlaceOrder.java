package de.fhdw.ify208.ticketmaster.webapp.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PlaceOrder complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="PlaceOrder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{de.fhdw.ify208.ticketmaster.common.model}event" minOccurs="0"/>
 *         &lt;element ref="{de.fhdw.ify208.ticketmaster.common.model}customer" minOccurs="0"/>
 *         &lt;element name="shippingTo" type="{de.fhdw.ify208.ticketmaster.common.model}addressDTO" minOccurs="0"/>
 *         &lt;element name="billingTo" type="{de.fhdw.ify208.ticketmaster.common.model}addressDTO" minOccurs="0"/>
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlaceOrder", propOrder = {
        "event",
        "customer",
        "shippingTo",
        "billingTo",
        "quantity"
})
public class PlaceOrder {

    protected EventDTO event;
    protected CustomerDTO customer;
    protected AddressDTO shippingTo;
    protected AddressDTO billingTo;
    protected int quantity;

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
     * Gets the value of the shippingTo property.
     *
     * @return possible object is
     *         {@link AddressDTO }
     */
    public AddressDTO getShippingTo() {
        return shippingTo;
    }

    /**
     * Sets the value of the shippingTo property.
     *
     * @param value allowed object is
     *              {@link AddressDTO }
     */
    public void setShippingTo(AddressDTO value) {
        this.shippingTo = value;
    }

    /**
     * Gets the value of the billingTo property.
     *
     * @return possible object is
     *         {@link AddressDTO }
     */
    public AddressDTO getBillingTo() {
        return billingTo;
    }

    /**
     * Sets the value of the billingTo property.
     *
     * @param value allowed object is
     *              {@link AddressDTO }
     */
    public void setBillingTo(AddressDTO value) {
        this.billingTo = value;
    }

    /**
     * Gets the value of the quantity property.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     */
    public void setQuantity(int value) {
        this.quantity = value;
    }

}
