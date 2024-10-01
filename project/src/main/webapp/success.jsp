<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        background-color: #ffffff;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        padding: 20px;
        max-width: 400px;
        width: 100%;
        text-align: center;
    }

    h1 {
        color: #28a745;
        font-size: 24px;
        margin-bottom: 20px;
    }

    p {
        color: #333;
        font-size: 18px;
        margin-bottom: 20px;
    }

    a {
        text-decoration: none;
        color: #007bff;
        font-size: 16px;
        display: inline-block;
        margin-top: 10px;
    }

    a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Success!</h1>
        <p>Your data was successfully inserted.</p>
        <a href="home.jsp">Go to Home</a>
    </div>
</body>
</html>
