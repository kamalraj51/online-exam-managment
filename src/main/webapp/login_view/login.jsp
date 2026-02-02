<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
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
<link rel="stylesheet" href="css/style.css"/>
</head>

<body style="background-image: url('assets/bgplain.jpg'); background-size: 100%; background-repeat: no-repeat;">
  
   <div class="login_container">
        <h2>Login As user</h2>

        <form action="controller?action=login_user" method="post" class = "login_form">
            <!-- <input type="hidden" value="login_user" name="action">-->

            <div class="label-style">
            <input type="text" name="email" required class = "text"  placeholder="" value="<%= request.getParameter("email") != null ? request.getParameter("email") : "" %>">
            <label for = "email">enter your email</label>
            </div>
            
            <div class="label-style">
            <input type="password" name="password" required class = "password" placeholder="" value="<%= request.getParameter("password") != null ? request.getParameter("password") : "" %>">
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
