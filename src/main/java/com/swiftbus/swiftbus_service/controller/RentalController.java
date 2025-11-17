package com.swiftbus.swiftbus_service.controller;

import com.swiftbus.swiftbus_service.dto.RentalDTO;
import com.swiftbus.swiftbus_service.entity.Rental;
import com.swiftbus.swiftbus_service.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @GetMapping
    public List<RentalDTO> getAll() {
        return rentalService.getAllRentals();
    }

    @GetMapping("/{id}")
    public RentalDTO getById(@PathVariable Long id) {
        return rentalService.getRentalById(id);
    }

    @PostMapping
    public RentalDTO create(@RequestBody Rental rental) {
        return rentalService.createRental(rental);
    }

    @PutMapping("/{id}")
    public RentalDTO update(@PathVariable Long id, @RequestBody Rental rental) {
        return rentalService.updateRental(id, rental);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        rentalService.deleteRental(id);
    }


    @GetMapping("/client/{clientId}")
    public List<RentalDTO> getRentalsByClient(@PathVariable Long clientId) {
        return rentalService.getRentalsByClientId(clientId);
    }
    @PutMapping("/{id}/approve")
    public void approveRental(@PathVariable Long id) {
        rentalService.approveRental(id);
    }

}
