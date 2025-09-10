CREATE DATABASE hostel_db;
USE hostel_db;

-- Students Table
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    admission_no VARCHAR(50) UNIQUE NOT NULL,
    keam_rank INT,
    phone VARCHAR(15),
    address TEXT,
    guardian_name VARCHAR(100),
    guardian_phone VARCHAR(15),
    room_no VARCHAR(10) DEFAULT NULL
);

-- Admins Table
CREATE TABLE admins (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);

-- Complaints Table
CREATE TABLE complaints (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    complaint_text TEXT NOT NULL,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE
);
