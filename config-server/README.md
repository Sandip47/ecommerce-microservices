# Config Server

Centralized Configuration Server for the Enterprise E-Commerce Microservices project.

---

## Responsibilities

- Centralized configuration management
- Externalized configuration
- Service configuration
- Integration with Eureka Service Registry

---

## Technology Stack

- Java 21
- Spring Boot 3.2.6
- Spring Cloud Config Server
- Eureka Client
- Maven
- Docker

---

## Port

8888

---

## Run

```bash
mvn clean install
```

```bash
mvn spring-boot:run
```

---

## URL

```
http://localhost:8888
```

---

## Config Endpoint Example

```
http://localhost:8888/product-service/default
```

---

## Folder Structure

```
config-server
│
├── Dockerfile
├── pom.xml
├── README.md
└── src
```