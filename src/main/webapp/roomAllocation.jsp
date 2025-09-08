<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Room Allocation</title>
</head>
<body>
    <h2>Room Allocation Form</h2>
    
    <form action="RoomAllocationController" method="post">
        <label for="studentId">Student ID:</label>
        <input type="text" name="studentId" required><br><br>
        
        <label for="roomNumber">Room Number:</label>
        <input type="text" name="roomNumber" required><br><br>
        
        <label for="allocationDate">Allocation Date:</label>
        <input type="date" name="allocationDate" required><br><br>
        
        <input type="submit" value="Allocate Room">
    </form>

    <p><a href="roomList.jsp">View Available Rooms</a></p>
</body>
</html>