package com.booking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a physical address associated with a hotel.
 */
@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @SequenceGenerator(name = "address_seq", sequenceName = "address_sequence", allocationSize = 1)
    private Integer id;

    /**
     * The house number of the address.
     * This field is required and cannot be null.
     */
    @Column(nullable = false)
    private int houseNumber;

    /**
     * The name of the street for the address.
     * This field is required and cannot be null.
     */
    @Column(nullable = false)
    private String street;

    /**
     * The city where the address is located.
     * This field is required and cannot be null.
     */
    @Column(nullable = false)
    private String city;

    /**
     * The country where the address is located.
     * This field is required and cannot be null.
     */
    @Column(nullable = false)
    private String country;

    /**
     * The postal code for the address.
     * This field is required and cannot be null.
     */
    @Column(nullable = false)
    private String postCode;
}