package com.booking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

/**
 * Represents the arrival times for bookings in the system.
 * This class is mapped to the "arrival_times" table in the database.
 */
@Getter
@Setter
@Entity
@Table(name = "arrival_times")
public class ArrivalTime {

    /**
     * The unique identifier for the arrival time entry.
     * This field is automatically generated using a sequence.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "arrival_seq")
    @SequenceGenerator(name = "arrival_seq", sequenceName = "arrival_sequence", allocationSize = 1)
    private Integer id;

    /**
     * The check-in time for the booking.
     * This field cannot be null.
     */
    @Column(nullable = false)
    private LocalTime checkIn;

    /**
     * The check-out time for the booking.
     * This field can be null, indicating that check-out time is not specified.
     */
    @Column(nullable = true)
    private LocalTime checkOut;
}
