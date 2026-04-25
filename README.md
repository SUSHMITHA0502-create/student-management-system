# Student Management System

## 📌 Overview

A console-based **Student Management System** developed using **Java, JDBC, and PostgreSQL** to manage students, courses, and enrollments efficiently.
This project demonstrates backend database integration, DAO architecture, connection pooling, and PostgreSQL stored procedures/functions.

---

## 🚀 Features

### Admin Module

* Add New Student
* View All Students
* Update Student Details
* Delete Student
* Add New Course
* View All Courses
* Enroll Student in Course
* Assign / Update Grades

### Student Module
* Register Profile
* Update Personal Profile
* Enroll in Available Courses
* View Enrolled Courses
* View Grades

## 🛠 Tech Stack

* **Language:** Java
* **Database:** PostgreSQL
* **Connectivity:** JDBC
* **Build Tool:** Maven
* **IDE:** Eclipse

---

## 🧠 Concepts Implemented

* JDBC CRUD Operations
* Custom Connection Pooling
* Stored Procedures
* Exception Handling
* Layered Architecture

---

## 🗃 Database Schema

### Students Table

* `id` (Primary Key)
* `name`
* `email` (Unique)
* `dob`

### Courses Table

* `id` (Primary Key)
* `course_name`
* `credits`

### Enrollments Table

* `id` (Primary Key)
* `student_id` (Foreign Key)
* `course_id` (Foreign Key)
* `grade`

---

## 📂 Project Structure

student-management-system/
│
├── src/main/java/com/scms/
│   ├── db/
│   │   ├── ConnectionPool.java       # Manages a pool of DB connections
│   │   └── DBConnection.java         # Wrapper to get/release connections
│   │
│   ├── dao/
│   │   ├── StudentDAO.java           # CRUD operations for Student
│   │   ├── CourseDAO.java            # CRUD operations for Course
│   │   └── EnrollmentDAO.java        # CRUD operations for Enrollment
│   │
│   ├── model/
│   │   ├── Student.java              # Student entity class
│   │   ├── Course.java               # Course entity class
│   │   └── Enrollment.java           # Enrollment entity class
│   │
│   └── main/
│       └── MainApp.java              # Main entry point of the application
│
├── src/main/resources/
│   └── db.properties.example         # Template for database configuration
│
├── .gitignore
├── pom.xml
└── README.md

---

## ▶️ How to Run

### 1. Clone Repository

```bash
git clone https://github.com/SUSHMITHA0502/student-management-system
```

### 2. Create PostgreSQL Database

```sql
CREATE DATABASE scms_db;
```

### 3. Run Database Schema Script

Execute table creation queries and stored procedures/functions in PostgreSQL.

### 4. Configure Database Credentials

Update DB credentials in:

```java
CreateConnection.java
```

### 5. Run Application

Execute:

```java
MainApp.java
```

## 👩‍💻 Author

*Sushmitha Y*

GitHub: @SUSHMITHA0502-create
Email: sushmithayadukul05@gmail.com

---

## ⭐ If You Like This Project

Feel free to star the repository!
