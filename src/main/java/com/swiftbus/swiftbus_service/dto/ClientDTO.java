package com.swiftbus.swiftbus_service.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClientDTO {
    private Long id;
    private String username;
    private String email;
    private String phone;
    private String name;
    private List<RentalDTO> rentalDTOList;
}
