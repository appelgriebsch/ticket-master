package de.fhdw.ify208.ticketmaster.dataaccess;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the t_user database table.
 */
@Entity

@NamedQueries({
        @NamedQuery(name = "User.findByUserName",
                query = "SELECT u FROM User u WHERE u.username LIKE :userName")
})
@Table(name = "t_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Date birthdate;
    private String email;
    private String firstname;
    private int gender;
    private String lastname;
    private String password;
    private String salutation;
    private String username;
    private int status;
    private List<Order> Orders;
    private Usertype UserType;
    private List<Address> Addresses;

    public User() {
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


    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    public Date getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }


    @Column(nullable = false, length = 255)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Column(nullable = false, length = 40)
    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    @Column(nullable = false)
    public int getGender() {
        return this.gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }


    @Column(nullable = false, length = 40)
    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    @Column(nullable = false, length = 255)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Column(nullable = false, length = 8)
    public String getSalutation() {
        return this.salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }


    @Column(nullable = false, length = 40)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(nullable = false)
    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    //bi-directional many-to-one association to Order
    @OneToMany(mappedBy = "customer")
    public List<Order> getOrders() {
        return this.Orders;
    }

    public void setOrders(List<Order> Orders) {
        this.Orders = Orders;
    }


    //uni-directional many-to-one association to Usertype
    @ManyToOne
    @JoinColumn(name = "type", nullable = false)
    public Usertype getUserType() {
        return this.UserType;
    }

    public void setUserType(Usertype UserType) {
        this.UserType = UserType;
    }


    //uni-directional many-to-many association to Address
    @ManyToMany
    @JoinTable(
            name = "t_user_address"
            , joinColumns = {
            @JoinColumn(name = "userid", nullable = false)
    }
            , inverseJoinColumns = {
            @JoinColumn(name = "addressid", nullable = false)
    }
    )
    public List<Address> getAddresses() {
        return this.Addresses;
    }

    public void setAddresses(List<Address> Addresses) {
        this.Addresses = Addresses;
    }

}