package com.swiftbus.swiftbus_service.controller;

import com.swiftbus.swiftbus_service.entity.Driver;
import com.swiftbus.swiftbus_service.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    @Autowired
    private DriverService service;

    @GetMapping
    public List<Driver> getAll() {
        return service.getAllDrivers();
    }

    @GetMapping("/{id}")
    public Driver getById(@PathVariable Long id) {
        return service.getDriverById(id);
    }

    @PostMapping
    public Driver create(@RequestBody Driver driver) {
        return service.createDriver(driver);
    }

    @PutMapping("/{id}")
    public Driver update(@PathVariable Long id, @RequestBody Driver driver) {
        return service.updateDriver(id, driver);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteDriver(id);
    }
}
