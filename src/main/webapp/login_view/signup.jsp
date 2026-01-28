<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
<link rel="stylesheet" href="css/style.css"/>
<style>
    body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        background-image: url('assets/bgplain.jpg'); 
        background-size: 100%; 
        background-repeat: no-repeat;
    }

    .container {
        height: 100vh;
        width: 100vw;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
    }

    h2 {
        margin-bottom: 20px;
        color: white;
        text-transform: uppercase;
        letter-spacing: 2px;
    }

    .signuo_form {
        width: 320px;
        height: 350px;
    	box-shadow: 0 4px 6px black;
        border-radius: 6px;
    }




</style>
<link rel="stylesheet" href="css/style.css"/>
</head>

<body>
    <div class="container">
        <h2 style="color: white;">Signup Page</h2>

        <form action="controller" method="post" class="singup_form">
            <input type="hidden" value="signup_user" name="action">

           
            <input type="text" name="username" placeholder="enter the username">

            
            <input type="email" name="email"  placeholder="enter the email">

            
            <input type="password" name="password"  placeholder="enter the password">

            <input type="hidden" value="2" name="role_id">

            <button type="submit">Sign Up</button>
        </form>
    </div>
</body>
</html>
