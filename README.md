# Cursos API

REST API for course management built with Java 21, Spring Boot and PostgreSQL.

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue.svg)](https://www.postgresql.org/)
[![Docker](https://img.shields.io/badge/Docker-enabled-2496ED.svg)](https://www.docker.com/)

---

# Table of Contents

1. [About the Project](#about-the-project)
2. [Technologies](#technologies)
3. [Features](#features)
4. [Project Structure](#project-structure)
5. [Running the Project](#running-the-project)
6. [API Endpoints](#api-endpoints)
7. [Author](#author)

---

# About the Project

This project is a RESTful API developed as a backend challenge for course management.

The API allows creating, listing, updating, deleting and activating/deactivating courses.

The project was built following REST architecture principles and using layered architecture with Controller, Service and Repository layers.

---

# Technologies

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven
- PostgreSQL
- Docker
- Lombok

---

# Features

- Create a course
- List all courses
- Filter courses by name and category
- Update course information
- Delete a course
- Toggle course active status
- Automatic timestamps
- Request validation

---

# Project Structure

```plaintext
src/main/java/br/com/felipeluizon/cursosapi
│
├── controller
├── dto
├── entity
├── exception
├── repository
└── service
```

---

# Running the Project

## Prerequisites

- Java 21
- Docker
- Maven

---

## Clone repository

```bash
git clone https://github.com/FelipeLuizonDev/cursos-api.git
```

---

## Start PostgreSQL container

```bash
docker compose up -d
```

---

## Run application

Windows:

```bash
mvnw.cmd spring-boot:run
```

Linux/macOS:

```bash
./mvnw spring-boot:run
```

---

# API Endpoints

## Create course

```http
POST /cursos
```

Body:

```json
{
  "name": "Java Spring",
  "category": "Backend"
}
```

---

## List courses

```http
GET /cursos
```

---

## Filter courses

```http
GET /cursos?name=java
```

```http
GET /cursos?category=backend
```

---

## Update course

```http
PUT /cursos/{id}
```

---

## Delete course

```http
DELETE /cursos/{id}
```

---

## Toggle active status

```http
PATCH /cursos/{id}/active
```

---

# Author

**Felipe Luizon**

- GitHub: https://github.com/FelipeLuizonDev
- LinkedIn: https://linkedin.com/in/felipeluizon