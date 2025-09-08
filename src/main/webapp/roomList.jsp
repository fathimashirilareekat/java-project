<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*, com.hostel.model.Room" %>
<%
    // Sample data (Replace this with real data from backend)
    List<Room> rooms = (List<Room>) request.getAttribute("roomList");

    if (rooms == null) {
        out.println("<p>No room data available. Please check backend.</p>");
    } else {
%>
    <h2>Room List</h2>
    <table border="1">
        <tr>
            <th>Room Number</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        <% for (Room room : rooms) { %>
            <tr>
                <td><%= room.getRoomNumber() %></td>
                <td><%= room.getStatus() %></td>
                <td>
                    <% if ("Available".equals(room.getStatus())) { %>
                        <form action="roomAllocation.jsp" method="get">
                            <input type="hidden" name="roomNumber" value="<%= room.getRoomNumber() %>">
                            <input type="submit" value="Allocate">
                        </form>
                    <% } else { %>
                        Occupied
                    <% } %>
                </td>
            </tr>
        <% } %>
    </table>
<%
    }
%>