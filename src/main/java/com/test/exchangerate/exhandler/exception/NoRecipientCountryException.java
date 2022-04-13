package com.test.exchangerate.exhandler.exception;

public class NoRecipientCountryException extends IllegalArgumentException {

    public NoRecipientCountryException() {
        super();
    }

    public NoRecipientCountryException(String s) {
        super(s);
    }

    public NoRecipientCountryException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoRecipientCountryException(Throwable cause) {
        super(cause);
    }
}
