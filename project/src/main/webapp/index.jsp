<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Access</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        text-align: center;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .container {
        background: #fff;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        padding: 20px;
        text-align: center;
    }
    a {
        text-decoration: none;
        color: #007bff;
        font-size: 18px;
        font-weight: bold;
        margin: 10px;
        display: inline-block;
        transition: color 0.3s, transform 0.3s;
    }
    a:hover {
        color: #0056b3;
        transform: scale(1.05);
    }
    a:active {
        color: #004085;
    }
    h1 {
        margin-bottom: 20px;
        font-size: 24px;
        color: #333;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Welcome to Our Platform</h1>
        <a href="signup.jsp">Sign Up</a> 
        <a href="login.jsp">Login Page</a>
    </div>
</body>
</html>
