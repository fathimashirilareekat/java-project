package dao;

import dao.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {

    // Validate admin login
    public boolean validateAdminLogin(String username, String password) {
        String sql = "SELECT * FROM admins WHERE username=? AND password=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // true if admin exists
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Quick test
    public static void main(String[] args) {
        AdminDAO dao = new AdminDAO();
        if (dao.validateAdminLogin("admin1", "pass123")) {
            System.out.println("✅ Admin login successful!");
        } else {
            System.out.println("❌ Admin login failed!");
        }
    }
}

