package de.fhdw.ify208.ticketmaster.model;

import de.fhdw.ify208.ticketmaster.common.BaseEntityManager;
import de.fhdw.ify208.ticketmaster.common.EntityMapper;
import de.fhdw.ify208.ticketmaster.common.model.*;
import de.fhdw.ify208.ticketmaster.dataaccess.Address;
import de.fhdw.ify208.ticketmaster.dataaccess.User;
import de.fhdw.ify208.ticketmaster.dataaccess.Usertype;

import javax.persistence.EntityManager;
import java.util.Iterator;
import java.util.List;

/**
 * @author ankariu
 *
 */

/**
 * Singleton-Implementation of OrderManager
 */
public class CustomerManager extends BaseEntityManager {

    private static CustomerManager _instance = null;

    /**
     * Internal default constructor
     */
    private CustomerManager() {
    }


    /**
     * External static methode returning instance of class
     * @return CustomerManager
     */
    public static CustomerManager getInstance() {
        if (_instance == null) {
            _instance = new CustomerManager();
        }
        return _instance;
    }


    /**
     * External methode returning addresses for customer
     * @param theCustomer
     * @return AddressListDTO
     */
    public AddressListDTO getCustomerAddresses(CustomerDTO theCustomer) {
        AddressListDTO addressListDTO = new AddressListDTO();
        User customer = _checkCustomerExists(theCustomer.getid());
        if (customer == null) {
            addressListDTO.setReturncode(99);
            addressListDTO.setMessage("Customer does not exist on database.");
        } else {
            EntityMapper mapper = new EntityMapper();
            List<Address> addressList = customer.getAddresses();
            for (Iterator<Address> i = addressList.iterator(); i.hasNext(); ) {
                addressListDTO.addAddressToList(mapper.getAddressDTOfromAddress(i.next()));
            }
        }
        return addressListDTO;
    }


    /**
     * External methode customer login
     * @param userName
     * @param password
     * @return CustomerDTO
     */
    public CustomerDTO signOn(String userName, String password) {
        CustomerDTO customerDTO = new CustomerDTO();
        EntityMapper mapper = new EntityMapper();
        // get Customer by userName
        User customer = _checkCustomerExistsByName(userName);
        if (customer != null) {
            // check password for Customer
            if (customer.getPassword().equals(password)) {
                // build CustomerDTO
                customerDTO = mapper.getCustomerDTOFromUser(customer);
            } else {
                customerDTO.setReturncode(99);
                customerDTO.setMessage("Password mismatch.");
            }
        } else {
            customerDTO.setReturncode(99);
            customerDTO.setMessage("Customer does not exist");
        }
        return customerDTO;
    }


    /**
     * External methode for changing password
     * @param userName
     * @param oldPassword
     * @param newPassword
     * @return BaseDTO
     */
    public BaseDTO changePassword(String userName, String oldPassword, String newPassword) {
        BaseDTO baseDTO = new BaseDTO();
        // get Customer by userName
        User customer = _checkCustomerExistsByName(userName);
        if (customer != null) {
            // check password for Customer
            if (customer.getPassword().equals(oldPassword)) {
                // update customer
                customer.setPassword(newPassword);
                customer = _updateCustomer(customer);
                if (customer == null) {
                    baseDTO.setReturncode(99);
                    baseDTO.setMessage("Error during update of password.");
                }
            } else {
                baseDTO.setReturncode(99);
                baseDTO.setMessage("Password mismatch.");
            }
        } else {
            baseDTO.setReturncode(99);
            baseDTO.setMessage("Customer does not exist");
        }
        return baseDTO;
    }


