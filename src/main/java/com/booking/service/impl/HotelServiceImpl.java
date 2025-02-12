package com.booking.service.impl;

import com.booking.entity.Hotel;
import com.booking.entity.util.HotelSearchCriteria;
import com.booking.exception.HotelNotFoundException;
import com.booking.repository.HotelRepository;
import com.booking.service.HotelService;
import com.booking.repository.specification.HotelSpecifications;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service for managing hotels.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {


    private final HotelRepository hotelRepository;

    /**
     * {@inheritDoc}
     */

    @Transactional(readOnly = true)
    @Override
    public Hotel getHotel(Integer id) throws HotelNotFoundException {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException("Hotel with id " + id + " not found!"));
    }

    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = true)
    @Override
    public Page<Hotel> findAll(PageRequest page) {
        return hotelRepository.findAll(page);

    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public Hotel createHotel(@NotNull Hotel newHotel) {
        Hotel savedHotel = hotelRepository.save(newHotel);
        return savedHotel;
    }

    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = true)
    @Override
    public List<Hotel> searchHotelsByFilters(HotelSearchCriteria criteria) {

        log.debug("Searching hotels with criteria: Brand={}, City={}, Country={}, Amenities={}",
                criteria.getBrand(), criteria.getCity(), criteria.getCountry(), criteria.getAmenities());

        List<Hotel> hotels = hotelRepository.findAll(HotelSpecifications.byCriteria(
                criteria.getBrand(),
                criteria.getCity(),
                criteria.getCountry(),
                criteria.getAmenities()
        ));

        log.debug("Found {} hotels matching the criteria.", hotels.size());

        return hotels;
    }

}
