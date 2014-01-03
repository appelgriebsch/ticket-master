/**
 *
 */
package de.fhdw.ify208.ticketmaster.common.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author appelgriebsch
 */
@XmlRootElement(name = "address")
public class AddressDTO extends BaseDTO {

    /**
     * the id of the address
     */
    private Long _addressID;

    /**
     * the type of the address
     */
    private TypeCodeDTO _addressType;

    /**
     * the first line in the address header
     */
    private String _addressLine;

    /**
     * the name of the street incl. number
     */
    private String _streetName;

    /**
     * the ZIP code of the address
     */
    private String _zipCode;

    /**
     * the name of the city
     */
    private String _cityName;

    /**
     * the country to which the address belongs
     */
    private CountryDTO _country;

    /**
     * the district in the country the city is placed
     */
    private String _district;

    /**
     * @return the id
     */
    public Long getid() {
        return _addressID;
    }

    /**
     * @param id the _theAddress to set
     */
    public void setid(Long addressID) {
        this._addressID = addressID;
    }

    /**
     * @return the _addressType
     */
    public TypeCodeDTO getAddressType() {
        return _addressType;
    }

    /**
     * @param _addressType the _addressType to set
     */
    public void setAddressType(TypeCodeDTO _addressType) {
        this._addressType = _addressType;
    }

    /**
     * @return the _addressLine
     */
    public String getAddressLine() {
        return _addressLine;
    }

    /**
     * @param _addressLine the _addressLine to set
     */
    public void setAddressLine(String _addressLine) {
        this._addressLine = _addressLine;
    }

    /**
     * @return the _streetName
     */
    public String getStreetName() {
        return _streetName;
    }

    /**
     * @param _streetName the _streetName to set
     */
    public void setStreetName(String _streetName) {
        this._streetName = _streetName;
    }

    /**
     * @return the _zipCode
     */
    public String getZipCode() {
        return _zipCode;
    }

    /**
     * @param _zipCode the _zipCode to set
     */
    public void setZipCode(String _zipCode) {
        this._zipCode = _zipCode;
    }

    /**
     * @return the _cityName
     */
    public String getCityName() {
        return _cityName;
    }

    /**
     * @param _cityName the _cityName to set
     */
    public void setCityName(String _cityName) {
        this._cityName = _cityName;
    }

    /**
     * @return the _country
     */
    public CountryDTO getCountry() {
        return _country;
    }

    /**
     * @param _country the _country to set
     */
    public void setCountry(CountryDTO _country) {
        this._country = _country;
    }

    /**
     * @return the _district
     */
    public String getDistrict() {
        return _district;
    }

    /**
     * @param _district the _district to set
     */
    public void setDistrict(String _district) {
        this._district = _district;
    }
}
