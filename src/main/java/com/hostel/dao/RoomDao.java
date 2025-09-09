package com.hostel.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.hostel.model.Room;
import com.hostel.util.DatabaseConnection;

public class RoomDAO {

    // ✅ Get all available rooms for a hostel type (MEN or LADIES)
    public List<Room> getAvailableRooms(String hostelType) {
        List<Room> rooms = new ArrayList<>();
        try (Connection con = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM rooms WHERE hostel_type = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, hostelType);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Room room = new Room();
                room.setRoomNo(rs.getInt("room_no"));
                room.setCapacity(rs.getInt("capacity"));
                room.setAllocated(rs.getInt("allocated"));
                rooms.add(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }

    // ✅ Allocate a room to a student
    public boolean allocateRoom(int roomNo, String admissionNo) {
        boolean success = false;
        try (Connection con = DatabaseConnection.getConnection()) {
            con.setAutoCommit(false); // begin transaction

            // 1. Check room capacity
            String checkQuery = "SELECT capacity, allocated FROM rooms WHERE room_no = ?";
            PreparedStatement checkPs = con.prepareStatement(checkQuery);
            checkPs.setInt(1, roomNo);
            ResultSet rs = checkPs.executeQuery();

            if (rs.next()) {
                int capacity = rs.getInt("capacity");
                int allocated = rs.getInt("allocated");

                if (allocated < capacity) {
                    // 2. Update allocated count in rooms table
                    String updateQuery = "UPDATE rooms SET allocated = allocated + 1 WHERE room_no = ?";
                    PreparedStatement updatePs = con.prepareStatement(updateQuery);
                    updatePs.setInt(1, roomNo);
                    updatePs.executeUpdate();

                    // 3. Insert into student_room mapping table (if you have one)
                    String insertQuery = "INSERT INTO student_room (admission_no, room_no) VALUES (?, ?)";
                    PreparedStatement insertPs = con.prepareStatement(insertQuery);
                    insertPs.setString(1, admissionNo);
                    insertPs.setInt(2, roomNo);
                    insertPs.executeUpdate();

                    con.commit();
                    success = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}
