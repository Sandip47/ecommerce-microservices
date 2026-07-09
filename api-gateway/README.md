# API Gateway

Enterprise API Gateway for the Enterprise Ecommerce Microservices Project.

---

## Responsibilities

- Centralized Routing
- JWT Authentication
- Authorization
- Request Logging
- Global Exception Handling
- Correlation ID
- API Filtering
- Rate Limiting
- Load Balancing
- Service Discovery

---

## Technology

- Java 21
- Spring Boot 3.2.6
- Spring Cloud Gateway
- Spring Security
- Eureka Client
- Config Client
- JWT
- Docker

---

## Port

8080

---

## Routes

| Service | Endpoint |
|----------|----------|
| Auth | /api/auth/** |
| User | /api/users/** |
| Product | /api/products/** |
| Order | /api/orders/** |
| Payment | /api/payments/** |
| Inventory | /api/inventory/** |
| Notification | /api/notifications/** |
| Analytics | /api/analytics/** |

---

## Run

```bash
mvn clean install
```

```bash
mvn spring-boot:run
```

---

## Health

```
http://localhost:8080/actuator/health
```

---

## Architecture

```
                 Client
                    │
             API Gateway
                    │
 --------------------------------------------------
 │       │        │        │        │            │
Auth   User    Product   Order   Payment   Notification
```