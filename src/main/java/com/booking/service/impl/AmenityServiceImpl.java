package com.booking.service.impl;


import com.booking.entity.Amenity;
import com.booking.entity.Hotel;
import com.booking.repository.AmenityRepository;
import com.booking.repository.HotelRepository;
import com.booking.service.AmenityService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for managing amenities associated with hotels.
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class AmenityServiceImpl implements AmenityService {

    private final AmenityRepository amenityRepository;
    private final HotelRepository hotelRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public void addAmenitiesToHotel(Integer hotelId, List<String> amenities) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new EntityNotFoundException("Hotel not found with id: " + hotelId));

        for (String amenityName : amenities) {
            Amenity amenity = amenityRepository.findByName(amenityName)
                    .orElseGet(() -> amenityRepository.save(Amenity.builder().name(amenityName).build()));
            hotel.getAmenities().add(amenity);
        }

        hotelRepository.save(hotel);
    }
}
