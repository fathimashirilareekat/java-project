package servlets;

import dao.RoomDAO;
import dao.StudentDAO;
import model.Room;
import model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class RoomAllocationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        try {
            StudentDAO studentDAO = new StudentDAO();
            RoomDAO roomDAO = new RoomDAO();

            List<Student> students = studentDAO.getStudentsWithoutRoom();
            List<Room> rooms = roomDAO.getAllRooms();

            for (Student student : students) {
                for (Room room : rooms) {
                    if (roomDAO.isRoomAvailable(room)) {
                        // Allocate this student
                        studentDAO.updateStudentRoom(student.getAdmissionNo(), room.getRoomNo());
                        roomDAO.incrementAllocation(room.getRoomNo());
                        room.setAllocated(room.getAllocated() + 1); // update in memory too
                        break;
                    }
                }
            }

            response.sendRedirect("admindashboard.jsp?allocated=success");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("admindashboard.jsp?allocated=error");
        }
    }
}

