package com.hostel.gui;

import com.hostel.dao.StudentDAO;
import com.hostel.model.Student;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {
    private JComboBox<String> roleCombo;
    private JTextField admissionField;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("Hostel Management - Login");
        setSize(420, 220);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(8,8,8,8);
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0; c.gridy = 0; p.add(new JLabel("Role:"), c);
        c.gridx = 1; roleCombo = new JComboBox<>(new String[] {"Student", "Admin"}); p.add(roleCombo, c);

        c.gridx = 0; c.gridy = 1; p.add(new JLabel("Admission No / Username:"), c);
        c.gridx = 1; admissionField = new JTextField(18); p.add(admissionField, c);

        c.gridx = 0; c.gridy = 2; p.add(new JLabel("Password:"), c);
        c.gridx = 1; passwordField = new JPasswordField(18); p.add(passwordField, c);

        JPanel buttons = new JPanel();
        JButton loginBtn = new JButton("Login");
        JButton registerBtn = new JButton("Register");
        buttons.add(loginBtn);
        buttons.add(registerBtn);

        c.gridx = 0; c.gridy = 3; c.gridwidth = 2; p.add(buttons, c);

        add(p);

        // Actions
        loginBtn.addActionListener(this::onLogin);
        registerBtn.addActionListener(e -> {
            RegisterFrame rf = new RegisterFrame();
            rf.setVisible(true);
            this.dispose();
        });
    }

    private void onLogin(ActionEvent e) {
        String role = (String) roleCombo.getSelectedItem();
        String admission = admissionField.getText().trim();
        String pass = new String(passwordField.getPassword());

        if (role.equals("Student")) {
            // Student login via StudentDAO
            StudentDAO sdao = new StudentDAO();
            SwingWorker<Student, Void> worker = new SwingWorker<>() {
                @Override
                protected Student doInBackground() {
                    return sdao.getStudentByAdmissionNo(admission);
                }
                @Override
                protected void done() {
                    try {
                        Student s = get();
                        if (s == null) {
                            JOptionPane.showMessageDialog(LoginFrame.this, "Student not found");
                            return;
                        }
                        // password check: assumes Student has getPassword()
                        if (s.getPassword() == null || !s.getPassword().equals(pass)) {
                            JOptionPane.showMessageDialog(LoginFrame.this, "Invalid password");
                            return;
                        }
                        // Success
                        StudentDashboard sd = new StudentDashboard(admission);
                        sd.setVisible(true);
                        dispose();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(LoginFrame.this, "Login error: " + ex.getMessage());
                    }
                }
            };
            worker.execute();
        } else {
            // Admin login: either call AdminDAO or use simple credentials
            if ("admin".equals(admission) && "admin123".equals(pass)) {
                AdminDashboard ad = new AdminDashboard();
                ad.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid admin credentials");
            }
        }
    }
}
