<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard - LBS Hostel</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f0f4f7; padding: 50px 20px; text-align: center; }
        h1 { color: #1f3c88; text-transform: uppercase; margin-bottom: 30px; }
        table { width: 90%; margin: 0 auto 30px auto; border-collapse: collapse; background: white; box-shadow: 0 4px 12px rgba(0,0,0,0.1); }
        th, td { border: 1px solid #ccc; padding: 12px; text-align: center; }
        th { background-color: #3b82f6; color: white; }
        .button { padding: 10px 20px; background-color: #10b981; color: white; text-decoration: none; border-radius: 6px; margin: 5px; display: inline-block; }
        .button:hover { background-color: #059669; }
    </style>
</head>
<body>

<h1>Admin Dashboard</h1>

<!-- Example Table: Students & Room Numbers -->
<h2>Student Room Allocations</h2>
<table>
    <tr>
        <th>Admission No</th>
        <th>Name</th>
        <th>Year</th>
        <th>Hostel</th>
        <th>Room No</th>
    </tr>
    <tr>
        <td>2025ME001</td>
        <td>John Doe</td>
        <td>First Year</td>
        <td>Mens Hostel</td>
        <td>101</td>
    </tr>
    <tr>
        <td>2025CE002</td>
        <td>Jane Smith</td>
        <td>Second Year</td>
        <td>Ladies Hostel</td>
        <td>201</td>
    </tr>
</table>

<!-- Example Table: Complaints -->
<h2>Student Complaints</h2>
<table>
    <tr>
        <th>Complaint ID</th>
        <th>Student Admission No</th>
        <th>Room No</th>
        <th>Complaint</th>
        <th>Date</th>
    </tr>
    <tr>
        <td>1</td>
        <td>2025ME001</td>
        <td>101</td>
        <td>Leaky faucet in bathroom</td>
        <td>2025-09-09</td>
    </tr>
</table>

<a href="admin_login.jsp" class="button">Logout</a>

</body>
</html>

