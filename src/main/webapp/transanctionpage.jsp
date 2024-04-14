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

<body>

  <header>
    <h1>J Bank</h1>
    <a href="logout" class="logout">Logout</a>
  </header>
  
  <div class="height:30px;"><p></p></div>

<section class="tran-sec">

    <div class="tran-container">
      <h1>Transactions</h1>
      <h2>Transaction ID | Sender | Receiver | Amount | Type | Timestamp</h2>
      <ul class="transaction-list">
      
      <%! User u; %>
      <%
    	u = (User) request.getSession().getAttribute("user");
      
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
    		  stb.append("<li> <span class=\"transaction-id\">")
     	  	 .append(n.get(0))
     	  	 .append("</span><span class=\"sender\">")
     	  	 .append(n.get(4))
     	  	 .append("</span> to <span class=\"receiver\">")
     	  	 .append(n.get(2))
     	  	 .append("</span> | <span class=\"amount\">Rs ")
     	  	 .append(n.get(5))
     	  	 .append(type)
     	  	 .append(n.get(7))
     	  	 .append("</span> <span class=\"timestamp\">")
     	  	 .append(n.get(6))
     	  	 .append("</span></li>");
    	  }else{
    		  type = "</span> <span class=\"debit\">";
    		  stb.append("<li> <span class=\"transaction-id\">")
     	  	 .append(n.get(0))
     	  	 .append("</span><span class=\"sender\">")
     	  	 .append(n.get(2))
     	  	 .append("</span> to <span class=\"receiver\">")
     	  	 .append(n.get(4))
     	  	 .append("</span> | <span class=\"amount\">Rs ")
     	  	 .append(n.get(5))
     	  	 .append(type)
     	  	 .append(n.get(7))
     	  	 .append("</span> <span class=\"timestamp\">")
     	  	 .append(n.get(6))
     	  	 .append("</span></li>");
    	  }
    	  
    	  
    	  String output = stb.toString();
    	  
    	  out.println(output);
    	  
      }      
      }
      %>
      </ul>               
    </div>
    
    <div class="tranback">
    <a href="dashboard.jsp" class="button">Back to Dashboard</a>

  </div>

  </section>
    <footer>
    <p>&copy; J Bank 2024</p>
  </footer>

</body>
</html>