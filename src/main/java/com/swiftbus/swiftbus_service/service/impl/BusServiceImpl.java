package com.swiftbus.swiftbus_service.service.impl;

import com.swiftbus.swiftbus_service.entity.Bus;
import com.swiftbus.swiftbus_service.repository.BusRepository;
import com.swiftbus.swiftbus_service.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository repo;

    @Override
    public List<Bus> getAllBuses() {
        return repo.findAll();
    }

    @Override
    public Bus getBusById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Bus createBus(Bus bus) {
        return repo.save(bus);
    }

    @Override
    public Bus updateBus(Long id, Bus updated) {
        Bus existing = repo.findById(id).orElseThrow();

        existing.setPlateNumber(updated.getPlateNumber());
        existing.setModel(updated.getModel());
        existing.setCapacity(updated.getCapacity());
        existing.setStatus(updated.getStatus());
        existing.setDriver(updated.getDriver());

        return repo.save(existing);
    }

    @Override
    public void deleteBus(Long id) {
        repo.deleteById(id);
    }
}
