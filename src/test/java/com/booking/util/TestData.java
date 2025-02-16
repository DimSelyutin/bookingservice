package com.booking.util;

import com.booking.entity.*;
import com.booking.openapi.model.*;
import com.booking.openapi.model.ArrivalTime;
import com.booking.openapi.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    public static List<Hotel> createTestHotels() {
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(createTestHotel(1, "Hotel One", createTestAddress(1, "Main St", "New York", "USA", "10001")));
        hotels.add(createTestHotel(2, "Hotel Two", createTestAddress(2, "Second St", "Los Angeles", "USA", "90001")));
        hotels.add(createTestHotel(3, "Hotel Three", createTestAddress(3, "Third St", "Chicago", "USA", "60601")));
        return hotels;
    }

    public static Hotel createTestHotel(int id, String name, AddressEntity addressEntity) {
        Hotel hotel = new Hotel();
        hotel.setId(id);
        hotel.setName(name);
        hotel.setAddressEntity(addressEntity);
        return hotel;
    }

    public static AddressEntity createTestAddress(int id, String streetName, String city, String country, String postCode) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(id);
        Country countryObj = new Country();
        countryObj.setName(country);

        City cityObj = new City();
        cityObj.setName(city);

        Street street = new Street();
        street.setName(streetName);

        cityObj.setCountry(countryObj);
        street.setCity(cityObj);
        addressEntity.setStreet(street);


        addressEntity.setPostCode(postCode);
        addressEntity.setHouseNumber(9);

        return addressEntity;
    }

    public static com.booking.openapi.model.Address createAddressDto(String street, String city, String country, String postCode, int houseNumber) {
        com.booking.openapi.model.Address address = new com.booking.openapi.model.Address();
        address.setStreet(street);
        address.setCity(city);
        address.setHouseNumber(houseNumber);
        address.setPostCode(postCode);
        address.setCountry(country);
        return address;
    }

    public static Hotel createSingleTestHotel() {
        return createTestHotel(1, "Single Hotel", createTestAddress(1, "Single St", "Cityville", "Country A", "12345"));
    }

    public static HotelBrief createTestHotelBrief() {
        HotelBrief hotelBrief = new HotelBrief();
        hotelBrief.setId(1);
        hotelBrief.setName("DoubleTree by Hilton Minsk");
        hotelBrief.setDescription("Nice brief description.");
        hotelBrief.setAddress("123 Brief St, City, Country");
        hotelBrief.setPhone("123-456-7890");
        return hotelBrief;
    }

    public static NewHotel createTestNewHotel() {
        Contact contact = new Contact();
        contact.setPhone("098-765-4321");
        contact.setEmail("test@example.com");

        ArrivalTime arrivalTime = new ArrivalTime();
        arrivalTime.setCheckIn("14:00");
        arrivalTime.setCheckOut("12:00");

        NewHotel newHotel = new NewHotel();
        newHotel.setName("New Hotel");
        newHotel.setDescription("Description for new hotel.");
        newHotel.setBrand("Brand A");
        newHotel.setAddress(createAddressDto("New St", "New City", "New Country", "123456", 9));
        newHotel.setContacts(contact);
        newHotel.setArrivalTime(arrivalTime);

        return newHotel;
    }

    public static HotelDetail createTestHotelDetails() {
        HotelDetail hotelDetail = new HotelDetail();
        hotelDetail.setId(1);
        hotelDetail.setName("Detail Hotel");
        hotelDetail.setBrand("Brand B");

        hotelDetail.setAddress(createAddressDto("Detail St", "Detail City", "Detail Country", "654321", 12));


        com.booking.openapi.model.Contact contact = new com.booking.openapi.model.Contact();
        contact.setPhone("321-654-0987");
        contact.setEmail("detail@example.com");
        hotelDetail.setContacts(contact);

        ArrivalTime arrivalTime = new ArrivalTime();
        arrivalTime.setCheckIn("15:00");
        arrivalTime.setCheckOut("11:00");
        hotelDetail.setArrivalTime(arrivalTime);
        hotelDetail.setAmenities(List.of("Free WiFi", "Gym", "Spa"));

        return hotelDetail;
    }
}
