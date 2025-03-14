## Overview

The Flight Booking System is built using a microservices architecture with three main services:

1. **Flight Service** - Manages flight information
2. **Schedule Service** - Handles flight schedules and seat availability
3. **Ticket Service** - Processes ticket bookings and management

## Services

### Flight Service
- **Port**: 5000
- **Functionality**: Creates and manages flight information (routes, departure times)
- **API Endpoints**:
  - `GET /flights` - List all flights (with optional sorting)
  - `POST /flights` - Create a new flight
  - `GET /flights/{id}` - Get flight details
  - `GET /flights/{id}/schedules` - Get schedules for a specific flight
  - `DELETE /flights/{id}` - Delete a flight

### Schedule Service
- **Port**: 5001
- **Functionality**: Manages flight schedules and available seats
- **API Endpoints**:
  - `GET /schedules?flightId={id}&dates={yyyy-MM-dd}` - Get schedules for a flight with optional date filtering
  - `POST /schedules` - Create a new schedule
  - `DELETE /schedules/{id}` - Delete a schedule

### Ticket Service
- **Port**: 5002
- **Functionality**: Handles ticket booking, passenger information, and booking status
- **API Endpoints**:
  - `GET /tickets` - List all tickets
  - `POST /tickets` - Create a new ticket
  - `POST /tickets/{id}` - Get ticket details
  - `DELETE /tickets/{id}` - Delete a ticket

## Technology Stack

- Java 17
- Spring Boot 3.4.2
- Lombok
- Spring Web (RESTful APIs)
- Spring Actuator
- Maven

## Data Models

### Flight
```
- id: String
- flightNumber: String
- departure: String
- destination: String
- departureTime: String
```

### Schedule
```
- id: String
- flightId: String
- date: LocalDateTime
- availableSeats: int
```

### Ticket
```
- id: String
- passengerName: String
- passengerEmail: String
- passengerPhone: String
- flightId: String
- scheduleId: String
- seatNumber: String
- price: double
- status: TicketStatus (BOOKED, CANCELLED)
```

## Running the Application

### Prerequisites
- Java 17
- Maven (or use the included Maven wrapper)

### Starting the Services

1. **Start Flight Service**:
   ```bash
   cd microservice_flights
   ./mvnw spring-boot:run
   ```

2. **Start Schedule Service**:
   ```bash
   cd microservice_schedules
   ./mvnw spring-boot:run
   ```

3. **Start Ticket Service**:
   ```bash
   cd microservice_tickets
   ./mvnw spring-boot:run
   ```