package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // Update DB name, user, and password as per your setup
    private static final String URL = "jdbc:mysql://localhost:3306/HostelDB?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root"; // change if needed
    private static final String PASSWORD = "Kdssdim@123"; // change to your MySQL password

    public static Connection getConnection() {
        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Return connection
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("❌ JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Database connection failed!");
            e.printStackTrace();
        }
        return null;
    }

    // Quick test
    public static void main(String[] args) {
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            System.out.println("✅ Connected to DB successfully!");
        } else {
            System.out.println("❌ Connection failed!");
        }
    }
}
