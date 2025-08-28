import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterPage extends JFrame {

    // Declare text fields
    private JTextField nameField, admissionField, teamRankField, phoneField, emailField, guardianNameField;
    private JTextArea addressArea, guardianDetailsArea;

    public RegisterPage() {
        setTitle("Register Page");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Only close this window
        setLocationRelativeTo(null);

        // Panel with GridLayout for form
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Name
        panel.add(new JLabel("Enter Your Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        // Address
        panel.add(new JLabel("Enter Your Address:"));
        addressArea = new JTextArea(3, 20);
        panel.add(new JScrollPane(addressArea));

        // Admission Number
        panel.add(new JLabel("Admission Number:"));
        admissionField = new JTextField();
        panel.add(admissionField);

        // Team Rank
        panel.add(new JLabel("Team Rank:"));
        teamRankField = new JTextField();
        panel.add(teamRankField);

        // Phone Number
        panel.add(new JLabel("Phone Number:"));
        phoneField = new JTextField();
        panel.add(phoneField);

        // Email
        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        // Guardian Name
        panel.add(new JLabel("Guardian Name:"));
        guardianNameField = new JTextField();
        panel.add(guardianNameField);

        // Guardian Details
        panel.add(new JLabel("Guardian Details:"));
        guardianDetailsArea = new JTextArea(3, 20);
        panel.add(new JScrollPane(guardianDetailsArea));

        // Submit Button
        JButton submitButton = new JButton("Submit");
        panel.add(submitButton);

        // Empty placeholder to align button properly
        panel.add(new JLabel(""));

        // Add ActionListener for Submit
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "Name: " + nameField.getText() +
                        "\nAddress: " + addressArea.getText() +
                        "\nAdmission No: " + admissionField.getText() +
                        "\nTeam Rank: " + teamRankField.getText() +
                        "\nPhone: " + phoneField.getText() +
                        "\nEmail: " + emailField.getText() +
                        "\nGuardian Name: " + guardianNameField.getText() +
                        "\nGuardian Details: " + guardianDetailsArea.getText();

                JOptionPane.showMessageDialog(null, data, "Registration Details", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RegisterPage().setVisible(true);
        });
    }
}