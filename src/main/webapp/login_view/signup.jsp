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
        background-color: #f4f6f8;
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
        color: #333;
    }

    form {
        background-color: #ffffff;
        border: 1px solid #ccc;
        padding: 30px 40px;
        border-radius: 6px;
        box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        width: 320px;
    }

    label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
        color: #555;
    }

    input {
        width: 100%;
        padding: 8px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    button {
        width: 100%;
        padding: 10px;
        background-color: #28a745;
        border: none;
        color: white;
        font-size: 16px;
        border-radius: 4px;
        cursor: pointer;
    }

    button:hover {
        background-color: #218838;
    }
</style>
<link rel="stylesheet" href="css/style.css"/>
</head>

<body>
    <div class="container">
        <h2>Signup Page</h2>

        <form action="controller" method="post">
            <input type="hidden" value="signup_user" name="action">

            <label for="username">User Name</label>
            <input type="text" name="username">

            <label for="email">Email</label>
            <input type="email" name="email">

            <label for="password">Password</label>
            <input type="password" name="password">

            <input type="hidden" value="2" name="role_id">

            <button type="submit">Sign Up</button>
        </form>
    </div>
</body>
</html>
