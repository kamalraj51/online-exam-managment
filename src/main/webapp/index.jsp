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
        height: 100vh;
        width: 100vw;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    form {
    		display:flex;
    		flex-direction:column;
    		gap:10px;
    		height:200px;
        padding: 30px 40px;
        border-radius: 6px;
        box-shadow: 0 4px 6px black;
        text-align: center;
        justify-content:center;
        align-items: center;
    }
 button {
        text-decoration: none;
        border:none;
      	background-color: #75B06F;
      	color:white;
        padding: 12px 25px;
        border-radius: 5px;
        font-size: 18px;
        font-weight:bold;
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

<body style="background-image: url('assets/bg.jpg'); background-size: 100%; background-repeat: no-repeat;">

    <div class="container">
        <form action="controller" method="post">
           	<button name="action" value="signup">Signup</button>
           	<button name="action" value="login">Login</button>
        </form>
    </div>
</body>
</html>
