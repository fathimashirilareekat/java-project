package com.hostel.servlet;

import com.hostel.dao.StudentDAO;
import com.hostel.model.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private StudentDAO studentDAO;

    @Override
    public void init() {
        studentDAO = new StudentDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String admissionNo = request.getParameter("admission_no");
        String password = request.getParameter("password");

        Student student = studentDAO.getStudent(admissionNo, password);

        if (student != null) {
            HttpSession session = request.getSession();
            session.setAttribute("student", student);
            response.sendRedirect("jsp/studentHome.jsp");
        } else {
            request.setAttribute("error", "Invalid login. Try again.");
            request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
        }
    }
}

