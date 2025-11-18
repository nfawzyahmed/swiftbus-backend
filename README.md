# SwiftBus Service API

A Spring Boot RESTful API for managing buses, clients, drivers, employees, and rentals for SwiftBus, a bus rental and management system.

---

## Table of Contents
- [Technologies](#technologies)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
    - [Bus Endpoints](#bus-endpoints)
    - [Client Endpoints](#client-endpoints)
    - [Driver Endpoints](#driver-endpoints)
    - [Employee Endpoints](#employee-endpoints)
    - [Rental Endpoints](#rental-endpoints)
- [Entity Relationship Diagram](#entity-relationship-diagram)
- [Usage](#usage)
- [License](#license)

---

## Technologies
- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **RESTful API**
- **Database:** H2 / MySQL / PostgreSQL (optional)

---

## Getting Started

### 1. Clone the repository
git clone <repository-url>  
cd swiftbus_service

### 2. Configure application properties
Open `src/main/resources/application.properties` (or `application.yml`) and set your database configuration:

spring.datasource.url=jdbc:mysql://localhost:3306/swiftbus  
spring.datasource.username=root  
spring.datasource.password=yourpassword  
spring.jpa.hibernate.ddl-auto=update

> You can switch between H2, MySQL, or PostgreSQL by updating the `spring.datasource.url` and dependencies in `pom.xml`.

### 3. Build and Run the Application
Using Maven:

mvn clean install  
mvn spring-boot:run

Or using your IDE (IntelliJ, Eclipse, VS Code): run `SwiftbusServiceApplication.java`.

The API will be available at `http://localhost:8080/api`.

### 4. Optional: Seed the Database
- You can add initial data using `data.sql` or `import.sql` in `src/main/resources`.
- Example: adding a few buses, clients, and drivers for testing.

### 5. Verify
Open your browser or use a tool like Postman or curl:

curl -X GET http://localhost:8080/api/buses

---

## API Endpoints

### Bus Endpoints
| Method | URL | Description |
|--------|-----|-------------|
| GET | `/api/buses` | Get all buses |
| GET | `/api/buses/{id}` | Get bus by ID |
| POST | `/api/buses` | Create a new bus |
| PUT | `/api/buses/{id}` | Update a bus |
| DELETE | `/api/buses/{id}` | Delete a bus |

### Client Endpoints
| Method | URL | Description |
|--------|-----|-------------|
| GET | `/api/clients` | Get all clients |
| GET | `/api/clients/{id}` | Get client by ID |
| POST | `/api/clients` | Create a new client |
| PUT | `/api/clients/{id}` | Update a client |
| DELETE | `/api/clients/{id}` | Delete a client |
| POST | `/api/clients/login` | Client login (returns auth token/session info) |

### Driver Endpoints
| Method | URL | Description |
|--------|-----|-------------|
| GET | `/api/drivers` | Get all drivers |
| GET | `/api/drivers/{id}` | Get driver by ID |
| POST | `/api/drivers` | Create a new driver |
| PUT | `/api/drivers/{id}` | Update a driver |
| DELETE | `/api/drivers/{id}` | Delete a driver |

### Employee Endpoints
| Method | URL | Description |
|--------|-----|-------------|
| GET | `/api/employees` | Get all employees |
| GET | `/api/employees/{id}` | Get employee by ID |
| POST | `/api/employees` | Create a new employee |
| PUT | `/api/employees/{id}` | Update an employee |
| DELETE | `/api/employees/{id}` | Delete an employee |

### Rental Endpoints
| Method | URL | Description |
|--------|-----|-------------|
| GET | `/api/rentals` | Get all rentals |
| GET | `/api/rentals/{id}` | Get rental by ID |
| POST | `/api/rentals` | Create a new rental |
| PUT | `/api/rentals/{id}` | Update a rental |
| DELETE | `/api/rentals/{id}` | Delete a rental |
| GET | `/api/rentals/client/{clientId}` | Get rentals by client ID |
| PUT | `/api/rentals/{id}/approve` | Approve a rental |

---

## Entity Relationship Diagram

+---------+       1     *       +---------+       *     1       +---------+  
|  Client |---------------------|  Rental |---------------------|   Bus   |  
+---------+                     +---------+                     +---------+  
| id      |                     | id      |                     | id      |  
| name    |                     | date    |                     | number  |  
| email   |                     | status  |                     | seats   |  
| ...     |                     | client  |                     | ...     |  
+---------+                     | bus     |                     +---------+  
+---------+

**Explanation:**
- A **Client** can have **multiple Rentals**.
- A **Rental** is associated with **one Bus**.
- A **Bus** can be associated with **multiple Rentals**.

---

## Usage Examples

**Get all buses**
curl -X GET http://localhost:8080/api/buses

**Create a new client**
curl -X POST http://localhost:8080/api/clients -H "Content-Type: application/json" -d '{ "username": "john_doe", "password": "securepassword", "email": "john@example.com" }'

**Approve a rental**
curl -X PUT http://localhost:8080/api/rentals/1/approve

---

## License
This project is licensed under the MIT License.
