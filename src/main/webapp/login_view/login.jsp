<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="css/style.css"/>
</head>

<body style="background-image: url('assets/bgplain.jpg'); background-size: 100%; background-repeat: no-repeat;">
  
   <div class="login_container">
        <h2>Login Page</h2>

        <form action="controller" method="post" class = "login_form">
            <input type="hidden" value="login_user" name="action">

            
            <input type="text" name="email" required class = "text"  placeholder="enter your email">

            <input type="password" name="password" required class = "password" placeholder="enter your password">

            <input type="submit" value="Login" class = "login_btn">
        </form>
        </div>
</body>
</html>
