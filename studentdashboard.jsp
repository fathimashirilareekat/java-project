<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome - LBS Hostel</title>
    <style>
        body { font-family: Arial, sans-serif; text-align: center; padding: 100px 20px; background: #f0f4f7; }
        h1 { color: #1f3c88; text-transform: uppercase; }
        p { font-size: 18px; margin-top: 20px; color: #2c3e50; }
        .button { display: block; width: 250px; margin: 20px auto; padding: 15px; font-size: 18px; border: none; border-radius: 6px; cursor: pointer; background-color: #10b981; color: white; text-decoration: none; text-align: center; transition: 0.3s; }
        .button:hover { background-color: #059669; }
    </style>
</head>
<body>

<h1>Welcome!</h1>
<p id="welcomeMessage"></p>

<a href="complaint.jsp" class="button">Submit Complaint</a>
<a href="room_status.jsp" class="button">Check Room Status</a>

<script>
const admissionNo = localStorage.getItem("admissionNo");
if(admissionNo){
    document.getElementById("welcomeMessage").innerText = "Logged in as Admission No: " + admissionNo;
} else {
    document.getElementById("welcomeMessage").innerText = "You are logged in!";
}
</script>
</body>
</html>





