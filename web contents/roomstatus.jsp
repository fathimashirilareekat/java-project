<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Room Status - LBS Hostel</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f0f4f7;
            text-align: center;
            padding: 100px 20px;
        }
        h1 {
            color: #1f3c88;
            text-transform: uppercase;
            margin-bottom: 20px;
        }
        p {
            font-size: 18px;
            color: #2c3e50;
            margin-bottom: 30px;
        }
    </style>
</head>
<body>

<h1>Room Allocation Status</h1>
<p id="statusMessage"></p>

<script>
// Simulated room allocation
const admissionNo = localStorage.getItem("admissionNo");
const roomNo = localStorage.getItem("roomNo"); // room number stored after complaint

const statusMessage = document.getElementById("statusMessage");

if(admissionNo){
    if(roomNo){
        statusMessage.innerText = "Room allocation for Admission No " + admissionNo + ":\nRoom No: " + roomNo + " - Allocated";
    } else {
        statusMessage.innerText = "Room allocation for Admission No " + admissionNo + " is pending.";
    }
} else {
    statusMessage.innerText = "No admission number found. Please login first.";
}
</script>

</body>
</html>
