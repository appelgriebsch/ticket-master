/**
 *  the model classes for the web application (MVC pattern)
 */

package de.fhdw.ify208.ticketmaster.webapp.model;

import de.fhdw.ify208.ticketmaster.webapp.webservices.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * a model class for handling the user profile information in the web app
 *
 * @author appelgriebsch
 */
@ManagedBean
@SessionScoped
public class UserProfile {

    /**
     *  the customer information from the web service
     */
    private CustomerDTO _customerDTO = null;

    /**
     *  a list of addresses for the current customer
     */
    private List<AddressDTO> _addresses = new ArrayList<AddressDTO>();

    /**
     *  a list of possible customer type codes from the database
     */
    private List<TypeCodeDTO> _customerTypes = new ArrayList<TypeCodeDTO>();

    /**
     *  a list of possible address type codes from the database
     */
    private List<TypeCodeDTO> _addressTypes = new ArrayList<TypeCodeDTO>();

    /**
     *  a list of possible countries from the database
     */
    private List<CountryDTO> _countries = new ArrayList<CountryDTO>();

    /**
     *  the current shipping address of the customer
     */
    private AddressDTO _shippingAddress = null;

    /**
     *  the current billing address of the customer
     */
    private AddressDTO _billingAddress = null;

    /**
     *  flag denoting if the billing and shipping addresses are equal
     */
    private boolean _billingEqualsShipping = true;

    /**
     *  holds the information when changing the pin for this customer
     */
    private ChangePin _changePin = null;

    /**
     * constructs a new model object for the given customer information
     *
     * @param customerDTO the customer information from the web service
     */
    public UserProfile(CustomerDTO customerDTO) {

        _customerDTO = customerDTO;
        _changePin = new ChangePin();
    }

    /**
     * provides access to the raw data from the web service
     *
     * @return the raw data from the web service
     */
    public CustomerDTO getProfileData() {

        return _customerDTO;
    }

    /**
     * provides access to the birthday of the customer
     *
     * @return the birthday of the customer
     */
    public Date getBirthdate() {

        if ((_customerDTO == null) ||
                (_customerDTO.getBirthdate() == null))
            return new Date();

        return _customerDTO.getBirthdate().toGregorianCalendar().getTime();
    }

