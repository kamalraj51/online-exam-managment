<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Exam</title>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        background-color: #f4f6f8;
    }

    h1 {
        text-align: center;
        margin-top: 40px;
        color: #333;
    }

    .container {
        height: 400px;
        width: 100vw;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    form {
        background-color: #ffffff;
        border: 1px solid #ccc;
        padding: 30px 40px;
        border-radius: 6px;
        box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        text-align: center;
    }

    a {
        display: block;
        text-decoration: none;
        color: #ffffff;
        background-color: #007bff;
        padding: 10px;
        margin: 10px 0;
        border-radius: 4px;
        font-weight: bold;
    }

    a:hover {
        background-color: #0056b3;
    }
</style>
</head>

<body>
    <h1>Online Exam</h1>

    <div class="container">
        <form action="controller" method="post">
            <a href="signup.jsp">Signup</a>
            <a href="login.jsp">Login</a>
        </form>
    </div>
</body>
</html>
