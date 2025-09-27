package test;

import dao.StudentDAO;
import model.Student;

public class StudentTest {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

        // 1. Register a new student
        Student s1 = new Student("Rahul", "ADM001", 123, "9876543210",
                                 "rahul@example.com", "2nd Year", "Boys Hostel", "B101");
        boolean inserted = studentDAO.registerStudent(s1);
        if (inserted) {
            System.out.println("✅ Student registered successfully!");
        } else {
            System.out.println("❌ Failed to register student.");
        }

        // 2. Fetch student by admission no
        Student fetched = studentDAO.getStudentByAdmissionNo("ADM001");
        if (fetched != null) {
            System.out.println("✅ Student fetched: " + fetched);
        } else {
            System.out.println("❌ Student not found.");
        }
    }
}


