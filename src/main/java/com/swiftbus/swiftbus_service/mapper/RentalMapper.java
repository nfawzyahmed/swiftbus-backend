package com.swiftbus.swiftbus_service.mapper;

import com.swiftbus.swiftbus_service.dto.BusDTO;
import com.swiftbus.swiftbus_service.dto.ClientDTO;
import com.swiftbus.swiftbus_service.dto.RentalDTO;
import com.swiftbus.swiftbus_service.entity.Bus;
import com.swiftbus.swiftbus_service.entity.Client;
import com.swiftbus.swiftbus_service.entity.Rental;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RentalMapper {

    // ---------- RENTAL → RENTALDTO ----------
    @Mapping(target = "busId", source = "bus.id")
    @Mapping(target = "bus", source = "bus")  // full nested bus mapping
    RentalDTO rentalToDTO(Rental rental);

    // ---------- RENTALDTO → RENTAL ----------
    @Mapping(target = "bus", ignore = true)    // we load bus in service, not mapper
    @Mapping(target = "client", ignore = true) // same for client
    Rental rentalToEntity(RentalDTO dto);

    // ---------- BUS → BUSDTO ----------
    @Mapping(target = "driverName", source = "driver.name")
    @Mapping(target = "driverPhone", source = "driver.phone")
    @Mapping(target = "licenseNumber", source = "driver.licenseNumber")
    BusDTO busToDTO(Bus bus);

    Bus busToEntity(BusDTO dto);

    // ---------- CLIENT → CLIENTDTO ----------
    ClientDTO clientToDTO(Client client);
    Client clientToEntity(ClientDTO dto);
}
