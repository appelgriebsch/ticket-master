package de.fhdw.ify208.ticketmaster.webapp.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetCustomerOrdersResponse complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GetCustomerOrdersResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{de.fhdw.ify208.ticketmaster.common.model}orderListDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCustomerOrdersResponse", propOrder = {
        "_return"
})
public class GetCustomerOrdersResponse {

    @XmlElement(name = "return")
    protected OrderListDTO _return;

    /**
     * Gets the value of the return property.
     *
     * @return possible object is
     *         {@link OrderListDTO }
     */
    public OrderListDTO getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     *
     * @param value allowed object is
     *              {@link OrderListDTO }
     */
    public void setReturn(OrderListDTO value) {
        this._return = value;
    }

}
