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
        <h2>Login As user</h2>

        <form action="controller?action=login_user" method="post" class = "login_form">
            <!-- <input type="hidden" value="login_user" name="action">-->

            <div class="label-style">
            <input type="text" name="email" required class = "text"  placeholder="">
            <label for = "email">enter your email</label>
            </div>
            
            <div class="label-style">
            <input type="password" name="password" required class = "password" placeholder="">
            <label for = "password">enter your password</label>
            </div>
            
            <input type="submit" value="Login" class = "login_btn">
        </form>
        <form class="new_user" action="controller" method="post" >
        
            <p class="login_text">New User - </p> <button name="action" value="signup" class="signup_button" >Signup </button>
        </form>
        </div>
</body>
<script type="text/javascript">

	
</script>
</html>
