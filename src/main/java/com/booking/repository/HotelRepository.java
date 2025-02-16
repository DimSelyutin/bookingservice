package com.booking.repository;

import com.booking.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing and managing Hotel entities.
 * This interface extends JpaRepository for basic CRUD operations
 * and JpaSpecificationExecutor for advanced querying capabilities.
 */
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer>, JpaSpecificationExecutor<Hotel> {


}
