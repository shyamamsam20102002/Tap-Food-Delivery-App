<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Profile Update Failed</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .message-container {
            background: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
            max-width: 400px;
            width: 100%;
        }
        .message-container h1 {
            color: #e74c3c;
            margin-bottom: 20px;
        }
        .message-container p {
            color: #555555;
            font-size: 16px;
            margin: 0;
        }
        .message-container a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            text-decoration: none;
            color: #ffffff;
            background-color: #e74c3c;
            border-radius: 5px;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }
        .message-container a:hover {
            background-color: #c0392b;
        }
    </style>
</head>
<body>

<div class="message-container">
    <h1>Profile Update Failed</h1>
    <p>There was an error updating your profile. Please try again later.</p>
    <a href="home.jsp">Return to Home</a>
</div>

</body>
</html>
