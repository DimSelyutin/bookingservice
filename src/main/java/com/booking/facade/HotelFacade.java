package com.booking.facade;

import com.booking.openapi.model.HotelBrief;
import com.booking.openapi.model.HotelDetail;
import com.booking.openapi.model.HotelSearchCriteriaDTO;
import com.booking.openapi.model.NewHotel;

import java.util.List;

/**
 * Facade for hotels.
 */
public interface HotelFacade {

    /**
     * Getting details of hotel.
     *
     * @param id id hotel
     * @return DTO hotel details
     */
    HotelDetail getHotel(Integer id);

    /**
     * Getting list of hotel.
     *
     * @param page page number
     * @param size page size
     * @return list of hotels
     */
    List<HotelBrief> getHotels(int page, int size);

    /**
     * Creating new hotel.
     *
     * @param newHotel dto with info of new Hotel
     * @return HotelBrief
     */
    HotelBrief createHotel(NewHotel newHotel);

    /**
     * Search hotels of criteria.
     *
     * @param criteriaDTO dto with List of Hotel
     * @return list of HotelBrief
     */
    List<HotelBrief> searchHotels(HotelSearchCriteriaDTO criteriaDTO);
}
