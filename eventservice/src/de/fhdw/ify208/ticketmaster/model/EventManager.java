package de.fhdw.ify208.ticketmaster.model;

import de.fhdw.ify208.ticketmaster.common.BaseEntityManager;
import de.fhdw.ify208.ticketmaster.common.EntityMapper;
import de.fhdw.ify208.ticketmaster.common.model.*;
import de.fhdw.ify208.ticketmaster.dataaccess.*;

import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author ankariu
 *
 */

/**
 * Singleton-Implementation of OrderManager
 */
public class EventManager extends BaseEntityManager {

    private static EventManager _instance = null;

    /**
     * Internal default constructor
     */
    private EventManager() {
    }


    /**
     * External static method returning instance of class
     * @return EventManager
     */
    public static EventManager getInstance() {
        if (_instance == null) {
            _instance = new EventManager();
        }
        return _instance;
    }

    /**
     * @param artistName
     * @return EventListDTO
     */
    public EventListDTO getEventsByArtist(String artistName) {
        // Get events with artists attendance
        return _getEventsByArtist(artistName);
    }

    /**
     * @param cityName
     * @return EventListDTO
     */
    public EventListDTO getEventsByLocation(String cityName) {
        // Get events in city
        EventListDTO _eventListDTO = _getEventsByLocation(cityName);
        if (_eventListDTO == null) {
            _eventListDTO = new EventListDTO();
            _eventListDTO.setReturncode(99);
            _eventListDTO.setMessage("No events found for city in database");
        }
        return _eventListDTO;
    }

    /**
     * @param genreName
     * @return EventListDTO
     */
    public EventListDTO getEventsByGenre(String genreName) {
        // Check genre exists
        Genre genre = _checkGenreExists(genreName);
        // Get events for genre
        if (genre != null) {
            return _getEventsByGenre(genre.getId());
        } else {
            EventListDTO _eventListDTO = new EventListDTO();
            _eventListDTO.setReturncode(99);
            _eventListDTO.setMessage("Event does not existing in database");
            return _eventListDTO;
        }

    }

    /**
     * @param category
     * @return EventListDTO
     */
    public EventListDTO getEventsByCategory(String category) {
        // Get events for category
        EventListDTO _eventListDTO = _getEventsByCategory(category);
        if (_eventListDTO == null) {
            _eventListDTO = new EventListDTO();
            _eventListDTO.setReturncode(99);
            _eventListDTO.setMessage("No events found for category in database");
        }
        return _eventListDTO;
    }

    /**
     * @param startDate
     * @param endDate
     * @return EventListDTO
     */
    public EventListDTO getEventsByDateRange(Date startDate, Date endDate) {
        // Get events by in date range
        EventListDTO _eventListDTO = _getEventsByDateRange(startDate, endDate);
        if (_eventListDTO == null) {
            _eventListDTO = new EventListDTO();
            _eventListDTO.setReturncode(99);
            _eventListDTO.setMessage("No events found in range in database");
        }
        return _eventListDTO;
    }

    /**
     * @param theEvent
     * @return BaseDTO
     */
    public BaseDTO registerNewEvent(EventDTO theEvent) {
        BaseDTO baseDTO;
        EntityMapper mapper = new EntityMapper();
        // Check event exists
        Event event = _checkEventExistsOnLocation(theEvent.getStartDate(), theEvent.getEndDate(),
                mapper.getAddressfromAddressDTO(theEvent.getLocation()));
        // Create event if event not registered
        if (event != null) {
            baseDTO = new BaseDTO();
            baseDTO.setReturncode(1);
            baseDTO.setMessage("There is already an event registered on this location at this time.");
        } else {
            // Map eventDTO to event
            event = mapper.getEventFromEventDTO(theEvent);
            EventStatus eventStatus = new EventStatus();
            eventStatus.setId(eventStatus.STATUS_OPEN);
            event.setEventStatus(eventStatus);

            // check event location
            Address address = _checkAddressExists(theEvent.getLocation().getAddressType().getName(),
                    theEvent.getLocation().getAddressLine(),
                    theEvent.getLocation().getCityName(),
                    theEvent.getLocation().getCountry().getIsoCode());
            if (address == null) {
                address = _createAddress(mapper.getAddressfromAddressDTO(theEvent.getLocation()));
            }

            event.setAddress(address);

            // Register event
            baseDTO = _registerNewEvent(event);
        }
        return baseDTO;
    }