    /**
     * External methode for register a new customer
     * @param theCustomer
     * @return CustomerDTO     
     */
    public CustomerDTO registerCustomer(CustomerDTO theCustomer) {
        CustomerDTO customerDTO = new CustomerDTO();
        EntityMapper mapper = new EntityMapper();
        // check username is not in use
        User customer = _checkCustomerExistsByName(theCustomer.getUserName());
        if (customer == null) {
            // map customerDTO to customer
            customer = mapper.getUserFromCustomerDTO(theCustomer);
            // write customer to database
            customer = _insertCustomer(customer);
            if (customer == null) {
                customerDTO.setReturncode(99);
                customerDTO.setMessage("Error during insertion of customer.");
            } else {
                customerDTO = mapper.getCustomerDTOFromUser(customer);
            }
        } else {
            customerDTO.setReturncode(99);
            customerDTO.setMessage("Username is already in use.");
        }
        return customerDTO;
    }


    /**
     * External methode for maintanance of an existing address
     * Maintanance can be insert or update of address
     * @param theCustomer
     * @param theAddress
     * @return AddressDTO
     */
    public AddressDTO maintainAddress(CustomerDTO theCustomer, AddressDTO theAddress) {
        User customer = null;
        Address address = null;
        EntityMapper mapper = new EntityMapper();
        AddressDTO addressDTO = null;

        if (theAddress.getid() != null) {
            // address has an id, so just update the address itself
            address = _updateAddress(mapper.getAddressfromAddressDTO(theAddress));
            if (address == null) {
                addressDTO = new AddressDTO();
                addressDTO.setReturncode(99);
                addressDTO.setMessage("Error during update of customers addressdata.");
            } else {
                addressDTO = mapper.getAddressDTOfromAddress(address);
            }
        } else {
            customer = _checkCustomerExists(theCustomer.getid());
            // address has no id, put it to customer and update customer
            if (customer != null) {
                customer.getAddresses().add(mapper.getAddressfromAddressDTO(theAddress));
                customer = _updateCustomer(customer);
                if (customer != null) {
                    address = _findNewAddressFromCustomer(customer);
                    addressDTO = mapper.getAddressDTOfromAddress(address);
                } else {
                    addressDTO = new AddressDTO();
                    addressDTO.setReturncode(99);
                    addressDTO.setMessage("Error during update of customers addressdata.");
                }
            } else {
                addressDTO = new AddressDTO();
                addressDTO.setReturncode(99);
                addressDTO.setMessage("User does not exist on database.");
            }
        }
        return addressDTO;
    }


    /**
     * External methode for removal of an existing address
     * @param theCustomer
     * @param theAddress
     * @return BaseDTO
     */
    public BaseDTO removeAddress(CustomerDTO theCustomer, AddressDTO theAddress) {
        BaseDTO baseDTO = new BaseDTO();
        // check address exists
        Address address = _checkAddressExists(theAddress.getid());
        User customer = _checkCustomerExists(theCustomer.getid());
        if (address != null && customer != null) {
            customer = _removeCustomerAddress(customer, address.getId());
            if (customer != null) {
                customer = _updateCustomer(customer);
                if (customer == null) {
                    baseDTO.setReturncode(99);
                    baseDTO.setMessage("Error during update of customers addressdata.");
                }
            } else {
                baseDTO.setReturncode(99);
                baseDTO.setMessage("Address does not belong to customer.");
            }
        } else {
            baseDTO.setReturncode(99);
            baseDTO.setMessage("User or Address do not exist on database.");
        }
        // delete address from database
        return baseDTO;
    }


    /**
     * External methode for closing a customers profile
     * @param theCustomer
     * @return BaseDTO
     */
    public BaseDTO closeCustomerProfile(CustomerDTO theCustomer) {
        // check user does exist

        // delete user from database

        return null;
    }

    /**
     * @return TypeCodeListDTO
     */
    public TypeCodeListDTO getCustomerTypes() {

        TypeCodeListDTO listDTO = new TypeCodeListDTO();
        EntityMapper mapper = new EntityMapper();

        List<Usertype> _listOfUserTypes = this._getAllUserTypes();
        for (Iterator<Usertype> iter = _listOfUserTypes.iterator(); iter.hasNext(); ) {

            listDTO.addTypeCodeToList(mapper.getTypeCodeDTOFromUserType(iter.next()));
        }

        if (listDTO.getTypeCodeDTOList().size() > 0) {
            listDTO.setReturncode(0);
        } else {
            listDTO.setReturncode(99);
            listDTO.setMessage("Error getting user types from database");
        }
        return listDTO;
    }

