<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
<link rel="stylesheet" href="css/style2.css" />

</head>

<body>
	<div class="container">
		<div class="img_container">
			<img class="img_style" alt="no image" src="./assets/bgplain.jpg" />
		</div>
		<div class="form_container">
		<h2>Signup as admin user</h2>


		<form action="controller" method="post" class="login_form">

			<input type="hidden" value="signup_user" name="action">

			<div class="label-style">
				<input type="text" name="username" placeholder=""
					value="<%= request.getParameter("username") != null ? request.getParameter("username") : "" %>">
				<label for="username">enter the username</label>
			</div>
			<% String nameError = (String) request.getAttribute("nameError"); %>
			<% if (nameError != null) { %>
			<p class="error_message"><%= nameError %></p>
			<% } %>
			<div class="label-style">
				<input type="text" name="email" placeholder=""
					value="<%= request.getParameter("email") != null ? request.getParameter("email") : "" %>">
				<label for="email">enter the email</label>
			</div>
			<% String emailError = (String) request.getAttribute("emailError"); %>
			<% if (emailError != null) { %>
			<p class="error_message"><%= emailError %></p>
			<% } %>
			<div class="label-style">
				<input type="password" name="password" placeholder=""
					value="<%= request.getParameter("password") != null ? request.getParameter("password") : "" %>">
				<label for="password">enter the password</label>
			</div>
			<% String passwordError = (String) request.getAttribute("passwordError"); %>
			<% if (passwordError != null) { %>
			<p class="error_message"><%= passwordError %></p>
			<% } %>
			<input type="hidden" value="1" name="role_id">

			<button type="submit" class="login_btn">Sign Up</button>
		</form>
		<form class="new_user" action="controller" method="post">

			<p class="login_text">Already signed up? -</p>
			<button name="action" value="login" class="signup_button">Login
			</button>
		</form>
		</div>
	</div>
</body>
</html>
