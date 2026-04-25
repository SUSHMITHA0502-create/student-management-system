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

```bash
src/main/java
└── com.scms
    ├── db
    │   ├── DBConnection.java
    │   └── CreateConnection.java
    ├── dao
    │   ├── StudentDAO.java
    │   ├── CourseDAO.java
    │   └── EnrollmentDAO.java
    ├── model
    │   ├── Student.java
    │   ├── Course.java
    │   └── Enrollment.java
    ├── main
    │   └── MainApp.java
    └── test
        ├── TestStudentDAO.java
        ├── TestCourseDAO.java
        └── TestEnrollmentDAO.java
```

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

**Sushmitha Y**

GitHub: @SUSHMITHA0502-create
Email: sushmithayadukul05@gmail.com

---

## ⭐ If You Like This Project

Feel free to star the repository!
