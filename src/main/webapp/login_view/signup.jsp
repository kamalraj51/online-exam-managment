<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
<style>
input:required::after {
    content: '';
    display: none; /* Hide the red asterisk */
}

input:required:invalid {
    border-color: red;  /* This will make the border red if the field is invalid */
}

input:required:focus {
    border-color: #4CAF50;  /* Make border green when the field is focused (optional) */
}

label::after {
    content: '*'; 
    color: red;
    margin-left: 5px;  /* Space between label and asterisk */
}

</style>
<link rel="stylesheet" href="css/style.css" />

</head>

<body style="background-image: url('assets/bgplain.jpg'); background-size: 100%; background-repeat: no-repeat;">
	<div class="signup_container">

		<h2>Sign up as user</h2>


		<form action="controller" method="post" class="signup_form">

			<input type="hidden" value="signup_user" name="action">
			
			<div class="label-style">
			<input type="text" name="username" placeholder=""  required value="<%= request.getParameter("username") != null ? request.getParameter("username") : "" %>">
			 <label for = "username">enter the username</label>
			</div>
			<div class="label-style">
			<input type="text" name="email" placeholder="" required  value="<%= request.getParameter("email") != null ? request.getParameter("email") : "" %>">
			<label for = "email">enter the email</label>
			</div>
			 <% String error = (String) request.getAttribute("error"); %>
		        <% if (error != null) { %>
		        <p style="color:red; font-size: 12px; font-weight: bold; text-shadow: none;"><%= error %></p>
		        <% } %>
			<div class="label-style">
			<input type="password" name="password" placeholder=""  required value="<%= request.getParameter("password") != null ? request.getParameter("password") : "" %>"> 
			<label for = "password">enter the password</label>
			</div>

		
			<input type="hidden" value="2" name="role_id">

			<button type="submit" class="signup_btn">Sign Up</button>
		</form>
		<form class="new_user" action="controller" method="post" >
        
            <p class="login_text">Already signed up? - </p> 
            <button name="action" value="login" class="signup_button" >login </button>
        </form>
	</div>
</body>
</html>
