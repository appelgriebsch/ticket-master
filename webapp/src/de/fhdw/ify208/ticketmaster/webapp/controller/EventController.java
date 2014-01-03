/**
 *  the controller classes for the web application (MVC pattern)
 */
package de.fhdw.ify208.ticketmaster.webapp.controller;

import de.fhdw.ify208.ticketmaster.webapp.model.*;
import de.fhdw.ify208.ticketmaster.webapp.webservices.*;
import org.primefaces.context.RequestContext;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.xml.bind.DatatypeConverter;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * the event controller dealing with lookup of events, searching for events and rating of events
 * @author appelgriebsch
 */

@ManagedBean
@SessionScoped
public class EventController implements Serializable {

    /**
     *   a reference to the event web service
     */
    private EventServiceImplService _eventWebService = null;

    /**
     *   the search request object holding the information about the type of search and the value
     */
    private SearchRequest _searchRequest = null;

    /**
     *   the search result object storing the information about the last search
     */
    private SearchResult _searchResult = null;

    /**
     *  the event selected by the user in the web app
     */
    private EventDetail _selectedEvent = null;

    /**
     *  the list of event categories in the database
     */
    private List<TypeCodeDTO> _eventCategories = null;

    /**
     * the list of event genres in the database
     */
    private List<TypeCodeDTO> _eventGenres = null;

    /**
     *  the details of a rating for this event
     */
    private RatingDetail _ratingDetail = null;

    /**
     *  is the rating detail view visible or not
     */
    private boolean _enableRatingDetailView = false;

    /**
     *  constructs a new controller and connects to the local web service instance
     */
    public EventController() {

        try {

            _eventWebService = new EventServiceImplService(
                    new URL(String.format("http://%s/ticketmaster/eventservice?wsdl", SystemController.getHost())),
                    new QName("http://service.ticketmaster.ify208.fhdw.de/", "EventServiceImplService"));

            _searchRequest = new SearchRequest();

            this.loadConfigurationData();
            this.Search();

        } catch (MalformedURLException e) {
        }
    }

    /**
     *  use the current search request parameter to trigger the corresponding web operation to
     *  retrieve the list of available events
     */
    public void Search() {

        EventListDTO webResult = null;

        FacesMessage msg = null;

        try {

            switch (getSearchRequest().getSearchOption()) {

                case ARTIST:
                    webResult = _eventWebService.getEventServiceImplPort().getEventsByArtists(
                            getSearchRequest().getValue());
                    break;

                case CATEGORY:
                    webResult = _eventWebService.getEventServiceImplPort().getEventsByCategory(
                            getSearchRequest().getValue());
                    break;

                case GENRE:
                    webResult = _eventWebService.getEventServiceImplPort().getEventsByGenre(
                            getSearchRequest().getValue());
                    break;

                case DATE:
                    String paramDate = getSearchRequest().getValue();
                    String dtStart, dtEnd;

                    dtStart = paramDate == null ?
                            DatatypeConverter.printDateTime(new GregorianCalendar()) : paramDate;
                    dtEnd = DatatypeConverter.printDateTime(new GregorianCalendar(2099, 12, 31));

                    webResult = _eventWebService.getEventServiceImplPort().getEventsByDateRange(
                            DatatypeFactory.newInstance().newXMLGregorianCalendar(dtStart),
                            DatatypeFactory.newInstance().newXMLGregorianCalendar(dtEnd));
                    break;

                case LOCATION:
                    webResult = _eventWebService.getEventServiceImplPort().getEventsByLocation(
                            getSearchRequest().getValue());
                    break;
            }

        } catch (Exception ex) {

            msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error communicating with event web service!",
                    String.format("Unable to access event web service at %s: %s",
                            _eventWebService.getWSDLDocumentLocation(),
                            ex.getMessage()));
        }

