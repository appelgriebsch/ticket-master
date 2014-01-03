/**
 *
 */
package de.fhdw.ify208.ticketmaster.common.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * @author appelgriebsch
 */
@XmlRootElement(name = "customer")
public class CustomerDTO extends BaseDTO {

    /**
     * the id of the customer
     */
    private long _customerID;

    /**
     * the salutation of the customer
     */
    private String _salutation;

    /**
     * the first name of the customer
     */
    private String _firstName;

    /**
     * the last name of the customer
     */
    private String _lastName;

    /**
     * the gender type of the customer
     */
    private GenderType _genderType = GenderType.Female;

    /**
     * the birth date of the customer
     */
    private Date _birthdate;

    /**
     * the type of the customer
     */
    private TypeCodeDTO _type;

    /**
     * the user name of the customer
     */
    private String _userName;

    /**
     * the encrypted password of the customer
     */
    private String _password;

    /**
     * the email id of the customer
     */
    private String _mailID;

    /**
     * the status of the customer
     */
    private CustomerStatus _status;

    /**
     * @return the id
     */
    public long getid() {
        return _customerID;
    }

    /**
     * @param id the _theCustomer to set
     */
    public void setid(long customerID) {
        this._customerID = customerID;
    }

    /**
     * @return the _salutation
     */
    public String getSalutation() {
        return _salutation;
    }

    /**
     * @param _salutation the _salutation to set
     */
    public void setSalutation(String _salutation) {
        this._salutation = _salutation;
    }

    /**
     * @return the _firstName
     */
    public String getFirstName() {
        return _firstName;
    }

    /**
     * @param _firstName the _firstName to set
     */
    public void setFirstName(String _firstName) {
        this._firstName = _firstName;
    }

    /**
     * @return the _lastName
     */
    public String getLastName() {
        return _lastName;
    }

    /**
     * @param _lastName the _lastName to set
     */
    public void setLastName(String _lastName) {
        this._lastName = _lastName;
    }

    /**
     * @return the _genderType
     */
    public GenderType getGenderType() {
        return _genderType;
    }

    /**
     * @param _genderType the _genderType to set
     */
    public void setGenderType(GenderType _genderType) {
        this._genderType = _genderType;
    }

    /**
     * @return the _birthdate
     */
    public Date getBirthdate() {
        return _birthdate;
    }

    /**
     * @param _birthdate the _birthdate to set
     */
    public void setBirthdate(Date _birthdate) {
        this._birthdate = _birthdate;
    }

    /**
     * @return the _type
     */
    public TypeCodeDTO getType() {
        return _type;
    }

    /**
     * @param _type the _type to set
     */
    public void setType(TypeCodeDTO _type) {
        this._type = _type;
    }

    /**
     * @return the _userName
     */
    public String getUserName() {
        return _userName;
    }

    /**
     * @param _userName the _userName to set
     */
    public void setUserName(String _userName) {
        this._userName = _userName;
    }

    /**
     * @return the _password
     */
    public String getPassword() {
        return _password;
    }

    /**
     * @param _password the _password to set
     */
    public void setPassword(String _password) {
        this._password = _password;
    }

    /**
     * @return the _mailID
     */
    public String getEmail() {
        return _mailID;
    }

    /**
     * @param _mailID the _mailID to set
     */
    public void setEmail(String _mailID) {
        this._mailID = _mailID;
    }

    /**
     * @return the current customer status
     */
    public CustomerStatus getStatus() {
        return _status;
    }

    /**
     * @param _status
     */
    public void setStatus(CustomerStatus _status) {
        this._status = _status;
    }
}
