package com.booking.mapper.util;

import com.booking.entity.AddressEntity;
import com.booking.entity.City;
import com.booking.entity.Country;
import com.booking.entity.Street;
import com.booking.openapi.model.Address;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-16T18:02:25+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressEntity toEntity(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setStreet( addressToStreet( address ) );
        if ( address.getHouseNumber() != null ) {
            addressEntity.setHouseNumber( address.getHouseNumber() );
        }
        addressEntity.setPostCode( address.getPostCode() );

        return addressEntity;
    }

    @Override
    public Address toDto(AddressEntity addressEntity) {
        if ( addressEntity == null ) {
            return null;
        }

        Address address = new Address();

        address.setStreet( addressEntityStreetName( addressEntity ) );
        address.setCity( addressEntityStreetCityName( addressEntity ) );
        address.setCountry( addressEntityStreetCityCountryName( addressEntity ) );
        address.setHouseNumber( addressEntity.getHouseNumber() );
        address.setPostCode( addressEntity.getPostCode() );

        return address;
    }

    protected Country addressToCountry(Address address) {
        if ( address == null ) {
            return null;
        }

        Country country = new Country();

        country.setName( address.getCountry() );

        return country;
    }

    protected City addressToCity(Address address) {
        if ( address == null ) {
            return null;
        }

        City city = new City();

        city.setCountry( addressToCountry( address ) );
        city.setName( address.getCity() );

        return city;
    }

    protected Street addressToStreet(Address address) {
        if ( address == null ) {
            return null;
        }

        Street street = new Street();

        street.setCity( addressToCity( address ) );
        street.setName( address.getStreet() );

        return street;
    }

    private String addressEntityStreetName(AddressEntity addressEntity) {
        Street street = addressEntity.getStreet();
        if ( street == null ) {
            return null;
        }
        return street.getName();
    }

    private String addressEntityStreetCityName(AddressEntity addressEntity) {
        Street street = addressEntity.getStreet();
        if ( street == null ) {
            return null;
        }
        City city = street.getCity();
        if ( city == null ) {
            return null;
        }
        return city.getName();
    }

    private String addressEntityStreetCityCountryName(AddressEntity addressEntity) {
        Street street = addressEntity.getStreet();
        if ( street == null ) {
            return null;
        }
        City city = street.getCity();
        if ( city == null ) {
            return null;
        }
        Country country = city.getCountry();
        if ( country == null ) {
            return null;
        }
        return country.getName();
    }
}
