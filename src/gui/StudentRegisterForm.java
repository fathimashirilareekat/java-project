package gui;

import dao.StudentDAO;
import model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegisterForm extends JFrame {
    private JTextField nameField, admissionNoField, keamRankField, phoneField, emailField, yearField, hostelTypeField;
    private JButton registerBtn, backBtn;

    public StudentRegisterForm() {
        setTitle("Student Registration");
        setSize(400, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10));

        // Form labels and inputs
        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Admission No:"));
        admissionNoField = new JTextField();
        panel.add(admissionNoField);

        panel.add(new JLabel("KEAM Rank:"));
        keamRankField = new JTextField();
        panel.add(keamRankField);

        panel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        panel.add(phoneField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        panel.add(new JLabel("Year:"));
        yearField = new JTextField();
        panel.add(yearField);

        panel.add(new JLabel("Hostel Type:"));
        hostelTypeField = new JTextField();
        panel.add(hostelTypeField);

        // Buttons
        registerBtn = new JButton("Register");
        backBtn = new JButton("Back");  
        panel.add(registerBtn);
        panel.add(backBtn);

        add(panel);

        // Button Actions
        registerBtn.addActionListener(e -> registerStudent());

        backBtn.addActionListener(e -> {
            new FrontPage(); // Open main menu
            dispose();      // Close current form
        });

        setVisible(true);
    }

    private void registerStudent() {
        try {
            String name = nameField.getText();
            String admissionNo = admissionNoField.getText();
            int keamRank = Integer.parseInt(keamRankField.getText());
            String phone = phoneField.getText();
            String email = emailField.getText();
            String year = yearField.getText();
            String hostelType = hostelTypeField.getText();

            // Room no empty for now
            Student student = new Student(name, admissionNo, keamRank, phone, email, year, hostelType, "");

            StudentDAO dao = new StudentDAO();
            if (dao.registerStudent(student)) {
                JOptionPane.showMessageDialog(this, "Student Registered Successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Registration Failed!");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new StudentRegisterForm();
    }
}

