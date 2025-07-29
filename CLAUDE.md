# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

### Build and Run
- **Build:** `./mvnw clean compile`
- **Run:** `./mvnw spring-boot:run`
- **Package (JAR):** `./mvnw clean package`
- **Run JAR:** `java -jar target/cardatabase-0.0.1-SNAPSHOT.jar`

### Testing
- **Run all tests:** `./mvnw test`
- **Run specific test class:** `./mvnw test -Dtest=CardatabaseApplicationTests`
- **Skip tests during build:** `./mvnw clean package -DskipTests`

### Database
- **H2 Console (if enabled):** http://localhost:8080/h2-console
- **MariaDB connection:** Currently configured to connect to localhost:3306/cardb

## Architecture

### Core Components

1. **Domain Layer** (`com.kobby.cardatabase.domain`)
   - JPA entities: `Car`, `Owner`, `User`
   - Spring Data repositories extending `CrudRepository`
   - Many-to-one relationship between Car and Owner

2. **Security Layer**
   - JWT-based authentication (JwtService)
   - BCrypt password encoding
   - Role-based access control (USER, ADMIN)
   - Stateless session management
   - UserDetailsService implementation for database user authentication

3. **Web Layer** (`com.kobby.cardatabase.web`)
   - RESTful endpoints
   - Spring Data REST auto-generated endpoints at `/api`
   - Custom controller at `/cars`

4. **Service Layer** (`com.kobby.cardatabase.service`)
   - JWT token generation and validation
   - Custom UserDetailsService for authentication

### Key Dependencies
- Spring Boot 3.5.0
- Spring Security with JWT (jjwt 0.11.2)
- Spring Data JPA with MariaDB/H2
- Spring Data REST
- BCrypt for password encoding

### API Endpoints
- **Base path for auto-generated REST endpoints:** `/api`
- **Custom endpoints:** `/cars` (GET)
- **Authentication required for all endpoints except** `/login/**`
- **DELETE operations require ADMIN role**

### Database Configuration
- Development: MariaDB on localhost:3306
- Test: H2 in-memory database (commented out in application.properties)
- Auto DDL: create-drop (rebuilds schema on startup)