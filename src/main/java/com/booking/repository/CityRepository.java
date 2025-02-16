package com.booking.repository;

import com.booking.entity.City;
import com.booking.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for accessing and managing City entities.
 * This interface extends JpaRepository for basic CRUD operations.
 */
@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    Optional<City> findByNameAndCountry(String name, Country country);
}
