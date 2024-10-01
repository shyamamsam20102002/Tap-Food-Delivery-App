<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.tap.dto.User" %>
<%@ page import="com.tap.dto.Restaurant"%>
<%@ page import="com.tap.dao.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Food Delivery</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }
    header {
        background-color: #333;
        color: #fff;
        padding: 10px 20px;
        text-align: center;
    }
    header h1 {
        margin: 0;
    }
    nav {
        margin-top: 10px;
    }
    nav a {
        color: #fff;
        text-decoration: none;
        margin: 0 10px;
        font-weight: bold;
    }
    nav a:hover {
        text-decoration: underline;
    }
    .welcome-message {
        display: inline-block;
        margin-right: 20px;
    }
    .restaurant-list {
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        padding: 20px;
    }
    .restaurant {
        background-color: #fff;
        border: 1px solid #ddd;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        margin: 10px;
        padding: 15px;
        text-align: center;
        width: 250px;
        position: relative;
    }
    .restaurant img {
        max-width: 100%;
        border-radius: 8px;
    }
    .restaurant h3 {
        margin: 10px 0;
        font-size: 18px;
    }
    .restaurant p {
        margin: 5px 0;
        color: #555;
    }
    .restaurant a {
        color: #007bff;
        text-decoration: none;
        font-weight: bold;
    }
    .restaurant a:hover {
        text-decoration: underline;
    }
    .no-restaurants {
        text-align: center;
        font-size: 18px;
        color: #555;
        margin-top: 20px;
    }
</style>
</head>
<body>

<header>
    <h1>Welcome to Online Food Delivery</h1>
    <nav>
        <a href="home">Home</a>
        <% User user = (User) session.getAttribute("loggedInUser"); %>
        <% if (user != null) { %>
            <span class="welcome-message">Welcome, <%= user.getUsername() %></span>
            <a href="cart">View Cart</a>
            <a href="OrdersHistory">View Order History</a>
            <a href="UpdateProfile.jsp">Update Profile</a>
            <a href="LogoutServlet">Logout</a>
        <% } else { %>
            <a href="login.jsp">Login</a>
            <a href="signup.jsp">Register</a>
        <% } %>
    </nav>
</header>

<h2 class="featured-restaurants">Featured Restaurants</h2>
<section class="restaurant-list">
    <% 
        List<Restaurant> restaurantList = (List<Restaurant>) session.getAttribute("restaurantList");
        if (restaurantList != null) {
            for (Restaurant restaurant : restaurantList) {
    %>
        <div class="restaurant">
            <img src="images/<%= restaurant.getImgPath() %>" alt="Image of <%= restaurant.getRestaurantName() %>">
            <h3><%= restaurant.getRestaurantName() %></h3>
            <p><%= restaurant.getCuisineType() %> - <%= restaurant.getDeliveryTime() %> mins</p>
            <a href="menuServlet?restaurantId=<%= restaurant.getRestaurantId() %>">View Menu</a>
        </div>
    <% 
            }
        } else { 
    %>
        <p class="no-restaurants">No restaurants available at the moment.</p>
    <% 
        } 
    %>
</section>

</body>
</html>
