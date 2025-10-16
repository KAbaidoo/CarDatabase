# Project Overview

This is a Spring Boot application that provides a REST API for managing a car database. The application uses Spring Web, Spring Data JPA, and Spring Security to provide a secure and robust API. The database is populated with some initial data on startup.

## Main Technologies

*   **Backend:** Java, Spring Boot
*   **Database:** MariaDB (production), H2 (test)
*   **Authentication:** JSON Web Tokens (JWT)
*   **Build Tool:** Maven

## Architecture

The application follows a standard Spring Boot architecture. It has a controller layer for handling web requests, a service layer for business logic, and a repository layer for data access. The application is secured using Spring Security, and authentication is handled using JWTs.

# Building and Running

## Prerequisites

*   Java 17
*   Maven

## Running the Application

To run the application, you can use the following Maven command:

```bash
./mvnw spring-boot:run
```

The application will be available at `http://localhost:8080`.

## Testing the Application

To run the tests, you can use the following Maven command:

```bash
./mvnw test
```

# Development Conventions

## API Endpoints

The following API endpoints are available:

*   `POST /login`: Authenticate a user and get a JWT.
*   `GET /cars`: Get all cars.
*   `DELETE /cars/{id}`: Delete a car by its ID (requires `ADMIN` role).

## Authentication

To access the protected endpoints, you need to include a JWT in the `Authorization` header of your request. The token should be prefixed with `Bearer `.

For example:

```
Authorization: Bearer <your-jwt>
```

## Users

The application is pre-populated with the following users:

*   **user:** `user` / `userPass`
*   **admin:** `admin` / `adminPass`
