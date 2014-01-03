/**
 *  the controller classes for the web application (MVC pattern)
 */
package de.fhdw.ify208.ticketmaster.webapp.controller;

import de.fhdw.ify208.ticketmaster.webapp.model.LogonCredentials;
import de.fhdw.ify208.ticketmaster.webapp.model.UserProfile;
import de.fhdw.ify208.ticketmaster.webapp.webservices.*;
import org.primefaces.context.RequestContext;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * the user controller dealing with registering new users, logging in or -out and providing access to the customer profile
 *
 * @author appelgriebsch
 */

@ManagedBean
@SessionScoped
public class UserController implements Serializable {

    /**
     * the profile of the currently logged on user
     */
    private UserProfile _loggedOnUser = null;

    /**
     *  the profile of the user that is currently registering
     */
    private UserProfile _newUser = null;

    /**
     *  the logon credentials of the current user
     */
    private LogonCredentials _logonCredentials = null;

    /**
     *  a reference to the internal customer web service
     */
    private CustomerServiceImplService _customerWebService = null;

    /**
     * the list of available address types in the database
     */
    private List<TypeCodeDTO> _addressTypes = null;

    /**
     * the list of available customer types in the database
     */
    private List<TypeCodeDTO> _customerTypes = null;

    /**
     * the list of available countries in the database
     */
    private List<CountryDTO> _countries = null;

    /**
     * constructs a new user controller and connects to the local customer web service
     */
    public UserController() {

        _logonCredentials = new LogonCredentials();

        try {

            _customerWebService = new CustomerServiceImplService(
                    new URL(String.format("http://%s/ticketmaster/customerservice?wsdl", SystemController.getHost())),
                    new QName("http://service.ticketmaster.ify208.fhdw.de/", "CustomerServiceImplService"));

            this.loadConfigurationData();

        } catch (MalformedURLException e) {
        }
    }

    /**
     * try to sign on the current user w/ his given credentials
     *
     * @param actEvent contains information about the event that triggers the execution of this operation
     */
    public void Login(ActionEvent actEvent) {

        RequestContext ctx = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        boolean bIsLoggedIn = false;

        try {

            CustomerDTO _customerDTO = _customerWebService.getCustomerServiceImplPort().signOn(
                    this.getLogonCredentials().getUserName(), this.getLogonCredentials().getPassword());

            if (_customerDTO.getReturncode() == 0) {

                bIsLoggedIn = true;
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome back", _customerDTO.getUserName());

            } else {

                bIsLoggedIn = false;
                msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login credentials invalid!", _customerDTO.getMessage());
            }

            if (bIsLoggedIn) {

                _loggedOnUser = getUserProfile(_customerDTO);

            } else {

                _loggedOnUser = null;
            }

        } catch (Exception ex) {

            bIsLoggedIn = false;

            _loggedOnUser = null;
            _logonCredentials = new LogonCredentials();

            msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error communicating with customer web service!",
                    String.format("Unable to access customer web service at %s: %s",
                            _customerWebService.getWSDLDocumentLocation(),
                            ex.getMessage()));
        }

        if (msg != null)
            FacesContext.getCurrentInstance().addMessage(null, msg);

