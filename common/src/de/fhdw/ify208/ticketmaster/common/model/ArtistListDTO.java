package de.fhdw.ify208.ticketmaster.common.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author ankariu
 */
@XmlRootElement(name = "artists")
public class ArtistListDTO extends BaseDTO {

    private List<ArtistDTO> artists = new ArrayList<ArtistDTO>();

    public void addArtistToList(ArtistDTO artistDTO) {
        artists.add(artistDTO);
    }

    @XmlElement(name = "artist")
    public Collection<ArtistDTO> getArtistDTOList() {
        return artists;
    }
}
