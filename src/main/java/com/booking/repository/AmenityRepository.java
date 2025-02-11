package com.booking.repository;

import com.booking.entity.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for accessing and managing Amenity entities.
 * This interface extends JpaRepository, providing CRUD operations
 * and additional query methods for Amenity entities.
 */
@Repository
public interface AmenityRepository extends JpaRepository<Amenity, Integer> {

    /**
     * Retrieves an Amenity entity by its name.
     *
     * @param name the name of the amenity to search for.
     * @return an Optional containing the found Amenity, or empty if no amenity with the given name exists.
     */
    Optional<Amenity> findByName(String name);
}
