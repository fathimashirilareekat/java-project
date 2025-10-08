package gui;

import dao.StudentDAO;
import dao.RoomDAO;
import dao.ComplaintDAO;
import model.Student;
import model.Room;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AdminDashboard extends JFrame {

    private JTable studentTable;
    private JButton allocateBtn, viewComplaintsBtn, logoutBtn;

    public AdminDashboard() {
        setTitle("Admin Dashboard");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Student Table
        String[] cols = {"ID", "Name", "Admission No", "KEAM Rank", "Room No"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        studentTable = new JTable(model);
        loadStudents(model);

        add(new JScrollPane(studentTable), BorderLayout.CENTER);

        // Buttons Panel
        JPanel btnPanel = new JPanel();
        allocateBtn = new JButton("Allocate Room");
        viewComplaintsBtn = new JButton("View Complaints");
        logoutBtn = new JButton("Logout");

        btnPanel.add(allocateBtn);
        btnPanel.add(viewComplaintsBtn);
        btnPanel.add(logoutBtn);

        add(btnPanel, BorderLayout.SOUTH);

        // Allocate Room Action
        allocateBtn.addActionListener(e -> {
            int row = studentTable.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Select a student first!");
                return;
            }

            int studentId = (int) model.getValueAt(row, 0);
            String roomNo = JOptionPane.showInputDialog("Enter Room No:");

            if (roomNo != null && !roomNo.trim().isEmpty()) {
                try {
                    RoomDAO roomDAO = new RoomDAO();
                    List<Room> rooms = roomDAO.getAllRooms();
                    Room selectedRoom = null;

                    // find the room by its number (case-insensitive)
                    for (Room r : rooms) {
                        if (r.getRoomNo().equalsIgnoreCase(roomNo.trim())) {
                            selectedRoom = r;
                            break;
                        }
                    }

                    if (selectedRoom == null) {
                        JOptionPane.showMessageDialog(this, "Room does not exist!");
                        return;
                    }

                    if (!roomDAO.isRoomAvailable(selectedRoom)) {
                        JOptionPane.showMessageDialog(this, "Room is full!");
                        return;
                    }

                    StudentDAO studentDAO = new StudentDAO();
                    boolean updated = studentDAO.updateRoom(studentId, roomNo);

                    if (updated) {
                        roomDAO.incrementAllocation(roomNo);
                        JOptionPane.showMessageDialog(this, "✅ Room allocated successfully!");
                        loadStudents(model);
                    } else {
                        JOptionPane.showMessageDialog(this, "❌ Failed to allocate room.");
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "⚠️ Error occurred while allocating room.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Enter a valid room number!");
            }
        });

        // View Complaints Action
        viewComplaintsBtn.addActionListener(e -> {
            ComplaintDAO dao = new ComplaintDAO();
            List<String> complaints = dao.getAllComplaints();
            StringBuilder sb = new StringBuilder("All Complaints:\n\n");
            for (String c : complaints) sb.append(c).append("\n");
            JOptionPane.showMessageDialog(this, sb.toString());
        });

        // Logout Action
        logoutBtn.addActionListener(e -> {
            dispose();
            new AdminLoginForm(); // redirect to admin login
        });

        setVisible(true);
    }

    private void loadStudents(DefaultTableModel model) {
        model.setRowCount(0);
        StudentDAO dao = new StudentDAO();
        List<Student> students = dao.getAllStudents();
        for (Student s : students) {
            model.addRow(new Object[]{
                    s.getId(),
                    s.getName(),
                    s.getAdmissionNo(),
                    s.getKeamRank(),
                    s.getRoomNo() != null ? s.getRoomNo() : "Not allocated"
            });
        }
    }

    public static void main(String[] args) {
        new AdminDashboard();
    }
}
