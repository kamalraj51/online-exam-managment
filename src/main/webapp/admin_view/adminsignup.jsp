<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>


<link rel="stylesheet" href="css/style.css"/>
</head>
<body style="background-image: url('assets/bgplain.jpg'); background-size: 100%; background-repeat: no-repeat;">
    <jsp:include page="/common/header.jsp"/>
<!-- this is dedicated for admin signup by kamal -->
    <div class="signup_container">
        <h2>Admin Signup Page</h2>

        <form action="controller" method="post" class="signup_form">
			<input type="hidden" value="signup_user" name="action"> 
			<input type="text" name="username" placeholder="enter the username">
			<input type="email" name="email" placeholder="enter the email">
			<input type="password" name="password" placeholder="enter the password"> 
			<input type="hidden" value="2" name="role_id">

			<button type="submit" class="signup_btn">Sign Up</button>
		</form>
    </div>
    <jsp:include page="/common/footer.jsp"/>
</body>
</html>
