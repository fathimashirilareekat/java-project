package dao;

import model.Student;
import dao.DBConnection;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // Insert a new student
    public boolean registerStudent(Student student) {
        String sql = "INSERT INTO students (name, admission_no, keam_rank, phone, email, year, hostel_type, room_no) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getName());
            stmt.setString(2, student.getAdmissionNo());
            stmt.setInt(3, student.getKeamRank());
            stmt.setString(4, student.getPhone());
            stmt.setString(5, student.getEmail());
            stmt.setString(6, student.getYear());
            stmt.setString(7, student.getHostelType());
            stmt.setString(8, student.getRoomNo());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Fetch student by admission number
    public Student getStudentByAdmissionNo(String admissionNo) {
        String sql = "SELECT * FROM students WHERE admission_no = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, admissionNo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("admission_no"),
                        rs.getInt("keam_rank"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("year"),
                        rs.getString("hostel_type"),
                        rs.getString("room_no")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Fetch all students (for admin dashboard)
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("admission_no"),
                        rs.getInt("keam_rank"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("year"),
                        rs.getString("hostel_type"),
                        rs.getString("room_no")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    // Update room allocation
    public boolean updateRoom(int studentId, String roomNo) {
        String sql = "UPDATE students SET room_no = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, roomNo);
            ps.setInt(2, studentId);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

