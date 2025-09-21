<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Hostel Registration - LBSCEK</title>
    <style>
        body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background: linear-gradient(to bottom, #f0f4f7, #d9e2ec); text-align: center; padding: 50px 20px; }
        h1 { color: #1f3c88; margin-bottom: 30px; text-transform: uppercase; font-weight: bold; }
        .form-card { background: white; padding: 30px 25px; border-radius: 10px; box-shadow: 0 4px 12px rgba(0,0,0,0.1); width: 400px; margin: 0 auto; text-align: left; }
        .form-card label { font-weight: bold; margin-top: 10px; display: block; }
        .form-card input[type="text"], .form-card input[type="email"], .form-card select { width: 100%; padding: 10px; margin: 5px 0 15px 0; border-radius: 6px; border: 1px solid #ccc; font-size: 15px; box-sizing: border-box; }
        .form-card input[type="radio"] { margin-right: 5px; }
        .hostel-options { display: flex; gap: 20px; align-items: center; margin-bottom: 15px; }
        .hostel-options label { margin: 0; font-weight: normal; }
        .form-card button { width: 100%; padding: 12px; font-size: 16px; border-radius: 6px; border: none; background-color: #10b981; color: white; cursor: pointer; transition: all 0.3s ease; margin-top: 10px; }
        .form-card button:hover { background-color: #059669; }
        #message { margin-bottom: 20px; font-weight: bold; text-align: center; font-size: 16px; }
        .back-link { display: block; text-align: center; margin-top: 20px; color: #1f3c88; text-decoration: none; font-weight: bold; }
        .back-link:hover { text-decoration: underline; }
    </style>
</head>
<body>

<h1>Hostel Room Application</h1>

<div class="form-card">
    <div id="message"></div>
    <form action="RegisterServlet" method="post">
        <label>Name:</label>
        <input type="text" name="name" required placeholder="Enter your full name">

        <label>Address:</label>
        <input type="text" name="address" required placeholder="Enter your address">

        <label>Admission No:</label>
        <input type="text" name="admission_no" required placeholder="Enter admission number">

        <label>KEAM Rank:</label>
        <input type="text" name="keam_rank" required placeholder="Enter KEAM rank">

        <label>Phone No:</label>
        <input type="text" name="phone" required placeholder="Enter phone number">

        <label>Email:</label>
        <input type="email" name="email" required placeholder="Enter your email">

        <label>Select Year:</label>
        <select name="year" required>
            <option value="">-- Select Year --</option>
            <option value="First Year">First Year</option>
            <option value="Second Year">Second Year</option>
            <option value="Third Year">Third Year</option>
            <option value="Fourth Year">Fourth Year</option>
        </select>

        <label>Select Hostel:</label>
        <div class="hostel-options">
            <input type="radio" id="mens" name="hostel" value="Mens Hostel" required>
            <label for="mens">Mens Hostel</label>
            <input type="radio" id="ladies" name="hostel" value="Ladies Hostel">
            <label for="ladies">Ladies Hostel</label>
        </div>

        <button type="submit">Apply for Room</button>
    </form>
</div>

<a href="frontpage.jsp" class="back-link">Back to Home</a>
</body>
</html>

