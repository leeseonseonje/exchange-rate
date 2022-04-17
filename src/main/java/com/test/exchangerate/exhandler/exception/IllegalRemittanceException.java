package com.test.exchangerate.exhandler.exception;

public class IllegalRemittanceException extends IllegalArgumentException {

    public IllegalRemittanceException() {
        super();
    }

    public IllegalRemittanceException(String s) {
        super(s);
    }

    public IllegalRemittanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalRemittanceException(Throwable cause) {
        super(cause);
    }
}
