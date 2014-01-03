package de.fhdw.ify208.ticketmaster.dataaccess;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the t_event database table.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Event.getListByDateRange",
                query = "SELECT e FROM Event e WHERE e.enddate >= :from AND e.enddate <= :to ORDER BY e.startdate"),
        @NamedQuery(name = "Event.getListByCategory",
                query = "SELECT e FROM Event e WHERE e.category.displayname = :category ORDER BY e.startdate"),
        @NamedQuery(name = "Event.getListByLocation",
                query = "SELECT e FROM Event e WHERE e.address.cityname = :cityname ORDER BY e.startdate"),
        @NamedQuery(name = "Event.findEventOnLocation",
                query = "SELECT e FROM Event e WHERE e.address.id = :locationID AND e.startdate = :startDate AND e.enddate = :endDate")
})
@Table(name = "t_event")
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String adurl;
    private String description;
    private Timestamp enddate;
    private Integer maxtickets;
    private BigDecimal price;
    private Timestamp startdate;
    private Address Address;
    private List<Artist> Artists;
    private List<Order> Orders;
    private Category Category;
    private EventStatus EventStatus;

    public Event() {
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


    @Column(nullable = false, length = 255)
    public String getAdurl() {
        return this.adurl;
    }

    public void setAdurl(String adurl) {
        this.adurl = adurl;
    }


    @Column(nullable = false, length = 2147483647)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Column(nullable = false)
    //@Temporal( TemporalType.TIMESTAMP)
    public Timestamp getEnddate() {
        return this.enddate;
    }

    public void setEnddate(Timestamp enddate) {
        this.enddate = enddate;
    }


    @Column(nullable = false)
    public Integer getMaxtickets() {
        return this.maxtickets;
    }

    public void setMaxtickets(Integer maxtickets) {
        this.maxtickets = maxtickets;
    }


    @Column(nullable = false, precision = 131089)
    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    @Column(nullable = false)
    //@Temporal( TemporalType.TIMESTAMP)
    public Timestamp getStartdate() {
        return this.startdate;
    }

    public void setStartdate(Timestamp startdate) {
        this.startdate = startdate;
    }


    //bi-directional many-to-one association to Address
    @ManyToOne
    @JoinColumn(name = "location", nullable = false)
    public Address getAddress() {
        return this.Address;
    }

    public void setAddress(Address Address) {
        this.Address = Address;
    }


    //bi-directional many-to-many association to Artist
    @ManyToMany
    @JoinTable(
            name = "t_event_artist"
            , joinColumns = {
            @JoinColumn(name = "eventid", nullable = false)
    }
            , inverseJoinColumns = {
            @JoinColumn(name = "artistid", nullable = false)
    }
    )
    public List<Artist> getArtists() {
        return this.Artists;
    }

    public void setArtists(List<Artist> Artists) {
        this.Artists = Artists;
    }


    //bi-directional many-to-one association to Order
    @OneToMany(mappedBy = "event", cascade = CascadeType.MERGE)
    public List<Order> getOrders() {
        return this.Orders;
    }

    public void setOrders(List<Order> Orders) {
        this.Orders = Orders;
    }


    //bi-directional many-to-one association to Category
    @ManyToOne
    @JoinColumn(name = "category", nullable = false)
    public Category getCategory() {
        return this.Category;
    }

    public void setCategory(Category Category) {
        this.Category = Category;
    }

    //uni-directional many-to-one association to OrderStatus
    @ManyToOne
    @JoinColumn(name = "status", nullable = false)
    public EventStatus getEventStatus() {
        return this.EventStatus;
    }

    public void setEventStatus(EventStatus EventStatus) {
        this.EventStatus = EventStatus;
    }
}