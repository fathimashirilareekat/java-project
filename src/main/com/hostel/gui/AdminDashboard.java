package com.hostel.gui;

import com.hostel.dao.RoomDAO;
import com.hostel.model.Room;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AdminDashboard extends JFrame {
    private DefaultTableModel model;
    private JTable table;
    private JTextField admissionField;
    private JComboBox<String> hostelCombo;

    public AdminDashboard() {
        setTitle("Admin Dashboard - Room Allocation");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initUI();
        loadRooms();
    }

    private void initUI() {
        setLayout(new BorderLayout(8,8));

        JPanel top = new JPanel();
        top.add(new JLabel("Hostel:"));
        hostelCombo = new JComboBox<>(new String[]{"MEN","LADIES"});
        top.add(hostelCombo);
        JButton loadBtn = new JButton("Load Rooms");
        top.add(loadBtn);
        add(top, BorderLayout.NORTH);

        model = new DefaultTableModel(new String[]{"Room No", "Capacity", "Allocated"}, 0) {
            public boolean isCellEditable(int row, int column) { return false; }
        };
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel bottom = new JPanel();
        bottom.add(new JLabel("Admission No:"));
        admissionField = new JTextField(12);
        bottom.add(admissionField);
        JButton allocateBtn = new JButton("Allocate Selected Room");
        bottom.add(allocateBtn);
        add(bottom, BorderLayout.SOUTH);

        loadBtn.addActionListener(e -> loadRooms());
        allocateBtn.addActionListener(e -> allocateSelectedRoom());
    }

    private void loadRooms() {
        model.setRowCount(0);
        String hostelType = (String) hostelCombo.getSelectedItem();

        SwingWorker<List<Room>, Void> worker = new SwingWorker<>() {
            @Override
            protected List<Room> doInBackground() {
                return new RoomDAO().getAvailableRooms(hostelType);
            }
            @Override
            protected void done() {
                try {
                    List<Room> rooms = get();
                    for (Room r : rooms) model.addRow(new Object[]{r.getRoomNo(), r.getCapacity(), r.getAllocated()});
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(AdminDashboard.this, "Error loading rooms");
                }
            }
        };
        worker.execute();
    }

    private void allocateSelectedRoom() {
        int row = table.getSelectedRow();
        if (row < 0) { JOptionPane.showMessageDialog(this, "Select a room first"); return; }
        String admissionNo = admissionField.getText().trim();
        if (admissionNo.isEmpty()) { JOptionPane.showMessageDialog(this, "Enter admission number"); return; }
        int roomNo = (int) model.getValueAt(row, 0);

        SwingWorker<Boolean, Void> worker = new SwingWorker<>() {
            @Override
            protected Boolean doInBackground() {
                return new RoomDAO().allocateRoom(roomNo, admissionNo);
            }
            @Override
            protected void done() {
                try {
                    boolean ok = get();
                    if (ok) {
                        JOptionPane.showMessageDialog(AdminDashboard.this, "Successfully allocated room " + roomNo);
                        loadRooms();
                    } else {
                        JOptionPane.showMessageDialog(AdminDashboard.this, "Allocation failed (room full / invalid admission).");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(AdminDashboard.this, "Error during allocation");
                }
            }
        };
        worker.execute();
    }
}