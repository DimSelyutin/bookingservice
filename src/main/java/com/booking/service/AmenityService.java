package com.booking.service;

import java.util.List;
/**
 * API сервиса для работы с amenities.
 */
public interface AmenityService {
    /**
     *
     * @param hotelId
     * @param amenities
     */
    void addAmenitiesToHotel(Integer hotelId, List<String> amenities);
}
