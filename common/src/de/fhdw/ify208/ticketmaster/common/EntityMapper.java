package de.fhdw.ify208.ticketmaster.common;

import de.fhdw.ify208.ticketmaster.common.model.*;
import de.fhdw.ify208.ticketmaster.dataaccess.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author ankariu
 */

public class EntityMapper {

    public AddressDTO getAddressDTOfromAddress(Address address) {
        // Create new instance of DTO as return value
        AddressDTO addressDTO = new AddressDTO();
        // Map ID from DAO to DTO
        addressDTO.setid(address.getId());
        // Map addressline from DAO to DTO
        addressDTO.setAddressLine(address.getAddressline());
        // Map addresstype from DAO to DTO
        addressDTO.setAddressType(getTypeCodeDTOFromAddressType(address.getAddressType()));
        // Map city from DAO to DTO
        addressDTO.setCityName(address.getCityname());
        // Map country from DAO to DTO
        addressDTO.setCountry(getCountryDTOFromCountry(address.getCountry()));
        // Map district from DAO to DTO
        addressDTO.setDistrict(address.getDistrictcode());
        // Map street from DAO to DTO
        addressDTO.setStreetName(address.getStreetname());
        // Map ZIP-code from DAO to DTO
        addressDTO.setZipCode(address.getZipcode());
        return addressDTO;
    }

    public ArtistDTO getArtistDTOFromArtist(Artist artist) {
        // Create new instance of DTO as return value
        ArtistDTO artistDTO = new ArtistDTO();
        // Map ID from DAO to DTO
        artistDTO.setid(artist.getId());
        // Map first name from DAO to DTO
        artistDTO.setFirstName(artist.getFirstname());
        // Map last name from DAO to DTO
        artistDTO.setLastName(artist.getLastname());
        // Map Genre from DAO to DTO
        artistDTO.setGenre(getTypeCodeDTOFromGenre(artist.getGenre()));
        // Map stage name from DAO to DTO
        artistDTO.setStageName(artist.getDisplayname());
        return artistDTO;
    }

    public CustomerDTO getCustomerDTOFromUser(User user) {
        // Create new instance of DTO as return value
        CustomerDTO customerDTO = new CustomerDTO();
        // Map date of birth from DAO to DTO
        customerDTO.setBirthdate(user.getBirthdate());
        // Map e-mail from DAO to DTO
        customerDTO.setEmail(user.getEmail());
        // Map firstname from DAO to DTO
        customerDTO.setFirstName(user.getFirstname());
        // Map ID from DAO to DTO
        customerDTO.setid(user.getId());
        // Map lastname from DAO to DTO
        customerDTO.setLastName(user.getLastname());
        // Map password from DAO to DTO
        customerDTO.setPassword(user.getPassword());
        // Map salutation from DAO to DTO
        customerDTO.setSalutation(user.getSalutation());
        // Map usertype from DAO to DTO
        customerDTO.setType(getTypeCodeDTOFromUserType(user.getUserType()));
        // Map username from DAO to DTO
        customerDTO.setUserName(user.getUsername());
        // Map gender from DAO to DTO
        if (user.getGender() == 0) {
            customerDTO.setGenderType(GenderType.Male);
        } else {
            customerDTO.setGenderType(GenderType.Female);
        }
        if (user.getStatus() == 0) {
            customerDTO.setStatus(CustomerStatus.Active);
        } else {
            customerDTO.setStatus(CustomerStatus.Inactive);
        }

        return customerDTO;
    }

    public CountryDTO getCountryDTOFromCountry(Country country) {
        // Create new instance of DTO as return value
        CountryDTO countryDTO = new CountryDTO();
        // Map country name from DAO to DTO
        countryDTO.setName(country.getName());
        // Map country description from DAO to DTO
        countryDTO.setDescription(country.getDescription());
        // Map country ISO code from DAO to DTO
        countryDTO.setIsoCode(country.getIsocode());
        return countryDTO;
    }

