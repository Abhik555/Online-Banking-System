<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBank SignUp</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f0f0f0;
}

.header {
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 1rem 2rem;
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

/* Signup Form Styles */
.signup-form {
	display: flex;
	flex-direction: column;
	align-items: center;
	padding: 2rem;
	border: 1px solid #ddd;
	border-radius: 5px;
	margin-top: 5rem;
	background-color: #fff;
	width: fit-content;
	border-radius: 15px;
}

.signup-form h2 {
	margin-bottom: 1rem;
}

.signup-input {
	width: 60%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 3px;
	margin-bottom: 1rem;
}

.signup-button {
	padding: 10px 20px;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.signup-button:hover {
	background-color: #0062cc;
}

.container-div {
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: center;
}

.form-box {
	align-items: center;
	text-align: center;
}
</style>
</head>
<body>
	<header class="header">
		<div>https://www.jbank.com</div>
		<h1>J Bank</h1>
		<a href="login.html" class="login-button">Login</a>
	</header>

	<div class="container-div">
		<section class="signup-form">
			<h2>Sign Up</h2>
			<form action="register" method="post" class="form-box">
			<input type="text" name="username" class="signup-input"
					placeholder="Username" required>
				<input type="text" name="firstname" class="signup-input"
					placeholder="First Name" required> <input type="text"
					name="lastname" class="signup-input" placeholder="Last Name"
					required> <input type="email" name="email"
					class="signup-input" placeholder="Email Address" required>
				<input type="password" name="password" class="signup-input"
					placeholder="Password" required> <input type="tel"
					name="phone" class="signup-input" placeholder="Phone Number">
				<input type="text" name="location" class="signup-input"
					placeholder="Location (City, State)"> <br>
				<button type="submit" class="signup-button">Sign Up</button>
			</form>
		</section>
	</div>
</body>
</html>