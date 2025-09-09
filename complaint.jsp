<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Submit Complaint - LBS Hostel</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f0f4f7; text-align: center; padding: 50px 20px; }
        h1 { color: #1f3c88; margin-bottom: 30px; text-transform: uppercase; }
        .form-card { background: white; padding: 30px 25px; border-radius: 10px; box-shadow: 0 4px 12px rgba(0,0,0,0.1); width: 400px; margin: 0 auto; text-align: left; }
        .form-card label { font-weight: bold; display: block; margin-top: 10px; }
        .form-card input[type="text"], .form-card textarea { width: 100%; padding: 10px; margin-top: 5px; border-radius: 6px; border: 1px solid #ccc; box-sizing: border-box; font-size: 15px; }
        .form-card textarea { resize: vertical; min-height: 100px; }
        .form-card button { width: 100%; padding: 12px; font-size: 16px; border-radius: 6px; border: none; background-color: #3b82f6; color: white; cursor: pointer; margin-top: 15px; }
        .form-card button:hover { background-color: #2563eb; }
        #message { text-align: center; font-weight: bold; margin-bottom: 15px; }
        .back-button { display: block; width: 150px; margin: 20px auto 0 auto; padding: 12px; font-size: 16px; border: none; border-radius: 6px; background-color: #10b981; color: white; text-decoration: none; text-align: center; cursor: pointer; }
        .back-button:hover { background-color: #059669; }
    </style>
</head>
<body>

<h1>Submit Complaint</h1>

<div class="form-card">
    <div id="message"></div>
    <form action="ComplaintServlet" method="post">
        <label>Complaint:</label>
        <textarea name="complaint_text" placeholder="Enter your complaint here..." required></textarea>

        <label>Room Number:</label>
        <input type="text" name="room_no" placeholder="Enter your room number" required>

        <button type="submit">Submit Complaint</button>
    </form>
</div>

<a href="student_dashboard.jsp" class="back-button">Back</a>

</body>
</html>


                    

