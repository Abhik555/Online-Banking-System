<%@page import="com.abthedev.models.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>

  <style>
    /* Global Styles */
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      display: flex;
      min-height: 100vh;
      background-color: #f5f5f5;
    }

    .container {
      flex: 1;
      display: flex;
      flex-direction: column;
      padding: 1rem 2rem;
    }

    /* Header Styles */
    .header {
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 1rem 0;
      border-bottom: 1px solid #ddd;
    }

    .header h1 {
      margin: 0;
      font-size: 1.5rem;
      color: #333;
    }

    .header a {
      color: #007bff;
      text-decoration: none;
      font-weight: bold;
    }

    /* Main Content Styles */
    .main-content {
      flex: 1;
      display: flex;
      flex-wrap: wrap;
      justify-content: space-between;
      gap: 1rem;
    }

    .card {
      width: calc(33% - 1.5rem); /* Adjust width for responsive layout */
      padding: 1rem;
      border-radius: 5px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
      background-color: #fff;
    }

    .card h3 {
      margin-bottom: 0.5rem;
      font-size: 1rem;
    }

    .card p {
      margin-bottom: 0.75rem;
      font-size: 0.875rem;
      color: #777;
    }

    .card a {
      color: #007bff;
      text-decoration: none;
    }
  </style>

</head>
<body>

<%

//String uname = request.getSession().getAttribute("username").toString();
//String pass =  User.deencryptPassword(request.getSession().getAttribute("password").toString());

//response.getWriter().println(uname);
//response.getWriter().println(pass);

%>

 <div class="container">
    <header class="header">
      <h1>J Bank Dashboard</h1>
      <a href="#">Logout</a>
    </header>

    <main class="main-content">
      <div class="card">
        <h4>Account</h4>
        <h3>Balance: <%  %></h3>
      </div>

      <div class="card">
        <h3>Recent Transactions</h3>
        <ul>
          <li>10/21/2023 - Grocery Store - $54.20</li>
          <li>10/18/2023 - Online Payment - $25.00</li>
          <li>10/15/2023 - ATM Withdrawal - $100.00</li>
        </ul>
        <a href="#">View More Transactions</a>
      </div>

      <div class="card">
        <h3>Quick Actions</h3>
        <ul>
          <li><a href="#">Transfer Funds</a></li>
          <li><a href="#">Pay Bills</a></li>
          <li><a href="#">Mobile Deposit</a></li>
        </ul>
      </div>
    </main>
  </div>

</body>
</html>