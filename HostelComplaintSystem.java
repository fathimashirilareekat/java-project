
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class HostelComplaintSystem extends JFrame {
    private JTextField nameField, roomField, admissionField;
    private JTextArea complaintArea;
    private static final String FILE_NAME = "complaints.txt";

    public HostelComplaintSystem() {
        setTitle("Hostel Complaint System");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(180, 220, 240));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel nameLabel = new JLabel("Name:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nameLabel, gbc);
        nameField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(nameField, gbc);

        JLabel roomLabel = new JLabel("Room Number:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(roomLabel, gbc);
        roomField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(roomField, gbc);

        JLabel admissionLabel = new JLabel("Admission Number:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(admissionLabel, gbc);
        admissionField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(admissionField, gbc);

        JLabel complaintLabel = new JLabel("Complaint:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(complaintLabel, gbc);
        complaintArea = new JTextArea(5, 20);
        gbc.gridx = 1;
        panel.add(new JScrollPane(complaintArea), gbc);

        JButton submitButton = new JButton("Submit");
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(submitButton, gbc);

        JButton adminButton = new JButton("Admin View");
        gbc.gridx = 1;
        panel.add(adminButton, gbc);

        add(panel);

        submitButton.addActionListener(e -> saveComplaint());
        adminButton.addActionListener(e -> showAdminLogin());
    }

    private void saveComplaint() {
        String name = nameField.getText().trim();
        String room = roomField.getText().trim();
        String admission = admissionField.getText().trim();
        String complaint = complaintArea.getText().trim();

        if (name.isEmpty() || room.isEmpty() || complaint.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write("Name: " + name + "\n");
            fw.write("Room: " + room + "\n");
            fw.write("Admission: " + admission + "\n");
            fw.write("Complaint: " + complaint + "\n");
            fw.write("-----\n");
            JOptionPane.showMessageDialog(this, "Complaint saved!");
            nameField.setText("");
            roomField.setText("");
            admissionField.setText("");
            complaintArea.setText("");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving complaint!");
        }
    }

    private void showAdminLogin() {
        JPasswordField passField = new JPasswordField();
        int option = JOptionPane.showConfirmDialog(this, passField, "Admin Password",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            String password = new String(passField.getPassword());
            if (password.equals("admin123")) {
                showAdminView();
            } else {
                JOptionPane.showMessageDialog(this, "Wrong password!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showAdminView() {
        JFrame adminFrame = new JFrame("Admin Dashboard");
        adminFrame.setSize(600, 400);
        adminFrame.setLocationRelativeTo(this);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> complaintList = new JList<>(listModel);
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            StringBuilder complaint = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals("-----")) {
                    listModel.addElement(complaint.toString().trim());
                    complaint.setLength(0);
                } else {
                    complaint.append(line).append("\n");
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "No complaints yet!");
        }

        JButton resolveButton = new JButton("Mark as Resolved");
        resolveButton.addActionListener(e -> {
            int index = complaintList.getSelectedIndex();
            if (index != -1) {
                listModel.remove(index);
                saveRemaining(listModel);
            }
        });

        adminFrame.add(new JScrollPane(complaintList), BorderLayout.CENTER);
        adminFrame.add(resolveButton, BorderLayout.SOUTH);
        adminFrame.setVisible(true);
    }

    private void saveRemaining(DefaultListModel<String> listModel) {
        try (FileWriter fw = new FileWriter(FILE_NAME, false)) {
            for (int i = 0; i < listModel.size(); i++) {
                fw.write(listModel.get(i) + "\n-----\n");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error updating complaints!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HostelComplaintSystem().setVisible(true));
    }
}
