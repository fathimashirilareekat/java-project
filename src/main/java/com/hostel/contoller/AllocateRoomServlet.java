package com.hostel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.hostel.dao.RoomDAO;

@WebServlet("/AllocateRoomServlet")
public class AllocateRoomServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // ✅ Get values from the JSP form
        String admissionNo = request.getParameter("admissionNo");
        String roomNoStr = request.getParameter("roomNo");

        boolean success = false;

        try {
            int roomNo = Integer.parseInt(roomNoStr);

            // ✅ Call DAO to allocate the room
            RoomDAO dao = new RoomDAO();
            success = dao.allocateRoom(roomNo, admissionNo);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // ✅ Redirect back with success/error message
        if (success) {
            response.sendRedirect("roomstatus.jsp?msg=success");
        } else {
            response.sendRedirect("roomstatus.jsp?msg=error");
        }
    }
}
