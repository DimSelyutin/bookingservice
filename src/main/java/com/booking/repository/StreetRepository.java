package com.booking.repository;

import com.booking.entity.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing and managing Street entities.
 * This interface extends JpaRepository for basic CRUD operations.
 */
@Repository
public interface StreetRepository extends JpaRepository<Street, Integer> {
}
