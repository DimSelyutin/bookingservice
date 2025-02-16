package com.booking.facade.impl;

import com.booking.facade.AmenityFacade;
import com.booking.mapper.HotelMapper;
import com.booking.service.AmenityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Facade for Amenities.
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class AmenityFacadeImpl implements AmenityFacade {

    private final AmenityService amenityService;
    private final HotelMapper hotelMapper;

    /**
     * Create amenities for hotel.
     *
     * @param hotelId id of hotel.
     * @param amenities list amenities.
     */
    @Override
    public void addAmenitiesToHotel(Integer hotelId, List<String> amenities) {
        log.info("Adding amenities to hotel - start, hotelId = {}, amenities = {}", hotelId, amenities);
        amenityService.addAmenitiesToHotel(hotelId, amenities);
        log.info("Adding amenities to hotel - end, hotelId = {}", hotelId);
    }
}
