/**
 *
 */
package de.fhdw.ify208.ticketmaster.common.model;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @author appelgriebsch
 */
@WebService(name = "orderservice",
        targetNamespace = "de.fhdw.ify208.ticketmaster.common.model",
        serviceName = "orderservice")
public interface IOrderService {

    /**
     * @param theCustomer
     * @return
     */
    @WebMethod(operationName = "GetCustomerOrders")
    OrderListDTO GetCustomerOrders(@WebParam(name = "customer") CustomerDTO theCustomer);

    /**
     * @param theEvent
     * @param theCustomer
     * @param shippingAddress
     * @param BillingAddress
     * @param quantity
     * @return
     */
    @WebMethod(operationName = "PlaceOrder")
    @WebResult(name = "order")
    OrderDTO PlaceOrder(@WebParam(name = "event") EventDTO theEvent,
                        @WebParam(name = "customer") CustomerDTO theCustomer,
                        @WebParam(name = "shippingTo") AddressDTO shippingAddress,
                        @WebParam(name = "billingTo") AddressDTO BillingAddress,
                        @WebParam(name = "quantity") int quantity);

    /**
     * @param theOrder
     * @return
     */
    @WebMethod(operationName = "CancelOrder")
    BaseDTO CancelOrder(@WebParam(name = "order") OrderDTO theOrder);

    /**
     * @return
     */
    @WebMethod(operationName = "GetOrderStatuses")
    TypeCodeListDTO GetOrderStatuses();
}
