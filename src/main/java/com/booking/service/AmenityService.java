package com.booking.service;

import java.util.List;

/**
 * Service interface for managing amenities associated with hotels.
 * This interface defines methods for adding amenities to a specific hotel.
 */
public interface AmenityService {

    /**
     * Adds a list of amenities to a specified hotel.
     *
     * @param hotelId   the ID of the hotel to which amenities will be added. Must not be null.
     * @param amenities a list of amenity names to be added to the hotel. Must not be null or empty.
     */
    void addAmenitiesToHotel(Integer hotelId, List<String> amenities);
}
