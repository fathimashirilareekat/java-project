package dao;

import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComplaintDAO {

    // Add a complaint
    public boolean addComplaint(int studentId, String roomNo, String complaintText) {
        String sql = "INSERT INTO complaints(student_id, room_no, complaint_text) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ps.setString(2, roomNo);
            ps.setString(3, complaintText);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Fetch all complaints (for admin dashboard)
    public List<String> getAllComplaints() {
        List<String> complaints = new ArrayList<>();
        String sql = "SELECT c.complaint_text, s.name, s.room_no " +
                     "FROM complaints c JOIN students s ON c.student_id = s.id";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String text = rs.getString("complaint_text");
                String studentName = rs.getString("name");
                String roomNo = rs.getString("room_no");
                complaints.add(studentName + " (Room " + roomNo + "): " + text);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return complaints;
    }
}



