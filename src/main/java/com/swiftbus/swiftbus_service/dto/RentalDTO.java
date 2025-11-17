package com.swiftbus.swiftbus_service.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class RentalDTO {
    private Long id;
    private Long busId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double price;
    private String status;

    private BusDTO bus;   // Optional: include full bus info
}
