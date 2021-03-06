package de.fhdw.ify208.ticketmaster.webapp.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetEventsByLocation complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GetEventsByLocation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cityName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetEventsByLocation", propOrder = {
        "cityName"
})
public class GetEventsByLocation {

    protected String cityName;

    /**
     * Gets the value of the cityName property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Sets the value of the cityName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCityName(String value) {
        this.cityName = value;
    }

}
