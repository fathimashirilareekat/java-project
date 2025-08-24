<!DOCTYPE html>
<html>
<head>
    <title>Hostel Room Allocation - LBS College of Engineering</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            text-align: center;
            padding: 50px;
        }
        h1 {
            color: #2c3e50;
            margin-bottom: 60px;
            text-transform: uppercase; 
            font-weight: bold;
            letter-spacing: 2px;
        }
        .button {
            display: inline-block;
            background-color: #2980b9;
            color: white;
            padding: 15px 30px;
            margin: 10px auto;
            font-size: 18px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            text-decoration: none;
            transition: background-color 0.3s ease;
            width: 250px; 
            text-align: center;
        }
        .button:hover {
            background-color: #3498db;
        }
        .button.admin {
            background-color: #8e44ad;
        }
        .button.admin:hover {
            background-color: #9b59b6;
        }
        .form-group {
            width: 250px;
            margin: 0 auto 20px auto;
            text-align: left;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
        }
        .form-group label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
            color: #2c3e50;
        }
        .form-group input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            font-size: 16px;
            border-radius: 4px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }
        .form-group input[type="submit"] {
            width: 100%;
            padding: 12px;
            font-size: 16px;
            border-radius: 4px;
            border: none;
            background-color: #27ae60;
            color: white;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .form-group input[type="submit"]:hover {
            background-color: #2ecc71;
        }
    </style>
</head>
<body>

    <h1>LBS COLLEGE OF ENGINEERING HOSTEL</h1>

    <!-- Register and Login grouped -->
    <div class="form-group">
        <label>Register</label>
        <a href="register.jsp" class="button" style="margin-bottom: 20px; display: block;">Register Here</a>

        <label>Login</label>
        <form action="student-login" method="post" style="margin-top: 10px;">
            <input type="text" name="name" placeholder="Name" required />
            <input type="text" name="admission_no" placeholder="Admission Number" required />
            <input type="submit" value="Login" />
        </form>
    </div>

    <!-- Admin Login Button -->
    <a href="admin_login.jsp" class="button admin">Admin Login</a>

    <br/>

    <!-- Hostel Details Button -->
    <a href="hostel_details.jsp" class="button" style="margin-top: 20px;">Hostel Details</a>

</body>
</html>