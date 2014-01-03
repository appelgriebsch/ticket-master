package de.fhdw.ify208.ticketmaster.webapp.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for baseDTO complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="baseDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="returncode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "baseDTO", propOrder = {
        "message",
        "returncode"
})
@XmlSeeAlso({
        CustomerDTO.class,
        TypeCodeDTO.class,
        ArtistListDTO.class,
        OrderDTO.class,
        AddressDTO.class,
        EventDTO.class,
        TypeCodeListDTO.class,
        OrderListDTO.class,
        RatingDTO.class,
        ArtistDTO.class,
        RatingListDTO.class
})
public class BaseDTO {

    protected String message;
    protected int returncode;

    /**
     * Gets the value of the message property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the returncode property.
     */
    public int getReturncode() {
        return returncode;
    }

    /**
     * Sets the value of the returncode property.
     */
    public void setReturncode(int value) {
        this.returncode = value;
    }

}
