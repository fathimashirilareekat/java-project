package dao;

import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ComplaintDAO {

    // Add a complaint
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

    // Quick test
    public static void main(String[] args) {
        ComplaintDAO dao = new ComplaintDAO();
        if (dao.addComplaint(1, "B101", "Lights not working")) {
            System.out.println("✅ Complaint added successfully!");
        } else {
            System.out.println("❌ Failed to add complaint!");
        }
    }
}