        ctx.addCallbackParam("loggedIn", bIsLoggedIn);
    }

    /**
     * log out the current user and reset the internal state
     *
     * @param actEvent contains information about the event that triggers the execution of this operation
     */
    public void Logout(ActionEvent actEvent) {

        RequestContext ctx = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        boolean bIsLoggedOut = false;

        _loggedOnUser = null;
        _logonCredentials = new LogonCredentials();

        bIsLoggedOut = true;

        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bye",
                "Please come back and check our offerings soon!");

        if (msg != null)
            FacesContext.getCurrentInstance().addMessage(null, msg);

        ctx.addCallbackParam("loggedOut", bIsLoggedOut);
        SystemController.redirectUrl(ctx, "index");
    }

    /**
     * reload the customer profile information from the database
     *
     * @param actEvent contains information about the event that triggers the execution of this operation
     */
    public void CheckCustomerProfile(ActionEvent actEvent) {

        RequestContext ctx = RequestContext.getCurrentInstance();

        if (this.getLoggedOnUser() == null) {

            return;
        }

        _loggedOnUser = getUserProfile(_loggedOnUser.getProfileData());

        SystemController.redirectUrl(ctx, "userprofile");
    }

    /**
     * cancel the update on the customer profile and reset the internal profile information
     *
     * @param evt  contains information about the event that triggers the execution of this operation
     */
    public void CancelUpdateProfile(ActionEvent evt) {

        RequestContext ctx = RequestContext.getCurrentInstance();

        this.CheckCustomerProfile(evt);

        SystemController.redirectUrl(ctx, "index");
    }

    /**
     * prepares a new customer profile object for storing the information from a new user
     *
     * @param actEvent   contains information about the event that triggers the execution of this operation
     */
    public void PrepareUserRegistration(ActionEvent actEvent) {

        CustomerDTO newCustomerDTO = new CustomerDTO();
        newCustomerDTO.setStatus(CustomerStatus.ACTIVE);
        newCustomerDTO.setType(_customerTypes.get(0));

        _newUser = getUserProfile(newCustomerDTO);
    }

    /**
     * try to register the new user with his information
     *
     * @param actEvent contains information about the event that triggers the execution of this operation
     */
    public void UserRegistration(ActionEvent actEvent) {

        RequestContext ctx = RequestContext.getCurrentInstance();
        FacesMessage msg = null;

        boolean bIsRegistered = false;

        try {

            UserProfile profile = getNewUser();

            if (!profile.getChangePin().getNewPin().equals(profile.getChangePin().getRetryPin())) {

                bIsRegistered = false;

                msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Password mismatch",
                        "Please make sure that your re-type your pin correctly!");
            } else {

                profile.getProfileData().setPassword(profile.getChangePin().getNewPin());

                CustomerDTO _customerDTO = _customerWebService.getCustomerServiceImplPort().registerCustomer(
                        profile.getProfileData());

                if (_customerDTO.getReturncode() == 0) {

                    bIsRegistered = true;

                    AddressDTO defaultAdr =_customerWebService.getCustomerServiceImplPort().maintainAddress(_customerDTO, profile.getBillingAddress());

                    if (defaultAdr.getReturncode() != 0) {
                    
                        msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Profile Data missing",
                                        "Could not store your billing address. Please check the data!");
                        
                        SystemController.redirectUrl(ctx, "userprofile");
                    }
                    
                    defaultAdr = _customerWebService.getCustomerServiceImplPort().maintainAddress(_customerDTO, profile.getShippingAddress());

                    if (defaultAdr.getReturncode() != 0) {

                        msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Profile Data missing",
                                "Could not store your shipping address. Please check the data!");

                        SystemController.redirectUrl(ctx, "userprofile");
                    }

                    if (msg == null)
                        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", _customerDTO.getUserName());

                } else {

                    bIsRegistered = false;
                    msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registration failed!", _customerDTO.getMessage());
                }

                if (bIsRegistered) {

                    _loggedOnUser = getUserProfile(_customerDTO);
                    _newUser = null;

                } else {

                    _loggedOnUser = null;
                }
            }

        } catch (Exception ex) {

            bIsRegistered = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error communicating with customer web service!",
                    String.format("Unable to access customer web service at %s: %s",
                            _customerWebService.getWSDLDocumentLocation(),
                            ex.getMessage()));
        }

        if (msg != null)
            FacesContext.getCurrentInstance().addMessage(null, msg);

        ctx.addCallbackParam("registered", bIsRegistered);
    }

    /**
     * try to update the customer profile and the address information of the customer
     *
     * @param actEvent   contains information about the event that triggers the execution of this operation
     */
    public void UpdateProfile(ActionEvent actEvent) {

        RequestContext ctx = RequestContext.getCurrentInstance();
        FacesMessage msg = null;

        try {

            AddressDTO shipAdr = _customerWebService.getCustomerServiceImplPort().maintainAddress(
                    getLoggedOnUser().getProfileData(), getLoggedOnUser().getBillingAddress()
            );

            if (shipAdr.getReturncode() == 0) {

                getLoggedOnUser().setShippingAddress(shipAdr);

            } else {

                msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Could not update customer profile!", shipAdr.getMessage());
            }

            AddressDTO billAdr = _customerWebService.getCustomerServiceImplPort().maintainAddress(
                    getLoggedOnUser().getProfileData(), getLoggedOnUser().getBillingAddress()
            );

            if (billAdr.getReturncode() == 0) {

                getLoggedOnUser().setBillingAddress(billAdr);
            } else {

                msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Could not update customer profile!", billAdr.getMessage());
            }

            if (msg == null)
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Successfully updated customer profile!");

        } catch (Exception ex) {

            msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error communicating with customer web service!",
                    String.format("Unable to access customer web service at %s: %s",
                            _customerWebService.getWSDLDocumentLocation(),
                            ex.getMessage()));
        }

        if (msg != null)
            FacesContext.getCurrentInstance().addMessage(null, msg);

        SystemController.redirectUrl(ctx, "userprofile");
    }

    /**
     * try to change the pin of the currently logged on user
     *
     * @param actEvent  contains information about the event that triggers the execution of this operation
     */
    public void ChangePin(ActionEvent actEvent) {

        RequestContext ctx = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        boolean bChangedPin = false;

        try {

            if (!getLoggedOnUser().getChangePin().getNewPin().equals(getLoggedOnUser().getChangePin().getRetryPin())) {
                bChangedPin = false;
                msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Password mismatch",
                        "Please make sure that your re-type your pin correctly!");
            } else {
                BaseDTO result = _customerWebService.getCustomerServiceImplPort().changeCustomer(
                        getLoggedOnUser().getProfileData().getUserName(),
                        getLoggedOnUser().getChangePin().getCurrentPin(),
                        getLoggedOnUser().getChangePin().getNewPin());

                if (result.getReturncode() == 0) {

                    bChangedPin = true;
                    msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pin changed", "Your pin has been changed successfully!");
                } else {

                    bChangedPin = false;
                    msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Pin not changed", result.getMessage());
                }
            }
        } catch (Exception ex) {

            bChangedPin = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error communicating with customer web service!",
                    String.format("Unable to access customer web service at %s: %s",
                            _customerWebService.getWSDLDocumentLocation(),
                            ex.getMessage()));
        }

        if (msg != null)
            FacesContext.getCurrentInstance().addMessage(null, msg);

        ctx.addCallbackParam("changedPin", bChangedPin);
    }

    /**
     * provides access to the currently logged on user profile
     *
     * @return the user profile of the currently logged on user
     */
    public UserProfile getLoggedOnUser() {
        return _loggedOnUser;
    }

    /**
     * provides access to the currently given logon credentials
     *
     * @return the active logon credentials as given by the user
     */
    public LogonCredentials getLogonCredentials() {
        return this._logonCredentials;
    }

    /**
     * provides access to the profile information for a fresh customer before registration
     * @return
     */
    public UserProfile getNewUser() {
        return _newUser;
    }

    /**
     *  load used master data from the database
     */
    private void loadConfigurationData() {

        TypeCodeListDTO result = _customerWebService.getCustomerServiceImplPort().getAddressTypes();

        if ((result != null) &&
                (result.getReturncode() == 0)) {

            _addressTypes = result.getTypecode();
        }

        result = _customerWebService.getCustomerServiceImplPort().getCustomerTypes();

        if ((result != null) &&
                (result.getReturncode() == 0)) {

            _customerTypes = result.getTypecode();
        }

        CountryListDTO countries = _customerWebService.getCustomerServiceImplPort().getCountries();

        if ((result != null) &&
                (result.getReturncode() == 0)) {

            _countries = countries.getCountry();
        }
    }

    /**
     * build a detailed user profile based on the basic customer record
     *
     * @param customerDTO the customer which profile is to be returned
     * @return  the user profile for this customer
     */
    private UserProfile getUserProfile(CustomerDTO customerDTO) {

        UserProfile result = new UserProfile(customerDTO);
        result.setCustomerTypes(_customerTypes);
        result.setAddressTypes(_addressTypes);
        result.setCountries(_countries);

        if (customerDTO.getId() != 0) {

            AddressListDTO addresses = _customerWebService.getCustomerServiceImplPort().getCustomerAddresses(customerDTO);

            if ((addresses != null) &&
                    (addresses.getReturncode() == 0)) {

                result.setAddresses(addresses.getAddress());
            }
        } else {

            result.setAddresses(new ArrayList<AddressDTO>());
        }

        return result;
    }
}
