package de.fhdw.ify208.ticketmaster.common.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author ankariu
 */
public class EventListDTO extends BaseDTO {

    private List<EventDTO> events = new ArrayList<EventDTO>();

    public void addEventToList(EventDTO eventDTO) {
        events.add(eventDTO);
    }

    @XmlElement(name = "events")
    public Collection<EventDTO> getEventsDTOList() {
        return events;
    }
}
