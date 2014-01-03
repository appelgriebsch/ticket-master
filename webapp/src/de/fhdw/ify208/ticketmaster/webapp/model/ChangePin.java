/**
 *  the model classes for the web application (MVC pattern)
 */

package de.fhdw.ify208.ticketmaster.webapp.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *  entity to hold the information required for changing the pin of the user
 *
 *   @author appelgriebsch
 */
@ManagedBean
@SessionScoped
public class ChangePin {

    /**
     *   holds the current pin of the user
     */
    private String _currPin = null;

    /**
     *   holds the new pin that has been entered
     */
    private String _newPin = null;

    /**
     *  holds the re-typed pin (double check w/ new pin required)
     */
    private String _retryPin = null;

    /**
     *  provides access to the current pin of the user
     *
     * @return the current pin of the user
     */
    public String getCurrentPin() {
        
        return _currPin;
    }

    /**
     *  stores the entered pin as current pin
     *
     * @param pin the pin that has been entered
     */
    public void setCurrentPin(String pin) {

        _currPin = pin;
    }

    /**
     *  provides access to the new pin of the user
     *
     * @return the new pin of the user
     */
    public String getNewPin() {
        
        return _newPin;
    }

    /**
     *   stores the entered pin as new pin
     *
     * @param pin the pin that has been entered
     */
    public void setNewPin(String pin) {
       
        _newPin = pin;
    }

    /**
     *   provides access to the re-try pin information of the user
     *
     * @return the retry pin information of the user
     */
    public String getRetryPin() {

        return _retryPin;
    }

    /**
     * stores the entered pin as retry pin
     *
     * @param pin the pin that has been entered
     */
    public void setRetryPin(String pin) {

        _retryPin = pin;
    }
}