    /**
     * @param theArtist
     * @return BaseDTO
     */
    public BaseDTO registerNewArtist(ArtistDTO theArtist) {
        BaseDTO baseDTO;
        EntityMapper mapper = new EntityMapper();
        // Check artist exists
        Artist artist = _checkArtistExists(theArtist.getStageName());
        // Create artist if not registered up to know
        if (artist != null) {
            baseDTO = new BaseDTO();
            baseDTO.setReturncode(1);
            baseDTO.setMessage("artist already registered");
        } else {
            // check if genre exists
            Genre genre = _checkGenreExists(theArtist.getGenre().getName());
            if (genre == null) {
                genre = _createGenre(mapper.getGenreFromTypeCodeDTO(theArtist.getGenre()));
            }
            // Map artistDTO to artist
            artist = mapper.getArtistFromArtistDTO(theArtist);
            artist.setGenre(genre);
            // Register artist
            baseDTO = _registerNewArtist(artist);
        }
        return baseDTO;
    }

    /**
     * @param theEvent
     * @return BaseDTO
     */
    public BaseDTO cancelEvent(EventDTO theEvent) {
        BaseDTO baseDTO;
        // Check event exists
        Event event = _checkEventExists(theEvent.getid());
        // Cancel event if registered
        if (event == null) {
            baseDTO = new BaseDTO();
            baseDTO.setReturncode(99);
            baseDTO.setMessage("event is not registered and can't be cancelled");
        } else {
            // Event is existing, check status update
            _updateEventStatusToCompleted(event);
            // Check Status
            if (event.getEventStatus().getId() == event.getEventStatus().STATUS_OPEN) {
                baseDTO = _cancelEvent(event);
            } else {
                baseDTO = new BaseDTO();
                baseDTO.setReturncode(99);
                baseDTO.setMessage("event has not status open and can't be cancelled");
            }
        }
        return baseDTO;
    }

    /**
     * @param theEvent
     * @param theCustomer
     * @param rating
     * @param comment
     * @return BaseDTO
     */
    public BaseDTO rateEvent(EventDTO theEvent, CustomerDTO theCustomer, double rating, String comment) {
        // local variables
        BaseDTO baseDTO = null;
        Event event = null;
        User customer = null;

        // Check event exists
        event = _checkEventExists(theEvent.getid());
        // Check customer exists
        customer = _checkCustomerExists(theCustomer.getid());
        if (event == null) {
            baseDTO = new BaseDTO();
            baseDTO.setReturncode(99);
            baseDTO.setMessage("Event does not existing in database");
        } else if (customer == null) {
            baseDTO = new BaseDTO();
            baseDTO.setReturncode(99);
            baseDTO.setMessage("Customer does not existing in database");
        } /*else if (event.getEventStatus().getId() != event.getEventStatus().STATUS_COMPLETED) {
            baseDTO = new BaseDTO();
            baseDTO.setReturncode(99);
            baseDTO.setMessage("Event ist either cancelled or not finished, so rating is not possible");
        } */else {
            baseDTO = _rateEvent(event, customer, rating, comment);
        }

        // Rate Event
        return baseDTO;
    }

    /**
     * @return TypeCodeListDTO
     */
    public TypeCodeListDTO getEventStatuses() {

        TypeCodeListDTO listDTO = new TypeCodeListDTO();
        EntityMapper mapper = new EntityMapper();

        List<EventStatus> _listOfEventStatuses = this._getAllEventStatuses();
        for (Iterator<EventStatus> iter = _listOfEventStatuses.iterator(); iter.hasNext(); ) {

            listDTO.addTypeCodeToList(mapper.getTypeCodeDTOFromEventStatus(iter.next()));
        }

        if (listDTO.getTypeCodeDTOList().size() >= 0) {
            listDTO.setReturncode(0);
        } else {
            listDTO.setReturncode(99);
            listDTO.setMessage("Error getting event statuses from database");
        }
        return listDTO;
    }

