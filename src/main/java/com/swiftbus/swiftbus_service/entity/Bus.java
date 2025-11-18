package com.swiftbus.swiftbus_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;


@Entity
@Data
@Getter
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plateNumber;
    private String model;
    private int capacity;
    private String status;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;  // current driver assigned
}
