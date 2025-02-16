package com.booking.mapper.util;

import com.booking.entity.AddressEntity;
import com.booking.openapi.model.Address;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {StreetMapper.class, CityMapper.class, CountryMapper.class})
public interface AddressMapper {

    @Mapping(target = "street.name", source = "address.street")
    @Mapping(target = "street.city.name", source = "address.city")
    @Mapping(target = "street.city.country.name", source = "address.country")
    AddressEntity toEntity(Address address);

    @Mapping(target = "street", source = "street.name")
    @Mapping(target = "city", source = "street.city.name")
    @Mapping(target = "country", source = "street.city.country.name")
    Address toDto(AddressEntity addressEntity);
}
