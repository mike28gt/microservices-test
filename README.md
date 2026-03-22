# Microservices Test

This project implements a microservices-based backend using Spring Boot and PostgreSQL. The system is designed following best practices for separation of concerns, scalability, and maintainability.

---

## Architecture

The solution is composed of two independent microservices:

- **customers-service**: Manages customers and personal information
- **accounts-service** : Manages accounts and transactions

Each microservice has its own dedicated PostgreSQL database.

---

## Technologies

- Java 21
- Spring Boot 3.5.12
- Spring Data JPA
- PostgreSQL
- Docker & Docker Compose
- Maven

---

## Project Structure

```
microservices-test/
  customers-service/
  accounts-service/
  docker-compose.yml
  .env.example
  README.md
```

## Requirements

- Java 21
- Docker & Docker Compose installed

---

## Setup Instructions

### 1. Clone the repository

```bash
git clone https://github.com/mike28gt/microservices-test.git
cd microservices-test
```
### 2. Configure environment variables

Create a .env file based on the example:

```bash
cp .env.example .env
```

### 3. Start PostgreSQL databases
```bash
docker compose up -d
```

This will start:
- customers database → port 5433
- accounts database → port 5434

### 4. Run microservices

#### customers-service

```bash
cd customers-service
./mvnw spring-boot:run
```

#### accounts-service
```bash
cd ../accounts-service
./mvnw spring-boot:run
```

---

## Ports

| Service            | Port |
|-------------------|------|
| customers-service | 8081 |
| accounts-service  | 8082 |
| customers-db      | 5433 |
| accounts-db       | 5434 |

---

## Notes

- Each microservice has its own database, following microservices architecture principles.
- Configuration is managed via Docker and environment variables.
- The system is designed to be easily extensible and deployable.