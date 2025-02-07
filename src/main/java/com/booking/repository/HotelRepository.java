package com.booking.repository;

import com.booking.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, UUID> {

    /**
     * Поиск гостиницы по её имени.
     *
     * @param id имя гостиницы
     * @return гостиница с указанным именем
     */
    Optional<Hotel> findById(Integer id);
}
