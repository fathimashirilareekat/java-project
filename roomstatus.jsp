<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Room Status - LBS Hostel</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f0f4f7; text-align: center; padding: 100px 20px; }
        h1 { color: #1f3c88; text-transform: uppercase; margin-bottom: 20px; }
        p { font-size: 18px; color: #2c3e50; margin-bottom: 30px; }
        .back-button { display: block; width: 150px; margin: 20px auto 0 auto; padding: 12px; font-size: 16px; border: none; border-radius: 6px; background-color: #10b981; color: white; text-decoration: none; text-align: center; cursor: pointer; }
        .back-button:hover { background-color: #059669; }
    </style>
</head>
<body>

<h1>Room Allocation Status</h1>
<p>
    <% 
        String admissionNo = (String) session.getAttribute("admissionNo");
        String roomNo = (String) session.getAttribute("roomNo");
        if(admissionNo != null){
            if(roomNo != null && !roomNo.isEmpty()){
                out.println("Room allocation for Admission No " + admissionNo + ": Room No " + roomNo + " - Allocated");
            } else {
                out.println("Room allocation for Admission No " + admissionNo + " is pending.");
            }
        } else {
            out.println("No admission number found. Please login first.");
        }
    %>
</p>

<a href="student_dashboard.jsp" class="back-button">Back</a>

</body>
</html>


