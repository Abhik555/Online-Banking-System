<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>

<%

int code = (int) request.getAttribute("status");

if(code == 0){
	out.println("successful");
	//response.getWriter().println("Successful");
}else{
	//response.getWriter().println("Failed");
	out.println("Failed");
}

%>

</title>
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
      flex-direction: column;
      align-items: center;
      text-align: center;
    }

    .info-message {
      padding: 1rem;
      border-radius: 5px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
      background-color: #fff;
      margin: 2rem auto;
      max-width: 500px;
    }

    .info-message h2 {
      margin-bottom: 1rem;
      font-size: 1.25rem;
    }

    .info-message p {
      margin-bottom: 1rem;
      font-size: 1rem;
      line-height: 1.5;
    }

    .info-message a {
      color: #007bff;
      text-decoration: none;
      font-weight: bold;
    }
  </style>
</head>
<body>

  <div class="container">
    <header class="header">
      <h1>J Bank</h1>
      <a href="#">Home</a>
    </header>

    <main class="main-content">
      <div class="info-message">
        <h2>Information</h2>
        <p>
          <%
          
          String msg = request.getAttribute("message").toString();
          out.println(msg);
         
          //response.getWriter().println(msg);
    
          
          %>
        </p>
        <a href="loginpage.jsp">Return to Login Page</a>
      </div>
    </main>
  </div>

</body>
</html>