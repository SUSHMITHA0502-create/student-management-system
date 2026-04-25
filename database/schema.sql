-- =========================
-- Create Database
-- =========================
CREATE DATABASE scms_db;

-- =========================
-- STUDENTS TABLE
-- =========================
CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    dob DATE NOT NULL
);

-- =========================
-- COURSES TABLE
-- =========================
CREATE TABLE courses (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    credits INT CHECK (credits > 0)
);

-- =========================
-- ENROLLMENTS TABLE
-- =========================
CREATE TABLE enrollments (
    id SERIAL PRIMARY KEY,
    student_id INT REFERENCES students(id) ON DELETE CASCADE,
    course_id INT REFERENCES courses(id) ON DELETE CASCADE,
    grade VARCHAR(5),
    UNIQUE(student_id, course_id)
);

-- =========================
-- STORED PROCEDURE
-- =========================
CREATE OR REPLACE PROCEDURE add_student_sp(
    s_name VARCHAR,
    s_email VARCHAR,
    s_dob DATE
)
LANGUAGE plpgsql
AS $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM students WHERE email = s_email
    ) THEN
        INSERT INTO students(name, email, dob)
        VALUES (s_name, s_email, s_dob);
    ELSE
        RAISE NOTICE 'Student already exists';
    END IF;
END;
$$;