    /**
     * sets a new date as birthday of the customer
     *
     * @param date the date to set as birthday
     */
    public void setBirthdate(Date date) {

        if (_customerDTO != null) {

            try {

                GregorianCalendar calendar = (GregorianCalendar) GregorianCalendar.getInstance();
                calendar.setTime(date);

                _customerDTO.setBirthdate(
                        DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar));

            } catch (DatatypeConfigurationException e) {
            }
        }
    }

    /**
     * provides access to the address list of the customer
     *
     * @return the list of addresses for the customer
     */
    public List<AddressDTO> getAddresses() {

        return _addresses;
    }

    /**
     * sets a new list of addresses for the customer
     *
     * @param addresses the new list of addresses to set
     */
    public void setAddresses(List<AddressDTO> addresses) {

        _addresses = addresses;

        this.setBillingAddress(this.findAddress("Billing"));
        this.setShippingAddress(this.findAddress("Shipping"));

        if (this.getBillingAddressEqualsShippingAddress())
            this.setBillingAddress(this.getBillingAddress());
    }

    /**
     * provides the list of available customer types
     *
     * @return the list of available customer types from the database
     */
    public List<TypeCodeDTO> getCustomerTypes() {

        return _customerTypes;
    }

    /**
     * sets a new list of customer types
     *
     * @param types the list of customer types to set
     */
    public void setCustomerTypes(List<TypeCodeDTO> types) {

        _customerTypes = types;
    }

    /**
     * provides the list of available address types
     *
     * @return the list of address types available in the  database
     */
    public List<TypeCodeDTO> getAddressTypes() {

        return _addressTypes;
    }

    /**
     * sets a new list of available address types
     *
     * @param types the list of address types to set
     */
    public void setAddressTypes(List<TypeCodeDTO> types) {

        _addressTypes = types;
    }

    /**
     * provides the information if billing and shipping addresses are equal
     *
     * @return TRUE/FALSE
     */
    public boolean getBillingAddressEqualsShippingAddress() {

        return _billingEqualsShipping;
    }

    /**
     * sets the information whether billing and shipping addresses are equal
     *
     * @param val TRUE/FALSE
     */
    public void setBillingAddressEqualsShippingAddress(boolean val) {

        _billingEqualsShipping = val;

        if (val) {

            setBillingAddress(getShippingAddress());
        } else {

            setBillingAddress(findAddress("Billing"));
        }
    }

    /**
     * provides access to the shipping address of the current customer
     *
     * @return the shipping address of the customer
     */
    public AddressDTO getShippingAddress() {

        return _shippingAddress;
    }

    /**
     * sets a new shipping address for this customer
     *
     * @param address the shipping address to use
     */
    public void setShippingAddress(AddressDTO address) {

        _shippingAddress = address;
    }

    /**
     * provides access to the billing address of this customer
     *
     * @return the billing address of this customer
     */
    public AddressDTO getBillingAddress() {

        if (getBillingAddressEqualsShippingAddress())
            return _shippingAddress;
        else
            return _billingAddress;
    }

    /**
     * sets a new billing address for this customer
     *
     * @param address the new billing address to use
     */
    public void setBillingAddress(AddressDTO address) {

        _billingAddress = address;
    }

    /**
     * provides an array of selectable items containing the available gender types
     *
     * @return the array of possible gender types
     */
    public SelectItem[] getGenderTypes() {

        SelectItem[] items = new SelectItem[GenderType.values().length];
        int i = 0;

        for (GenderType g : GenderType.values()) {

            items[i++] = new SelectItem(g, g.name());
        }

        return items;
    }

    /**
     * provides a list of available countries
     *
     * @return the list of countries available
     */
    public List<CountryDTO> getCountries() {

        return _countries;
    }

    /**
     * sets a new list of available countries
     *
     * @param countries the list of countries to set
     */
    public void setCountries(List<CountryDTO> countries) {

        _countries = countries;
    }

    /**
     * provides access to the change pin request information
     *
     * @return the change pin request information
     */
    public ChangePin getChangePin() {

        return _changePin;
    }

    /**
     * looks for a specific address type by type code
     *
     * @param typeCode the type code to look for
     * @return the address type code object holding the type code
     */
    private TypeCodeDTO getAddressType(String typeCode) {

        TypeCodeDTO adrType = null;

        for (TypeCodeDTO a : this.getAddressTypes()) {

            if (a.getName().equals(typeCode)) {

                adrType = a;
                break;
            }
        }

        return adrType;
    }

    /**
     * looks for a specific address based on the address type
     *
     * @param addressType the address type to look for
     * @return the address type object for the type given
     */
    private AddressDTO findAddress(String addressType) {

        AddressDTO addressDTO = null;
        TypeCodeDTO adrType = getAddressType(addressType);

        for (AddressDTO adr : this.getAddresses()) {

            if (adr.getAddressType().getId() == adrType.getId()) {

                addressDTO = adr;
                break;
            }
        }

        if (addressDTO == null) {

            addressDTO = new AddressDTO();
            addressDTO.setAddressType(adrType);
            addressDTO.setCountry(findCountry("DEU"));
        }

        return addressDTO;
    }

    /**
     * looks for a specific country based on it's iso code
     *
     * @param isocode the iso code to look for
     * @return the country that holds this iso code
     */
    private CountryDTO findCountry(String isocode) {

        CountryDTO result = null;

        for (CountryDTO c : this.getCountries()) {

            if (c.getIsoCode().equals(isocode)) {

                result = c;
                break;
            }
        }

        return result;
    }
}
