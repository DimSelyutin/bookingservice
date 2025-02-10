package com.booking.facade;

import java.util.List;

/**
 * Facade for Amenities.
 */
public interface AmenityFacade {

    /**
     * Create amenities for hotel.
     *
     * @param hotelId
     * @param amenities
     */
    void addAmenitiesToHotel(Integer hotelId, List<String> amenities);
}
