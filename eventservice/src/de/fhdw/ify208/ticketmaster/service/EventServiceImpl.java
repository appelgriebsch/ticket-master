/**
 *
 */
package de.fhdw.ify208.ticketmaster.service;

import de.fhdw.ify208.ticketmaster.common.model.*;
import de.fhdw.ify208.ticketmaster.model.EventManager;

import javax.jws.WebService;
import java.util.Date;

/**
 * @author appelgriebsch
 */
@WebService(endpointInterface = "de.fhdw.ify208.ticketmaster.common.model.IEventService")
public class EventServiceImpl implements IEventService {

    private EventManager eventManager = EventManager.getInstance();

    /* (non-Javadoc)
      * @see de.fhdw.ify208.ticketmaster.common.model.IEventService#getEventsByArtist(java.lang.String)
      */
    @Override
    public EventListDTO GetEventsByArtist(String artistName) {
        return eventManager.getEventsByArtist(artistName);
    }

    /* (non-Javadoc)
      * @see de.fhdw.ify208.ticketmaster.common.model.IEventService#getEventsByLocation(java.lang.String)
      */
    @Override
    public EventListDTO GetEventsByLocation(String cityName) {
        return eventManager.getEventsByLocation(cityName);
    }

    /* (non-Javadoc)
      * @see de.fhdw.ify208.ticketmaster.common.model.IEventService#getEventsByGenre(java.lang.String)
      */
    @Override
    public EventListDTO GetEventsByGenre(String genre) {
        return eventManager.getEventsByGenre(genre);
    }

    /* (non-Javadoc)
      * @see de.fhdw.ify208.ticketmaster.common.model.IEventService#getEventsByCategory(java.lang.String)
      */
    @Override
    public EventListDTO GetEventsByCategory(String category) {
        return eventManager.getEventsByCategory(category);
    }

    /* (non-Javadoc)
      * @see de.fhdw.ify208.ticketmaster.common.model.IEventService#getEventsByDateRange(java.util.Date, java.util.Date)
      */
    @Override
    public EventListDTO GetEventsByDateRange(Date startDate, Date endDate) {
        return eventManager.getEventsByDateRange(startDate, endDate);
    }

    /* (non-Javadoc)
      * @see de.fhdw.ify208.ticketmaster.common.model.IEventService#RegisterNewEvent(de.fhdw.ify208.ticketmaster.common.model.Event)
      */
    @Override
    public BaseDTO RegisterNewEvent(EventDTO theEvent) {
        return eventManager.registerNewEvent(theEvent);
    }

    /* (non-Javadoc)
      * @see de.fhdw.ify208.ticketmaster.common.model.IEventService#RegisterNewArtist(de.fhdw.ify208.ticketmaster.common.model.Artist)
      */
    @Override
    public BaseDTO RegisterNewArtist(ArtistDTO theArtist) {
        return eventManager.registerNewArtist(theArtist);
    }

    /* (non-Javadoc)
      * @see de.fhdw.ify208.ticketmaster.common.model.IEventService#CancelEvent(de.fhdw.ify208.ticketmaster.common.model.Event)
      */
    @Override
    public BaseDTO CancelEvent(EventDTO theEvent) {
        return eventManager.cancelEvent(theEvent);
    }

    /* (non-Javadoc)
      * @see de.fhdw.ify208.ticketmaster.common.model.IEventService#RateEvent(de.fhdw.ify208.ticketmaster.common.model.Event, de.fhdw.ify208.ticketmaster.common.model.Customer, double, java.lang.String)
      */
    @Override
    public BaseDTO RateEvent(EventDTO theEvent, CustomerDTO theCustomer,
                             double rating, String comment) {
        return eventManager.rateEvent(theEvent, theCustomer, rating, comment);
    }

    /* (non-Javadoc)
      * @see de.fhdw.ify208.ticketmaster.common.model.IEventService#GetGenres()
      */
    @Override
    public TypeCodeListDTO GetGenres() {
        return eventManager.getGenres();
    }

    /* (non-Javadoc)
      * @see de.fhdw.ify208.ticketmaster.common.model.IEventService#GetCategories()
      */
    @Override
    public TypeCodeListDTO GetCategories() {
        return eventManager.getCategories();
    }

    /* (non-Javadoc)
      * @see de.fhdw.ify208.ticketmaster.common.model.IEventService#GetEventStatuses()
      */
    @Override
    public TypeCodeListDTO GetEventStatuses() {
        return eventManager.getEventStatuses();
    }

    /* (non-Javadoc)
      * @see de.fhdw.ify208.ticketmaster.common.model.IEventService#FindArtists(java.lang.String)
      */
    @Override
    public ArtistListDTO FindArtists(String filter) {
        return eventManager.findArtists(filter);
    }

    /* (non-Javadoc)
      * @see de.fhdw.ify208.ticketmaster.common.model.IEventService#FindLocations(java.lang.String)
      */
    @Override
    public AddressListDTO FindLocations(String filter) {
        return eventManager.findLocations(filter);
    }

}
