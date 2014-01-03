/**
 *  the model classes for the web application (MVC pattern)
 */

package de.fhdw.ify208.ticketmaster.webapp.model;

import de.fhdw.ify208.ticketmaster.webapp.webservices.EventDTO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * a model class for handling the search result in the web app
 *
 * @author appelgriebsch
 */
@ManagedBean
@RequestScoped
public class SearchResult {

    /**
     * the list of events of the current search result
     */
    List<EventDetail> _eventList = new ArrayList<EventDetail>();

    /**
     * constructs a new object with the given list of events
     *
     * @param events the list of events from the current search
     */
    public SearchResult(List<EventDTO> events) {

        if (events != null) {

            for (EventDTO evt : events) {

                _eventList.add(new EventDetail(evt));
            }
        } else {

            _eventList.clear();
        }
    }

    /**
     * delivers the number of events that are in the current result
     *
     * @return the number of events for the current result
     */
    public int getLength() {

        return _eventList.size();
    }

    /**
     * provides access to the list of events for the current search
     *
     * @return the list of events for the current search
     */
    public List<EventDetail> getResults() {

        return _eventList;
    }
}
