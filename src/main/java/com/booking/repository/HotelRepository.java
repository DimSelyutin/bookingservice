package com.booking.repository;

import com.booking.entity.Hotel;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer>, JpaSpecificationExecutor<Hotel> {

    /**
     * Поиск гостиницы по её имени.
     *
     * @param id имя гостиницы
     * @return гостиница с указанным именем
     */
    Optional<Hotel> findById(@NotNull Integer id);


}
