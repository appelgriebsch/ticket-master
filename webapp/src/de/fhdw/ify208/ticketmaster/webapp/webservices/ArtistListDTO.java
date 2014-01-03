package de.fhdw.ify208.ticketmaster.webapp.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for artistListDTO complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="artistListDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{de.fhdw.ify208.ticketmaster.common.model}baseDTO">
 *       &lt;sequence>
 *         &lt;element ref="{de.fhdw.ify208.ticketmaster.common.model}artist" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "artistListDTO", propOrder = {
        "artist"
})
public class ArtistListDTO
        extends BaseDTO {

    protected List<ArtistDTO> artist;

    /**
     * Gets the value of the artist property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the artist property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArtist().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link ArtistDTO }
     */
    public List<ArtistDTO> getArtist() {
        if (artist == null) {
            artist = new ArrayList<ArtistDTO>();
        }
        return this.artist;
    }

}
