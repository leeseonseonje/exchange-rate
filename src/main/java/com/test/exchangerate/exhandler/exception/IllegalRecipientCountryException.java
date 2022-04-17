package com.test.exchangerate.exhandler.exception;

public class IllegalRecipientCountryException extends IllegalArgumentException {

    public IllegalRecipientCountryException() {
        super();
    }

    public IllegalRecipientCountryException(String s) {
        super(s);
    }

    public IllegalRecipientCountryException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalRecipientCountryException(Throwable cause) {
        super(cause);
    }
}
