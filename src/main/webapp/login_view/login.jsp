<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<style type="text/css">

    .container_login {
        height: 100vh;
        width: 100vw;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
    }

    h2 {
        margin-bottom: 20px;
        color: #333;
    }

    .login {
        background-color: #ffffff;
        border: 1px solid #ccc;
        padding: 30px 40px;
        border-radius: 6px;
        box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        width: 320px;
    }

    .form_label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
        color: #555;
    }

    .text{
        width: 100%;
        padding: 8px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    
    .password{
        width: 100%;
        padding: 8px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    

    .submit {
        width: 100%;
        padding: 10px;
        background-color: #007bff;
        border: none;
        color: white;
        font-size: 16px;
        border-radius: 4px;
        cursor: pointer;
    }

    .submit:hover {
        background-color: #0056b3;
    }
</style>
<link rel="stylesheet" href="css/style.css"/>
</head>

<body>
  
    <div class="container_login">
        <h2>Login Page</h2>

        <form action="controller" method="post" class = "login">
            <input type="hidden" value="login_user" name="action">

            <label class = "form_label">Email</label>
            <input type="text" name="email" required class = "text">

            <label  class = "form_label">Password</label>
            <input type="password" name="password" required class = "password">

            <input type="submit" value="Login" class = "submit">
        </form>
        </div>
</body>
</html>
