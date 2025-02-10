package com.booking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "arrival_times")
public class ArrivalTime {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "arrival_seq")
    @SequenceGenerator(name = "arrival_seq", sequenceName = "arrival_sequence", allocationSize = 1)
    private Integer id;

    @Column(nullable = false)
    private LocalTime checkIn;

    @Column(nullable = false)
    private LocalTime checkOut;
}
