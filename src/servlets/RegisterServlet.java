package com.hostel.servlet;

import com.hostel.dao.StudentDAO;
import com.hostel.model.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private StudentDAO studentDAO;

    @Override
    public void init() {
        studentDAO = new StudentDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String admissionNo = request.getParameter("admission_no");
        String keamRank = request.getParameter("keam_rank");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String roomNo = null; // initially no room allocated
        String password = request.getParameter("password");

        // Simple validation
        if (name == null || admissionNo == null || password == null || name.isEmpty() || admissionNo.isEmpty()) {
            request.setAttribute("error", "All fields are required!");
            request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
            return;
        }

        Student student = new Student(name, admissionNo, Integer.parseInt(keamRank), phone, address, roomNo, password);
        
        boolean success = studentDAO.addStudent(student);
        if (success) {
            response.sendRedirect("jsp/login.jsp");  // after register → login page
        } else {
            request.setAttribute("error", "Admission number already exists!");
            request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
        }
    }
}