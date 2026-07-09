# Enterprise E-Commerce Microservices

A production-ready **Enterprise E-Commerce Platform** built using **Java 21**, **Spring Boot**, **Spring Cloud**, **Apache Kafka**, **Docker**, **PostgreSQL**, and **Redis** following a **Microservices Architecture** and **Event-Driven Design**.

---

## Project Overview

This project demonstrates how modern enterprise applications are designed using independently deployable microservices that communicate through REST APIs and asynchronous messaging with Kafka.

The application simulates a real-world e-commerce platform where users can browse products, place orders, make payments, manage inventory, and receive notifications.

---

## Technology Stack

### Backend

* Java 21
* Spring Boot 3
* Spring Cloud
* Spring Security
* Spring Data JPA
* Hibernate
* Maven

### Database

* PostgreSQL

### Messaging

* Apache Kafka

### Caching

* Redis

### API Documentation

* OpenAPI (Swagger)

### Infrastructure

* Eureka Service Registry
* Spring Cloud Config Server
* Spring Cloud Gateway
* Docker
* Docker Compose

### Monitoring

* Spring Boot Actuator
* Prometheus
* Grafana

### Testing

* JUnit 5
* Mockito

---

# Project Architecture

```text
                           Client
                              |
                        API Gateway
                              |
 ------------------------------------------------------------------
 |          |           |          |           |                   |
Auth      User      Product      Order      Payment        Notification
Service   Service    Service     Service     Service          Service
                                      |
                                   Kafka
                                      |
                  ------------------------------------------
                  |                  |                     |
            Inventory Service   Email Service     Analytics Service
```

---

# Microservices

| Service              | Responsibility                             |
| -------------------- | ------------------------------------------ |
| Service Registry     | Eureka Server for service discovery        |
| Config Server        | Centralized configuration management       |
| API Gateway          | Single entry point for all client requests |
| Auth Service         | Authentication and JWT authorization       |
| User Service         | User profile and account management        |
| Product Service      | Product catalog management                 |
| Order Service        | Order creation and Kafka producer          |
| Payment Service      | Payment processing and Kafka consumer      |
| Inventory Service    | Stock management                           |
| Notification Service | Notification processing                    |
| Email Service        | Email delivery                             |
| Analytics Service    | Business analytics and reporting           |

---

# Event-Driven Flow

```text
Client
   |
API Gateway
   |
Order Service
   |
OrderCreatedEvent
   |
Kafka
   |
Payment Service
   |
PaymentSuccessEvent
   |
Kafka
   |
Inventory Service
   |
InventoryUpdatedEvent
   |
Kafka
   |
Notification Service
   |
Email Service

Analytics Service consumes all events.
```

---

# Repository Structure

```text
enterprise-ecommerce-microservices
│
├── service-registry
├── config-server
├── api-gateway
├── common-library
│
├── auth-service
├── user-service
├── product-service
├── order-service
├── payment-service
├── inventory-service
├── notification-service
├── email-service
├── analytics-service
│
├── docker
├── docs
├── postman
│
├── README.md
└── pom.xml
```

---

# Features

* Microservices Architecture
* Event-Driven Communication
* Apache Kafka Integration
* JWT Authentication
* Role-Based Authorization
* API Gateway
* Centralized Configuration
* Service Discovery
* Dockerized Services
* Redis Caching
* OpenAPI Documentation
* Global Exception Handling
* DTO Pattern
* Mapper Pattern
* Validation
* Clean Architecture
* SOLID Principles
* Resilience4j
* Monitoring and Metrics

---

# Development Roadmap

## Phase 1

* Service Registry
* Config Server
* API Gateway
* Common Library

## Phase 2

* Auth Service
* User Service
* Product Service

## Phase 3

* Order Service
* Payment Service
* Inventory Service

## Phase 4

* Notification Service
* Email Service
* Analytics Service

---

# Future Enhancements

* Kubernetes Deployment
* GitHub Actions CI/CD
* Distributed Tracing
* ELK Stack Integration
* Rate Limiting
* API Versioning
* Multi-Tenant Support

---

# Author

**Sandip Pote**

Senior Java Backend Developer

Java • Spring Boot • Spring Cloud • Kafka • Microservices • Docker • PostgreSQL
