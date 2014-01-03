package de.fhdw.ify208.ticketmaster.webapp.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for countryDTO complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="countryDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{de.fhdw.ify208.ticketmaster.common.model}typeCodeDTO">
 *       &lt;sequence>
 *         &lt;element name="isoCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "countryDTO", propOrder = {
        "isoCode"
})
public class CountryDTO
        extends TypeCodeDTO {

    protected String isoCode;

    /**
     * Gets the value of the isoCode property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getIsoCode() {
        return isoCode;
    }

    /**
     * Sets the value of the isoCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIsoCode(String value) {
        this.isoCode = value;
    }

}
