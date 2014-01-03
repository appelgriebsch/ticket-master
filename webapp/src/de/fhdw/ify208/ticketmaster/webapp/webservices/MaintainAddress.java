package de.fhdw.ify208.ticketmaster.webapp.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MaintainAddress complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="MaintainAddress">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{de.fhdw.ify208.ticketmaster.common.model}customer" minOccurs="0"/>
 *         &lt;element ref="{de.fhdw.ify208.ticketmaster.common.model}address" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MaintainAddress", propOrder = {
        "customer",
        "address"
})
public class MaintainAddress {

    protected CustomerDTO customer;
    protected AddressDTO address;

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
     * Gets the value of the address property.
     *
     * @return possible object is
     *         {@link AddressDTO }
     */
    public AddressDTO getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     *
     * @param value allowed object is
     *              {@link AddressDTO }
     */
    public void setAddress(AddressDTO value) {
        this.address = value;
    }

}
