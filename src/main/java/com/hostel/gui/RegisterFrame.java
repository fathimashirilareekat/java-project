package com.hostel.gui;

import com.hostel.dao.StudentDAO;
import com.hostel.model.Student;

import javax.swing.*;
import java.awt.*;

public class RegisterFrame extends JFrame {
    private JTextField admissionField, nameField, phoneField, keamField, emailField;
    private JPasswordField passwordField;

    public RegisterFrame() {
        setTitle("Register Student");
        setSize(420, 340);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6,6,6,6);
        c.fill = GridBagConstraints.HORIZONTAL;

        int row = 0;
        c.gridx = 0; c.gridy = row; p.add(new JLabel("Admission No:"), c);
        c.gridx = 1; admissionField = new JTextField(18); p.add(admissionField, c);

        row++; c.gridx = 0; c.gridy = row; p.add(new JLabel("Name:"), c);
        c.gridx = 1; nameField = new JTextField(18); p.add(nameField, c);

        row++; c.gridx = 0; c.gridy = row; p.add(new JLabel("KEAM Rank:"), c);
        c.gridx = 1; keamField = new JTextField(18); p.add(keamField, c);

        row++; c.gridx = 0; c.gridy = row; p.add(new JLabel("Phone:"), c);
        c.gridx = 1; phoneField = new JTextField(18); p.add(phoneField, c);

        row++; c.gridx = 0; c.gridy = row; p.add(new JLabel("Email:"), c);
        c.gridx = 1; emailField = new JTextField(18); p.add(emailField, c);

        row++; c.gridx = 0; c.gridy = row; p.add(new JLabel("Password:"), c);
        c.gridx = 1; passwordField = new JPasswordField(18); p.add(passwordField, c);

        row++;
        JPanel btns = new JPanel();
        JButton submit = new JButton("Submit");
        JButton back = new JButton("Back");
        btns.add(submit); btns.add(back);
        c.gridx = 0; c.gridy = row; c.gridwidth = 2; p.add(btns, c);

        add(p);

        submit.addActionListener(ae -> onSubmit());
        back.addActionListener(ae -> {
            new LoginFrame().setVisible(true);
            dispose();
        });
    }

    private void onSubmit() {
        String adm = admissionField.getText().trim();
        String name = nameField.getText().trim();
        String keam = keamField.getText().trim();
        String phone = phoneField.getText().trim();
        String email = emailField.getText().trim();
        String pwd = new String(passwordField.getPassword());

        if (adm.isEmpty() || name.isEmpty() || pwd.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Admission, Name and Password are required.");
            return;
        }

        Student s = new Student();
        s.setAdmissionNo(adm);
        s.setName(name);
        s.setPassword(pwd);
        try { s.setKeamRank(Integer.parseInt(keam)); } catch (Exception ignored) {}

        s.setPhone(phone);
        s.setEmail(email);

        // Use SwingWorker to run DB op off EDT
        submitToDB(s);
    }

    private void submitToDB(Student s) {
        SwingWorker<Boolean, Void> worker = new SwingWorker<>() {
            @Override
            protected Boolean doInBackground() {
                return new StudentDAO().addStudent(s);
            }
            @Override
            protected void done() {
                try {
                    boolean ok = get();
                    if (ok) {
                        JOptionPane.showMessageDialog(RegisterFrame.this, "Registered successfully");
                        new LoginFrame().setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(RegisterFrame.this, "Registration failed (maybe duplicate).");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(RegisterFrame.this, "Error: " + ex.getMessage());
                }
            }
        };
        worker.execute();
    }
}