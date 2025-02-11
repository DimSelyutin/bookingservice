package com.booking.exception;

/**
 * Exception indicating an incorrect customer order.
 * Error code: 400.
 **/
public class BadRequestException extends RuntimeException {

    /**
     * Exception constructor.
     *
     * @param message Message.
     */
    public BadRequestException(final String message) {
        super(message);
    }
}
