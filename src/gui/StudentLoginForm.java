package gui;

import dao.StudentDAO;
import model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentLoginForm extends JFrame {
    private JTextField admissionNoField;
    private JTextField keamRankField;
    private JButton loginBtn, cancelBtn;

    public StudentLoginForm() {
        setTitle("Student Login");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        // Admission No
        panel.add(new JLabel("Admission No:"));
        admissionNoField = new JTextField();
        panel.add(admissionNoField);

        // KEAM Rank (acting as password here)
        panel.add(new JLabel("KEAM Rank:"));
        keamRankField = new JTextField();
        panel.add(keamRankField);

        // Buttons
        loginBtn = new JButton("Login");
        cancelBtn = new JButton("Cancel");

        panel.add(loginBtn);
        panel.add(cancelBtn);

        add(panel);

        // Action: Login
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginStudent();
            }
        });

        // Action: Cancel
        cancelBtn.addActionListener(e -> dispose());

        setVisible(true);
    }

    private void loginStudent() {
        String admissionNo = admissionNoField.getText();
        String keamRank = keamRankField.getText();

        if (admissionNo.isEmpty() || keamRank.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
            return;
        }

        try {
            StudentDAO dao = new StudentDAO();
            Student student = dao.getStudentByAdmissionNo(admissionNo);

            if (student != null && String.valueOf(student.getKeamRank()).equals(keamRank)) {
                JOptionPane.showMessageDialog(this, "Login Successful! Welcome " + student.getName());
                // TODO: Open student dashboard (Room status, complaints, etc.)
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Admission No or KEAM Rank");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new StudentLoginForm();
    }
}
