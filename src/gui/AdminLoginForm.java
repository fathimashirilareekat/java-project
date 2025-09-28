package gui;

import dao.AdminDAO;

import javax.swing.*;
import java.awt.*;

public class AdminLoginForm extends JFrame {

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton loginBtn, cancelBtn;

    public AdminLoginForm() {
        setTitle("Admin Login");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Username
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Username:"), gbc);

        gbc.gridx = 1;
        txtUsername = new JTextField(15);
        add(txtUsername, gbc);

        // Password
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        txtPassword = new JPasswordField(15);
        add(txtPassword, gbc);

        // Buttons
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel btnPanel = new JPanel();
        loginBtn = new JButton("Login");
        cancelBtn = new JButton("Cancel");
        btnPanel.add(loginBtn);
        btnPanel.add(cancelBtn);
        add(btnPanel, gbc);

        // Login action
        loginBtn.addActionListener(e -> {
            String username = txtUsername.getText().trim();
            String password = new String(txtPassword.getPassword()).trim();

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter both username and password!");
                return;
            }

            AdminDAO dao = new AdminDAO();
            if (dao.validateAdminLogin(username, password)) {
                JOptionPane.showMessageDialog(this, "✅ Login successful!");
                dispose();
                new AdminDashboard();
            } else {
                JOptionPane.showMessageDialog(this, "❌ Invalid username or password!");
            }
        });

        // Cancel action
        cancelBtn.addActionListener(e -> {
            dispose();
        });

        setVisible(true);
    }

    // Quick test
    public static void main(String[] args) {
        new AdminLoginForm();
    }
}

