/**
 *
 */
package de.fhdw.ify208.ticketmaster.common.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author appelgriebsch
 */
@XmlRootElement(name = "event")
public class EventDTO extends BaseDTO {

    /**
     * the id of the event
     */
    private long _eventID;

    /**
     * the start date of the event
     */
    private Date _startDate;

    /**
     * the end date of the event
     */
    private Date _endDate;

    /**
     * the description of the event
     */
    private String _description;

    /**
     * the URL holding ad for this event
     */
    private String _imgUrl;

    /**
     * the location of this event
     */
    private AddressDTO _eventLocation;

    /**
     * the category of this event
     */
    private TypeCodeDTO _category;

    /**
     * the current status of the order
     */
    private TypeCodeDTO _eventStatus;

    /**
     * the max nmbr of tickets for this event
     */
    private int _maxNoOfTickets;

    /**
     * the price of one ticket
     */
    private BigDecimal _ticketPrice;

    /**
     * the nmbr of tickets that are available
     */
    private int _availableTickets;

    /**
     * the average rating for this event
     */
    private double _avrgRating;

    /**
     * the artists performing on the event
     */
    private ArtistListDTO _eventArtists = new ArtistListDTO();

    /**
     * the ratings for this event
     */
    private RatingListDTO _eventRatings = new RatingListDTO();

    /**
     * @return the id
     */
    public long getid() {
        return _eventID;
    }

    /**
     * @param eventID the _theEvent to set
     */
    public void setid(long eventID) {
        this._eventID = eventID;
    }

    /**
     * @return the _startDate
     */
    public Date getStartDate() {
        return _startDate;
    }

    /**
     * @param _startDate the _startDate to set
     */
    public void setStartDate(Date _startDate) {
        this._startDate = _startDate;
    }

    /**
     * @return the _endDate
     */
    public Date getEndDate() {
        return _endDate;
    }

    /**
     * @param _endDate the _endDate to set
     */
    public void setEndDate(Date _endDate) {
        this._endDate = _endDate;
    }

    /**
     * @return the _description
     */
    public String getDescription() {
        return _description;
    }

    /**
     * @param _description the _description to set
     */
    public void setDescription(String _description) {
        this._description = _description;
    }

    /**
     * @return the _imgUrl
     */
    public String getAdUrl() {
        return _imgUrl;
    }

    /**
     * @param _adUrl the _imgUrl to set
     */
    public void setAdUrl(String _adUrl) {
        this._imgUrl = _adUrl;
    }

    /**
     * @return the _eventLocation
     */
    public AddressDTO getLocation() {
        return _eventLocation;
    }

    /**
     * @param _eventLocation the _eventLocation to set
     */
    public void setLocation(AddressDTO _eventLocation) {
        this._eventLocation = _eventLocation;
    }

    /**
     * @return the _category
     */
    public TypeCodeDTO getCategory() {
        return _category;
    }

    /**
     * @param _eventStatus the _evenStats to set
     */
    public void setEventStatus(TypeCodeDTO _eventStatus) {
        this._eventStatus = _eventStatus;
    }

    /**
     * @return the _eventStatus
     */
    public TypeCodeDTO getEventStatus() {
        return _eventStatus;
    }

    /**
     * @param _category the _category to set
     */
    public void setCategory(TypeCodeDTO _category) {
        this._category = _category;
    }

    /**
     * @return the _maxNoOfTickets
     */
    public int getMaxNoOfTickets() {
        return _maxNoOfTickets;
    }

    /**
     * @param _maxNoOfTickets the _maxNoOfTickets to set
     */
    public void setMaxNoOfTickets(int _maxNoOfTickets) {
        this._maxNoOfTickets = _maxNoOfTickets;
    }

    /**
     * @return the _ticketPrice
     */
    public BigDecimal getTicketPrice() {
        return _ticketPrice;
    }

    /**
     * @param _ticketPrice the _ticketPrice to set
     */
    public void setTicketPrice(BigDecimal _ticketPrice) {
        this._ticketPrice = _ticketPrice;
    }

    /**
     * @return the _availableTickets
     */
    public int getAvailableTickets() {
        return _availableTickets;
    }

    /**
     * @param _availableTickets the _availableTickets to set
     */
    public void setAvailableTickets(int _availableTickets) {
        this._availableTickets = _availableTickets;
    }

    /**
     * @return the _avrgRating
     */
    public double getAvrgRating() {
        return _avrgRating;
    }

    /**
     * @param _avrgRating the _avrgRating to set
     */
    public void setAvrgRating(double _avrgRating) {
        this._avrgRating = _avrgRating;
    }

    /**
     * @return the _eventArtists
     */
    public ArtistListDTO getArtists() {
        return _eventArtists;
    }

    /**
     * @param _eventArtists the _eventArtists to set
     */
    public void setArtists(ArtistListDTO _eventArtists) {
        this._eventArtists = _eventArtists;
    }

    /**
     * @return the _eventRatings
     */
    public RatingListDTO getRatings() {
        return _eventRatings;
    }

    /**
     * @param _eventRatings the _eventRatings to set
     */
    public void setRatings(RatingListDTO _eventRatings) {
        this._eventRatings = _eventRatings;
    }
}