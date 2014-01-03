package de.fhdw.ify208.ticketmaster.webapp.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addressDTO complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="addressDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{de.fhdw.ify208.ticketmaster.common.model}baseDTO">
 *       &lt;sequence>
 *         &lt;element name="addressLine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addressType" type="{de.fhdw.ify208.ticketmaster.common.model}typeCodeDTO" minOccurs="0"/>
 *         &lt;element name="cityName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{de.fhdw.ify208.ticketmaster.common.model}country" minOccurs="0"/>
 *         &lt;element name="district" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="streetName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="zipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addressDTO", propOrder = {
        "addressLine",
        "addressType",
        "cityName",
        "country",
        "district",
        "streetName",
        "zipCode",
        "id"
})
public class AddressDTO
        extends BaseDTO {

    protected String addressLine;
    protected TypeCodeDTO addressType;
    protected String cityName;
    protected CountryDTO country;
    protected String district;
    protected String streetName;
    protected String zipCode;
    protected Long id;

    /**
     * Gets the value of the addressLine property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getAddressLine() {
        return addressLine;
    }

    /**
     * Sets the value of the addressLine property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAddressLine(String value) {
        this.addressLine = value;
    }

    /**
     * Gets the value of the addressType property.
     *
     * @return possible object is
     *         {@link TypeCodeDTO }
     */
    public TypeCodeDTO getAddressType() {
        return addressType;
    }

    /**
     * Sets the value of the addressType property.
     *
     * @param value allowed object is
     *              {@link TypeCodeDTO }
     */
    public void setAddressType(TypeCodeDTO value) {
        this.addressType = value;
    }

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

    /**
     * Gets the value of the country property.
     *
     * @return possible object is
     *         {@link CountryDTO }
     */
    public CountryDTO getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     *
     * @param value allowed object is
     *              {@link CountryDTO }
     */
    public void setCountry(CountryDTO value) {
        this.country = value;
    }

    /**
     * Gets the value of the district property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDistrict() {
        return district;
    }

    /**
     * Sets the value of the district property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDistrict(String value) {
        this.district = value;
    }

    /**
     * Gets the value of the streetName property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Sets the value of the streetName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStreetName(String value) {
        this.streetName = value;
    }

    /**
     * Gets the value of the zipCode property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the value of the zipCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setZipCode(String value) {
        this.zipCode = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setId(Long value) {
        this.id = value;
    }

}
