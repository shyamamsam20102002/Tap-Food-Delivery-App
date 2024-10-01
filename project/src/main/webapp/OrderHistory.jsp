<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.tap.dto.OrderHistory" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order History</title>
<style>
    .order-history {
        border: 1px solid #ddd;
        padding: 10px;
        margin: 10px 0;
    }
    .order-history h2 {
        margin-top: 0;
    }
    .order-history p {
        margin: 5px 0;
    }
    .view-link {
        color: blue;
        text-decoration: underline;
    }
</style>
</head>
<body>

<h1>Order History</h1>

<% 
    ArrayList<OrderHistory> OrderHistories = (ArrayList<OrderHistory>) session.getAttribute("OrderHistory123");
    
    if (OrderHistories != null && !OrderHistories.isEmpty()) {
        for (OrderHistory orderhistory : OrderHistories) {
            int orderId = orderhistory.getOrderId();
%>
            <div class="order-history">
                <h2>Order History ID: <%= orderhistory.getOrderHistoryId() %></h2>
                <p><strong>Order ID:</strong> <%= orderId %></p>
                <p><strong>Status:</strong> <%= orderhistory.getStatus() %></p>
                <p><strong>Total Amount:</strong> $<%= orderhistory.getTotalAmount() %></p>
                <p><strong>User ID:</strong> <%= orderhistory.getUserId() %></p>
                <a href="OrderItemServlet?orderId=<%= orderId %>" class="view-link">View Order Items</a>
            </div>
<%
        }
    } else {
%>
        <p>No order history available.</p>
<%
    }
%>

</body>
</html>
