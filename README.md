# University Management System - Lab 8

This project is a Spring Boot based university management system. It contains two services:

- `student-service` - manages students
- `course-service` - manages courses, enrollments, prerequisite validation, and course retrieval by student name

## Technologies

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Cloud OpenFeign
- H2 / PostgreSQL
- Gradle
- Swagger / OpenAPI
- Docker support

## Main Features

- Create, read, update, and delete students
- Create, read, update, and delete courses
- Store enrollment date when a student enrolls in a course
- Support optional course prerequisite using `prerequisiteCourseId`
- Validate prerequisites before enrollment
- Reject invalid enrollments with meaningful error responses
- Retrieve courses associated with a student by student name
- Azerbaijani Swagger API documentation

## Running the Project

From the root folder:

```bash
./gradlew :student-service:bootRun
./gradlew :course-service:bootRun
