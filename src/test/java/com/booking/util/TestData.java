package com.booking.util;

import com.booking.entity.Address;
import com.booking.entity.Amenity;
import com.booking.entity.Hotel;
import com.booking.openapi.model.*;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    private static final String SINGLE_HOTEL_TEST_NAME = "Single Hotel Test";
    private static final String HOTEL_NAME = "DoubleTree by Hilton Minsk";
    private static final String HOTEL_DESCRIPTION = "A fine hotel for your stay.";
    private static final String HOTEL_BRIEF_ADDRESS = "9 Pobediteley Avenue, Minsk, 220004, Belarus";
    private static final String HOTEL_PHONE = "+375291234567";
    private static final String HOTEL_EMAIL = "contact@testhotel.com";

    private static final String HOTEL_BRAND = "Hilton";


    private static final String HOTEL_DETAIL_ADDRESS_STREET = "Pobediteley Avenue";
    private static final String HOTEL_DETAIL_ADDRESS_CITY = "Minsk";
    private static final String HOTEL_DETAIL_COUNTRY = "Belarus";
    private static final String HOTEL_DETAIL_ADDRESS_POST_CODE = "220004";

    private static final String ARRIVAL_CHECK_IN = "14:00";
    private static final String ARRIVAL_CHECK_OUT = "15:00";

    public static List<Hotel> createTestHotels() {
        List<Hotel> hotels = new ArrayList<>();

        Address address = createTestAddress();

        Hotel hotel1 = createTestHotel(1, HOTEL_NAME, address);
        hotels.add(hotel1);

        Hotel hotel2 = createTestHotel(2, HOTEL_NAME, address);
        hotels.add(hotel2);

        return hotels;
    }

    public static Hotel createTestHotel(int id, String name, Address address) {
        Hotel hotel = new Hotel();
        hotel.setId(id);
        hotel.setName(name);
        hotel.setAddress(address);
        return hotel;
    }

    public static Address createTestAddress() {
        Address address = new Address();
        address.setCity(HOTEL_DETAIL_ADDRESS_CITY);
        address.setHouseNumber(9);
        address.setPostCode(HOTEL_DETAIL_ADDRESS_POST_CODE);
        address.setStreet(HOTEL_DETAIL_ADDRESS_STREET);
        address.setCountry(HOTEL_DETAIL_COUNTRY);
        return address;
    }

    public static com.booking.openapi.model.Address createAddressDto() {
        com.booking.openapi.model.Address address = new com.booking.openapi.model.Address();
        address.setCity(HOTEL_DETAIL_ADDRESS_CITY);
        address.setHouseNumber(9);
        address.setPostCode(HOTEL_DETAIL_ADDRESS_POST_CODE);
        address.setStreet(HOTEL_DETAIL_ADDRESS_STREET);
        address.setCountry(HOTEL_DETAIL_COUNTRY);
        return address;
    }

    public static Hotel createSingleTestHotel() {
        Address address = createTestAddress();
        return createTestHotel(1, SINGLE_HOTEL_TEST_NAME, address);
    }

    public static HotelBrief createTestHotelBrief() {
        HotelBrief hotelBrief = new HotelBrief();
        hotelBrief.setId(1);
        hotelBrief.setName(HOTEL_NAME);
        hotelBrief.setDescription(HOTEL_DESCRIPTION);
        hotelBrief.setAddress(HOTEL_BRIEF_ADDRESS);
        hotelBrief.setPhone(HOTEL_PHONE);
        return hotelBrief;
    }

    public static NewHotel createTestNewHotel() {
        Contact contact = new Contact();
        contact.setPhone(HOTEL_PHONE);
        contact.setEmail(HOTEL_EMAIL);

        ArrivalTime arrivalTime = new ArrivalTime();
        arrivalTime.setCheckIn(ARRIVAL_CHECK_IN);
        arrivalTime.setCheckOut(ARRIVAL_CHECK_OUT);

        NewHotel newHotel = new NewHotel();
        newHotel.setName(HOTEL_NAME);
        newHotel.setDescription(HOTEL_DESCRIPTION);
        newHotel.setBrand(HOTEL_BRAND);
        newHotel.setAddress(createAddressDto());
        newHotel.setContacts(contact);
        newHotel.setArrivalTime(arrivalTime);

        return newHotel;
    }

    public static HotelDetail createTestHotelDetails() {
        HotelDetail hotelDetail = new HotelDetail();
        hotelDetail.setId(1);
        hotelDetail.setName(HOTEL_NAME);
        hotelDetail.setBrand(HOTEL_BRAND);


        com.booking.openapi.model.Address address = new com.booking.openapi.model.Address();
        address.setStreet(HOTEL_DETAIL_ADDRESS_STREET);
        address.setCity(HOTEL_DETAIL_ADDRESS_CITY);
        address.setHouseNumber(9);
        address.setPostCode(HOTEL_DETAIL_ADDRESS_POST_CODE);
        hotelDetail.setAddress(address);

        com.booking.openapi.model.Contact contact = new com.booking.openapi.model.Contact();
        contact.setPhone(HOTEL_PHONE);
        contact.setEmail(HOTEL_EMAIL);
        hotelDetail.setContacts(contact);

        ArrivalTime arrivalTime = new ArrivalTime();
        arrivalTime.setCheckIn(ARRIVAL_CHECK_IN);
        arrivalTime.setCheckOut(ARRIVAL_CHECK_OUT);
        hotelDetail.setArrivalTime(arrivalTime);
        hotelDetail.setAmenities(List.of("Free Parking", "Pool"));

        return hotelDetail;
    }
}
