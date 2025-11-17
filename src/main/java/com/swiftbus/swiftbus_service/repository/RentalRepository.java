package com.swiftbus.swiftbus_service.repository;

import com.swiftbus.swiftbus_service.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

    // Get all rentals for a specific client username
    List<Rental> findByClient_IdAndStatus(Long clientId, String status);

    // Get all available rentals (status = "AVAILABLE")
    List<Rental> findByStatus(String status);


}
