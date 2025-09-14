package dao;

import model.Room;
import java.sql.*;
import java.util.*;

public class RoomDAO {

    public List<Room> getAllRooms() throws Exception {
        List<Room> rooms = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM rooms";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Room r = new Room();
            r.setRoomNo(rs.getInt("room_no"));
            r.setCapacity(rs.getInt("capacity"));
            r.setAllocated(rs.getInt("allocated"));
            rooms.add(r);
        }
        con.close();
        return rooms;
    }

    public void incrementAllocation(int roomNo) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "UPDATE rooms SET allocated = allocated + 1 WHERE room_no = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, roomNo);
        ps.executeUpdate();
        con.close();
    }

    public boolean isRoomAvailable(Room room) {
        return room.getAllocated() < room.getCapacity();
    }
}

