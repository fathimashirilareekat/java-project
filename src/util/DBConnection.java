package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/hosteldb"; 
    private static final String USER = "root";   
    private static final String PASSWORD = "Kdssdim@123"; 

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/hosteldb", "root", "Kdssdim@123");
            System.out.println("✅ Database Connected Successfully!");
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("❌ JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ SQL Connection Failed!");
            e.printStackTrace();
        }
        return null;
    }
}



