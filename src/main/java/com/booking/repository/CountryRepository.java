package com.booking.repository;


import com.booking.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for accessing and managing Country entities.
 * This interface extends JpaRepository for basic CRUD operations.
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    Optional<Country> findByName(String name);
}
