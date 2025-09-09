<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Login - LBS Hostel</title>
    <style>
        body { font-family: Arial; text-align: center; background: #f0f4f7; padding: 100px 20px; }
        h1 { color: #1f3c88; text-transform: uppercase; margin-bottom: 30px; }
        .form-card { background: white; padding: 30px; border-radius: 10px; width: 300px; margin: auto; box-shadow: 0 4px 12px rgba(0,0,0,0.1); }
        .form-card input { width: 100%; padding: 10px; margin: 10px 0; border-radius: 6px; border: 1px solid #ccc; }
        .form-card button { width: 100%; padding: 12px; border-radius: 6px; border: none; background-color: #3b82f6; color: white; cursor: pointer; }
        .form-card button:hover { background-color: #2563eb; }
        #message { color: red; font-weight: bold; margin-bottom: 10px; }
    </style>
</head>
<body>

<h1>Admin Login</h1>

<div class="form-card">
    <div id="message"></div>
    <form action="AdminLoginServlet" method="post">
        <input type="text" name="username" placeholder="Username" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Login</button>
    </form>
</div>

</body>
</html>

   

