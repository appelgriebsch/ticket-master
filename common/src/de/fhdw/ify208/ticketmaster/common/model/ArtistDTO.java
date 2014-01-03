/**
 *
 */
package de.fhdw.ify208.ticketmaster.common.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author appelgriebsch
 */
@XmlRootElement(name = "artist")
public class ArtistDTO extends BaseDTO {

    /**
     * the id of the artist
     */
    private long _artistID;

    /**
     * the artist name on stage
     */
    private String _stageName;

    /**
     * the first name of the artist
     */
    private String _firstName;

    /**
     * the last name of the artist
     */
    private String _lastName;

    /**
     * the artist' genre
     */
    private TypeCodeDTO _genre;

    /**
     * @return the id
     */
    public long getid() {
        return _artistID;
    }

    /**
     * @param id the _theOrder to set
     */
    public void setid(long artistID) {
        this._artistID = artistID;
    }

    /**
     * @return the _stageName
     */
    public String getStageName() {
        return _stageName;
    }

    /**
     * @param _stageName the _stageName to set
     */
    public void setStageName(String _stageName) {
        this._stageName = _stageName;
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
     * @return the _genre
     */
    public TypeCodeDTO getGenre() {
        return _genre;
    }

    /**
     * @param _genre the _genre to set
     */
    public void setGenre(TypeCodeDTO _genre) {
        this._genre = _genre;
    }
}
