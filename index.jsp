<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Hostel Room Allocation - LBS College of Engineering</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(to bottom, #f0f4f7, #d9e2ec);
            text-align: center;
            padding: 50px 20px;
        }
        h1 {
            color: #1f3c88;
            margin-bottom: 50px;
            text-transform: uppercase;
            font-weight: bold;
            letter-spacing: 2px;
        }
        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            gap: 20px;
        }
        .button {
            display: block;
            background-color: #3b82f6;
            color: white;
            padding: 15px 30px;
            font-size: 18px;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            text-decoration: none;
            width: 250px;
            transition: all 0.3s ease;
            box-shadow: 0 4px 8px rgba(0,0,0,0.15);
        }
        .button:hover {
            background-color: #2563eb;
            transform: translateY(-2px);
        }
        .button.register { background-color: #10b981; }
        .button.register:hover { background-color: #059669; }
        .button.login { background-color: #f59e0b; }
        .button.login:hover { background-color: #b45309; }
        .button.admin { background-color: #8b5cf6; }
        .button.admin:hover { background-color: #6d28d9; }
        .button.details { background-color: #ef4444; }
        .button.details:hover { background-color: #b91c1c; }

        .login-form {
            background: white;
            padding: 30px 25px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
            width: 300px;
            text-align: center;
        }
        .login-form input[type="text"] {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border-radius: 6px;
            border: 1px solid #ccc;
            font-size: 16px;
            box-sizing: border-box;
        }
        .login-form input[type="submit"] {
            width: 100%;
            padding: 12px;
            font-size: 16px;
            border-radius: 6px;
            border: none;
            background-color: #f59e0b;
            color: white;
            cursor: pointer;
            transition: all 0.3s ease;
        }
        .login-form input[type="submit"]:hover {
            background-color: #b45309;
        }
    </style>
</head>
<body>

    <h1>LBS COLLEGE OF ENGINEERING HOSTEL</h1>

    <div class="container">
        <a href="register.jsp" class="button register">Register</a>

        <div class="login-form">
            <h3>Login</h3>
            <form action="student-login" method="post">
                <input type="text" name="admission_no" placeholder="Admission Number" required />
                <input type="submit" value="Login" />
            </form>
        </div>

        <a href="admin_login.jsp" class="button admin">Admin Login</a>
        <a href="hostel_details.jsp" class="button details">Hostel Details</a>
    </div>

</body>
</html>
