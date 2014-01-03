package de.fhdw.ify208.ticketmaster.model;

import de.fhdw.ify208.ticketmaster.common.BaseEntityManager;
import de.fhdw.ify208.ticketmaster.common.EntityMapper;
import de.fhdw.ify208.ticketmaster.common.model.*;
import de.fhdw.ify208.ticketmaster.dataaccess.*;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.*;

/**
 * @author ankariu
 *
 */

/**
 * Singleton-Implementation of OrderManager
 */

public class OrderManager extends BaseEntityManager {

    private static OrderManager _instance = null;


    /**
     * Internal default constructor
     */
    private OrderManager() {
    }


    /**
     * External static method returning instance of class
     * @return OrderManager
     */
    public static OrderManager getInstance() {
        if (_instance == null) {
            _instance = new OrderManager();
        }
        return _instance;
    }


    /**
     * External Method returning all orders for a given customer
     * Logic is encapsulated into an internal method, which is just processed
     * in case every check was successful!
     * @param customerDTO
     * @return OrderListDTO
     */
    public OrderListDTO getCustomerOrders(CustomerDTO customerDTO) {
        User _customer = _checkCustomerExists(customerDTO.getid());

        if (_customer != null) {
            return _getCustomerOrders(_customer);
        } else {
            OrderListDTO _orderListDTO = new OrderListDTO();
            _orderListDTO.setReturncode(99);
            _orderListDTO.setMessage("Customer does not existing in database");
            return _orderListDTO;
        }
    }


    /**
     * external method for placing an order
     * @param eventDTO
     * @param customerDTO
     * @param shippingAddressDTO
     * @param billingAddressDTO
     * @param quantity
     * @return EventListDTO
     */
    public OrderDTO placeOrder(EventDTO eventDTO, CustomerDTO customerDTO, AddressDTO shippingAddressDTO, AddressDTO billingAddressDTO, int quantity) {
        Event _event = _checkEventExists(eventDTO.getid());
        User _customer = _checkCustomerExists(customerDTO.getid());
        Address _shpAddress = _checkAddressExists(shippingAddressDTO.getid());
        Address _payAddress = _checkAddressExists(billingAddressDTO.getid());
        Order _order = null;
        OrderDTO _orderDTO = new OrderDTO();
        Integer _quantityAvail = new Integer(0);
        boolean _payAddressOkay = false;
        boolean _shpAddressOkay = false;

        // Check all objects are existing
        if (_event == null) {
            _orderDTO.setReturncode(99);
            _orderDTO.setMessage("Event does not existing in database");
        } else if (_customer == null) {
            _orderDTO.setReturncode(99);
            _orderDTO.setMessage("Customer does not existing in database");
        } else if (_shpAddress == null) {
            _orderDTO.setReturncode(99);
            _orderDTO.setMessage("ShippingAddress does not existing in database");
        } else if (_payAddress == null) {
            _orderDTO.setReturncode(99);
            _orderDTO.setMessage("BillingAddress does not existing in database");
        } else {
            // Check addresses are belonging to customer
            List<Address> addressList = (List<Address>) _customer.getAddresses();
            for (Iterator<Address> i = addressList.iterator(); i.hasNext(); ) {
                Address address = i.next();
                if (address.getId() == _shpAddress.getId()) {
                    _payAddressOkay = true;
                }

                if (address.getId() == _shpAddress.getId()) {
                    _shpAddressOkay = true;
                }
            }
            // billing address okay?
            if (!_payAddressOkay) {
                _orderDTO.setReturncode(99);
                _orderDTO.setMessage("BillingAddress does not belong to customer");
            }
            // shipping address okay?
            if (!_shpAddressOkay) {
                _orderDTO.setReturncode(99);
                _orderDTO.setMessage("ShippingAddress does not belong to customer");
            }
            // Check event has an amount of available of greater-equal requested ticket quantity
            _quantityAvail = _event.getMaxtickets();
            for (Iterator<Order> i = _event.getOrders().iterator(); i.hasNext(); ) {
                _order = i.next();
                if (_order.getOrderStatus().getId() != _order.getOrderStatus().STATUS_VOIDED) {
                    _quantityAvail = _quantityAvail - _order.getQuantity();
                } else {
                    // Do nothing, cause order has status cancelled
                }
            }
            if (_quantityAvail < quantity) {
                _orderDTO.setReturncode(99);
                _orderDTO.setMessage("The quantity requested is not available");
            }
        }
        if (_orderDTO.getReturncode() == (int) 0) {
            return _placeOrder(_event, _customer, _shpAddress, _payAddress, quantity);
        } else {
            return _orderDTO;
        }
    }


