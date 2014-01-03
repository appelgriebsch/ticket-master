package de.fhdw.ify208.ticketmaster.webapp.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for customerDTO complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="customerDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{de.fhdw.ify208.ticketmaster.common.model}baseDTO">
 *       &lt;sequence>
 *         &lt;element name="birthdate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="genderType" type="{de.fhdw.ify208.ticketmaster.common.model}genderType" minOccurs="0"/>
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="salutation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{de.fhdw.ify208.ticketmaster.common.model}customerStatus" minOccurs="0"/>
 *         &lt;element name="type" type="{de.fhdw.ify208.ticketmaster.common.model}typeCodeDTO" minOccurs="0"/>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerDTO", propOrder = {
        "birthdate",
        "email",
        "firstName",
        "genderType",
        "lastName",
        "password",
        "salutation",
        "status",
        "type",
        "userName",
        "id"
})
public class CustomerDTO
        extends BaseDTO {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar birthdate;
    protected String email;
    protected String firstName;
    protected GenderType genderType;
    protected String lastName;
    protected String password;
    protected String salutation;
    protected CustomerStatus status;
    protected TypeCodeDTO type;
    protected String userName;
    protected long id;

    /**
     * Gets the value of the birthdate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getBirthdate() {
        return birthdate;
    }

    /**
     * Sets the value of the birthdate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setBirthdate(XMLGregorianCalendar value) {
        this.birthdate = value;
    }

    /**
     * Gets the value of the email property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the firstName property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the genderType property.
     *
     * @return possible object is
     *         {@link GenderType }
     */
    public GenderType getGenderType() {
        return genderType;
    }

    /**
     * Sets the value of the genderType property.
     *
     * @param value allowed object is
     *              {@link GenderType }
     */
    public void setGenderType(GenderType value) {
        this.genderType = value;
    }

    /**
     * Gets the value of the lastName property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the password property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the salutation property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSalutation() {
        return salutation;
    }

    /**
     * Sets the value of the salutation property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSalutation(String value) {
        this.salutation = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return possible object is
     *         {@link CustomerStatus }
     */
    public CustomerStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value allowed object is
     *              {@link CustomerStatus }
     */
    public void setStatus(CustomerStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the type property.
     *
     * @return possible object is
     *         {@link TypeCodeDTO }
     */
    public TypeCodeDTO getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is
     *              {@link TypeCodeDTO }
     */
    public void setType(TypeCodeDTO value) {
        this.type = value;
    }

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
     * Gets the value of the id property.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     */
    public void setId(long value) {
        this.id = value;
    }

}
