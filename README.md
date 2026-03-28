# Wallet System API

## Project Overview
A RESTful API built for managing a wallet system. It allows users to create wallets, fund them, debit them, and view wallet details with high performance and thread safety.

## Technology Stack
*   **Java 17**
*   **Spring Boot 3.5.12**
*   **SpringDoc OpenAPI** (Swagger)
*   **Lombok** (Boilerplate reduction)

## Steps to Build and Run
1.  **Clone the repo:** `git clone <repo-url>`
2.  **Build the project:** `./mvnw clean install`
3.  **Run the application:** `./mvnw spring-boot:run`
4.  The server will start on `http://localhost:8080`.

## How to Access Swagger UI
Visit [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) to view the interactive API documentation and test the endpoints directly.

## Endpoints

* **POST /wallets → Create wallet**

* **POST /wallets/{id}/fund → Fund wallet**

* **POST /wallets/{id}/debit → Debit wallet**

* **GET /wallets/{id} → Get wallet**

## Assumptions & Design Decisions
*   **In-Memory Storage:** For this assessment, a `ConcurrentHashMap` is used as a data store. In production, this would be replaced with a persistent database like PostgreSQL.
*   **Concurrency:** Used `computeIfPresent` on the map to ensure atomic balance updates, preventing race conditions during simultaneous transactions.
*   **Authentication & Authorization:** For the scope of this assessment, no authentication is implemented.
*   **Balance is stored using BigDecimal for accuracy**
*   **Global Exception Handling:** Implemented a `@RestControllerAdvice` to ensure all errors return a consistent `ErrorResponseDto` format.
*   **Fail-Fast Validation:** Input validation (e.g., amount > 0) is performed before any business logic to save resources.