package com.booking.service.impl;

import com.booking.entity.Address;
import com.booking.entity.Contact;
import com.booking.entity.Hotel;
import com.booking.entity.util.HotelDetailsDto;
import com.booking.exception.HotelNotFoundException;
import com.booking.openapi.model.HotelBrief;
import com.booking.openapi.model.NewHotel;
import com.booking.repository.HotelRepository;
import com.booking.service.HotelService;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {


    private final HotelRepository hotelRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Hotel getHotel(Integer id) throws HotelNotFoundException {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException("Hotel with id " + id + " not found!"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<Hotel> findAll(PageRequest page) {
        return hotelRepository.findAll(page);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Hotel createHotel(@NotNull Hotel newHotel) {
        Hotel savedHotel = hotelRepository.save(newHotel);
        return savedHotel;
    }

    /**
     * ------------/search?city=minsk&name=Avrora
     * {@inheritDoc}
     */
    @Override
    public List<Hotel> searchHotelsByFilters(String filter) {
        return List.of();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<Hotel> getAllHotelsByStatus(String status, Integer page, Integer size) {
        return null;
    }
}