    /**
     * Internal methode for check existance of user by username
     */
    private User _checkCustomerExistsByName(String userName) {
        // local variables
        EntityManager _em = null;
        User customer = null;

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            customer = (User) _em.createNamedQuery("User.findByUserName").setParameter("userName", userName).getSingleResult();

            // commit transaction
            _em.getTransaction().commit();

        } catch (Exception e) {
            // roll back of unit of work if possible
            if (_em.getTransaction() != null && _em.getTransaction().isActive()) {
                _em.getTransaction().rollback();
            }
        } finally {
            // close-sequence
            _cleanup(_em);
        }
        return customer;
    }

    private User _updateCustomer(User customer) {
        // local variables
        EntityManager _em = null;

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            customer = _em.merge(customer);

            // commit transaction
            _em.getTransaction().commit();

        } catch (Exception e) {
            // roll back of unit of work if possible
            if (_em.getTransaction() != null && _em.getTransaction().isActive()) {
                _em.getTransaction().rollback();
            }
            customer = null;
        } finally {
            // close-sequence
            _cleanup(_em);
        }
        return customer;
    }

    private Address _updateAddress(Address address) {
        // local variables
        EntityManager _em = null;

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            address = _em.merge(address);

            // commit transaction
            _em.getTransaction().commit();

        } catch (Exception e) {
            // roll back of unit of work if possible
            if (_em.getTransaction() != null && _em.getTransaction().isActive()) {
                _em.getTransaction().rollback();
            }
            address = null;
        } finally {
            // close-sequence
            _cleanup(_em);
        }
        return address;
    }

    private User _insertCustomer(User customer) {
        // local variables
        EntityManager _em = null;
        User _customer = null;

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            _customer = _em.merge(customer);

            // commit transaction
            _em.getTransaction().commit();

        } catch (Exception e) {
            // roll back of unit of work if possible
            if (_em.getTransaction() != null && _em.getTransaction().isActive()) {
                _em.getTransaction().rollback();
            }
        } finally {
            // close-sequence
            _cleanup(_em);
        }
        return _customer;
    }

    private User _removeCustomerAddress(User customer, Long addressID) {
        List<Address> addressList = customer.getAddresses();
        Address addressToRemove = null;
        // search for address in customers addresses
        for (Iterator<Address> i = addressList.iterator(); i.hasNext(); ) {
            Address address = i.next();
            if (address.getId() == addressID) {
                // existing address has to be removed
                addressToRemove = address;
            }
        }
        addressList.remove(addressToRemove);
        customer.setAddresses(addressList);
        return customer;
    }

    private Address _findNewAddressFromCustomer(User customer) {
        List<Address> addressList = customer.getAddresses();
        Long high = new Long(0);
        Address newAddress = null;
        // search for address in customers addresses
        for (Iterator<Address> i = addressList.iterator(); i.hasNext(); ) {
            Address address = i.next();
            if (address.getId() > high) {
                // remember me
                high = address.getId();
                newAddress = address;
            }
        }
        customer.setAddresses(addressList);
        return newAddress;
    }

    private List<Usertype> _getAllUserTypes() {

        // local variables
        EntityManager _em = null;
        List<Usertype> _result = null;

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            _result = _em.createNamedQuery("Usertype.All").getResultList();

            // commit transaction
            _em.getTransaction().commit();

        } catch (Exception e) {
            // roll back of unit of work if possible
            if (_em.getTransaction() != null && _em.getTransaction().isActive()) {
                _em.getTransaction().rollback();
            }
        } finally {
            // close-sequence
            _cleanup(_em);
        }
        return _result;
    }
}