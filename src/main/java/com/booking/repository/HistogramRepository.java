package com.booking.repository;

import com.booking.entity.Hotel;
import com.booking.entity.util.HotelCountDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repository interface for accessing and managing Hotel entities.
 * This interface extends JpaRepository and provides additional
 * query methods for generating histogram data based on hotel statistics.
 */
public interface HistogramRepository extends JpaRepository<Hotel, Integer> {

    /**
     * Counts the number of hotels grouped by city.
     *
     * @return a list of objects where each object array contains the city name
     * and the corresponding hotel count.
     */
    @Query("SELECT new com.booking.entity.util.HotelCountDTO(h.addressEntity.street.city.name, COUNT(h)) FROM Hotel h GROUP BY h.addressEntity.street.city.name")
    List<HotelCountDTO> countHotelsByCity();

    /**
     * Counts the number of hotels grouped by brand.
     *
     * @return a list of objects where each object array contains the brand name
     * and the corresponding hotel count.
     */
    @Query("SELECT h.brand AS name, COUNT(h) AS count FROM Hotel h GROUP BY h.brand")
    List<HotelCountDTO> countHotelsByBrand();

    /**
     * Counts the number of hotels grouped by country.
     *
     * @return a list of objects where each object array contains the country name
     * and the corresponding hotel count.
     */
    @Query("SELECT h.addressEntity.street.city.country AS name, COUNT(h) AS count FROM Hotel h GROUP BY h.addressEntity.street.city.country")
    List<HotelCountDTO> countHotelsByCountry();

    /**
     * Counts the number of hotels grouped by amenities.
     *
     * @return a list of objects where each object array contains the amenity name
     * and the corresponding hotel count.
     */
    @Query("SELECT new com.booking.entity.util.HotelCountDTO(a.name, COUNT(h)) " +
            "FROM Hotel h JOIN h.amenities a " +
            "GROUP BY a.name")
    List<HotelCountDTO> countHotelsByAmenities();
}
