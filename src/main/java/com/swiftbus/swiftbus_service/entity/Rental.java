package com.swiftbus.swiftbus_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Data
@Setter
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

    private LocalDate startDate;
    private LocalDate endDate;
    private Double price;
    private String status;
}

