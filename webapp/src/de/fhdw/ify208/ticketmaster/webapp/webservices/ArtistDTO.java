package de.fhdw.ify208.ticketmaster.webapp.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for artistDTO complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="artistDTO">
 *   &lt;complexContent>
 *     &lt;extension base="{de.fhdw.ify208.ticketmaster.common.model}baseDTO">
 *       &lt;sequence>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="genre" type="{de.fhdw.ify208.ticketmaster.common.model}typeCodeDTO" minOccurs="0"/>
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stageName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "artistDTO", propOrder = {
        "firstName",
        "genre",
        "lastName",
        "stageName",
        "id"
})
public class ArtistDTO
        extends BaseDTO {

    protected String firstName;
    protected TypeCodeDTO genre;
    protected String lastName;
    protected String stageName;
    protected long id;

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
     * Gets the value of the genre property.
     *
     * @return possible object is
     *         {@link TypeCodeDTO }
     */
    public TypeCodeDTO getGenre() {
        return genre;
    }

    /**
     * Sets the value of the genre property.
     *
     * @param value allowed object is
     *              {@link TypeCodeDTO }
     */
    public void setGenre(TypeCodeDTO value) {
        this.genre = value;
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
     * Gets the value of the stageName property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getStageName() {
        return stageName;
    }

    /**
     * Sets the value of the stageName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStageName(String value) {
        this.stageName = value;
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
