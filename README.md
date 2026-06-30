# Greeting Servlet Application (With Login)

A Java-based web application that provides secure user authentication and personalized greeting management using **Java Servlets, JSP, Spring Framework, JDBC, and PostgreSQL**.

This project demonstrates **authentication, authorization, database connectivity, session management, and the MVC architecture** in a real-world web application.

---

# Project Overview

The application allows users to register, log in securely, and access personalized greeting services. User credentials are securely stored using password hashing, while authentication and authorization are enforced through servlet filters.

---

# Features

* User Registration
* Secure User Login
* Password Hashing
* Authentication Filter
* Greeting Management
* JDBC Database Connectivity
* PostgreSQL Integration
* Spring Dependency Injection
* MVC Architecture
* Session Management

---

# Technologies Used

* Java
* Servlets
* JSP
* Spring Framework
* JDBC
* PostgreSQL
* Apache Tomcat
* HTML5
* CSS3

---

# Project Structure

```text
GreetingServletAppWithLogin
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
├── web
│   └── WEB-INF
│       └── images
│
└── GreetingServletAppWithLogin.iml
```

---

# How to Run

## 1. Clone the Repository

```bash
git clone https://github.com/Muskankapoor07/BridgeLabz_Backend_Training.git
```

## 2. Switch to the Project Branch

```bash
git checkout Greeting_Servlet_Application2
```

## 3. Open the Project

Import the project into **IntelliJ IDEA** or your preferred Java IDE.

## 4. Configure PostgreSQL

* Install PostgreSQL.
* Create a new database.
* Execute the `schema.sql` file to create the required tables.
* Update the database URL, username, and password in the project configuration.

## 5. Configure Apache Tomcat

* Install Apache Tomcat.
* Add the Tomcat server to your IDE.
* Deploy the project as a WAR artifact.

## 6. Run the Application

Start the Tomcat server and open the application in your web browser.

---

# Learning Outcomes

During this project, I gained hands-on experience with:

* Java Servlet Development
* Spring Framework
* JDBC Database Connectivity
* PostgreSQL
* Authentication & Authorization
* Session Management
* Password Hashing
* MVC Architecture
* Repository Layer
* Service Layer
* Servlet Filters
* Web Application Development
* Git & GitHub Version Control

---

# Author

**Muskan Kapoor**

Bachelor of Technology (B.Tech)
Computer Science & Engineering (CSE)
GLA University, Mathura

---

# Skills

* Java
* Spring Framework
* Servlets
* JSP
* JDBC
* PostgreSQL
* Apache Tomcat
* MVC Architecture
* Git & GitHub

---

# License

This project is developed for educational and learning purposes as part of the **BridgeLabz Backend Training Program**.

⭐ Thank you for visiting this repository! Feel free to explore the project, review the source code, and share your feedback.
