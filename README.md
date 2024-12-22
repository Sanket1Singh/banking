# Banking Application

A Spring Boot-based RESTful API for managing bank accounts. This application allows users to perform various operations like creating accounts, retrieving account details, depositing, withdrawing, and deleting accounts.

---

## Features
- **Create Account**: Add a new bank account.
- **View Account Details**: Retrieve account details by ID.
- **Deposit Funds**: Deposit a specified amount into an account.
- **Withdraw Funds**: Withdraw a specified amount from an account.
- **List All Accounts**: Retrieve details of all accounts.
- **Delete Account**: Remove an account by ID.

---

## Project Structure

### Packages
- **Controller**: Handles incoming HTTP requests (`com.sanket.banking.controller`).
- **Service**: Business logic layer (`com.sanket.banking.service`).
- **Repository**: JPA repository for database operations (`com.sanket.banking.repository`).
- **Entity**: Represents database tables (`com.sanket.banking.entity`).
- **DTO**: Data Transfer Object for transferring data between layers (`com.sanket.banking.dto`).
- **Mapper**: Maps entities to DTOs and vice versa (`com.sanket.banking.mapper`).

---

## Prerequisites

- Java 17+
- Maven
- MySQL or any compatible database
- IDE (e.g., IntelliJ, Eclipse)
