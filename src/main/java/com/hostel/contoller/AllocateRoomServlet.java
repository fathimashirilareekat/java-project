package com.hostel.controller;

import com.hostel.dao.RoomDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class AllocateRoomServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get parameters from form
        int admissionNo = Integer.parseInt(request.getParameter("admissionNo"));
        int roomNo = Integer.parseInt(request.getParameter("roomNo"));

        RoomDAO dao = new RoomDAO();
        boolean success = dao.allocateRoom(admissionNo, roomNo);

        if (success) {
            // Redirect back with success message
            response.sendRedirect("viewRooms.jsp?msg=success");
        } else {
            // Redirect back with error message
            response.sendRedirect("viewRooms.jsp?msg=error");
        }
    }
}