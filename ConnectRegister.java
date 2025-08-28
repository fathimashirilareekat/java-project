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
        panel.add(registerButton);
        panel.add(loginButton);
        panel.add(hostelButton);

        add(panel);

        // Action when clicking Register
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RegisterPage().setVisible(true);  // Open Register Page
            }
        });

        // (You can later add login and hostel details actions here)
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }
}
