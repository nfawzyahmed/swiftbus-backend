package com.swiftbus.swiftbus_service.service.impl;

import com.swiftbus.swiftbus_service.entity.Client;
import com.swiftbus.swiftbus_service.repository.ClientRepository;
import com.swiftbus.swiftbus_service.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repo;

    @Override
    public List<Client> getAllClients() {
        return repo.findAll();
    }

    @Override
    public Client getClientById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Client createClient(Client client) {
        return repo.save(client);
    }

    @Override
    public Client updateClient(Long id, Client updated) {
        Client existing = repo.findById(id).orElseThrow();
        existing.setUsername(updated.getUsername());
        existing.setEmail(updated.getEmail());
        existing.setPhone(updated.getPhone());
        return repo.save(existing);
    }

    @Override
    public void deleteClient(Long id) {
        repo.deleteById(id);
    }
}
