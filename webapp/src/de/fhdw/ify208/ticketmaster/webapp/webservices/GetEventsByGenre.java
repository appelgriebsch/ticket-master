package de.fhdw.ify208.ticketmaster.webapp.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetEventsByGenre complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GetEventsByGenre">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="genre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetEventsByGenre", propOrder = {
        "genre"
})
public class GetEventsByGenre {

    protected String genre;

    /**
     * Gets the value of the genre property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the value of the genre property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGenre(String value) {
        this.genre = value;
    }

}