    public EventDTO getEventDTOFromEvent(Event event) {
        // Create new instance of DTO as return value
        EventDTO eventDTO = new EventDTO();
        // Map ID from DAO to DTO
        eventDTO.setid(event.getId());
        // Map additional URL from DAO to DTO
        eventDTO.setAdUrl(event.getAdurl());
        // Map ArtistList from DAO to DTO
        List<Artist> artistList = event.getArtists();
        ArtistListDTO artistListDTO = new ArtistListDTO();
        for (Iterator<Artist> i = artistList.iterator(); i.hasNext(); ) {
            artistListDTO.addArtistToList(getArtistDTOFromArtist(i.next()));
        }
        eventDTO.setArtists(artistListDTO);
        // Map category from DAO to DTO
        eventDTO.setCategory(getTypeCodeDTOFromCategory(event.getCategory()));
        // Map eventstatus from DAO to DTO
        eventDTO.setEventStatus(getTypeCodeDTOFromEventStatus(event.getEventStatus()));
        // Map description from DAO to DTO
        eventDTO.setDescription(event.getDescription());
        // Map startdate from DAO to DTO
        eventDTO.setStartDate(event.getStartdate());
        // Map enddate from DAO to DTO
        eventDTO.setEndDate(event.getEnddate());
        // Map location from DAO to DTO
        eventDTO.setLocation(getAddressDTOfromAddress(event.getAddress()));
        // Map maximum tickets from DAO to DTO
        eventDTO.setMaxNoOfTickets(event.getMaxtickets());
        // Map available tickets from DAO to DTO
        List<Order> orderList = event.getOrders();
        Rating rating = null;
        RatingListDTO ratingListDTO = new RatingListDTO();
        Integer availableTickets = event.getMaxtickets();
        Integer ratingNumber = 0;
        BigDecimal ratingSum = new BigDecimal(0);
        if (orderList != null) {
            for (Iterator<Order> j = orderList.iterator(); j.hasNext(); ) {
                Order _order = j.next();
                // subtract tickets of order from maximum amount of tickets
                availableTickets = availableTickets - _order.getQuantity();
                // sum all rating and set number of rating for average calculation
                rating = _order.getRating();
                if (rating != null) {
                    ratingNumber++;
                    ratingSum = ratingSum.add(rating.getRating());
                    ratingListDTO.addOrderToList(getRatingDTOFromRating(rating,_order.getCustomer().getUsername()));
                }
                rating = null;
            }
        }
        eventDTO.setAvailableTickets(availableTickets);
        // Map ratings from DAO to DTO
        eventDTO.setRatings(ratingListDTO);
        // Map average rating from DAO to DTO
        eventDTO.setAvrgRating(ratingSum.doubleValue() / ratingNumber);
        // Map ticket price from DAO to DTO
        eventDTO.setTicketPrice(event.getPrice());
        return eventDTO;
    }

    public OrderDTO getOrderDTOFromOrder(Order order) {
        // Create new instance of DTO as return value
        OrderDTO orderDTO = new OrderDTO();
        // Map id from DAO to DTO
        orderDTO.setid(order.getId());
        // Map date of order from DAO to DTO
        orderDTO.setOrderDate(order.getDate());
        // Map quantity from DAO to DTO
        orderDTO.setOrderQuantity(order.getQuantity());
        // Map status from DAO to DTO
        orderDTO.setOrderStatus(getTypeCodeDTOFromOrderStatus(order.getOrderStatus()));
        // Map billing address from DAO to DTO
        orderDTO.setBillingAddress(getAddressDTOfromAddress(order.getBillingAddress()));
        // Map shipping address from DOA to DTO
        orderDTO.setShippingAddress(getAddressDTOfromAddress(order.getShippingAddress()));
        ;
        // Map event from DAO to DTO
        orderDTO.setEvent(getEventDTOFromEvent(order.getEvent()));
        // Map Customer from DAO to DTO
        orderDTO.setCustomer(getCustomerDTOFromUser(order.getCustomer()));
        return orderDTO;
    }

    public RatingDTO getRatingDTOFromRating(Rating rating, String userName) {
        RatingDTO ratingDTO = new RatingDTO();
        ratingDTO.setUserName(userName);
        ratingDTO.setComment(rating.getComment());
        ratingDTO.setRating(rating.getRating().doubleValue());
        ratingDTO.setTimestamp(rating.getDate());
        return ratingDTO;
    }

    public TypeCodeDTO getTypeCodeDTOFromOrderStatus(OrderStatus orderStatus) {
        TypeCodeDTO typeCodeDTO = new TypeCodeDTO();
        typeCodeDTO.setId(orderStatus.getId());
        typeCodeDTO.setName(orderStatus.getDisplayname());
        typeCodeDTO.setDescription(orderStatus.getDescription());
        return typeCodeDTO;
    }

