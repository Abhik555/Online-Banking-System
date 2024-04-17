<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
	/*
	 <!DOCTYPE html>
	 <html>
	 <head>
	 <meta charset="UTF-8">
	 <title>Bank Login</title>
	 <link rel="stylesheet" href="/css/loginpage.css">
	 </head>
	 <body>
	 <h1>Welcome to Your Bank</h1>
	 <div class="login-form">
	 <form method="get" action="login">
	 <h2>Login</h2>
	 <input type="text" name="username" >
	 <input type="text" name="username" >
	 <input type="submit" name="username" >
	 </form>
	 </div>
	 </body>
	 </html>
	 */
</script>

<!DOCTYPE html>
<html lang="en">

<%
if (request.getSession().getAttribute("user") != null && request.getSession().getAttribute("User-Data") != null) {

	request.getRequestDispatcher("/dashboard.jsp").forward(request, response);

}
%>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Secure Bank - Login</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f0f0f0;
	text-align: center;
}

.error-message {
	background-color: #f8d7da;
	color: #721c24;
	padding: 10px 15px;
	border-radius: 5px;
	margin: 20px auto;
	width: 80%;
	text-align: center;
	box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
}

.header {
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 1rem 1rem;
	background-color: #333;
	color: #fff;
}

.header h1 {
	margin: 0;
}

.login-button {
	padding: 10px 20px;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.login-button:hover {
	background-color: #0062cc;
}

/* Login Form Styles */
.login-form {
	display: flex;
	flex-direction: column;
	align-items: center;
	padding: 2rem;
	border: 1px solid #ddd;
	border-radius: 5px;
	margin-top: 5rem;
	background-color: #fff;
	border-radius: 30px;
	width: fit-content;
	justify-content: center;
}

.login-form h2 {
	margin-bottom: 1rem;
}

.login-input {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 3px;
	margin-bottom: 1rem;
}

.login-button {
	padding: 10px 20px;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	align-items: center;
	text-align: center;
	display: flex;
}

.login-button:hover {
	background-color: #0062cc;
}

.login-box {
	display: flex;
	justify-content: center;
}
</style>
</head>
<body>
	<header class="header">
		<div>https://www.jbank.com</div>
		<h1>JBank</h1>
		<a href="index.jsp" class="login-button">Home</a>
	</header>

<% if( request.getSession().getAttribute("loginerror") != null && request.getSession().getAttribute("loginerror").equals("true")) {  %>
	<div class="error-message">
		<strong>Error:</strong> Invalid Credentials.
	</div>
	<% 
	request.getSession().setAttribute("loginerror", "false");
	%>
<% } %>

	<div class="login-box">
		<section class="login-form">
			<h2>Login</h2>
			<form action="login" method="post">
				<input type="text" name="accountid" class="login-input"
					placeholder="AccountID" required> <input type="password"
					name="password" class="login-input" placeholder="Password" required>
				<button type="submit" class="login-button">Login</button>
			</form>
		</section>
	</div>
</body>
</html>
