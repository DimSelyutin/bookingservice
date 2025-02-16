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
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    @Override
    public void addAmenitiesToHotel(Integer hotelId, List<String> amenities) {
        log.info("Attempting to add amenities to hotel with ID: {}", hotelId);

        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> {
                    log.error("Hotel not found with id: {}", hotelId);
                    return new EntityNotFoundException("Hotel not found with id: " + hotelId);
                });

        log.info("Found hotel: {}", hotel.getName());

        for (String amenityName : amenities) {
            log.debug("Processing amenity: {}", amenityName);
            Amenity amenity = amenityRepository.findByName(amenityName)
                    .orElseGet(() -> {
                        log.info("Amenity not found, creating new amenity: {}", amenityName);
                        return amenityRepository.save(Amenity.builder().name(amenityName).build());
                    });
            hotel.getAmenities().add(amenity);
            log.info("Added amenity '{}' to hotel '{}'", amenity.getName(), hotel.getName());
        }

        hotelRepository.save(hotel);
        log.info("Successfully added amenities to hotel: {}", hotel.getName());
    }
}
