<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard - LBS Hostel</title>
    <style>
        body { font-family: Arial; text-align: center; padding: 50px; background: #f0f4f7; }
        h1 { color: #1f3c88; text-transform: uppercase; margin-bottom: 30px; }
        .form-card { background: white; padding: 25px; border-radius: 10px; width: 400px; margin: auto; box-shadow: 0 4px 12px rgba(0,0,0,0.1); text-align: left; }
        .form-card label { font-weight: bold; margin-top: 10px; display: block; }
        .form-card input, .form-card textarea { width: 100%; padding: 10px; margin-top: 5px; border-radius: 6px; border: 1px solid #ccc; }
        .form-card button { width: 100%; padding: 12px; margin-top: 15px; border-radius: 6px; border: none; background-color: #10b981; color: white; cursor: pointer; }
        .form-card button:hover { background-color: #059669; }
        #message { color: green; font-weight: bold; margin-bottom: 15px; text-align: center; }
    </style>
</head>
<body>

<h1>Admin Dashboard</h1>

<div class="form-card">
    <div id="message"></div>
    <form id="allocateForm">
        <label>Student Admission Number:</label>
        <input type="text" id="studentAdmission" placeholder="Enter Admission No" required>
        <label>Room Number to Allocate:</label>
        <input type="text" id="roomNumber" placeholder="Enter Room No" required>
        <button type="submit">Allocate Room</button>
    </form>
</div>

<script>
const allocateForm = document.getElementById("allocateForm");
const messageDiv = document.getElementById("message");

allocateForm.addEventListener("submit", function(e){
    e.preventDefault();
    const admissionNo = document.getElementById("studentAdmission").value.trim();
    const roomNo = document.getElementById("roomNumber").value.trim();

    if(admissionNo === "" || roomNo === ""){
        messageDiv.style.color = "red";
        messageDiv.innerText = "Fill in all fields!";
        return;
    }

    // Save room allocation in localStorage for simplicity
    localStorage.setItem("roomNo", roomNo);
    localStorage.setItem("studentAllocated", admissionNo);

    messageDiv.style.color = "green";
    messageDiv.innerText = `Room ${roomNo} allocated to Admission No ${admissionNo}!`;

    allocateForm.reset();
});
</script>

</body>
</html>

