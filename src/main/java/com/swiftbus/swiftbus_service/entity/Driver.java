package com.swiftbus.swiftbus_service.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Driver extends Employee {

    private String licenseNumber;
    private int experienceYears;
}
