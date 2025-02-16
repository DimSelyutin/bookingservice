package com.booking.repository;

import com.booking.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing and managing AddressEntity entities.
 * This interface extends JpaRepository for basic CRUD operations.
 */
@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
}
