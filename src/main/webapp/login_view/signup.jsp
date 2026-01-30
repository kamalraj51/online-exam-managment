<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
<link rel="stylesheet" href="css/style.css" />
</head>

<body style="background-image: url('assets/bgplain.jpg'); background-size: 100%; background-repeat: no-repeat;">
	<div class="signup_container">

		<h2>Sign up as user</h2>


		<form action="controller" method="post" class="signup_form">

			<input type="hidden" value="signup_user" name="action">
			
			<div class="label-style">
			<input type="text" name="username" placeholder="">
			 <label for = "username">enter the username</label>
			</div>
			<div class="label-style">
			<input type="text" name="email" placeholder="" >
			<label for = "email">enter the email</label>
			</div>
			 <% String error = (String) request.getAttribute("error"); %>
		        <% if (error != null) { %>
		        <p style="color:red; font-size: 12px; font-weight: bold; text-shadow: none;"><%= error %></p>
		        <% } %>
			<div class="label-style">
			<input type="password" name="password" placeholder=""> 
			<label for = "password">enter the password</label>
			</div>

		
			<input type="hidden" value="2" name="role_id">

			<button type="submit" class="signup_btn">Sign Up</button>
		</form>
		<form class="new_user" action="controller" method="post" >
        
            <p class="login_text">Already signed up? - </p> <button name="action" value="login" class="signup_button" >login </button>
        </form>
	</div>
</body>
</html>
