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
<title>Cart Summary</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 20px;
    }
    .container {
        max-width: 900px;
        margin: auto;
        background: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h1 {
        text-align: center;
        color: #333;
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
    .total-summary {
        text-align: right;
        font-weight: bold;
        margin-top: 20px;
    }
    .form-container {
        margin-top: 20px;
    }
    input[type="text"] {
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 4px;
        width: calc(100% - 22px);
    }
    button {
        background-color: #007bff;
        color: #fff;
        border: none;
        padding: 10px 20px;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
    }
    button:hover {
        background-color: #0056b3;
    }
    .confirm-button {
        display: block;
        margin: 20px auto;
    }
</style>
</head>
<body>

<div class="container">
    <h1>Cart Summary</h1>

    <%
    float total = 0;
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
                <p><strong>Name:</strong> <%= value.getName() %></p>
                <p><strong>Price:</strong> $<%= value.getPrice() %></p>
                <p><strong>Quantity:</strong> <%= value.getQuantity() %></p>
                <p><strong>Item Cost:</strong> $<%= value.getQuantity() * value.getPrice() %></p>
            </div>
        </div>
        <%
            total = total + (value.getQuantity() * value.getPrice());
        }
    %>

    <div class="total-summary">
        <p>Total: $<%= total %></p>
    </div>

    <div class="form-container">
        <form action="InsertOrdersTables" method="post">
            <label for="address">Paymode (Address):</label>
            <input type="text" id="address" name="address" placeholder="Enter your address">
            <button type="submit" class="confirm-button">Confirm Order</button>
        </form>
    </div>

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
