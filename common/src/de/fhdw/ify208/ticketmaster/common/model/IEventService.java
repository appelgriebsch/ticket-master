/**
 *
 */
package de.fhdw.ify208.ticketmaster.common.model;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Date;

/**
 * @author appelgriebsch
 */
@WebService(name = "eventservice",
        targetNamespace = "de.fhdw.ify208.ticketmaster.common.model",
        serviceName = "eventservice")
public interface IEventService {

    /**
     * @param artistName
     * @return
     */
    @WebMethod(operationName = "GetEventsByArtists")
    EventListDTO GetEventsByArtist(@WebParam(name = "artistName") String artistName);

    /**
     * @param cityName
     * @return
     */
    @WebMethod(operationName = "GetEventsByLocation")
    EventListDTO GetEventsByLocation(@WebParam(name = "cityName") String cityName);

    /**
     * @param genre
     * @return
     */
    @WebMethod(operationName = "GetEventsByGenre")
    EventListDTO GetEventsByGenre(@WebParam(name = "genre") String genre);

    /**
     * @param category
     * @return
     */
    @WebMethod(operationName = "GetEventsByCategory")
    EventListDTO GetEventsByCategory(@WebParam(name = "category") String category);

    /**
     * @param startDate
     * @param endDate
     * @return
     */
    @WebMethod(operationName = "GetEventsByDateRange")
    EventListDTO GetEventsByDateRange(@WebParam(name = "startDate") Date startDate,
                                      @WebParam(name = "endDate") Date endDate);

    /**
     * @param theEvent
     * @return
     */
    @WebMethod(operationName = "RegisterNewEvent")
    BaseDTO RegisterNewEvent(@WebParam(name = "event") EventDTO theEvent);

    /**
     * @param theArtist
     * @return
     */
    @WebMethod(operationName = "RegisterNewArtist")
    BaseDTO RegisterNewArtist(@WebParam(name = "artist") ArtistDTO theArtist);

    /**
     * @param theEvent
     * @return
     */
    @WebMethod(operationName = "CancelEvent")
    BaseDTO CancelEvent(@WebParam(name = "event") EventDTO theEvent);

    /**
     * @param theEvent
     * @param theCustomer
     * @param rating
     * @param comment
     * @return
     */
    @WebMethod(operationName = "RateEvent")
    BaseDTO RateEvent(@WebParam(name = "event") EventDTO theEvent,
                      @WebParam(name = "customer") CustomerDTO theCustomer,
                      @WebParam(name = "rating") double rating,
                      @WebParam(name = "comment") String comment);

    /**
     * @return
     */
    @WebMethod(operationName = "GetGenres")
    TypeCodeListDTO GetGenres();

    /**
     * @return
     */
    @WebMethod(operationName = "GetCategories")
    TypeCodeListDTO GetCategories();

    /**
     * @return
     */
    @WebMethod(operationName = "GetEventStatuses")
    TypeCodeListDTO GetEventStatuses();

    /**
     * 
     * @param filter
     * @return
     */
    @WebMethod(operationName = "FindArtists")
    ArtistListDTO FindArtists(@WebParam(name = "filter") String filter);

    /**
     *
     * @param filter
     * @return
     */
    @WebMethod(operationName = "FindLocations")
    AddressListDTO FindLocations(@WebParam(name = "filter") String filter);
}
