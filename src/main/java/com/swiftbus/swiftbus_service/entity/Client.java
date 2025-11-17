package com.swiftbus.swiftbus_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;


import java.util.List;

@Entity
@Data
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "client")
    private List<Rental> rentals;
}
