package de.fhdw.ify208.ticketmaster.webapp.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ChangeCustomer complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ChangeCustomer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oldPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="newPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChangeCustomer", propOrder = {
        "userName",
        "oldPassword",
        "newPassword"
})
public class ChangeCustomer {

    protected String userName;
    protected String oldPassword;
    protected String newPassword;

    /**
     * Gets the value of the userName property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Gets the value of the oldPassword property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getOldPassword() {
        return oldPassword;
    }

    /**
     * Sets the value of the oldPassword property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setOldPassword(String value) {
        this.oldPassword = value;
    }

    /**
     * Gets the value of the newPassword property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * Sets the value of the newPassword property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNewPassword(String value) {
        this.newPassword = value;
    }

}
