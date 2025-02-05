package com.booking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "arrival_times")
public class ArrivalTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(nullable = false)
    private LocalTime checkIn;

    @Column(nullable = false)
    private LocalTime checkOut;
}
