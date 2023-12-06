# Employee-Management-System

## Description
Our Employee Management System is a robust web application offering seamless CRUD (Create, Read, Update, Delete) operations, streamlining personnel data management with efficiency and precision.

## Tech Stack

### Frontend
- Angular (Version 16)
- Bootstrap (Styling)
  
### Backend
- Java 17
- Spring Boot
- Spring Data JPA
### Database
- MySQL

![Create Employee](https://github.com/rutwik-kumbhar/Employee-Management-System/blob/main/create-employee.png)

## Prerequisites
- Node JS
- Angular Cli
- Java 8 or higher
- MySQL Server

## Spring Boot Project Configuration
Add the following lines to your `application.properties` file to configure the Spring Boot backend:
```base
server.port = 8080
spring.datasource.driver=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/your-database-name
spring.datasource.username= Your Username
spring.datasource.password= Your Password
spring.jpa.hibernate.ddl-auto=update
