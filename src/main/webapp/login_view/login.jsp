<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>


<link rel="stylesheet" href="css/style.css"/>
</head>

<body>
    <div class = "login_body">
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
    </div>
</body>
</html>
