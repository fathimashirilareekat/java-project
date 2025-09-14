package dao;

import model.Student;
import java.sql.*;
import java.util.*;

public class StudentDAO {

    public List<Student> getStudentsWithoutRoom() throws Exception {
        List<Student> students = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM students WHERE room_no = 0 OR room_no IS NULL ORDER BY keam_rank ASC";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Student s = new Student();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setAdmissionNo(rs.getString("admission_no"));
            s.setKeamRank(rs.getInt("keam_rank"));
            s.setPhone(rs.getString("phone"));
            s.setAddress(rs.getString("address"));
            s.setRoomNo(rs.getInt("room_no"));
            s.setPassword(rs.getString("password"));
            students.add(s);
        }

        con.close();
        return students;
    }

    public void updateStudentRoom(String admissionNo, int roomNo) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "UPDATE students SET room_no = ? WHERE admission_no = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, roomNo);
        ps.setString(2, admissionNo);
        ps.executeUpdate();
        con.close();
    }

    public List<Student> getAllStudents() throws Exception {
        List<Student> students = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM students";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Student s = new Student();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setAdmissionNo(rs.getString("admission_no"));
            s.setKeamRank(rs.getInt("keam_rank"));
            s.setPhone(rs.getString("phone"));
            s.setAddress(rs.getString("address"));
            s.setRoomNo(rs.getInt("room_no"));
            s.setPassword(rs.getString("password"));
            students.add(s);
        }
        con.close();
        return students;
    }

    public void deleteStudent(String admissionNo) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "DELETE FROM students WHERE admission_no = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, admissionNo);
        ps.executeUpdate();
        con.close();
    }
}
