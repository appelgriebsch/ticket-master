/**
 *
 */
package de.fhdw.ify208.ticketmaster.service;

import de.fhdw.ify208.ticketmaster.common.model.*;
import de.fhdw.ify208.ticketmaster.model.CustomerManager;

import javax.jws.WebService;

/**
 * @author appelgriebsch
 */
@WebService(endpointInterface = "de.fhdw.ify208.ticketmaster.common.model.ICustomerService")
public class CustomerServiceImpl implements ICustomerService {

    private CustomerManager customerManager = CustomerManager.getInstance();

    /* (non-Javadoc)
      * @see de.fhdw.ify208.ticketmaster.common.model.ICustomerService#getCustomerAddresses(de.fhdw.ify208.ticketmaster.common.model.Customer)
      */
    @Override
    public AddressListDTO GetCustomerAddresses(CustomerDTO theCustomer) {
        return customerManager.getCustomerAddresses(theCustomer);
    }

    /* (non-Javadoc)
      * @see de.fhdw.ify208.ticketmaster.common.model.ICustomerService#SignOn(java.lang.String, java.lang.String)
      */
    @Override
    public CustomerDTO SignOn(String userName, String password) {
        return customerManager.signOn(userName, password);
    }

    /* (non-Javadoc)
      * @see de.fhdw.ify208.ticketmaster.common.model.ICustomerService#ChangePassword(java.lang.String, java.lang.String, java.lang.String)
      */
    @Override
    public BaseDTO ChangePassword(String userName, String oldPassword,
                                  String newPassword) {
        return customerManager.changePassword(userName, oldPassword, newPassword);
    }

    /* (non-Javadoc)
      * @see de.fhdw.ify208.ticketmaster.common.model.ICustomerService#RegisterCustomer(de.fhdw.ify208.ticketmaster.common.model.Customer)
      */
    @Override
    public CustomerDTO RegisterCustomer(CustomerDTO theCustomer) {
        return customerManager.registerCustomer(theCustomer);
    }

    /* (non-Javadoc)
      * @see de.fhdw.ify208.ticketmaster.common.model.ICustomerService#MaintainAddress(de.fhdw.ify208.ticketmaster.common.model.Customer, de.fhdw.ify208.ticketmaster.common.model.Address)
      */
    @Override
    public AddressDTO MaintainAddress(CustomerDTO theCustomer, AddressDTO theAddress) {
        return customerManager.maintainAddress(theCustomer, theAddress);
    }

    /* (non-Javadoc)
      * @see de.fhdw.ify208.ticketmaster.common.model.ICustomerService#RemoveAddress(de.fhdw.ify208.ticketmaster.common.model.Customer, de.fhdw.ify208.ticketmaster.common.model.Address)
      */
    @Override
    public BaseDTO RemoveAddress(CustomerDTO theCustomer, AddressDTO theAddress) {
        return customerManager.removeAddress(theCustomer, theAddress);
    }

    /* (non-Javadoc)
      * @see de.fhdw.ify208.ticketmaster.common.model.ICustomerService#CloseCustomerProfile(de.fhdw.ify208.ticketmaster.common.model.Customer)
      */
    @Override
    public BaseDTO CloseCustomerProfile(CustomerDTO theCustomer) {
        return customerManager.closeCustomerProfile(theCustomer);
    }

    /* (non-Javadoc)
      * @see de.fhdw.ify208.ticketmaster.common.model.ICustomerService#GetCustomerTypes()
      */
    @Override
    public TypeCodeListDTO GetCustomerTypes() {
        return customerManager.getCustomerTypes();
    }

    /* (non-Javadoc)
      * @see de.fhdw.ify208.ticketmaster.common.model.ICustomerService#GetAddressTypes()
      */
    @Override
    public TypeCodeListDTO GetAddressTypes() {
        return customerManager.getAddressTypes();
    }

    /* (non-Javadoc)
      * @see de.fhdw.ify208.ticketmaster.common.model.ICustomerService#GetCountries()
      */
    @Override
    public CountryListDTO GetCountries() {
        return customerManager.getCountries();
    }
}
