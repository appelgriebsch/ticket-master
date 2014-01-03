package de.fhdw.ify208.ticketmaster.webapp.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;


/**
 * <p>Java class for eventDTO complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="eventDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{de.fhdw.ify208.ticketmaster.common.model}baseDTO">
 *       &lt;sequence>
 *         &lt;element name="adUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{de.fhdw.ify208.ticketmaster.common.model}artists" minOccurs="0"/>
 *         &lt;element name="availableTickets" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="avrgRating" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="category" type="{de.fhdw.ify208.ticketmaster.common.model}typeCodeDTO" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="eventStatus" type="{de.fhdw.ify208.ticketmaster.common.model}typeCodeDTO" minOccurs="0"/>
 *         &lt;element name="location" type="{de.fhdw.ify208.ticketmaster.common.model}addressDTO" minOccurs="0"/>
 *         &lt;element name="maxNoOfTickets" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element ref="{de.fhdw.ify208.ticketmaster.common.model}ratings" minOccurs="0"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ticketPrice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eventDTO", propOrder = {
        "adUrl",
        "artists",
        "availableTickets",
        "avrgRating",
        "category",
        "description",
        "endDate",
        "eventStatus",
        "location",
        "maxNoOfTickets",
        "ratings",
        "startDate",
        "ticketPrice",
        "id"
})
public class EventDTO
        extends BaseDTO {

    protected String adUrl;
    protected ArtistListDTO artists;
    protected int availableTickets;
    protected double avrgRating;
    protected TypeCodeDTO category;
    protected String description;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;
    protected TypeCodeDTO eventStatus;
    protected AddressDTO location;
    protected int maxNoOfTickets;
    protected RatingListDTO ratings;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDate;
    protected BigDecimal ticketPrice;
    protected long id;

    /**
     * Gets the value of the adUrl property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getAdUrl() {
        return adUrl;
    }

    /**
     * Sets the value of the adUrl property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAdUrl(String value) {
        this.adUrl = value;
    }

    /**
     * Gets the value of the artists property.
     *
     * @return possible object is
     *         {@link ArtistListDTO }
     */
    public ArtistListDTO getArtists() {
        return artists;
    }

    /**
     * Sets the value of the artists property.
     *
     * @param value allowed object is
     *              {@link ArtistListDTO }
     */
    public void setArtists(ArtistListDTO value) {
        this.artists = value;
    }

    /**
     * Gets the value of the availableTickets property.
     */
    public int getAvailableTickets() {
        return availableTickets;
    }

    /**
     * Sets the value of the availableTickets property.
     */
    public void setAvailableTickets(int value) {
        this.availableTickets = value;
    }

    /**
     * Gets the value of the avrgRating property.
     */
    public double getAvrgRating() {
        return avrgRating;
    }

    /**
     * Sets the value of the avrgRating property.
     */
    public void setAvrgRating(double value) {
        this.avrgRating = value;
    }

    /**
     * Gets the value of the category property.
     *
     * @return possible object is
     *         {@link TypeCodeDTO }
     */
    public TypeCodeDTO getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     *
     * @param value allowed object is
     *              {@link TypeCodeDTO }
     */
    public void setCategory(TypeCodeDTO value) {
        this.category = value;
    }

    /**
     * Gets the value of the description property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the endDate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the eventStatus property.
     *
     * @return possible object is
     *         {@link TypeCodeDTO }
     */
    public TypeCodeDTO getEventStatus() {
        return eventStatus;
    }

    /**
     * Sets the value of the eventStatus property.
     *
     * @param value allowed object is
     *              {@link TypeCodeDTO }
     */
    public void setEventStatus(TypeCodeDTO value) {
        this.eventStatus = value;
    }

    /**
     * Gets the value of the location property.
     *
     * @return possible object is
     *         {@link AddressDTO }
     */
    public AddressDTO getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     *
     * @param value allowed object is
     *              {@link AddressDTO }
     */
    public void setLocation(AddressDTO value) {
        this.location = value;
    }

    /**
     * Gets the value of the maxNoOfTickets property.
     */
    public int getMaxNoOfTickets() {
        return maxNoOfTickets;
    }

    /**
     * Sets the value of the maxNoOfTickets property.
     */
    public void setMaxNoOfTickets(int value) {
        this.maxNoOfTickets = value;
    }

    /**
     * Gets the value of the ratings property.
     *
     * @return possible object is
     *         {@link RatingListDTO }
     */
    public RatingListDTO getRatings() {
        return ratings;
    }

    /**
     * Sets the value of the ratings property.
     *
     * @param value allowed object is
     *              {@link RatingListDTO }
     */
    public void setRatings(RatingListDTO value) {
        this.ratings = value;
    }

    /**
     * Gets the value of the startDate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the ticketPrice property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    /**
     * Sets the value of the ticketPrice property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setTicketPrice(BigDecimal value) {
        this.ticketPrice = value;
    }

    /**
     * Gets the value of the id property.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     */
    public void setId(long value) {
        this.id = value;
    }

}
