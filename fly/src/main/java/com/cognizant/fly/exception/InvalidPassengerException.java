package com.cognizant.fly.exception;

public class InvalidPassengerException extends Exception {

    private static final long serialVersionUID = 5151260494073634535L;

    /**
     * @param message
     * @param cause
     */
    public InvalidPassengerException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public InvalidPassengerException(String message) {
        super(message);
    }

}
