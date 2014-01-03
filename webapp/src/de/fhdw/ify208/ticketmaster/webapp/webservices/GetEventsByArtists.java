package de.fhdw.ify208.ticketmaster.webapp.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetEventsByArtists complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GetEventsByArtists">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="artistName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetEventsByArtists", propOrder = {
        "artistName"
})
public class GetEventsByArtists {

    protected String artistName;

    /**
     * Gets the value of the artistName property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getArtistName() {
        return artistName;
    }

    /**
     * Sets the value of the artistName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setArtistName(String value) {
        this.artistName = value;
    }

}
