package com.booking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Represents a hotel entity with its details, including address, contact information,
 * arrival time, and available amenities.
 */
@Getter
@Setter
@Entity
@Table(name = "hotels")
public class Hotel {

    /**
     * Unique identifier for the hotel.
     * This field is automatically generated using a sequence.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_seq")
    @SequenceGenerator(name = "hotel_seq", sequenceName = "hotel_sequence", allocationSize = 1)
    private Integer id;

    /**
     * The name of the hotel.
     * This field is required and cannot be null.
     */
    @Column(nullable = false)
    private String name;

    /**
     * A brief description of the hotel.
     * This field can contain up to 1000 characters.
     */
    @Column(length = 1000)
    private String description;

    /**
     * The brand associated with the hotel.
     * This field can be null.
     */
    private String brand;

    /**
     * The address of the hotel.
     * This field is required and cannot be null.
     */
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    /**
     * The contact information for the hotel.
     * This field is required and cannot be null.
     */
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "contact_id", nullable = false)
    private Contact contact;

    /**
     * The arrival time details for the hotel.
     * This field is required and cannot be null.
     */
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "arrival_time_id", nullable = false)
    private ArrivalTime arrivalTime;

    /**
     * A list of amenities available at the hotel.
     * This field can contain multiple amenities and is managed through a join table.
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hotel_amenities",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "amenity_id"))
    private List<Amenity> amenities;
}
