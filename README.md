# Employee Payroll Application

A robust **Employee Payroll Management System** developed using **Java, Jakarta Servlet, JSP, Spring JDBC, and PostgreSQL**. The application enables secure user authentication, role-based authorization, employee management, payroll processing, and audit tracking while following the **MVC architecture** and industry-standard development practices.

---

## 📌 Overview

The Employee Payroll Application is designed to simplify employee and payroll management within an organization. It provides administrators with complete control over employee records and payroll operations, while employees can securely access their own profile information.

---

## 🚀 Tech Stack

| Category        | Technologies                                 |
| --------------- | -------------------------------------------- |
| Language        | Java 21                                      |
| Backend         | Jakarta Servlet, Spring Context, Spring JDBC |
| Frontend        | JSP, JSTL, HTML5, CSS3                       |
| Database        | PostgreSQL                                   |
| Database Access | JDBC Template                                |
| Server          | Apache Tomcat 10                             |
| IDE             | IntelliJ IDEA                                |
| Version Control | Git & GitHub                                 |

---

## ✨ Key Features

### 🔐 Authentication & Security

* Secure User Registration
* Login & Logout
* Password Hashing
* Session Management
* Protected Routes
* Role-Based Authorization

### 👨‍💼 Employee Management

* Add Employee
* Update Employee Information
* Delete Employee
* View Employee Details
* Employee Profile Management

### 💰 Payroll Management

* Salary Management
* Department-wise Payroll Calculation
* Payroll History
* Salary Audit Logs

### 👥 Role-Based Access Control

#### Admin

* Register Users
* Login
* Add Employees
* Update Employee Details
* Delete Employees
* View All Employees
* Access Payroll Audit Logs

#### User

* Login
* View Personal Employee Profile

---

## 📂 Project Structure

```text
employee_payroll_servlet_app
│
├── lib
│   ├── jakarta.servlet-api
│   ├── jstl
│   ├── postgresql-driver
│   ├── spring-framework-jars
│   └── java-dotenv
│
├── src
│   └── payroll
│       ├── config
│       │   └── AppConfig.java
│       │
│       ├── model
│       │   ├── Employee.java
│       │   └── User.java
│       │
│       ├── repository
│       │   ├── EmployeeRepository.java
│       │   └── UserRepository.java
│       │
│       ├── util
│       │   └── HashUtil.java
│       │
│       ├── web
│       │   ├── EmployeeServlet.java
│       │   ├── LoginServlet.java
│       │   ├── LogoutServlet.java
│       │   └── RegisterServlet.java
│       │
│       ├── application.properties
│       └── schema.sql
│
├── web
│   ├── WEB-INF
│   │   └── web.xml
│   │
│   ├── assets
│   │   └── images
│   │
│   ├── login.jsp
│   ├── register.jsp
│   ├── add-employee.jsp
│   ├── edit-employee.jsp
│   └── list-employees.jsp
│
└── README.md
```

---

## 🗄️ Database Schema

The application uses the following database tables:

| Table                    | Description                         |
| ------------------------ | ----------------------------------- |
| **users**                | Stores user credentials and roles   |
| **employees**            | Stores employee information         |
| **employee_departments** | Maintains department details        |
| **payroll_audit**        | Stores payroll modification history |

---

## 🏗️ Application Modules

### User Module

* User Registration
* Secure Login
* Logout
* Session Handling

### Employee Module

* Create Employee
* Update Employee
* Delete Employee
* View Employee List

### Payroll Module

* Salary Management
* Department-wise Payroll Processing
* Payroll Records

### Audit Module

* Salary Change History
* Payroll Activity Logs

---

## 🔒 Security Features

* Password Hashing
* Session Validation
* Role-Based Authorization
* Protected URLs
* Secure Authentication Flow

---

## 🖥️ Application Screens

* Login
* Registration
* Employee Dashboard
* Add Employee
* Edit Employee
* Employee Listing
* Payroll Audit Dashboard

---

## 📦 Dependencies

* Jakarta Servlet API
* JSP & JSTL
* Spring Context
* Spring Core
* Spring Beans
* Spring JDBC
* Spring AOP
* Spring TX
* PostgreSQL JDBC Driver
* java-dotenv

---

## ⚙️ Getting Started

### Prerequisites

* Java 21
* Apache Tomcat 10
* PostgreSQL
* IntelliJ IDEA

### Installation

#### 1. Clone the Repository

```bash
git clone https://github.com/Muskankapoor07/BridgeLabz-Training-Backend.git
```

#### 2. Open the Project

Import the project into **IntelliJ IDEA**.

#### 3. Configure the Database

* Create a PostgreSQL database.
* Execute the `schema.sql` file.
* Update database credentials in `application.properties`.

#### 4. Configure the Server

* Add Apache Tomcat 10.
* Include all required library JARs.
* Deploy the application.

#### 5. Run the Application

Open the following URL in your browser:

```text
http://localhost:8080/employee_payroll_servlet_app/
```

---

## 📈 Future Enhancements

* Employee Search
* Advanced Filters
* Pagination
* Profile Image Upload
* Email Notifications
* REST API Integration
* Maven Support
* Spring Boot Migration
* Dashboard Analytics

---

## 👩‍💻 Author

**Muskan Kapoor**

B.Tech Computer Science Engineering
GLA University, Mathura
