<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        background-image: url('assets/plainbg.jpg'); 
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
    }

    form {
    		box-shadow: 0 4px 6px black;
        padding: 30px 40px;
        border-radius: 6px;
        width: 320px;
    }

    label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
        color: black;
    }

    input {
        width: 100%;
        padding: 8px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 4px;
        background-color: none;
    }

   button {
        text-decoration: none;
        border:none;
      	background-color: #75B06F;
      	color:white;
        padding: 12px 25px;
        border-radius: 5px;
        font-size: 18px;
        letter-spacing:2px;
        width: 200px;
        text-align: center;
        transition: background-color 0.3s;
    }

    button:hover {
        background-color: #628141;
    }
</style>
<link rel="stylesheet" href="css/style.css"/>
</head>

<body>
    <div class="container">
        <h2 style="color: white;">Signup Page</h2>

        <form action="controller" method="post">
            <input type="hidden" value="signup_user" name="action">

           
            <input type="text" name="username" placeholder="Enter the username">

            
            <input type="email" name="email"  placeholder="Enter the email">

            
            <input type="password" name="password"  placeholder="Enter the password">

            <input type="hidden" value="2" name="role_id">

            <button type="submit">Sign Up</button>
        </form>
    </div>
</body>
</html>
