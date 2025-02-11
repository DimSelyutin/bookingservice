package com.booking.repository;

import com.booking.entity.Hotel;
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
    @Query("SELECT h.address.city AS city, COUNT(h) AS count FROM Hotel h GROUP BY h.address.city")
    List<Object[]> countHotelsByCity();

    /**
     * Counts the number of hotels grouped by brand.
     *
     * @return a list of objects where each object array contains the brand name
     * and the corresponding hotel count.
     */
    @Query("SELECT h.brand AS name, COUNT(h) AS count FROM Hotel h GROUP BY h.brand")
    List<Object[]> countHotelsByBrand();

    /**
     * Counts the number of hotels grouped by country.
     *
     * @return a list of objects where each object array contains the country name
     * and the corresponding hotel count.
     */
    @Query("SELECT h.address.country AS name, COUNT(h) AS count FROM Hotel h GROUP BY h.address.country")
    List<Object[]> countHotelsByCountry();

    /**
     * Counts the number of hotels grouped by amenities.
     *
     * @return a list of objects where each object array contains the amenity name
     * and the corresponding hotel count.
     */
    @Query("SELECT a.name AS name, COUNT(h) AS count " +
            "FROM Hotel h JOIN h.amenities a " +
            "GROUP BY a.name")
    List<Object[]> countHotelsByAmenities();
}