    /**
     * external method for cancellation of an order
     * @param orderDTO
     * @return BaseDTO
     */
    public BaseDTO cancelOrder(OrderDTO orderDTO) {
        Order _order = _checkOrderExists(orderDTO.getid());
        BaseDTO _baseDTO = new BaseDTO();

        if (_order == null) {
            _baseDTO.setReturncode(99);
            _baseDTO.setMessage("Order does not exist on database");
        } else {
            _order.setOrderStatus(_acceptOrder(_order));
            if (_order.getOrderStatus().getId() == _order.getOrderStatus().STATUS_COMPLETED) {
                // Order has already been accepted, cancellation not possible
                _baseDTO.setReturncode(99);
                _baseDTO.setMessage("Order has already been accepted, cancellation not possible");
            } else if (_order.getOrderStatus().getId() == _order.getOrderStatus().STATUS_VOIDED) {
                // Order has already been cancelled, cancellation not possible
                _baseDTO.setReturncode(99);
                _baseDTO.setMessage("Order has already been cancelled, cancellation not possible");
            } else {
                if (_cancelOrder(_order)) {
                    // Order successfully cancelled
                    _baseDTO.setReturncode(0);
                    _baseDTO.setMessage("");
                } else {
                    // error during cancellation
                    _baseDTO.setReturncode(99);
                    _baseDTO.setMessage("Error during cancellation of order");
                }
            }
        }
        return _baseDTO;
    }

    /**
     * @return TypeCodeListDTO
     */
    public TypeCodeListDTO getOrderStatuses() {

        TypeCodeListDTO listDTO = new TypeCodeListDTO();
        EntityMapper mapper = new EntityMapper();

        List<OrderStatus> _listOfOrderStatuses = this._getAllOrderStatuses();
        for (Iterator<OrderStatus> iter = _listOfOrderStatuses.iterator(); iter.hasNext(); ) {

            listDTO.addTypeCodeToList(mapper.getTypeCodeDTOFromOrderStatus(iter.next()));
        }

        if (listDTO.getTypeCodeDTOList().size() > 0) {
            listDTO.setReturncode(0);
        } else {
            listDTO.setReturncode(99);
            listDTO.setMessage("Error getting order statuses from database");
        }
        return listDTO;
    }

    /**
     * Internal method returning all orders for a given customer
     */
    @SuppressWarnings("unchecked")
    private OrderListDTO _getCustomerOrders(User customer) {
        // local variables
        EntityManager _em = null;
        OrderListDTO _orderListDTO = new OrderListDTO();
        OrderDTO _orderDTO = null;
        Order _order = null;
        List<Order> _orderList = null;
        EntityMapper _mapper = new EntityMapper();

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            _orderList = (List<Order>) _em.createNamedQuery("Order.findByCustomerID").setParameter("customerID", customer.getId()).getResultList();
            for (Iterator<Order> i = _orderList.iterator(); i.hasNext(); ) {
                _order = i.next();
                // update status of order if necessary
                _order.setOrderStatus(_acceptOrder(_order));
                // Get all attributes from DAO to DTO
                _orderDTO = _mapper.getOrderDTOFromOrder(_order);
                // Append DTO to list
                _orderListDTO.addOrderToList(_orderDTO);
            }

        } catch (Exception e) {
            // roll back of unit of work if possible
            if (_em.getTransaction() != null && _em.getTransaction().isActive()) {
                _em.getTransaction().rollback();
            }
            // exception caught, order has not been placed
            _orderDTO = new OrderDTO();
            _orderDTO.setReturncode(99);
            _orderDTO.setMessage("Orderlist could not be generated due to internal error");
        } finally {
            // close-sequence
            _cleanup(_em);
        }

