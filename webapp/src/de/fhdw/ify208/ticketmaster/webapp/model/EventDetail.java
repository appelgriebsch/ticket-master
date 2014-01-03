/**
 *  the model classes for the web application (MVC pattern)
 */

package de.fhdw.ify208.ticketmaster.webapp.model;

import de.fhdw.ify208.ticketmaster.webapp.webservices.EventDTO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * a model class for handling the event details displayed on screen
 *
 * @author appelgriebsch
 */
@ManagedBean
@RequestScoped
public class EventDetail {

    /**
     * the event data object from the web service call
     */
    private EventDTO _eventDTO = null;

    /**
     * constructs a new model object for the given event
     *
     * @param eventDTO the event data from the web service
     */
    public EventDetail(EventDTO eventDTO) {

        _eventDTO = eventDTO;
    }

    /**
     * provides access to the raw event data from the web service
     *
     * @return the raw event data from the web service
     */
    public EventDTO getEventData() {

        return _eventDTO;
    }

    /**
     * provides information about the event availability
     *
     * @return the event availability information
     */
    public EventAvailability getEventAvailability() {

        if (_eventDTO == null)
            return EventAvailability.RED;

        double percAvailable = _eventDTO.getAvailableTickets() * 100 / _eventDTO.getMaxNoOfTickets();

        if (percAvailable < 20.0) {

            return EventAvailability.RED;
        } else if ((percAvailable < 60.0)) {

            return EventAvailability.YELLOW;
        }

        return EventAvailability.GREEN;
    }

    /**
     * provides the artist(s) of the current event
     *
     * @return the artist(s) name of the current event
     */
    public String getArtistName() {

        if (_eventDTO == null)
            return null;

        if (_eventDTO.getArtists().getArtist().size() == 1)
            return _eventDTO.getArtists().getArtist().get(0).getStageName();

        return String.format("%s et.al.", _eventDTO.getArtists().getArtist().get(0).getStageName());
    }

    /**
     * provides the information if there are already ratings for this event or not
     *
     * @return TRUE/FALSE
     */
    public boolean hasRatings() {

        return getEventData().getRatings().getRating().size() > 0;
    }
}
