# Greeting Servlet Application (With Login)

A Java-based web application that implements secure user authentication and personalized greeting management using **Java Servlets, JSP, Spring Framework, JDBC, and PostgreSQL**. The project demonstrates the implementation of authentication, session management, database integration, and the MVC design pattern in a real-world web application.

---

## Project Overview

The Greeting Servlet Application enables users to register, log in securely, and access personalized greeting services. User credentials are securely stored using password hashing, while protected resources are accessible only after successful authentication through session-based authorization.

---

## Features

* User Registration
* Secure User Login
* Password Hashing
* Authentication & Authorization
* Session Management
* Greeting Management
* JDBC Database Connectivity
* PostgreSQL Integration
* Spring Dependency Injection
* MVC Architecture

---

## Technologies Used

* Java
* Java Servlets
* JSP
* Spring Framework
* JDBC
* PostgreSQL
* Apache Tomcat
* HTML5
* CSS3

---

## Project Structure

```text
GreetingServletApplication
│
├── resources
│   └── schema.sql
│
├── src
│   └── com
│       └── greet
│           ├── filter
│           │   └── AuthFilter.java
│           │
│           ├── model
│           │   ├── Greeting.java
│           │   └── User.java
│           │
│           ├── repository
│           │   ├── GreetingRepository.java
│           │   ├── GreetingRepositoryImpl.java
│           │   ├── UserRepository.java
│           │   └── UserRepositoryImpl.java
│           │
│           ├── service
│           │   ├── GreetingService.java
│           │   ├── GreetingServiceImpl.java
│           │   ├── UserService.java
│           │   └── UserServiceImpl.java
│           │
│           ├── servlet
│           │   ├── AuthServlet.java
│           │   └── GreetingServlet.java
│           │
│           └── util
│               └── HashUtil.java
│
├── WebContent
│   └── WEB-INF
│       └── web.xml
│
└── pom.xml
```

---

## How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/Muskankapoor07/BridgeLabz-Training-Backend.git
```

### 2. Switch to the Project Branch

```bash
git checkout Greeting_Servlet_Application2
```

### 3. Open the Project

Import the project into **IntelliJ IDEA** or any Java IDE that supports Maven and Apache Tomcat.

### 4. Configure the Database

* Install PostgreSQL.
* Create a new database.
* Execute the `schema.sql` file located in the `resources` directory.
* Update the database URL, username, and password in the project configuration.

### 5. Configure Apache Tomcat

* Add Apache Tomcat to your IDE.
* Deploy the project as a WAR artifact.
* Start the Tomcat server.

### 6. Run the Application

Launch the application in your browser after the server starts successfully.

---

## Learning Outcomes

This project provided hands-on experience in:

* Java Servlet Development
* Spring Framework
* JDBC Database Connectivity
* PostgreSQL Integration
* Authentication & Authorization
* Session Management
* Password Hashing
* MVC Architecture
* Repository & Service Layer Design
* Servlet Filters

---

## Author

**Muskan Kapoor**
Bachelor of Technology (B.Tech)
Computer Science & Engineering
GLA University, Mathura

---

## Skills

* Java
* Spring Framework
* Servlets
* JSP
* JDBC
* PostgreSQL
* MVC Architecture
* Git & GitHub

---

## License

This project was developed for educational purposes as part of the **BridgeLabz Backend Training Program**.

⭐ If you found this project helpful, feel free to explore the repository and share your feedback.