        // check Data-Transfer-Object
        if (_orderList.size() == 0) {
            _orderListDTO = new OrderListDTO();
            _orderListDTO.setReturncode(99);
            _orderListDTO.setMessage("No Orders found for Customer");
        }
        return _orderListDTO;

    }

    /**
     * Internal method for placing an Order
     */
    private OrderDTO _placeOrder(Event event, User customer, Address shpAddress, Address payAddress, int quantity) {
        // local variables
        EntityManager _em = null;
        OrderDTO _orderDTO = null;
        Order _order = new Order();
        EntityMapper _mapper = new EntityMapper();

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            _order.setEvent(event);
            _order.setCustomer(customer);
            _order.setShippingAddress(shpAddress);
            _order.setBillingAddress(payAddress);
            _order.setQuantity(quantity);
            _order.setDate(new Timestamp(new Date().getTime()));
            OrderStatus orderStatus = new OrderStatus();
            orderStatus.setId(new Integer(orderStatus.STATUS_INPROGRESS));
            _order.setOrderStatus(orderStatus);
            _em.persist(_order);

            // commit transaction
            _em.getTransaction().commit();

            // Get all attributes from DAO to DTO
            _orderDTO = _mapper.getOrderDTOFromOrder(_order);

        } catch (Exception e) {
            // roll back of unit of work if possible
            if (_em.getTransaction() != null && _em.getTransaction().isActive()) {
                _em.getTransaction().rollback();
            }
            // exception caught, order has not been placed
            _orderDTO = new OrderDTO();
            _orderDTO.setReturncode(99);
            _orderDTO.setMessage("Order has not been placed due to internal error");
        } finally {
            // close-sequence
            _cleanup(_em);
        }

        return _orderDTO;
    }


    /**
     * internal method for cancellation of an order
     */
    private boolean _cancelOrder(Order order) {
        // logical-sequence
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setId(new Integer(orderStatus.STATUS_VOIDED));
        return _changeOrderStatus(order, orderStatus);
    }

    /**
     * internal method for statusupdate to accepted after 2 days
     * method is necessary because there is no interface to mail or
     * ticket supplier, which would have been state-responsible
     */
    private OrderStatus _acceptOrder(Order order) {
        // logical-sequence
        // check if creation date of order lies more than 2 day in the past
        Calendar calendar = new GregorianCalendar();
        Date acceptanceDate = order.getDate();    // get orderdate
        calendar.setTime(acceptanceDate);        // set it to calendar
        calendar.add(Calendar.DAY_OF_MONTH, 2); // add 2 days
        acceptanceDate = calendar.getTime();    // get changed date
        // Check time and status (cancelled orders can not be set to complete
        if (acceptanceDate.getTime() < new Date().getTime() &&
                order.getOrderStatus().getId() == order.getOrderStatus().STATUS_INPROGRESS) {
            // 2 days are over, change status of order and update on database
            OrderStatus orderStatus = _getOrderStatusByID(order.getOrderStatus().STATUS_COMPLETED);
            if (_changeOrderStatus(order, orderStatus)) {
                return orderStatus;
            } else {
                return order.getOrderStatus();
            }
        } else {
            // 2 days are not over right now or order has been cancelled, so it is okay
            return order.getOrderStatus();
        }
    }

    private OrderStatus _getOrderStatusByID(int orderStatus) {
        // local variables
        EntityManager _em = null;
        OrderStatus _orderStatus = new OrderStatus();

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            _orderStatus = _em.find(OrderStatus.class, orderStatus);

        } catch (Exception e) {
            // roll back of unit of work if possible
            if (_em.getTransaction() != null && _em.getTransaction().isActive()) {
                _em.getTransaction().rollback();
            }
            _orderStatus = null;
        } finally {
            // close-sequence
            _cleanup(_em);
        }
        return _orderStatus;
    }


    private boolean _changeOrderStatus(Order order, OrderStatus newOrderStatus) {
        // local variables
        EntityManager _em = null;
        boolean _statusChanged = true; // It is true unless it is false

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            order.setOrderStatus(newOrderStatus);
            _em.merge(order);

            // commit transaction
            _em.getTransaction().commit();

        } catch (Exception e) {
            // roll back of unit of work if possible
            if (_em.getTransaction() != null && _em.getTransaction().isActive()) {
                _em.getTransaction().rollback();
            }
            // exception caught, order has not been cancelled
            _statusChanged = false;
        } finally {
            // close-sequence
            _cleanup(_em);
        }
        return _statusChanged;
    }

    private List<OrderStatus> _getAllOrderStatuses() {

        // local variables
        EntityManager _em = null;
        List<OrderStatus> _result = null;

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            _result = _em.createNamedQuery("OrderStatus.All").getResultList();

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