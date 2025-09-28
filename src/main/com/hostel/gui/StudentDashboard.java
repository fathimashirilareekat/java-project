package com.hostel.gui;

import com.hostel.dao.StudentDAO;
import com.hostel.model.Student;

import javax.swing.*;
import java.awt.*;

public class StudentDashboard extends JFrame {
    private final String admissionNo;
    private JLabel nameLbl, roomLbl;

    public StudentDashboard(String admissionNo) {
        this.admissionNo = admissionNo;
        setTitle("Student Dashboard");
        setSize(360, 180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initUI();
        loadStudent();
    }

    private void initUI() {
        setLayout(new BorderLayout(10,10));
        JPanel top = new JPanel(new GridLayout(2,1));
        nameLbl = new JLabel("Name: ");
        roomLbl = new JLabel("Room: ");
        top.add(nameLbl);
        top.add(roomLbl);

        JButton refresh = new JButton("Refresh");
        refresh.addActionListener(e -> loadStudent());

        add(top, BorderLayout.CENTER);
        add(refresh, BorderLayout.SOUTH);
    }

    private void loadStudent() {
        SwingWorker<Student, Void> worker = new SwingWorker<>() {
            @Override
            protected Student doInBackground() {
                return new StudentDAO().getStudentByAdmissionNo(admissionNo);
            }
            @Override
            protected void done() {
                try {
                    Student s = get();
                    if (s == null) {
                        JOptionPane.showMessageDialog(StudentDashboard.this, "Student not found");
                        dispose();
                        return;
                    }
                    nameLbl.setText("Name: " + s.getName());
                    roomLbl.setText("Room: " + (s.getRoomNo() == null ? "Not allocated" : s.getRoomNo().toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(StudentDashboard.this, "Error loading student");
                }
            }
        };
        worker.execute();
    }
}