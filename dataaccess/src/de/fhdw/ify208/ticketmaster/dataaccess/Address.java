package de.fhdw.ify208.ticketmaster.dataaccess;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the t_address database table.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Address.findAddress",
                query = "SELECT adr FROM Address adr WHERE adr.addressline = :adrLine AND " +
                        "adr.addressType.displayname = :adrType AND adr.cityname = :cityName AND " +
                        "adr.country.isocode = :countryCode"),
        @NamedQuery(name = "Address.findAddresses",
                query = "SELECT adr FROM Address adr WHERE adr.cityname LIKE :city")
})
@Table(name = "t_address")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String addressline;
    private String cityname;
    private String districtcode;
    private String streetname;
    private String zipcode;
    private AddressType AddressType;
    private Country Country;
    private List<Event> Events;

    public Address() {
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


    @Column(nullable = false, length = 80)
    public String getAddressline() {
        return this.addressline;
    }

    public void setAddressline(String addressline) {
        this.addressline = addressline;
    }


    @Column(nullable = false, length = 40)
    public String getCityname() {
        return this.cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }


    @Column(nullable = false, length = 20)
    public String getDistrictcode() {
        return this.districtcode;
    }

    public void setDistrictcode(String districtcode) {
        this.districtcode = districtcode;
    }


    @Column(nullable = false, length = 128)
    public String getStreetname() {
        return this.streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }


    @Column(nullable = false, length = 20)
    public String getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }


    //uni-directional many-to-one association to AddressType
    @ManyToOne
    @JoinColumn(name = "type", nullable = false)
    public AddressType getAddressType() {
        return this.AddressType;
    }

    public void setAddressType(AddressType AddressType) {
        this.AddressType = AddressType;
    }


    //uni-directional many-to-one association to Country
    @ManyToOne
    @JoinColumn(name = "countrycode", nullable = false)
    public Country getCountry() {
        return this.Country;
    }

    public void setCountry(Country Country) {
        this.Country = Country;
    }


    //bi-directional many-to-one association to Event
    @OneToMany(mappedBy = "address")
    public List<Event> getEvents() {
        return this.Events;
    }

    public void setEvents(List<Event> Events) {
        this.Events = Events;
    }

}