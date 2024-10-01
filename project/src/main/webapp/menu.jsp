<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.tap.dto.*" %>
<%@ page import="com.tap.controller.*" %>
<%@ page import="com.tap.dao.*" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Items</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }
    .restaurant-list {
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        padding: 20px;
    }
    .restaurant {
        background: #fff;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        margin: 10px;
        padding: 15px;
        width: calc(33% - 40px);
        box-sizing: border-box;
        text-align: center;
        transition: transform 0.3s, box-shadow 0.3s;
    }
    .restaurant:hover {
        transform: translateY(-5px);
        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
    }
    .restaurant h3 {
        margin: 10px 0;
        color: #333;
    }
    .restaurant p {
        color: #555;
        font-size: 14px;
        margin: 5px 0;
    }
    .restaurant .price {
        color: #007bff;
        font-size: 18px;
        font-weight: bold;
    }
    form {
        margin-top: 10px;
    }
    input[type="number"] {
        width: 60px;
        padding: 5px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }
    input[type="submit"] {
        background-color: #28a745;
        color: #fff;
        border: none;
        padding: 10px 15px;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
        width: 100%;
        box-sizing: border-box;
        transition: background-color 0.3s;
    }
    input[type="submit"]:hover {
        background-color: #218838;
    }
</style>
</head>
<body>
    <section class="restaurant-list">
        <%
        ArrayList<Menu> MenuList = (ArrayList<Menu>) session.getAttribute("MENU");
        if (MenuList != null) {
            for (Menu menuItem : MenuList) {
        %>     
        <div class="restaurant">
            <h3><%= menuItem.getItemName() %></h3>
            <p class="price">$<%= menuItem.getPrice() %></p>
            <p><%= menuItem.getDescription() %></p>
            <p>Available: <%= menuItem.getIsAvailable() %></p>
            <form action="CartServlet" method="post">
                <input type="hidden" name="itemId" value="<%= menuItem.getMenuId() %>">
                Quantity: <input type="number" name="quantity" value="1" min="1">
                <input type="submit" value="Add to cart">
                <input type="hidden" name="action" value="add">
            </form>
        </div>  
        <%
            }
        } else {
        %>
        <p>No menu items available at the moment.</p>
        <%
        }
        %>
    </section>
</body>
</html>
