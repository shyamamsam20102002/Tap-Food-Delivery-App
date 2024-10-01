<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error - Data Insertion Failed</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f8d7da;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .container {
        background-color: #ffffff;
        border: 1px solid #f5c6cb;
        border-radius: 8px;
        padding: 20px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        text-align: center;
    }
    h1 {
        color: #721c24;
        margin-bottom: 10px;
    }
    p {
        color: #721c24;
        font-size: 16px;
        margin: 0;
    }
    .button {
        display: inline-block;
        margin-top: 20px;
        padding: 10px 20px;
        font-size: 16px;
        color: #ffffff;
        background-color: #721c24;
        border: none;
        border-radius: 4px;
        text-decoration: none;
        cursor: pointer;
    }
    .button:hover {
        background-color: #f5c6cb;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Error</h1>
        <p>Failed to insert data. Please try again later.</p>
        <a href="javascript:history.back()" class="button">Go Back</a>
    </div>
</body>
</html>
