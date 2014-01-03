package de.fhdw.ify208.ticketmaster.common.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author ankariu
 */
@XmlRootElement(name = "addresses")
public class AddressListDTO extends BaseDTO {

    private List<AddressDTO> addresses = new ArrayList<AddressDTO>();

    public void addAddressToList(AddressDTO addressDTO) {
        addresses.add(addressDTO);
    }

    @XmlElement(name = "address")
    public Collection<AddressDTO> getAddressDTOList() {
        return addresses;
    }
}
