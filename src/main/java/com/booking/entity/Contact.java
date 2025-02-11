package com.booking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents the contact information associated with a hotel.
 */
@Getter
@Setter
@Entity
@Table(name = "contacts")
public class Contact {

    /**
     * Unique identifier for the contact.
     * This field is automatically generated using a sequence.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_seq")
    @SequenceGenerator(name = "contact_seq", sequenceName = "contact_sequence", allocationSize = 1)
    private Integer id;

    /**
     * The phone number for contacting the hotel.
     * This field is required and cannot be null.
     */
    @Column(nullable = false)
    private String phone;

    /**
     * The email address for contacting the hotel.
     * This field is required and cannot be null.
     */
    @Column(nullable = false)
    private String email;
}
