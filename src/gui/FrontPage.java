package gui;

import javax.swing.*;
import java.awt.*;

public class FrontPage extends JFrame {

    private JButton btnRegister, btnLogin, btnAdminLogin, btnHostelDetails;

    public FrontPage() {
        setTitle("LBS College of Engineering Hostel");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1, 10, 10));

        // Welcome label
        JLabel welcomeLabel = new JLabel("Welcome to LBSCEK Hostel", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(welcomeLabel);

        // Buttons
        btnRegister = new JButton("Student Register");
        btnLogin = new JButton("Student Login");
        btnAdminLogin = new JButton("Admin Login");
        btnHostelDetails = new JButton("Hostel Details");

        add(btnRegister);
        add(btnLogin);
        add(btnAdminLogin);
        add(btnHostelDetails);

        // Button Actions
        btnRegister.addActionListener(e -> {
            dispose(); // close front page
            new StudentRegisterForm(); // open register form
        });

        btnLogin.addActionListener(e -> {
            dispose();
            new StudentLoginForm(); // open login form
        });

        btnAdminLogin.addActionListener(e -> {
            dispose();
            new AdminLoginForm(); // open admin login
        });

        btnHostelDetails.addActionListener(e -> {
            new HostelDetailsForm(); // open hostel details (no dispose)
        });

        setVisible(true);
    }

    // Main method to run the launcher
    public static void main(String[] args) {
        new FrontPage();
    }
}

