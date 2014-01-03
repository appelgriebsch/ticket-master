/**
 *  the controller classes for the web application (MVC pattern)
 */
package de.fhdw.ify208.ticketmaster.webapp.controller;

import org.primefaces.context.RequestContext;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Date;

/**
 * the system controller providing some basic system information
 * @author appelgriebsch
 */

@ManagedBean
@ApplicationScoped
public class SystemController implements Serializable {

    /**
     * the version string of the web application
     */
    private final String versionString = "1.0.0";

    /**
     * the copyright string of the web application
     */
    private final String copyrightString = "(c) 2011 by IFY208@FHDW Bielefeld";

    /**
     * provides the current system date on the server
     *
     * @return the current system date on the web server
     */
    public Date getSysDate() {
        return new Date();
    }

    /**
     * provides the version information of the web application
     *
     * @return the current version information of the web application
     */
    public String getVersionString() {
        return versionString;
    }

    /**
     * provides the current copyright information of the web application
     *
     * @return the current copyright information of the web application
     */
    public String getCopyrightString() {
        return copyrightString;
    }

    /**
     * provides the name of the current server (incl. port) where the web application is hosted
     *
     * @return the name of the current server incl. port
     */
    public static String getHost() {

        FacesContext context = FacesContext.getCurrentInstance();
        return context.getExternalContext().getRequestHeaderMap().get("Host");
    }

    /**
     * allows for re-directing the current context of the application to another web page
     *
     * @param context the current request context of the application
     * @param page the name of the page to redirect to that is part of the application
     */
    public static void redirectUrl(RequestContext context, String page) {

        context.addCallbackParam("redirectUrl", String.format("http://%s/ticketmaster/%s.xhtml",
                SystemController.getHost(), page));
    }
}
