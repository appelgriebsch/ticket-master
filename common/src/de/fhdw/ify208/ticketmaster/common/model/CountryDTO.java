/**
 *
 */
package de.fhdw.ify208.ticketmaster.common.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author appelgriebsch
 */
@XmlRootElement(name = "country")
public class CountryDTO extends TypeCodeDTO {

    /**
     * the 3-char ISO code for the country
     */
    private String _isoCode;

    /**
     * @return the _isoCode
     */
    public String getIsoCode() {
        return _isoCode;
    }

    /**
     * @param _isoCode the _isoCode to set
     */
    public void setIsoCode(String _isoCode) {
        this._isoCode = _isoCode;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