    public TypeCodeDTO getTypeCodeDTOFromGenre(Genre genre) {
        TypeCodeDTO typeCodeDTO = new TypeCodeDTO();
        typeCodeDTO.setId(genre.getId());
        typeCodeDTO.setName(genre.getDisplayname());
        typeCodeDTO.setDescription(genre.getDescription());
        return typeCodeDTO;
    }

    public TypeCodeDTO getTypeCodeDTOFromCategory(Category category) {
        TypeCodeDTO typeCodeDTO = new TypeCodeDTO();
        typeCodeDTO.setId(category.getId());
        typeCodeDTO.setName(category.getDisplayname());
        typeCodeDTO.setDescription(category.getDescription());
        return typeCodeDTO;
    }

    public TypeCodeDTO getTypeCodeDTOFromEventStatus(EventStatus eventStatus) {
        TypeCodeDTO typeCodeDTO = new TypeCodeDTO();
        typeCodeDTO.setId(eventStatus.getId());
        typeCodeDTO.setName(eventStatus.getDisplayname());
        typeCodeDTO.setDescription(eventStatus.getDescription());
        return typeCodeDTO;
    }

    public TypeCodeDTO getTypeCodeDTOFromAddressType(AddressType addressType) {
        TypeCodeDTO typeCodeDTO = new TypeCodeDTO();
        typeCodeDTO.setId(addressType.getId());
        typeCodeDTO.setName(addressType.getDisplayname());
        typeCodeDTO.setDescription(addressType.getDescription());
        return typeCodeDTO;
    }

    public TypeCodeDTO getTypeCodeDTOFromUserType(Usertype userType) {
        TypeCodeDTO typeCodeDTO = new TypeCodeDTO();
        typeCodeDTO.setId(userType.getId());
        typeCodeDTO.setName(userType.getDisplayname());
        typeCodeDTO.setDescription(userType.getDescription());
        return typeCodeDTO;
    }

    // DTO to DAO

    public Address getAddressfromAddressDTO(AddressDTO addressDTO) {
        // Create new instance of DAO as return value
        Address address = new Address();
        // Map ID from DTO to DAO
        address.setId(addressDTO.getid());
        // Map addressline from DAO to DTO
        address.setAddressline(addressDTO.getAddressLine());
        // Map addresstype from DAO to DTO
        address.setAddressType(getAddressTypeFromTypeCodeDTO(addressDTO.getAddressType()));
        // Map city from DAO to DTO
        address.setCityname(addressDTO.getCityName());
        // Map country from DAO to DTO
        address.setCountry(getCountryFromCountryDTO(addressDTO.getCountry()));
        // Map district from DAO to DTO
        address.setDistrictcode(addressDTO.getDistrict());
        // Map street from DAO to DTO
        address.setStreetname(addressDTO.getStreetName());
        // Map ZIP-code from DAO to DTO
        address.setZipcode(addressDTO.getZipCode());
        return address;
    }

    public Artist getArtistFromArtistDTO(ArtistDTO artistDTO) {
        Artist artist = new Artist();
        // Map id from DTO to DAO
        artist.setId(artistDTO.getid());
        // Map first name from DTO to DAO
        artist.setFirstname(artistDTO.getFirstName());
        // Map last name from DTO to DAO
        artist.setLastname(artistDTO.getLastName());
        // Map Genre from DTO to DAO
        artist.setGenre(getGenreFromTypeCodeDTO(artistDTO.getGenre()));
        // Map stage name from DTO to DAO
        artist.setDisplayname(artistDTO.getStageName());
        return artist;
    }

    public User getUserFromCustomerDTO(CustomerDTO customerDTO) {
        // Create new instance of DTO as return value
        User customer = new User();
        // Map date of birth from DAO to DTO
        customer.setBirthdate(customerDTO.getBirthdate());
        // Map e-mail from DAO to DTO
        customer.setEmail(customerDTO.getEmail());
        // Map firstname from DAO to DTO
        customer.setFirstname(customerDTO.getFirstName());
        // Map ID from DAO to DTO
        customer.setId(customerDTO.getid());
        // Map lastname from DAO to DTO
        customer.setLastname(customerDTO.getLastName());
        // Map password from DAO to DTO
        customer.setPassword(customerDTO.getPassword());
        // Map salutation from DAO to DTO
        customer.setSalutation(customerDTO.getSalutation());
        // Map usertype from DAO to DTO
        customer.setUserType(getUserTypeFromTypeCodeDTO(customerDTO.getType()));
        // Map username from DAO to DTO
        customer.setUsername(customerDTO.getUserName());
        // Map gender from DAO to DTO
        if (customerDTO.getGenderType() == GenderType.Male) {
            customer.setGender(0);
        } else {
            customer.setGender(1);
        }
        if (customerDTO.getStatus() == CustomerStatus.Active) {
            customer.setStatus(0);
        } else {
            customer.setStatus(1);
        }

        return customer;
    }

