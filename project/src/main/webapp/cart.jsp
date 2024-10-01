<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tap.dto.*" %>
<%@ page import="com.tap.controller.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart Items</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 20px;
    }
    h1 {
        text-align: center;
        color: #333;
    }
    .cart-container {
        max-width: 900px;
        margin: auto;
        background: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    .cart-item {
        border-bottom: 1px solid #ddd;
        padding: 10px 0;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }
    .cart-item:last-child {
        border-bottom: none;
    }
    .item-details {
        flex: 1;
    }
    .item-details p {
        margin: 0;
        color: #555;
    }
    .item-actions form {
        display: inline;
        margin-right: 10px;
    }
    button, input[type="submit"] {
        background-color: #007bff;
        color: #fff;
        border: none;
        padding: 10px 15px;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
    }
    button:hover, input[type="submit"]:hover {
        background-color: #0056b3;
    }
    .update-button {
        background-color: #28a745;
    }
    .update-button:hover {
        background-color: #218838;
    }
    .remove-button {
        background-color: #dc3545;
    }
    .remove-button:hover {
        background-color: #c82333;
    }
    .proceed-button {
        display: block;
        margin: 20px auto;
        background-color: #17a2b8;
    }
    .proceed-button:hover {
        background-color: #138496;
    }
</style>
</head>
<body>

<h1>Your Cart Items</h1>

<div class="cart-container">
    <% 
    HashMap<Integer, CartItem> itemsofcart = (HashMap<Integer, CartItem>) session.getAttribute("items");
    Integer key = null;
    CartItem value = null;
    if (itemsofcart != null && !itemsofcart.isEmpty()) {
        for (Map.Entry<Integer, CartItem> entry : itemsofcart.entrySet()) {
            key = entry.getKey();
            value = entry.getValue();
    %>
        <div class="cart-item">
            <div class="item-details">
                <p><strong>Item ID:</strong> <%= value.getItemId() %></p>
                <p><strong>Name:</strong> <%= value.getName() %></p>
                <p><strong>Price Per Item:</strong> $<%= value.getPrice() %></p>
                <p><strong>Quantity:</strong> <%= value.getQuantity() %></p>
                <p><strong>Restaurant:</strong> <%= value.getRestaurant() %></p>
            </div>
            <div class="item-actions">
                <form action="CartServlet" method="post" style="display: inline;">
                    <input type="hidden" name="itemId" value="<%= value.getItemId() %>">
                    <input type="number" name="quantity" value="1" min="1">
                    <input type="submit" value="Update In Cart" class="update-button">
                    <input type="hidden" name="action" value="update">
                </form>
                <form action="CartServlet" method="post" style="display: inline;">
                    <input type="hidden" name="itemId" value="<%= value.getItemId() %>">
                    <input type="submit" value="Remove" class="remove-button">
                    <input type="hidden" name="action" value="remove">
                </form>
            </div>
        </div>
    <% 
        }
    %>
        <a href="checkOut.jsp">
            <button class="proceed-button">Proceed to Checkout</button>
        </a>
    <% 
    } else {
    %>
        <p>No items in the cart.</p>
    <% 
    }
    %>
</div>

</body>
</html>
