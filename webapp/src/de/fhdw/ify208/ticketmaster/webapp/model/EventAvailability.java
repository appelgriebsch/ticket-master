/**
 *  the model classes for the web application (MVC pattern)
 */

package de.fhdw.ify208.ticketmaster.webapp.model;

/**
 * an enumeration specifying the status of the availability of the event
 *
 * @author appelgriebsch
 */
public enum EventAvailability {

    /**
     * there are less than 20 percent of the tickets available
     */
    RED,

    /**
     * there are between 20 and 60 percent of the tickets available
     */
    YELLOW,

    /**
     * there are more than 60 percent of the ticket available
     */
    GREEN;

    /**
     * a convenience operation to check if the status is red
     *
     * @return TRUE/FALSE
     */
    public boolean isRed() {

        return this.ordinal() == EventAvailability.RED.ordinal();
    }

    /**
     * a convenience operation to check if the status is yellow
     *
     * @return TRUE/FALSE
     */
    public boolean isYellow() {

        return this.ordinal() == EventAvailability.YELLOW.ordinal();
    }

    /**
     * a convenience operation to check if the status is green
     *
     * @return TRUE/FALSE
     */
    public boolean isGreen() {

        return this.ordinal() == EventAvailability.GREEN.ordinal();
    }
}
