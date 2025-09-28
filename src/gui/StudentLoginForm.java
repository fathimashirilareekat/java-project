package gui;

import dao.StudentDAO;
import model.Student;

import javax.swing.*;
import java.awt.*;

public class StudentLoginForm extends JFrame {

    private JLabel lblAdmissionNo;
    private JTextField txtAdmissionNo;
    private JButton loginBtn, registerBtn;

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
        registerBtn = new JButton("Register");

        add(loginBtn);
        add(registerBtn);

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

        // Register button action
        registerBtn.addActionListener(e -> {
            dispose();
            new StudentRegisterForm(); // your registration form
        });

        setVisible(true);
    }

    // Quick test
    public static void main(String[] args) {
        new StudentLoginForm();
    }
}


