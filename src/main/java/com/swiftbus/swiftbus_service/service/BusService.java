package com.swiftbus.swiftbus_service.service;

import com.swiftbus.swiftbus_service.entity.Bus;

import java.util.List;

public interface BusService {
    List<Bus> getAllBuses();
    Bus getBusById(Long id);
    Bus createBus(Bus bus);
    Bus updateBus(Long id, Bus bus);
    void deleteBus(Long id);
}
