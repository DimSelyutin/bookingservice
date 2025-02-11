package com.booking.repository;

import com.booking.entity.Hotel;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for accessing and managing Hotel entities.
 * This interface extends JpaRepository for basic CRUD operations
 * and JpaSpecificationExecutor for advanced querying capabilities.
 */
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer>, JpaSpecificationExecutor<Hotel> {

    /**
     * Retrieves a Hotel entity by its ID.
     *
     * @param id the ID of the hotel to retrieve. Must not be null.
     * @return an Optional containing the found Hotel, or empty if no hotel with the given ID exists.
     */
    Optional<Hotel> findById(@NotNull Integer id);
}
