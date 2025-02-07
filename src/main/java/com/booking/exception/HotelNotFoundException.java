package com.booking.exception;

/**
 * An exception indicating that no data was found.
 * Error code: 404.
 **/
public class HotelNotFoundException extends RuntimeException {

    public HotelNotFoundException(String message) {
        super(message);
    }
}
