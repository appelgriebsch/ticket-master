/**
 *  the model classes for the web application (MVC pattern)
 */

package de.fhdw.ify208.ticketmaster.webapp.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *   a model class for handling the log on process
 */
@ManagedBean
@SessionScoped
public class LogonCredentials {

    /**
     * the entered user name
     */
    private String _userName = null;

    /**
     * the entered password
     */
    private String _password = null;

    /**
     * provides access to the entered user name
     *
     * @return the entered user name
     */
    public String getUserName() {
        return _userName;
    }

    /**
     * stores a new user name value
     *
     * @param userName the new user name value
     */
    public void setUserName(String userName) {
        this._userName = userName;
    }

    /**
     * provides access to the entered password
     *
     * @return the entered password
     */
    public String getPassword() {
        return _password;
    }

    /**
     * stores a new password value
     *
     * @param password the new password value
     */
    public void setPassword(String password) {
        this._password = password;
    }
}
