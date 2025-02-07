package com.booking.util;

import com.booking.entity.Address;
import com.booking.entity.Hotel;
import com.booking.openapi.model.ArrivalTime;
import com.booking.openapi.model.Contact;
import com.booking.openapi.model.HotelBrief;
import com.booking.openapi.model.NewHotel;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    public static List<Hotel> createTestHotels() {
        List<Hotel> hotels = new ArrayList<>();

        Address address = createTestAddress();

        Hotel hotel1 = createTestHotel(1, "Hotel Test 1", address);
        hotels.add(hotel1);

        Hotel hotel2 = createTestHotel(2, "Hotel Test 2", address);
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
        address.setCity("Minsk");
        address.setHouseNumber(9);
        address.setPostCode("220004");
        address.setStreet("Pobediteley Avenue");
        address.setCountry("Belarus");
        return address;
    }

    public static com.booking.openapi.model.Address createAddressDto() {
        com.booking.openapi.model.Address address = new com.booking.openapi.model.Address();
        address.setCity("Minsk");
        address.setHouseNumber(9);
        address.setPostCode("220004");
        address.setStreet("Pobediteley Avenue");
        address.setCountry("Belarus");
        return address;
    }

    public static Hotel createSingleTestHotel() {
        Address address = createTestAddress();
        return createTestHotel(1, "Single Hotel Test", address);
    }

    public static HotelBrief createTestHotelBrief() {
        HotelBrief hotelBrief = new HotelBrief();
        hotelBrief.setId(1);
        hotelBrief.setName("Test Hotel");
        hotelBrief.setDescription("A fine hotel for your stay.");
        hotelBrief.setAddress("9 Pobediteley Avenue, Minsk, 220004, Belarus");
        hotelBrief.setPhone("+375171234567"); // Пример телефона
        return hotelBrief;
    }

    public static NewHotel createTestNewHotel() {
        Contact contact = new Contact();
        contact.setPhone("+375 17 309-80-00");
        contact.setEmail("doubletreeminsk.info@hilton.com");
        ArrivalTime arrivalTime = new ArrivalTime();
        arrivalTime.setCheckIn("14:00");
        arrivalTime.setCheckOut("15:00");
        NewHotel newHotel = new NewHotel();
        newHotel.setName("DoubleTree by Hilton Minsk");
        newHotel.setDescription("The DoubleTree by Hilton Hotel Minsk offers 193 luxurious rooms in the Belorussian capital and stunning views of Minsk city from the hotel's 20th floor ...");
        newHotel.setBrand("Hilton");
        newHotel.setAddress(createAddressDto());
        newHotel.setContacts(contact);
        newHotel.setArrivalTime(arrivalTime);

        return newHotel;
    }
}

