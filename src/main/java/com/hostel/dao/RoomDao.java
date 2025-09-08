package com.hostel.dao;

import com.hostel.model.Room;
import com.hostel.util.DatabaseConnection;
import java.sql.*;
import java.util.*;

public class RoomDAO {

    // Fetch available rooms by hostel type
    public List<Room> getAvailableRooms(String hostelType) {
        List<Room> rooms = new ArrayList<>();
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM rooms WHERE hostel_type=? AND allocated < capacity";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, hostelType);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Room r = new Room();
                r.setRoomNo(rs.getInt("room_no"));
                r.setHostelType(rs.getString("hostel_type"));
                r.setCapacity(rs.getInt("capacity"));
                r.setAllocated(rs.getInt("allocated"));
                rooms.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }

    // Allocate a room to a student
    public boolean allocateRoom(int admissionNo, int roomNo) {
        try (Connection con = DatabaseConnection.getConnection()) {
            con.setAutoCommit(false);

            // Update student table
            String sql1 = "UPDATE students SET room_no=? WHERE admission_no=?";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setInt(1, roomNo);
            ps1.setInt(2, admissionNo);
            int row1 = ps1.executeUpdate();

            // Update room allocation count
            String sql2 = "UPDATE rooms SET allocated = allocated + 1 WHERE room_no=? AND allocated < capacity";
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setInt(1, roomNo);
            int row2 = ps2.executeUpdate();

            if (row1 > 0 && row2 > 0) {
                con.commit();
                return true;
            } else {
                con.rollback();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
