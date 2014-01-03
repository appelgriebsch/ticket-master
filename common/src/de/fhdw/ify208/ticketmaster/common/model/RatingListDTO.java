package de.fhdw.ify208.ticketmaster.common.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author appelgriebsch
 */
@XmlRootElement(name = "ratings")
public class RatingListDTO extends BaseDTO {

    private List<RatingDTO> ratings = new ArrayList<RatingDTO>();

    public void addOrderToList(RatingDTO ratingDTO) {
        ratings.add(ratingDTO);
    }

    @XmlElement(name = "rating")
    public Collection<RatingDTO> getRatingDTOList() {
        return ratings;
    }

}
