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

        String countryName = hotel.getAddressEntity().getStreet().getCity().getCountry().getName();


        Country country = countryRepository.findByName(countryName).orElseGet(() -> {
            Country newCountry = new Country(null, countryName, null);
            return countryRepository.save(newCountry);
        });


        City city = hotel.getAddressEntity().getStreet().getCity();


        City existingCity = cityRepository.findByNameAndCountry(city.getName(), country)
                .orElseGet(() -> {
                    city.setCountry(country);
                    return cityRepository.save(city);
                });

        Street street = hotel.getAddressEntity().getStreet();
        street.setCity(existingCity);
        street = streetRepository.save(street);


        AddressEntity address = hotel.getAddressEntity();
        address.setStreet(street);
        address = addressRepository.save(address);


        hotel.setAddressEntity(address);
        return hotelRepository.save(hotel);
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
