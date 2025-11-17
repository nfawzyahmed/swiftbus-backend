package com.swiftbus.swiftbus_service.repository;

import com.swiftbus.swiftbus_service.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
}

