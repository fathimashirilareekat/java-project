package dao;

import util.DBConnection;
import model.Room;
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
            r.setRoomNo(rs.getString("room_no")); // room number as text
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
        List<Room> rooms = getAllRooms(); // fetch all rooms
        for (Room r : rooms) {
            if (isRoomAvailable(r)) {
                return r; // return first room with free slot
            }
        }
        return null; // no room available
    }

    // Allocate a student to a room automatically
    public String allocateRoom() throws Exception {
        Room room = getFirstAvailableRoom();
        if (room != null) {
            incrementAllocation(room.getRoomNo()); // update allocation in DB
            return room.getRoomNo(); // return assigned room number
        } else {
            return null; // no room available
        }
    }
}
