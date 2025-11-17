package com.swiftbus.swiftbus_service.service.impl;

import com.swiftbus.swiftbus_service.entity.Employee;
import com.swiftbus.swiftbus_service.repository.EmployeeRepository;
import com.swiftbus.swiftbus_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    @Override
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee updated) {
        Employee existing = repo.findById(id).orElseThrow();
        existing.setUsername(updated.getUsername());
        existing.setEmail(updated.getEmail());
        existing.setPhone(updated.getPhone());
        existing.setName(updated.getName());
        existing.setRole(updated.getRole());
        return repo.save(existing);
    }

    @Override
    public void deleteEmployee(Long id) {
        repo.deleteById(id);
    }
}

