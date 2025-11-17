package com.swiftbus.swiftbus_service.repository;

import com.swiftbus.swiftbus_service.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
}
