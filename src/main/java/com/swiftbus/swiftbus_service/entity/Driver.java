package com.swiftbus.swiftbus_service.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;


@Entity
@Data
@Setter
@EqualsAndHashCode(callSuper = false)
public class Driver extends Employee {

    private String licenseNumber;
    private int experienceYears;
}
