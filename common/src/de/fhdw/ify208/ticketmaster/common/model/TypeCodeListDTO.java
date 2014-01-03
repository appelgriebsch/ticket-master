package de.fhdw.ify208.ticketmaster.common.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author appelgriebsch
 */
@XmlRootElement(name = "typecodes")
public class TypeCodeListDTO extends BaseDTO {

    private List<TypeCodeDTO> typecodes = new ArrayList<TypeCodeDTO>();

    public void addTypeCodeToList(TypeCodeDTO typeCodeDTO) {
        typecodes.add(typeCodeDTO);
    }

    @XmlElement(name = "typecode")
    public Collection<TypeCodeDTO> getTypeCodeDTOList() {
        return typecodes;
    }
}
