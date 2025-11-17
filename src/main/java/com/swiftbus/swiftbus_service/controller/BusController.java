package com.swiftbus.swiftbus_service.controller;

import com.swiftbus.swiftbus_service.entity.Bus;
import com.swiftbus.swiftbus_service.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class BusController {

    @Autowired
    private BusService service;

    @GetMapping
    public List<Bus> getAll() {
        return service.getAllBuses();
    }

    @GetMapping("/{id}")
    public Bus getById(@PathVariable Long id) {
        return service.getBusById(id);
    }

    @PostMapping
    public Bus create(@RequestBody Bus bus) {
        return service.createBus(bus);
    }

    @PutMapping("/{id}")
    public Bus update(@PathVariable Long id, @RequestBody Bus bus) {
        return service.updateBus(id, bus);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteBus(id);
    }
}

