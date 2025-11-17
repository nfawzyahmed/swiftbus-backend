package com.swiftbus.swiftbus_service.service.impl;

import com.swiftbus.swiftbus_service.entity.Driver;
import com.swiftbus.swiftbus_service.repository.DriverRepository;
import com.swiftbus.swiftbus_service.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository repo;

    @Override
    public List<Driver> getAllDrivers() {
        return repo.findAll();
    }

    @Override
    public Driver getDriverById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Driver createDriver(Driver driver) {
        return repo.save(driver);
    }

    @Override
    public Driver updateDriver(Long id, Driver updated) {
        Driver existing = repo.findById(id).orElseThrow();
        existing.setUsername(updated.getUsername());
        existing.setEmail(updated.getEmail());
        existing.setPhone(updated.getPhone());
        existing.setName(updated.getName());
        existing.setLicenseNumber(updated.getLicenseNumber());
        existing.setExperienceYears(updated.getExperienceYears());
        return repo.save(existing);
    }

    @Override
    public void deleteDriver(Long id) {
        repo.deleteById(id);
    }
}

