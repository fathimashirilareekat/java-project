package gui;

import dao.StudentDAO;
import model.Student;

import javax.swing.*;
import java.awt.*;

public class StudentLoginForm extends JFrame {

    private JLabel lblAdmissionNo;
    private JTextField txtAdmissionNo;
    private JButton loginBtn, backBtn;

    public StudentLoginForm() {
        setTitle("Student Login");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));

        // Admission No
        lblAdmissionNo = new JLabel("Admission No:");
        txtAdmissionNo = new JTextField();

        add(lblAdmissionNo);
        add(txtAdmissionNo);

        // Buttons
        loginBtn = new JButton("Login");
        backBtn = new JButton("Back"); // Changed from "Register" to "Back"

        add(loginBtn);
        add(backBtn);

        // Login button action
        loginBtn.addActionListener(e -> {
            String admissionNo = txtAdmissionNo.getText().trim();
            if (admissionNo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter Admission Number!");
                return;
            }

            StudentDAO dao = new StudentDAO();
            Student student = dao.getStudentByAdmissionNo(admissionNo);

            if (student != null) {
                JOptionPane.showMessageDialog(this, "✅ Login successful!");
                dispose();
                new StudentDashboard(student);
            } else {
                JOptionPane.showMessageDialog(this, "❌ Student not found!");
            }
        });

        // Back button action
        backBtn.addActionListener(e -> {
            new FrontPage(); // Go back to main menu
            dispose();      // Close login form
        });

        setVisible(true);
    }

    // Quick test
    public static void main(String[] args) {
        new StudentLoginForm();
    }
}
