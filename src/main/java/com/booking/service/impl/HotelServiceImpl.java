package com.booking.service.impl;

import com.booking.entity.*;
import com.booking.entity.util.HotelSearchCriteria;
import com.booking.exception.HotelNotFoundException;
import com.booking.repository.*;
import com.booking.service.HotelService;
import com.booking.repository.specification.HotelSpecifications;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service for managing hotels.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {


    private final HotelRepository hotelRepository;


    private final CityRepository cityRepository;


    private final StreetRepository streetRepository;


    private final AddressRepository addressRepository;
    private final CountryRepository countryRepository;

    /**
     * {@inheritDoc}
     */

    @Transactional(readOnly = true)
    @Override
    public Hotel getHotel(Integer id) throws HotelNotFoundException {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException("Hotel with id " + id + " not found!"));
    }

    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = true)
    @Override
    public Page<Hotel> findAll(PageRequest page) {
        return hotelRepository.findAll(page);

    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    public Hotel createHotel(Hotel hotel) {
        if (hotel == null || hotel.getAddressEntity() == null || hotel.getAddressEntity().getStreet() == null) {
            throw new IllegalArgumentException("Hotel and its associated address and street must not be null");
        }

        // Сбор информации из репозиториев
        AddressEntity addressEntity = hotel.getAddressEntity();
        Street street = addressEntity.getStreet();
        City city = street.getCity();
        String countryName = city.getCountry().getName();

        // Получение или создание сущностей
        Country country = getOrCreateCountry(countryName);
        City existingCity = getOrCreateCity(city, country);
        Street existingStreet = getOrCreateStreet(street, existingCity);

        // Сохранение данных
        addressEntity.setStreet(existingStreet);
        addressEntity = addressRepository.save(addressEntity);

        hotel.setAddressEntity(addressEntity);
        return hotelRepository.save(hotel);
    }

    private Country getOrCreateCountry(String countryName) {
        return countryRepository.findByName(countryName)
                .orElseGet(() -> countryRepository.save(new Country(null, countryName, null)));
    }

    private City getOrCreateCity(City city, Country country) {
        return cityRepository.findByNameAndCountry(city.getName(), country)
                .orElseGet(() -> {
                    city.setCountry(country);
                    return cityRepository.save(city);
                });
    }

    private Street getOrCreateStreet(Street street, City city) {
        street.setCity(city);
        return streetRepository.save(street);
    }


    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = true)
    @Override
    public List<Hotel> searchHotelsByFilters(HotelSearchCriteria criteria) {

        log.debug("Searching hotels with criteria: Brand={}, City={}, Country={}, Amenities={}",
                criteria.getBrand(), criteria.getCity(), criteria.getCountry(), criteria.getAmenities());

        List<Hotel> hotels = hotelRepository.findAll(HotelSpecifications.byCriteria(
                criteria.getBrand(),
                criteria.getCity(),
                criteria.getCountry(),
                criteria.getAmenities()
        ));

        log.debug("Found {} hotels matching the criteria.", hotels.size());

        return hotels;
    }

}
