package test;

import dao.ComplaintDAO;

public class TestComplaint {
    public static void main(String[] args) {
        ComplaintDAO dao = new ComplaintDAO();
        if (dao.addComplaint(1, "B101", "Fan not working")) {
            System.out.println("✅ Complaint added successfully!");
        } else {
            System.out.println("❌ Failed to add complaint!");
        }
    }
}

