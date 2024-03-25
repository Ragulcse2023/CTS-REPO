package com.cognizant.fly.exception;

public class ApplicationException extends Exception {

    private static final long serialVersionUID = 5151260494073634535L;

    /**
     * @param message
     * @param cause
     */
    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public ApplicationException(String message) {
        super(message);
    }

}
