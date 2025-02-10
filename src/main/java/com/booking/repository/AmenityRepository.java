package com.booking.repository;

import com.booking.entity.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AmenityRepository extends JpaRepository<Amenity, Integer> {
    /**
     * Finding amenity.
     * @param name
     * @return
     */
    Optional<Amenity> findByName(String name);
}