        if ((webResult != null) &&
                (webResult.getReturncode() == 0)) {

            _searchResult = new SearchResult(webResult.getEvents());
            _selectedEvent = null;

        } else {

            _searchResult = null;
            _selectedEvent = null;

            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error processing search request",
                    (webResult != null ? webResult.getMessage() : ""));
        }

        if (msg != null)
            FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     *   creates a new RatingDetail object for storing the rating information for a customer & an event
     *
     * @param customer the customer who do the rating
     * @param event the event that gets rated
     */
    public void PrepareRateEvent(UserProfile customer, EventDetail event) {

        _ratingDetail = new RatingDetail(customer, event);
    }

    /**
     * provides access to the current rating detail object holding the current rating information
     *
     * @return the rating detail information
     */
    public RatingDetail getRatingDetail() {

        return _ratingDetail;
    }

    /**
     *   calls the event web service for persisting the current rating
     */
    public void RateEvent() {

        RequestContext ctx = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        boolean bRatingSuccess = false;

        try {

            BaseDTO result = _eventWebService.getEventServiceImplPort().rateEvent(
                    _ratingDetail.getEvent().getEventData(), _ratingDetail.getUser().getProfileData(),
                    _ratingDetail.getRating(), _ratingDetail.getComment());

            if (result.getReturncode() == 0) {

                bRatingSuccess = true;
                _ratingDetail = null;
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Rating submitted", "Thank you for your rating");

            } else {

                bRatingSuccess = false;
                msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Rating not submitted", result.getMessage());
            }

        } catch (Exception ex) {

            bRatingSuccess = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error communicating with event web service!",
                    String.format("Unable to access customer web service at %s: %s",
                            _eventWebService.getWSDLDocumentLocation(),
                            ex.getMessage()));
        }

        if (msg != null)
            FacesContext.getCurrentInstance().addMessage(null, msg);

        ctx.addCallbackParam("ratingFinished", bRatingSuccess);
    }

    /**
     * provides access to the latest search result object
     *
     * @return the last search results
     */
    public SearchResult getSearchResult() {

        return _searchResult;
    }

    /**
     * provides access to the current search request settings
     *
     * @return the current search request settings
     */
    public SearchRequest getSearchRequest() {

        return _searchRequest;
    }

    /**
     * stores new search request information
     *
     * @param request the new search request information
     */
    public void setSearchRequest(SearchRequest request) {

        if (request != _searchRequest) {

            _searchRequest = request;
            _searchResult = null;
        }
    }

    /**
     * provides access to the currently selected event
     *
     * @return the event details of the currently selected event
     */
    public EventDetail getSelectedEvent() {

        return _selectedEvent;
    }

    /**
     * stores a new event object as selected object
     *
     * @param evt the new event that has been selected in the web app
     */
    public void setSelectedEvent(EventDetail evt) {

        this._selectedEvent = evt;
    }

    /**
     * provides the information if the rating detail view is currently visible or not
     * 
     * @return TRUE/FALSE
     */
    public boolean getRatingDetailViewEnabled() {
        
        return _enableRatingDetailView;
    }

    /**
     *   allows for toggling the rating detail views visibility
     *
     * @param visible TRUE/FALSE
     *
     */
    public void setRatingDetailViewEnabled(boolean visible) {
       
        _enableRatingDetailView = visible;
    }
    
    /**
     * when using a full-text search option this operation will offer possible values for the context of the search request
     *
     * @param filter the information that has been entered by the user already
     * @return a list of items matching the information of the user depending on the search request option
     */
    public List<String> findValues(String filter) {

        ArrayList<String> result = new ArrayList<String>();

        switch (getSearchRequest().getSearchOption()) {

            case ARTIST:

                ArtistListDTO artists = _eventWebService.getEventServiceImplPort().findArtists(filter);

                if (artists.getReturncode() == 0) {

                    for (ArtistDTO artistDTO : artists.getArtist()) {
                        if (!result.contains(artistDTO.getStageName()))
                            result.add(artistDTO.getStageName());
                    }
                }
                break;

            case CATEGORY:

                for (TypeCodeDTO d : _eventCategories) {

                    if (d.getName().startsWith(filter))
                        result.add(d.getName());
                }
                break;

            case GENRE:

                for (TypeCodeDTO d : _eventGenres) {

                    if (d.getName().startsWith(filter))
                        result.add(d.getName());
                }
                break;

            case LOCATION:

                AddressListDTO addressListDTO = _eventWebService.getEventServiceImplPort().findLocations(filter);

                if (addressListDTO.getReturncode() == 0) {

                    for (AddressDTO adr : addressListDTO.getAddress()) {
                        if (!result.contains(adr.getCityName()))
                            result.add(adr.getCityName());
                    }
                }
                break;
        }

        return result;
    }

    /**
     *   loads the master data from the data base
     */
    private void loadConfigurationData() {

        TypeCodeListDTO result = _eventWebService.getEventServiceImplPort().getCategories();

        if ((result != null) &&
                (result.getReturncode() == 0)) {

            _eventCategories = result.getTypecode();
        }

        result = _eventWebService.getEventServiceImplPort().getGenres();

        if ((result != null) &&
                (result.getReturncode() == 0)) {

            _eventGenres = result.getTypecode();
        }
    }
}
