/**
 *
 */
package de.fhdw.ify208.ticketmaster.common.model;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author appelgriebsch
 */
@WebService(name = "customerservice",
        targetNamespace = "de.fhdw.ify208.ticketmaster.common.model",
        serviceName = "customerservice")
public interface ICustomerService {

    /**
     * @param theCustomer
     * @return
     */
    @WebMethod(operationName = "GetCustomerAddresses")
    AddressListDTO GetCustomerAddresses(@WebParam(name = "customer") CustomerDTO theCustomer);

    /**
     * @param userName
     * @param password
     * @return
     */
    @WebMethod(operationName = "SignOn")
    CustomerDTO SignOn(@WebParam(name = "userName") String userName,
                       @WebParam(name = "password") String password);

    /**
     * @param userName
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @WebMethod(operationName = "ChangeCustomer")
    BaseDTO ChangePassword(@WebParam(name = "userName") String userName,
                           @WebParam(name = "oldPassword") String oldPassword,
                           @WebParam(name = "newPassword") String newPassword);

    /**
     * @param theCustomer
     * @return
     */
    @WebMethod(operationName = "RegisterCustomer")
    CustomerDTO RegisterCustomer(@WebParam(name = "customer") CustomerDTO theCustomer);

    /**
     * @param theCustomer
     * @param theAddress
     * @return
     */
    @WebMethod(operationName = "MaintainAddress")
    AddressDTO MaintainAddress(@WebParam(name = "customer") CustomerDTO theCustomer,
                               @WebParam(name = "address") AddressDTO theAddress);

    /**
     * @param theCustomer
     * @param theAddress
     * @return
     */
    @WebMethod(operationName = "RemoveAddress")
    BaseDTO RemoveAddress(@WebParam(name = "customer") CustomerDTO theCustomer,
                          @WebParam(name = "address") AddressDTO theAddress);

    /**
     * @param theCustomer
     * @return
     */
    @WebMethod(operationName = "CloseCustomerProfile")
    BaseDTO CloseCustomerProfile(@WebParam(name = "customer") CustomerDTO theCustomer);

    /**
     * @return
     */
    @WebMethod(operationName = "GetCustomerTypes")
    TypeCodeListDTO GetCustomerTypes();

    /**
     * @return
     */
    @WebMethod(operationName = "GetAddressTypes")
    TypeCodeListDTO GetAddressTypes();

    /**
     * @return
     */
    @WebMethod(operationName = "GetCountries")
    CountryListDTO GetCountries();
}
