<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<% 

if(request.getSession().getAttribute("status") ==null || request.getSession().getAttribute("st") == null || request.getSession().getAttribute("sm") == null){
	response.sendRedirect("index.jsp");
}

%>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>J Bank - Status Page</title>
    <link rel="stylesheet" href="./css/dash.css">
</head>

<body>
    <header>
        <h1>J Bank</h1>
        <a href="logout" class="logout">Logout</a>
    </header>
    
    <section style="text-align: center; display: flex; flex-direction: column; justify-content: center; align-items: center; margin: 20px;">
    <div class="button-container-div">
    
    <div class=<%= request.getSession().getAttribute("status") %>>
    
    <h1><%= request.getSession().getAttribute("st") %></h1>
    <p> <%= request.getSession().getAttribute("sm") %> </p>    
    
    <a href=<%= request.getSession().getAttribute("loc") %>>Return</a>
    
    </div>
    
    </div>
    </section>
    
    <footer>
        <p>&copy; J Bank 2024</p>
    </footer>
</body>

</html>
