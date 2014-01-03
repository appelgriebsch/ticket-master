/**
 *  the model classes for the web application (MVC pattern)
 */

package de.fhdw.ify208.ticketmaster.webapp.model;

/**
 * an enumeration holding the available search options of the web app
 *
 * @author appelgriebsch
 */
public enum SearchOption {

    /**
     * searching by artist name
     */
    ARTIST,

    /**
     * searching by category name
     */
    CATEGORY,

    /**
     * searching by genre name
     */
    GENRE,

    /**
     * searching by date
     */
    DATE,

    /**
     * searching by city name
     */
    LOCATION;
}
