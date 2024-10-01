<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.tap.dto.OrderItem" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Items</title>
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
    .order-item {
        border-bottom: 1px solid #ddd;
        padding: 10px 0;
        display: flex;
        flex-direction: column;
        margin-bottom: 15px;
    }
    .order-item:last-child {
        border-bottom: none;
    }
    .order-item p {
        margin: 0;
        color: #555;
    }
    .order-item .item-label {
        font-weight: bold;
    }
    .order-item .item-value {
        margin-left: 10px;
        color: #333;
    }
</style>
</head>
<body>

<div class="container">
    <h1>Order Items</h1>

    <% 
    ArrayList<OrderItem> orderitemlists = (ArrayList<OrderItem>) session.getAttribute("OrderItemList");
    if (orderitemlists != null && !orderitemlists.isEmpty()) {
        for (OrderItem orderItem : orderitemlists) {
    %>
        <div class="order-item">
            <p><span class="item-label">Menu ID:</span> <span class="item-value"><%= orderItem.getMenuId() %></span></p>
            <p><span class="item-label">Order ID:</span> <span class="item-value"><%= orderItem.getOrderId() %></span></p>
            <p><span class="item-label">Order Item ID:</span> <span class="item-value"><%= orderItem.getOrderItemId() %></span></p>
            <p><span class="item-label">Quantity:</span> <span class="item-value"><%= orderItem.getQuantity() %></span></p>
            <p><span class="item-label">Sub Total:</span> <span class="item-value">$<%= orderItem.getSubTotal() %></span></p>
        </div>
    <% 
        }
    } else {
    %>
        <p>No items to display.</p>
    <% 
    }
    %>
</div>

</body>
</html>
