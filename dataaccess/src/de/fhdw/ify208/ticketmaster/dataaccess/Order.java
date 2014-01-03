package de.fhdw.ify208.ticketmaster.dataaccess;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


/**
 * The persistent class for the t_order database table.
 */
@Entity
@NamedQuery(name = "Order.findByCustomerID",
        query = "SELECT o FROM Order o WHERE o.customer.id = :customerID ORDER BY o.date DESC")
@Table(name = "t_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Timestamp date;
    private Integer quantity;
    private Address ShippingAddress;
    private Address BillingAddress;
    private Event Event;
    private OrderStatus OrderStatus;
    private User Customer;
    private Rating Rating;

    public Order() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    //@Temporal( TemporalType.TIMESTAMP)
    @Column(nullable = false)
    public Timestamp getDate() {
        return this.date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }


    @Column(nullable = false)
    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    //uni-directional many-to-one association to Address
    @ManyToOne
    @JoinColumn(name = "\"shippingAddress\"", nullable = false)
    public Address getShippingAddress() {
        return this.ShippingAddress;
    }

    public void setShippingAddress(Address ShippingAddress) {
        this.ShippingAddress = ShippingAddress;
    }


    //uni-directional many-to-one association to Address
    @ManyToOne
    @JoinColumn(name = "\"billingAddress\"", nullable = false)
    public Address getBillingAddress() {
        return this.BillingAddress;
    }

    public void setBillingAddress(Address BillingAddress) {
        this.BillingAddress = BillingAddress;
    }


    //bi-directional many-to-one association to Event
    @ManyToOne
    @JoinColumn(name = "eventid", nullable = false)
    public Event getEvent() {
        return this.Event;
    }

    public void setEvent(Event Event) {
        this.Event = Event;
    }


    //uni-directional many-to-one association to OrderStatus
    @ManyToOne
    @JoinColumn(name = "status", nullable = false)
    public OrderStatus getOrderStatus() {
        return this.OrderStatus;
    }

    public void setOrderStatus(OrderStatus OrderStatus) {
        this.OrderStatus = OrderStatus;
    }


    //bi-directional many-to-one association to User
    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    public User getCustomer() {
        return this.Customer;
    }

    public void setCustomer(User Customer) {
        this.Customer = Customer;
    }


    //uni-directional one-to-one association to Rating
    @OneToOne
    @JoinColumn(name = "id", nullable = false, insertable = false, updatable = false)
    public Rating getRating() {
        return this.Rating;
    }

    public void setRating(Rating Rating) {
        this.Rating = Rating;
    }

}