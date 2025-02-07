package com.booking.service;

import com.booking.entity.Hotel;
import com.booking.entity.util.HotelDetailsDto;
import com.booking.openapi.model.HotelBrief;
import com.booking.openapi.model.NewHotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * API сервиса для работы с {@link Hotel}.
 */
@Service
public interface HotelService {

    /**
     * Получение данных о гостинице по ее идентификатору.
     *
     * @param id идентификатор гостиницы
     * @return данные о гостинице
     */
    Hotel getHotel(Integer id);

    /**
     * Получить список гостиниц с учетом указанных индекса начала и размера.
     *
     * @return список гостиниц, начиная с указанного индекса и с заданным размером
     */
    Page<Hotel> findAll(PageRequest pageRequest);

    /**
     * Создание новой гостиницы.
     *
     * @param hotel данные для создания гостиницы
     * @return данные созданной гостиницы
     */
    Hotel createHotel(Hotel hotel);


    /**------------/search?city=minsk&name=Avrora
     * Получение списка гостиниц по определенным фильтрам.
     *
     * @param filter критерии для поиска гостиниц
     * @return список гостиниц, соответствующих критериям фильтрации
     */
    List<Hotel> searchHotelsByFilters(String filter);

//    /**
//     * Обновление информации о гостинице.
//     *
//     * @param id идентификатор гостиницы
//     * @param hotel новые данные для обновления
//     * @return обновленные данные о гостинице
//     */
//    Hotel updateHotel(Integer id, Hotel hotel);

    /**
     * Получение списка всех гостиниц, соответствующих заданному статусу.
     *
     * @param status статус гостиницы
     * @param page   начальный индекс
     * @param size   размер списка
     * @return список гостиниц с заданным статусом
     */
    Page<Hotel> getAllHotelsByStatus(String status, Integer page, Integer size);
}
