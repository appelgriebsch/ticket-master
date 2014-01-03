/**
 *  the model classes for the web application (MVC pattern)
 */

package de.fhdw.ify208.ticketmaster.webapp.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import javax.xml.bind.DatatypeConverter;
import java.util.Calendar;
import java.util.Date;

/**
 * a model class for holding the search request parameter from the webapp
 *
 * @author appelgriebsch
 */
@ManagedBean
@RequestScoped
public class SearchRequest {

    /**
     *   the option for the search request
     */
    private SearchOption _option = SearchOption.DATE;

    /**
     * the current value for the search request
     */
    private String _value = null;

    /**
     * provides access to the current search option setting
     *
     * @return the current search option setting
     */
    public SearchOption getSearchOption() {
        return _option;
    }

    /**
     * sets a new search option value
     *
     * @param option the search option to set
     */
    public void setSearchOption(SearchOption option) {

        this._option = option;

        switch (this._option) {

            case DATE:
                this.setDateValue(new Date());
                break;

            default:
                this.setValue("");
                break;
        }
    }

    /**
     * provides the current search request value
     *
     * @return the current search request value
     */
    public String getValue() {
        return _value;
    }

    /**
     * sets a new value for the current search request
     *
     * @param _value the search request value to set
     */
    public void setValue(String _value) {
        this._value = _value;
    }

    /**
     * provides the current search request value in Date format (when option is set to DATE)
     *
     * @return the current search request value as Date
     */
    public Date getDateValue() {

        if ((_option == SearchOption.DATE) && (_value != null)) {

            String value = getValue();
            return DatatypeConverter.parseDate(value).getTime();
        }

        return new Date();
    }

    /**
     * sets a new date value for the search request
     *
     * @param dtValue the date value to set
     */
    public void setDateValue(Date dtValue) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(dtValue);

        this._option = SearchOption.DATE;
        this._value = DatatypeConverter.printDateTime(cal);
    }

    /**
     * provides an array of items that can be selected from in the web app
     *
     * @return the available search options as items for an UI selection
     */
    public SelectItem[] getSearchOptions() {

        SelectItem[] items = new SelectItem[SearchOption.values().length];
        int i = 0;
        for (SearchOption o : SearchOption.values()) {
            items[i++] = new SelectItem(o, o.name());
        }
        return items;
    }

    /**
     * a convenience operation to check if a date search option is selected
     *
     * @return TRUE/FALSE
     */
    public boolean isDateOption() {

        return this.getSearchOption() == SearchOption.DATE;
    }
}
