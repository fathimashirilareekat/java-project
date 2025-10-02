package dao;

import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComplaintDAO {

    // Add a new complaint
    public boolean addComplaint(int studentId, String roomNo, String complaintText) {
        String sql = "INSERT INTO complaints(student_id, room_no, complaint_text) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ps.setString(2, roomNo);
            ps.setString(3, complaintText);

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Get complaints by a specific student (for StudentDashboard)
    public List<String> getComplaintsByStudentId(int studentId) {
        List<String> complaints = new ArrayList<>();
        String sql = "SELECT room_no, complaint_text FROM complaints WHERE student_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String room = rs.getString("room_no");
                String text = rs.getString("complaint_text");
                complaints.add("Room " + room + ": " + text);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return complaints;
    }

    // Get all complaints (for AdminDashboard)
    public List<String> getAllComplaints() {
        List<String> complaints = new ArrayList<>();
        String sql = "SELECT s.name, c.room_no, c.complaint_text " +
                     "FROM complaints c JOIN students s ON c.student_id = s.id";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String name = rs.getString("name");
                String room = rs.getString("room_no");
                String text = rs.getString("complaint_text");
                complaints.add(name + " (Room " + room + "): " + text);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return complaints;
    }

    // Quick test
    public static void main(String[] args) {
        ComplaintDAO dao = new ComplaintDAO();
        // Test adding complaint
        boolean added = dao.addComplaint(1, "B101", "Lights not working");
        System.out.println("Added: " + added);

        // Test fetching by student
        List<String> studentComplaints = dao.getComplaintsByStudentId(1);
        System.out.println("Student complaints: " + studentComplaints);

        // Test fetching all complaints
        List<String> allComplaints = dao.getAllComplaints();
        System.out.println("All complaints: " + allComplaints);
    }
}