    /**
     * @return TypeCodeListDTO
     */
    public TypeCodeListDTO getGenres() {

        TypeCodeListDTO listDTO = new TypeCodeListDTO();
        EntityMapper mapper = new EntityMapper();

        List<Genre> _listOfGenres = this._getAllGenres();
        for (Iterator<Genre> iter = _listOfGenres.iterator(); iter.hasNext(); ) {

            listDTO.addTypeCodeToList(mapper.getTypeCodeDTOFromGenre(iter.next()));
        }

        if (listDTO.getTypeCodeDTOList().size() >= 0) {
            listDTO.setReturncode(0);
        } else {
            listDTO.setReturncode(99);
            listDTO.setMessage("Error getting genres from database");
        }
        return listDTO;
    }

    /**
     * @return TypeCodeListDTO
     */
    public TypeCodeListDTO getCategories() {

        TypeCodeListDTO listDTO = new TypeCodeListDTO();
        EntityMapper mapper = new EntityMapper();

        List<Category> _listOfCategories = this._getAllCategories();
        for (Iterator<Category> iter = _listOfCategories.iterator(); iter.hasNext(); ) {

            listDTO.addTypeCodeToList(mapper.getTypeCodeDTOFromCategory(iter.next()));
        }

        if (listDTO.getTypeCodeDTOList().size() >= 0) {
            listDTO.setReturncode(0);
        } else {
            listDTO.setReturncode(99);
            listDTO.setMessage("Error getting categories from database");
        }
        return listDTO;
    }

    /**
     * @param artistName
     * @return ArtistDTO
     */
    public ArtistDTO findArtist(String artistName) {

        ArtistDTO result = new ArtistDTO();
        EntityMapper mapper = new EntityMapper();

        Artist artist = _checkArtistExists(artistName);

        if (artist == null) {
            result.setReturncode(99);
            result.setMessage("Artist does not exists!");
        } else {
            result = mapper.getArtistDTOFromArtist(artist);
        }

        return result;
    }

    /**
     * @param filter
     * @return ArtistListDTO
     */
    public ArtistListDTO findArtists(String filter) {

        ArtistListDTO result = new ArtistListDTO();
        EntityMapper mapper = new EntityMapper();

        List<Artist> artists = _findArtists(filter);

        for (Artist a : artists) {

            result.addArtistToList(mapper.getArtistDTOFromArtist(a));
        }

        return result;
    }

    /**
     * @param filter
     * @return AddressListDTO
     */
    public AddressListDTO findLocations(String filter) {

        AddressListDTO result = new AddressListDTO();
        EntityMapper mapper = new EntityMapper();

        List<Address> addresses = _findAddresses(filter);

        for(Address a: addresses) {
            
            result.addAddressToList(mapper.getAddressDTOfromAddress(a));
        }
        
        return  result;
    }

