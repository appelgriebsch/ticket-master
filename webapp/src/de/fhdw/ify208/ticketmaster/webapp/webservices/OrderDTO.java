package de.fhdw.ify208.ticketmaster.webapp.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for orderDTO complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="orderDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{de.fhdw.ify208.ticketmaster.common.model}baseDTO">
 *       &lt;sequence>
 *         &lt;element name="billingAddress" type="{de.fhdw.ify208.ticketmaster.common.model}addressDTO" minOccurs="0"/>
 *         &lt;element ref="{de.fhdw.ify208.ticketmaster.common.model}customer" minOccurs="0"/>
 *         &lt;element ref="{de.fhdw.ify208.ticketmaster.common.model}event" minOccurs="0"/>
 *         &lt;element name="orderDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="orderQuantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="orderStatus" type="{de.fhdw.ify208.ticketmaster.common.model}typeCodeDTO" minOccurs="0"/>
 *         &lt;element name="shippingAddress" type="{de.fhdw.ify208.ticketmaster.common.model}addressDTO" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderDTO", propOrder = {
        "billingAddress",
        "customer",
        "event",
        "orderDate",
        "orderQuantity",
        "orderStatus",
        "shippingAddress",
        "id"
})
public class OrderDTO
        extends BaseDTO {

    protected AddressDTO billingAddress;
    protected CustomerDTO customer;
    protected EventDTO event;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar orderDate;
    protected int orderQuantity;
    protected TypeCodeDTO orderStatus;
    protected AddressDTO shippingAddress;
    protected long id;

    /**
     * Gets the value of the billingAddress property.
     *
     * @return possible object is
     *         {@link AddressDTO }
     */
    public AddressDTO getBillingAddress() {
        return billingAddress;
    }

    /**
     * Sets the value of the billingAddress property.
     *
     * @param value allowed object is
     *              {@link AddressDTO }
     */
    public void setBillingAddress(AddressDTO value) {
        this.billingAddress = value;
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
     * Gets the value of the orderDate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getOrderDate() {
        return orderDate;
    }

    /**
     * Sets the value of the orderDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setOrderDate(XMLGregorianCalendar value) {
        this.orderDate = value;
    }

    /**
     * Gets the value of the orderQuantity property.
     */
    public int getOrderQuantity() {
        return orderQuantity;
    }

    /**
     * Sets the value of the orderQuantity property.
     */
    public void setOrderQuantity(int value) {
        this.orderQuantity = value;
    }

    /**
     * Gets the value of the orderStatus property.
     *
     * @return possible object is
     *         {@link TypeCodeDTO }
     */
    public TypeCodeDTO getOrderStatus() {
        return orderStatus;
    }

    /**
     * Sets the value of the orderStatus property.
     *
     * @param value allowed object is
     *              {@link TypeCodeDTO }
     */
    public void setOrderStatus(TypeCodeDTO value) {
        this.orderStatus = value;
    }

    /**
     * Gets the value of the shippingAddress property.
     *
     * @return possible object is
     *         {@link AddressDTO }
     */
    public AddressDTO getShippingAddress() {
        return shippingAddress;
    }

    /**
     * Sets the value of the shippingAddress property.
     *
     * @param value allowed object is
     *              {@link AddressDTO }
     */
    public void setShippingAddress(AddressDTO value) {
        this.shippingAddress = value;
    }

    /**
     * Gets the value of the id property.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     */
    public void setId(long value) {
        this.id = value;
    }

}
