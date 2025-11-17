package com.swiftbus.swiftbus_service.dto;

import lombok.Data;

@Data
public class BusDTO {
    private Long id;
    private String plateNumber;
    private String model;
    private int capacity;
    private String status;
    private String driverName;
    private String driverPhone;
    private String licenseNumber;
}