    @SuppressWarnings("unchecked")
    private EventListDTO _getEventsByArtist(String artistName) {
        // local variables
        EntityManager _em = null;
        EventListDTO _eventListDTO = null;
        List<Artist> _artistList = null;

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            _artistList = (List<Artist>) _em.createNamedQuery("Artist.findByArtistName").setParameter("artistName",
                    String.format("%%%s%%", artistName)).getResultList();

            // check result
            if (_artistList == null || _artistList.size() == 0) {
                _eventListDTO = new EventListDTO();
                _eventListDTO.setReturncode(99);
                _eventListDTO.setMessage("No Events found for artist");
            } else {
                _eventListDTO = _getEventListDTOfromArtistResultList(_artistList);
            }

        } catch (Exception e) {
            // roll back of unit of work if possible
            if (_em.getTransaction() != null && _em.getTransaction().isActive()) {
                _em.getTransaction().rollback();
            }
            // exception caught, no events found for artist
            _eventListDTO.setReturncode(99);
            _eventListDTO.setMessage("No Events found for artist due to internal error");
        } finally {
            // close-sequence
            _cleanup(_em);
        }
        return _eventListDTO;
    }

    @SuppressWarnings("unchecked")
    private EventListDTO _getEventsByLocation(String cityName) {
        // local variables
        EntityManager _em = null;
        EventListDTO _eventListDTO = null;
        List<Event> _eventList = null;

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            _eventList = (List<Event>) _em.createNamedQuery("Event.getListByLocation").setParameter("cityname", cityName).getResultList();

            // check result
            if (_eventList == null || _eventList.size() == 0) {
                _eventListDTO = new EventListDTO();
                _eventListDTO.setReturncode(99);
                _eventListDTO.setMessage("No Events found for city");
            } else {
                _eventListDTO = _getEventListDTOfromEventResultList(_eventList);
            }

        } catch (Exception e) {
            // roll back of unit of work if possible
            if (_em.getTransaction() != null && _em.getTransaction().isActive()) {
                _em.getTransaction().rollback();
            }
            // exception caught, no events found for location
            _eventListDTO.setReturncode(99);
            _eventListDTO.setMessage("No Events found for artist due to internal error");
        } finally {
            // close-sequence
            _cleanup(_em);
        }
        return _eventListDTO;
    }

    @SuppressWarnings("unchecked")
    private EventListDTO _getEventsByGenre(long genreID) {
        // local variables
        EntityManager _em = null;
        EventListDTO _eventListDTO = null;
        List<Artist> _artistList = null;

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            _artistList = _em.createNamedQuery("Artist.getListByGenre").setParameter("genreID", genreID).getResultList();

            // check result
            if (_artistList == null || _artistList.size() == 0) {
                _eventListDTO = new EventListDTO();
                _eventListDTO.setReturncode(99);
                _eventListDTO.setMessage("No Events found for genre");
            } else {
                _eventListDTO = _getEventListDTOfromArtistResultList(_artistList);
            }

            // commit transaction
            _em.getTransaction().commit();

        } catch (Exception e) {
            // roll back of unit of work if possible
            if (_em.getTransaction() != null && _em.getTransaction().isActive()) {
                _em.getTransaction().rollback();
            }
            // exception caught, no events found for genre
            _eventListDTO.setReturncode(99);
            _eventListDTO.setMessage("No Events found for artist due to internal genre");
        } finally {
            // close-sequence
            _cleanup(_em);
        }
        return _eventListDTO;
    }

    @SuppressWarnings("unchecked")
    private EventListDTO _getEventsByCategory(String category) {
        // local variables
        EntityManager _em = null;
        EventListDTO _eventListDTO = null;
        List<Event> _eventList = null;

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            _eventList = (List<Event>) _em.createNamedQuery("Event.getListByCategory").setParameter("category", category).getResultList();

            // check result
            if (_eventList == null || _eventList.size() == 0) {
                _eventListDTO = new EventListDTO();
                _eventListDTO.setReturncode(99);
                _eventListDTO.setMessage("No Events found for category");
            } else {
                _eventListDTO = _getEventListDTOfromEventResultList(_eventList);
            }

        } catch (Exception e) {
            // roll back of unit of work if possible
            if (_em.getTransaction() != null && _em.getTransaction().isActive()) {
                _em.getTransaction().rollback();
            }
            // exception caught, no events found for category
            _eventListDTO.setReturncode(99);
            _eventListDTO.setMessage("No Events found for category due to internal error");
        } finally {
            // close-sequence
            _cleanup(_em);
        }
        return _eventListDTO;
    }

    @SuppressWarnings("unchecked")
    private EventListDTO _getEventsByDateRange(Date startDate, Date endDate) {
        // local variables
        EntityManager _em = null;
        EventListDTO _eventListDTO = null;
        List<Event> _eventList = null;

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            _eventList = (List<Event>) _em.createNamedQuery("Event.getListByDateRange")
                    .setParameter("from", new Timestamp(startDate.getTime()), TemporalType.TIMESTAMP)
                    .setParameter("to", new Timestamp(endDate.getTime()), TemporalType.TIMESTAMP)
                    .getResultList();

            // check result
            if (_eventList == null || _eventList.size() == 0) {
                _eventListDTO = new EventListDTO();
                _eventListDTO.setReturncode(99);
                _eventListDTO.setMessage("No Events found in daterange");
            } else {
                // Update status if necessary
                for (Iterator<Event> i = _eventList.iterator(); i.hasNext(); ) {
                    _updateEventStatusToCompleted(i.next());
                }
                _eventListDTO = _getEventListDTOfromEventResultList(_eventList);
            }

        } catch (Exception e) {
            // roll back of unit of work if possible
            if (_em.getTransaction() != null && _em.getTransaction().isActive()) {
                _em.getTransaction().rollback();
            }
            // exception caught, no events found in daterange
            _eventListDTO.setReturncode(99);
            _eventListDTO.setMessage("No Events found in daterange due to internal error");
        } finally {
            // close-sequence
            _cleanup(_em);
        }
        return _eventListDTO;
    }

    private BaseDTO _registerNewEvent(Event event) {

        // local variables
        EntityManager _em = null;
        BaseDTO baseDTO = new BaseDTO();

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            _em.merge(event);

            // commit transaction
            _em.getTransaction().commit();
        } catch (Exception e) {
            // roll back of unit of work if possible
            if (_em.getTransaction() != null && _em.getTransaction().isActive()) {
                _em.getTransaction().rollback();
            }
            baseDTO.setReturncode(99);
            baseDTO.setMessage("Event could not be created.");
        } finally {
            // close-sequence
            _cleanup(_em);
        }
        return baseDTO;
    }

    private BaseDTO _registerNewArtist(Artist artist) {

        // local variables
        EntityManager _em = null;
        BaseDTO baseDTO = new BaseDTO();

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            _em.persist(artist);

            // commit transaction
            _em.getTransaction().commit();
        } catch (Exception e) {
            // roll back of unit of work if possible
            if (_em.getTransaction() != null && _em.getTransaction().isActive()) {
                _em.getTransaction().rollback();
            }
            baseDTO.setReturncode(99);
            baseDTO.setMessage("Artist could not be created.");
        } finally {
            // close-sequence
            _cleanup(_em);
        }
        return baseDTO;
    }

    private Genre _createGenre(Genre genre) {

        // local variables
        EntityManager _em = null;
        Genre result = null;

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            _em.persist(genre);

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

        return _checkGenreExists(genre.getDisplayname());
    }

    private BaseDTO _cancelEvent(Event event) {

        // cancel depending orders.
        List<Order> orderList = event.getOrders();
        for (Iterator<Order> i = orderList.iterator(); i.hasNext(); ) {
            Order order = i.next();
            OrderStatus newOrderStatus = new OrderStatus();
            newOrderStatus.setId(order.getOrderStatus().STATUS_VOIDED);
            order.setOrderStatus(newOrderStatus);
        }

        // set status of event to cancelled
        EventStatus eventStatus = new EventStatus();
        eventStatus.setId(eventStatus.STATUS_VOIDED);

        return _updateEventStatus(event, eventStatus);
    }

    private void _updateEventStatusToCompleted(Event event) {

        // check if enddate of order lies in the past and status is open
        if (event.getEnddate().before(new Date()) &&
                event.getEventStatus().getId() == event.getEventStatus().STATUS_OPEN) {
            // 2 days are over, change status of order and update on database
            EventStatus eventStatus = new EventStatus();
            eventStatus.setId(eventStatus.STATUS_COMPLETED);
            _updateEventStatus(event, eventStatus);
        } else {
            // do nothing
        }
    }

    private BaseDTO _updateEventStatus(Event event, EventStatus newEventStatus) {
        // local variables
        EntityManager _em = null;
        BaseDTO _baseDTO = new BaseDTO();

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            event.setEventStatus(newEventStatus);
            _em.merge(event);

            // commit transaction
            _em.getTransaction().commit();

        } catch (Exception e) {
            // roll back of unit of work if possible
            if (_em.getTransaction() != null && _em.getTransaction().isActive()) {
                _em.getTransaction().rollback();
            }
            // exception caught, no cancellation of event
            _baseDTO.setReturncode(99);
            _baseDTO.setMessage("Events could not be cancelled due to internal error");
        } finally {
            // close-sequence
            _cleanup(_em);
        }
        return _baseDTO;
    }

    @SuppressWarnings("unchecked")
    private BaseDTO _rateEvent(Event event, User customer, double rating, String comment) {
        // local variables
        EntityManager _em = null;
        BaseDTO _baseDTO = new BaseDTO();
        List<Order> _orderList = null;
        Order _order = null;
        Rating _rating = null;

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence - the rating is attached to the order - get orders for user
            _orderList = (List<Order>) _em.createNamedQuery("Order.findByCustomerID").setParameter("customerID", customer.getId()).getResultList();
            for (Iterator<Order> i = _orderList.iterator(); i.hasNext(); ) {
                Order _orderTemp = i.next();
                // get the order to the event to be rated
                if (_orderTemp.getEvent().getId() == event.getId()) {
                    // check if order was not rated right now and has been processed
                    if (_orderTemp.getRating() == null &&
                            _orderTemp.getOrderStatus().getId() == _orderTemp.getOrderStatus().STATUS_COMPLETED) {
                        _order = _orderTemp;
                        break;
                    }
                }
            }

            // create rating and if fitting order was found
            if (_order != null) {
                _rating = new Rating();
                _rating.setId(_order.getId());
                _rating.setComment(comment);
                _rating.setDate(new Timestamp(new Date().getTime())); // new Date initialized with current time
                _rating.setRating(new BigDecimal(rating));
                _order.setRating(_rating);
                //_em.persist(rating);
                _em.merge(_order);

                // commit transaction
                _em.getTransaction().commit();
            } else {
                // no order found for user and event, so nothing to rate
                _baseDTO.setReturncode(99);
                _baseDTO.setMessage("Events could not be rated.");
            }
        } catch (Exception e) {
            // roll back of unit of work if possible
            if (_em.getTransaction() != null && _em.getTransaction().isActive()) {
                _em.getTransaction().rollback();
            }
            // exception caught, no rating of event
            _baseDTO.setReturncode(99);
            _baseDTO.setMessage("Events could not be rated due to internal error");
        } finally {
            // close-sequence
            _cleanup(_em);
        }
        return _baseDTO;
    }

    private EventListDTO _getEventListDTOfromEventResultList(List<Event> eventList) {
        // local variables
        EventListDTO _eventListDTO = new EventListDTO();
        EventDTO _eventDTO = new EventDTO();
        Event _event = null;
        EntityMapper _mapper = new EntityMapper();

        for (Iterator<Event> i = eventList.iterator(); i.hasNext(); ) {
            _event = i.next();
            // Check event status-update necessary
            _updateEventStatusToCompleted(_event);
            // Map DAO to DTO
            _eventDTO = _mapper.getEventDTOFromEvent(_event);
            // Append EventDTO to EventListDTO
            _eventListDTO.addEventToList(_eventDTO);
        }

        return _eventListDTO;
    }

    private EventListDTO _getEventListDTOfromArtistResultList(List<Artist> artistList) {
        // local variables
        EventListDTO _eventListDTO = new EventListDTO();
        EventDTO _eventDTO = null;
        Artist _artist = null;
        Event _event = null;
        EntityMapper _mapper = new EntityMapper();

        for (Iterator<Artist> i = artistList.iterator(); i.hasNext(); ) {
            _artist = i.next();
            List<Event> eventList = (List<Event>) _artist.getEvents();
            for (Iterator<Event> j = eventList.iterator(); j.hasNext(); ) {
                _event = j.next();
                // Check event status-update necessary
                _updateEventStatusToCompleted(_event);
                // Map DAO to DTO
                _eventDTO = _mapper.getEventDTOFromEvent(_event);
                // Append EventDTO to EventListDTO
                _eventListDTO.addEventToList(_eventDTO);
            }
        }

        return _eventListDTO;
    }

    private List<EventStatus> _getAllEventStatuses() {

        // local variables
        EntityManager _em = null;
        List<EventStatus> _result = null;

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            _result = _em.createNamedQuery("EventStatus.All").getResultList();

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

    private List<Genre> _getAllGenres() {

        // local variables
        EntityManager _em = null;
        List<Genre> _result = null;

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            _result = _em.createNamedQuery("Genre.All").getResultList();

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

    private List<Category> _getAllCategories() {

        // local variables
        EntityManager _em = null;
        List<Category> _result = null;

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            _result = _em.createNamedQuery("Category.All").getResultList();

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

    private List<Artist> _findArtists(String filter) {

        // local variables
        EntityManager _em = null;
        List<Artist> _result = null;

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            _result = (List<Artist>) _em.createNamedQuery("Artist.findByArtistName")
                    .setParameter("artistName", String.format("%s%%", filter)).getResultList();

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
    
    private List<Address> _findAddresses(String filter) {

        // local variables
        EntityManager _em = null;
        List<Address> _result = null;

        // logic
        try {
            // startup-sequence
            _em = _startup();

            // logical-sequence
            _result = (List<Address>) _em.createNamedQuery("Address.findAddresses")
                    .setParameter("city", String.format("%s%%", filter)).getResultList();

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