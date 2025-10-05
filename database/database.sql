-- Create Database
CREATE DATABASE IF NOT EXISTS hosteldb;
USE hosteldb;

--1 Admins Table
CREATE TABLE IF NOT EXISTS admins (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);

-- 2️ Students Table

CREATE TABLE IF NOT EXISTS students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    admission_no VARCHAR(50) UNIQUE NOT NULL,
    keam_rank INT,
    phone VARCHAR(15),
    hostel_type VARCHAR(1),   -- 'B' or 'G'
    room_no VARCHAR(10) DEFAULT NULL
);

-- 3️ Rooms Table

CREATE TABLE IF NOT EXISTS rooms (
    room_no VARCHAR(10) PRIMARY KEY,
    capacity INT NOT NULL,
    allocated INT DEFAULT 0
);


-- 4️ Allocations Table

CREATE TABLE IF NOT EXISTS allocations (
    allocation_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    room_no VARCHAR(10) NOT NULL,
    allocation_date DATE,
    FOREIGN KEY (student_id) REFERENCES students(id),
    FOREIGN KEY (room_no) REFERENCES rooms(room_no)
);


-- 5️ Complaints Table

CREATE TABLE IF NOT EXISTS complaints (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    room_no VARCHAR(10),
    complaint_text TEXT NOT NULL,
    complaint_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) DEFAULT 'Pending',
    FOREIGN KEY (student_id) REFERENCES students(id),
    FOREIGN KEY (room_no) REFERENCES rooms(room_no)
);
