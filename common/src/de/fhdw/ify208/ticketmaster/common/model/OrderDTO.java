/**
 *
 */
package de.fhdw.ify208.ticketmaster.common.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * @author appelgriebsch
 */
@XmlRootElement(name = "order")
public class OrderDTO extends BaseDTO {

    /**
     * the id of the order
     */
    private long _orderID;

    /**
     * the event that is going to be used for ordering
     */
    private EventDTO _theEvent;

    /**
     * the customer that does the ordering
     */
    private CustomerDTO _theCustomer;

    /**
     * when was the order placed
     */
    private Date _orderDate;

    /**
     * the current status of the order
     */
    private TypeCodeDTO _orderStatus;

    /**
     * the shipping address for this order
     */
    private AddressDTO _shippingAddress;

    /**
     * the billing address for this order
     */
    private AddressDTO _billingAddress;

    /**
     * the nmbr of tickets that has been ordered
     */
    private int _orderQuantity;

    /**
     * @return the id
     */
    public long getid() {
        return _orderID;
    }

    /**
     * @param id the _theOrder to set
     */
    public void setid(long orderID) {
        this._orderID = orderID;
    }

    /**
     * @return the _theEvent
     */
    public EventDTO getEvent() {
        return _theEvent;
    }

    /**
     * @param _theEvent the _theEvent to set
     */
    public void setEvent(EventDTO _theEvent) {
        this._theEvent = _theEvent;
    }

    /**
     * @return the _theCustomer
     */
    public CustomerDTO getCustomer() {
        return _theCustomer;
    }

    /**
     * @param _theCustomer the _theCustomer to set
     */
    public void setCustomer(CustomerDTO _theCustomer) {
        this._theCustomer = _theCustomer;
    }

    /**
     * @return the _orderDate
     */
    public Date getOrderDate() {
        return _orderDate;
    }

    /**
     * @param _orderDate the _orderDate to set
     */
    public void setOrderDate(Date _orderDate) {
        this._orderDate = _orderDate;
    }

    /**
     * @return the _orderStatus
     */
    public TypeCodeDTO getOrderStatus() {
        return _orderStatus;
    }

    /**
     * @param _orderStatus the _orderStatus to set
     */
    public void setOrderStatus(TypeCodeDTO _orderStatus) {
        this._orderStatus = _orderStatus;
    }

    /**
     * @return the _shippingAddress
     */
    public AddressDTO getShippingAddress() {
        return _shippingAddress;
    }

    /**
     * @param _shippingAddress the _shippingAddress to set
     */
    public void setShippingAddress(AddressDTO _shippingAddress) {
        this._shippingAddress = _shippingAddress;
    }

    /**
     * @return the _billingAddress
     */
    public AddressDTO getBillingAddress() {
        return _billingAddress;
    }

    /**
     * @param _billingAddress the _billingAddress to set
     */
    public void setBillingAddress(AddressDTO _billingAddress) {
        this._billingAddress = _billingAddress;
    }

    /**
     * @return the _orderQuantity
     */
    public int getOrderQuantity() {
        return _orderQuantity;
    }

    /**
     * @param _orderQuantity the _orderQuantity to set
     */
    public void setOrderQuantity(int _orderQuantity) {
        this._orderQuantity = _orderQuantity;
    }
}
