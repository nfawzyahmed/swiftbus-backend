package com.swiftbus.swiftbus_service.service.impl;

import com.swiftbus.swiftbus_service.dto.RentalDTO;
import com.swiftbus.swiftbus_service.entity.Rental;
import com.swiftbus.swiftbus_service.repository.RentalRepository;
import com.swiftbus.swiftbus_service.service.RentalService;
import com.swiftbus.swiftbus_service.mapper.RentalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalServiceImpl implements RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private RentalMapper rentalMapper;

    @Override
    public List<RentalDTO> getRentalsByClientId(Long clientId) {
        List<Rental> rentals = rentalRepository.findByClient_IdAndStatus(clientId, "APPROVED");
        return rentals.stream()
                .map(rentalMapper::rentalToDTO)
                .collect(Collectors.toList());
    }

    // Other CRUD operations using the mapper
    @Override
    public List<RentalDTO> getAllRentals() {
        return rentalRepository.findAll()
                .stream()
                .map(rentalMapper::rentalToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RentalDTO getRentalById(Long id) {
        return rentalRepository.findById(id)
                .map(rentalMapper::rentalToDTO)
                .orElse(null);
    }

    @Override
    public RentalDTO createRental(Rental rental) {
        Rental saved = rentalRepository.save(rental);
        return rentalMapper.rentalToDTO(saved);
    }

    @Override
    public RentalDTO updateRental(Long id, Rental rental) {
        rental.setId(id);
        Rental updated = rentalRepository.save(rental);
        return rentalMapper.rentalToDTO(updated);
    }

    @Override
    public void deleteRental(Long id) {
        rentalRepository.deleteById(id);
    }
    @Override
    public void approveRental(Long rentalId) {
        Rental rental = rentalRepository.findById(rentalId)
                .orElseThrow(() -> new RuntimeException("Rental not found"));

        rental.setStatus("APPROVED");
        rentalRepository.save(rental);
    }

}
