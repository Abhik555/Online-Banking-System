<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.abthedev.models.Transanction"%>
<%@page import="com.abthedev.models.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


<%

if(request.getSession().getAttribute("user") == null){
	response.sendRedirect("loginpage.jsp");
}

%>


<head>
  <title>J Bank - Net Banking Dashboard</title>
  <link rel="stylesheet" type="text/css" href="./css/dash.css" />
</head>


<%! User u ; %>
<%
	u = (User) request.getSession().getAttribute("user");
%>


<body>
  <header>
    <h1>J Bank</h1>
    <a href="logout" class="logout">Logout</a>
  </header>

  <div class="body-div">
    <section>
  <div class="main-container">
    <div class="balance-div">
    	<% if(u != null){ %>
      <h1><%= u.getUsername() %></h1>
      <% } else { %>
      <h1>Account Name</h1>
      <% } %>
      <% if(u != null){ %>
      <h2>Balance : Rs  <%= u.getBalance() %>  </h2>
      <% } else { %>
      <h2>Balance : Error Retrieving</h2>
      <% } %>
    </div>

    <div class="spacer">

    </div>

    <div class="button-container-div">
      <h2>Actions</h2>
      <a href="transferpage.jsp" class="button">Transfer Funds</a>
      <a href="transanctionpage.jsp" class="button">Detailed Transactions History</a>
    </div>
  </div>
  </section>
  <section class="tran-sec">

    <div class="tran-container">
      <h1>Transactions</h1>
      <ul class="transaction-list">
      
      <%
      
      ArrayList<ArrayList<String>> tran = Transanction.getUserTransanctions(u);
      
      if(tran == null || tran.isEmpty()){
    	  out.println("<span>");
    	  out.println("<p class=\"tc\" style=\"color:red;\"> No Transactions </p>");
    	  out.println(" </span>");
    	  out.println("<div class=\"hp\"></div>");
      }else{
    	  
      for(ArrayList<String> n : tran){
    	  
    	  StringBuffer stb = new StringBuffer();
    	  
    	  String type;
    	  
    	  if(n.get(7).equalsIgnoreCase("credit")){
    		  type = "</span> <span class=\"credit\">";
    	  }else{
    		  type = "</span> <span class=\"debit\">";
    	  }
    	  
    	  stb.append("<li><span class=\"sender\">")
    	  	 .append(n.get(2))
    	  	 .append("</span> to <span class=\"receiver\">")
    	  	 .append(n.get(4))
    	  	 .append("</span> | <span class=\"amount\">Rs ")
    	  	 .append(n.get(5))
    	  	 .append(type)
    	  	 .append(n.get(7))
    	  	 .append("</span></li>");
    	  
    	  String output = stb.toString();
    	  
    	  out.println(output);
    	  
      }
      }
      %>
      </ul>               
    </div>

  </section>
  <div class="spacer-tall"></div>
  </div>

  <footer>
    <p>&copy; J Bank 2024</p>
  </footer>
</body>
</html>
