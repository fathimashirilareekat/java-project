# DAO Layer - Hostel Management System

This folder contains **DAO (Data Access Object)** classes for interacting with the database.

## 📂 Files

- **DBConnection.java** → Utility class to connect to `HostelDB` (MySQL).
- **StudentDAO.java** → Handles student registration and fetching student details.
- **AdminDAO.java** → Handles admin login validation.
- **ComplaintDAO.java** → Handles student complaint submission.

---

## 🛠 How to Use

### 1. StudentDAO
```java
StudentDAO studentDAO = new StudentDAO();

// Register a new student
Student student = new Student("Rahul", "ADM001", 123, "9876543210", "rahul@example.com", "2nd Year", "Boys Hostel", "B101");
boolean registered = studentDAO.registerStudent(student);

// Fetch student by admission number
Student s = studentDAO.getStudentByAdmissionNo("ADM001");
System.out.println(s);
