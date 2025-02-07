package com.booking.facade.impl;

import com.booking.entity.Hotel;
import com.booking.entity.util.HotelDetailsDto;
import com.booking.exception.HotelNotFoundException;
import com.booking.facade.HotelFacade;
import com.booking.mapper.HotelMapper;
import com.booking.openapi.model.HotelBrief;
import com.booking.openapi.model.HotelDetail;
import com.booking.openapi.model.NewHotel;
import com.booking.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class HotelFacadeImpl implements HotelFacade {

    private final HotelService hotelService;
    private final HotelMapper hotelMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public HotelDetail getHotel(Integer id) throws HotelNotFoundException {
        log.debug("GET-request, getHotel - start, id = {}", id);

        Hotel hotel = hotelService.getHotel(id);
        HotelDetail response = hotelMapper.toHotelDetailsDto(hotel);

        log.debug("GET-request, getHotel - end, id = {}, response = {}", id, response);
        return response;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public List<HotelBrief> getHotels(int page, int size) {
        log.debug("GET-request, getHotels - start, page = {}, size = {}", page, size);

        Page<Hotel> hotelPage = hotelService.findAll(PageRequest.of(page, size));

        List<HotelBrief> response = hotelMapper.toHotelBriefDtos(hotelPage.getContent());

        log.debug("GET-request, getHotels - end, size = {}, totalElements = {}, response = {}",
                hotelPage.getContent().size(),
                hotelPage.getTotalElements(),
                response);

        return response;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HotelBrief createHotel(NewHotel newHotel) {
        log.debug("GET-request, createHotel - start, newHotel = {}", newHotel);
        Hotel hotel = hotelMapper.toHotel(newHotel);
        Hotel savedHotel = hotelService.createHotel(hotel);
        HotelBrief hotelBrief = hotelMapper.toHotelBriefDto(savedHotel);
        log.debug("GET-request, createHotel - start, savedHotel = {}", hotelBrief);
        return hotelBrief;
    }
}
