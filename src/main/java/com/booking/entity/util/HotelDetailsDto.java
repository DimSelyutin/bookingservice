package com.booking.entity.util;


import com.booking.entity.AddressEntity;
import com.booking.entity.Contact;
import com.booking.entity.Hotel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The class representing the hotel.
 */
@Getter
@Setter
@Builder
@ToString
public class HotelDetailsDto {
    private Hotel hotel;
    private AddressEntity addressEntity;
    private Contact contact;

}