    public Country getCountryFromCountryDTO(CountryDTO countryDTO) {
        // Create new instance of DAO as return value
        Country country = new Country();
        // Map country name from DTO to DAO
        country.setName(countryDTO.getName());
        // Map country description from DTO to DAO
        country.setDescription(countryDTO.getDescription());
        // Map country ISO code from DTO to DAO
        country.setIsocode(countryDTO.getIsoCode());
        return country;
    }

    public Event getEventFromEventDTO(EventDTO eventDTO) {
        Event event = new Event();
        // Map URL from DTO to DAO
        event.setAdurl(eventDTO.getAdUrl().toString());
        // Map ArtistList from DTO to DAO
        ArtistListDTO artistListDTO = eventDTO.getArtists();
        List<ArtistDTO> artistDTOList = new ArrayList<ArtistDTO>(artistListDTO.getArtistDTOList());
        List<Artist> artistList = new ArrayList<Artist>();
        for (Iterator<ArtistDTO> i = artistDTOList.iterator(); i.hasNext(); ) {
            artistList.add(getArtistFromArtistDTO(i.next()));
        }
        event.setArtists(artistList);
        // Map category from DTO to DAO
        event.setCategory(getCategoryFromTypeCodeDTO(eventDTO.getCategory()));
        // Map eventstatus from DTO to DAO
        if (eventDTO.getEventStatus() != null) {
            // During event-creation status is not set at this point
            event.setEventStatus(getEventStatusFromTypeCodeDTO(eventDTO.getEventStatus()));
        }
        // Map description from DTO to DAO
        event.setDescription(eventDTO.getDescription());
        // Map startdate from DTO to DAO
        event.setStartdate(new Timestamp(eventDTO.getStartDate().getTime()));
        // Map enddate from DTO to DAO
        event.setEnddate(new Timestamp(eventDTO.getEndDate().getTime()));
        // Map location from DTO to DAO
        event.setAddress(getAddressfromAddressDTO(eventDTO.getLocation()));
        // Map maximum tickets from DTO to DAO
        event.setMaxtickets(eventDTO.getMaxNoOfTickets());
        // Map average rating from DTO to DAO
        event.setPrice(eventDTO.getTicketPrice());
        return event;
    }

    public Genre getGenreFromTypeCodeDTO(TypeCodeDTO typeCodeDTO) {
        Genre genre = new Genre();
        genre.setId(typeCodeDTO.getId());
        genre.setDisplayname(typeCodeDTO.getName());
        genre.setDescription(typeCodeDTO.getDescription());
        return genre;
    }

    public Category getCategoryFromTypeCodeDTO(TypeCodeDTO typeCodeDTO) {
        Category category = new Category();
        category.setId(typeCodeDTO.getId());
        category.setDisplayname(typeCodeDTO.getName());
        category.setDescription(typeCodeDTO.getDescription());
        return category;
    }

    public EventStatus getEventStatusFromTypeCodeDTO(TypeCodeDTO typeCodeDTO) {
        EventStatus eventStatus = new EventStatus();
        eventStatus.setId(typeCodeDTO.getId());
        eventStatus.setDisplayname(typeCodeDTO.getName());
        eventStatus.setDescription(typeCodeDTO.getDescription());
        return eventStatus;
    }

    public AddressType getAddressTypeFromTypeCodeDTO(TypeCodeDTO typeCodeDTO) {
        AddressType addressType = new AddressType();
        addressType.setId(typeCodeDTO.getId());
        addressType.setDisplayname(typeCodeDTO.getName());
        addressType.setDescription(typeCodeDTO.getDescription());
        return addressType;
    }

    public Usertype getUserTypeFromTypeCodeDTO(TypeCodeDTO typeCodeDTO) {
        Usertype userType = new Usertype();
        userType.setId(typeCodeDTO.getId());
        userType.setDisplayname(typeCodeDTO.getName());
        userType.setDescription(typeCodeDTO.getDescription());
        return userType;
    }

}
