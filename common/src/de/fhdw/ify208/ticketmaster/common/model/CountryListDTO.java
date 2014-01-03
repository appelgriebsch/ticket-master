package de.fhdw.ify208.ticketmaster.common.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author appelgriebsch
 */
@XmlRootElement(name = "countries")
public class CountryListDTO extends BaseDTO {

    private List<CountryDTO> countries = new ArrayList<CountryDTO>();

    public void addCountryToList(CountryDTO countryDTO) {
        countries.add(countryDTO);
    }

    @XmlElement(name = "country")
    public Collection<CountryDTO> getCountryDTOList() {
        return countries;
    }
}
