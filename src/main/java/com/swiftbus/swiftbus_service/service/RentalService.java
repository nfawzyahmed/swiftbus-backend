package com.swiftbus.swiftbus_service.service;

import com.swiftbus.swiftbus_service.dto.RentalDTO;
import com.swiftbus.swiftbus_service.entity.Rental;

import java.util.List;

public interface RentalService {
    List<RentalDTO>getAllRentals();
    RentalDTO getRentalById(Long id);
    RentalDTO createRental(Rental rental);
    RentalDTO updateRental(Long id, Rental rental);
    void deleteRental(Long id);
    void approveRental(Long rentalId);

    List<RentalDTO> getRentalsByClientId(Long clientId);


}
