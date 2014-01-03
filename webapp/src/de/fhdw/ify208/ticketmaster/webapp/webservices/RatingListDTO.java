package de.fhdw.ify208.ticketmaster.webapp.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ratingListDTO complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ratingListDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{de.fhdw.ify208.ticketmaster.common.model}baseDTO">
 *       &lt;sequence>
 *         &lt;element ref="{de.fhdw.ify208.ticketmaster.common.model}rating" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ratingListDTO", propOrder = {
        "rating"
})
public class RatingListDTO
        extends BaseDTO {

    protected List<RatingDTO> rating;

    /**
     * Gets the value of the rating property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rating property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRating().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link RatingDTO }
     */
    public List<RatingDTO> getRating() {
        if (rating == null) {
            rating = new ArrayList<RatingDTO>();
        }
        return this.rating;
    }

}
