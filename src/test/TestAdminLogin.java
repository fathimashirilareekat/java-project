package test;

import dao.AdminDAO;

public class TestAdminLogin {
    public static void main(String[] args) {
        AdminDAO dao = new AdminDAO();
        if (dao.validateAdminLogin("admin1", "pass123")) {
            System.out.println("✅ Admin login successful!");
        } else {
            System.out.println("❌ Admin login failed!");
        }
    }
}

