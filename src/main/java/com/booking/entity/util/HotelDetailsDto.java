package com.booking.entity.util;


import com.booking.entity.Address;
import com.booking.entity.Contact;
import com.booking.entity.Hotel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Класс, представляющий отель.
 */
@Getter
@Setter
@Builder
@ToString
public class HotelDetailsDto {
    private Hotel hotel;
    private Address address;
    private Contact contact;

}
