import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainPage extends JFrame {

    public MainPage() {
        setTitle("Main Page");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create buttons
        JButton registerButton = new JButton("Register");
        JButton loginButton = new JButton("Login");
        JButton hostelButton = new JButton("Hostel Details");

        // Panel for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        panel.add(registerButton);
        panel.add(loginButton);
        panel.add(hostelButton);

        // Add action listeners
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open Register Page
                RegisterPage registerPage = new RegisterPage();
                registerPage.setVisible(true);
            }
        });

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Login Page coming soon!");
            }
        });

        hostelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hostel Details Page coming soon!");
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainPage().setVisible(true);
        });
    }
}
