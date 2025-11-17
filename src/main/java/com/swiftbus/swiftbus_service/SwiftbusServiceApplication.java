package com.swiftbus.swiftbus_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SwiftbusServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwiftbusServiceApplication.class, args);
	}

}
