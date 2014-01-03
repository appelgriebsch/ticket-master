package de.fhdw.ify208.ticketmaster.webapp.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RegisterNewArtist complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="RegisterNewArtist">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{de.fhdw.ify208.ticketmaster.common.model}artist" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegisterNewArtist", propOrder = {
        "artist"
})
public class RegisterNewArtist {

    @XmlElement(namespace = "de.fhdw.ify208.ticketmaster.common.model")
    protected ArtistDTO artist;

    /**
     * Gets the value of the artist property.
     *
     * @return possible object is
     *         {@link ArtistDTO }
     */
    public ArtistDTO getArtist() {
        return artist;
    }

    /**
     * Sets the value of the artist property.
     *
     * @param value allowed object is
     *              {@link ArtistDTO }
     */
    public void setArtist(ArtistDTO value) {
        this.artist = value;
    }

}
