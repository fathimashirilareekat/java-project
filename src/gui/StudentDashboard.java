package gui;

import dao.ComplaintDAO;
import dao.StudentDAO;
import model.Student;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StudentDashboard extends JFrame {

    private JLabel lblName, lblAdmissionNo, lblRoomNo;
    private JTextArea complaintArea;
    private JButton submitBtn, viewComplaintsBtn, logoutBtn;

    private Student student; // logged-in student

    public StudentDashboard(Student student) {
        this.student = student;

        setTitle("Student Dashboard");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Profile Panel
        JPanel profilePanel = new JPanel(new GridLayout(3, 1, 5, 5));
        profilePanel.setBorder(BorderFactory.createTitledBorder("Your Details"));

        lblName = new JLabel("Name: " + student.getName());
        lblAdmissionNo = new JLabel("Admission No: " + student.getAdmissionNo());
        lblRoomNo = new JLabel("Room No: " + (student.getRoomNo() != null ? student.getRoomNo() : "Not allocated"));

        profilePanel.add(lblName);
        profilePanel.add(lblAdmissionNo);
        profilePanel.add(lblRoomNo);

        add(profilePanel, BorderLayout.NORTH);

        // Complaint Panel
        JPanel complaintPanel = new JPanel(new BorderLayout(5, 5));
        complaintPanel.setBorder(BorderFactory.createTitledBorder("Submit Complaint"));

        complaintArea = new JTextArea(5, 30);
        complaintPanel.add(new JScrollPane(complaintArea), BorderLayout.CENTER);

        submitBtn = new JButton("Submit Complaint");
        complaintPanel.add(submitBtn, BorderLayout.SOUTH);

        add(complaintPanel, BorderLayout.CENTER);

        // Buttons Panel
        JPanel btnPanel = new JPanel();
        viewComplaintsBtn = new JButton("View My Complaints");
        logoutBtn = new JButton("Logout");

        btnPanel.add(viewComplaintsBtn);
        btnPanel.add(logoutBtn);

        add(btnPanel, BorderLayout.SOUTH);

        // Submit Complaint Action
        submitBtn.addActionListener(e -> {
            String text = complaintArea.getText().trim();
            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter complaint text!");
                return;
            }
            ComplaintDAO dao = new ComplaintDAO();
            boolean success = dao.addComplaint(student.getId(),
                    student.getRoomNo() != null ? student.getRoomNo() : "Not allocated",
                    text);
            if (success) {
                JOptionPane.showMessageDialog(this, "✅ Complaint submitted!");
                complaintArea.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "❌ Failed to submit complaint.");
            }
        });

        // View Complaints Action
        viewComplaintsBtn.addActionListener(e -> {
            ComplaintDAO dao = new ComplaintDAO();
            List<String> complaints = dao.getComplaintsByStudentId(student.getId());
            StringBuilder sb = new StringBuilder("Your Complaints:\n\n");
            for (String c : complaints) sb.append(c).append("\n");
            JOptionPane.showMessageDialog(this, sb.toString());
        });

        // Logout Action
        logoutBtn.addActionListener(e -> {
            dispose();
            new StudentLoginForm(); // replace with your login form
        });

        setVisible(true);
    }

    // Quick test (replace with real student fetch)
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Student s = dao.getStudentByAdmissionNo("S123"); // replace with actual admission number
        if (s != null) new StudentDashboard(s);
        else System.out.println("Student not found!");
    }
}
