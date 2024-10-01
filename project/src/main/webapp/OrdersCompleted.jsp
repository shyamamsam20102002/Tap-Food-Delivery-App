<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Success</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100vh;
        text-align: center;
    }

    .container {
        background-color: #ffffff;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        padding: 20px;
        max-width: 400px;
        margin: 20px;
        width: 100%;
    }

    h1 {
        color: #28a745;
        font-size: 24px;
        margin-bottom: 20px;
    }

    a {
        color: #007bff;
        text-decoration: none;
        font-size: 18px;
        margin-top: 20px;
        display: inline-block;
        padding: 10px 20px;
        border-radius: 4px;
        background-color: #e9ecef;
        transition: background-color 0.3s, color 0.3s;
    }

    a:hover {
        background-color: #007bff;
        color: #ffffff;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Your items were successfully ordered!</h1>
        <a href="home.jsp">Go to Home</a>
    </div>
</body>
</html>
