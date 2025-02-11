package com.booking.service;

import com.booking.entity.Hotel;
import com.booking.entity.util.HotelSearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service interface for managing hotels.
 * This interface defines methods for retrieving, creating, and searching hotels.
 */
@Service
public interface HotelService {

    /**
     * Retrieves a hotel by its unique identifier.
     *
     * @param id the unique identifier of the hotel. Must not be null.
     * @return the Hotel object associated with the given ID, or null if not found.
     */
    Hotel getHotel(Integer id);

    /**
     * Retrieves a paginated list of all hotels.
     *
     * @param pageRequest the pagination information including page number and size.
     * @return a Page object containing a list of Hotel objects.
     */
    Page<Hotel> findAll(PageRequest pageRequest);

    /**
     * Creates a new hotel entry.
     *
     * @param hotel the Hotel object containing information about the hotel to be created.
     *              Must not be null.
     * @return the created Hotel object, including its generated ID.
     */
    Hotel createHotel(Hotel hotel);

    /**
     * Searches for hotels based on specified criteria.
     *
     * @param criteria the criteria used for searching hotels. Must not be null.
     * @return a list of Hotel objects that match the specified criteria.
     */
    List<Hotel> searchHotelsByFilters(HotelSearchCriteria criteria);
}
