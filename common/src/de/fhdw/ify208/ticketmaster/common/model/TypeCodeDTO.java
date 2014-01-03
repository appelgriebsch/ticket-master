/**
 *
 */
package de.fhdw.ify208.ticketmaster.common.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author appelgriebsch
 */
@XmlRootElement(name = "typecode")
public class TypeCodeDTO extends BaseDTO {

    /**
     * a id on database for identification and mapping
     */
    private int _id;

    /**
     * a name to display on screen
     */
    private String _name;

    /**
     * an optional description
     */
    private String _description;

    /**
     * @return the _id
     */
    public int getId() {
        return _id;
    }

    /**
     * @param _name the _id to set
     */
    public void setId(int _id) {
        this._id = _id;
    }

    /**
     * @return the _name
     */
    public String getName() {
        return _name;
    }

    /**
     * @param _name the _name to set
     */
    public void setName(String _name) {
        this._name = _name;
    }

    /**
     * @return the _description
     */
    public String getDescription() {
        return _description;
    }

    /**
     * @param _description the _description to set
     */
    public void setDescription(String _description) {
        this._description = _description;
    }

    @Override
    public String toString() {
        return getName();
    }
}
