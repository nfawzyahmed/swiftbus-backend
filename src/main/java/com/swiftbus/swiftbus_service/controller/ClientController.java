package com.swiftbus.swiftbus_service.controller;

import com.swiftbus.swiftbus_service.entity.Client;
import com.swiftbus.swiftbus_service.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public List<Client> getAll() {
        return service.getAllClients();
    }

    @GetMapping("/{id}")
    public Client getById(@PathVariable Long id) {
        return service.getClientById(id);
    }

    @PostMapping
    public Client create(@RequestBody Client client) {
        return service.createClient(client);
    }

    @PutMapping("/{id}")
    public Client update(@PathVariable Long id, @RequestBody Client client) {
        return service.updateClient(id, client);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteClient(id);
    }
}
