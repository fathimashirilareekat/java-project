package dao;

import util.DBConnection;
import model.Room;
import model.Student;
import java.sql.*;
import java.util.*;

public class RoomDAO {

    // Get all rooms from the database
    public List<Room> getAllRooms() throws Exception {
        List<Room> rooms = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM rooms ORDER BY room_no";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Room r = new Room();
            r.setRoomNo(rs.getString("room_no"));
            r.setCapacity(rs.getInt("capacity"));
            r.setAllocated(rs.getInt("allocated"));
            rooms.add(r);
        }

        rs.close();
        ps.close();
        con.close();
        return rooms;
    }

    // Increment allocation count for a given room
    public void incrementAllocation(String roomNo) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "UPDATE rooms SET allocated = allocated + 1 WHERE room_no = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, roomNo);
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    // Check if the room still has space
    public boolean isRoomAvailable(Room room) {
        return room.getAllocated() < room.getCapacity();
    }

    // Get the first room that has available capacity
    public Room getFirstAvailableRoom() throws Exception {
        List<Room> rooms = getAllRooms();
        for (Room r : rooms) {
            if (isRoomAvailable(r)) {
                return r;
            }
        }
        return null;
    }

    // Allocate a student to a room AND save allocation in DB
    public String allocateRoomToStudent(Student student) throws Exception {
        Room room = getFirstAvailableRoom();
        if (room != null) {
            // 1. Update allocated count in rooms table
            incrementAllocation(room.getRoomNo());

            // 2. Insert into allocations table
            String sql = "INSERT INTO allocations (admission_no, room_no, allocation_date) VALUES (?, ?, ?)";
            try (Connection con = DBConnection.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, student.getAdmissionNo());
                ps.setString(2, room.getRoomNo());
                ps.setDate(3, new java.sql.Date(System.currentTimeMillis()));
                ps.executeUpdate();
            }

            return room.getRoomNo();
        } else {
            return null; // no rooms available
        }
    }
}
