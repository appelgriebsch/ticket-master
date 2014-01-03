package de.fhdw.ify208.ticketmaster.common.model;

/**
 * @author ankariu
 */
public class BaseDTO {

    private int _returncode;
    private String _message;

    public void setMessage(String message) {
        this._message = message;
    }

    public String getMessage() {
        return _message;
    }

    public void setReturncode(int returncode) {
        this._returncode = returncode;
    }

    public int getReturncode() {
        return _returncode;
    }
}
