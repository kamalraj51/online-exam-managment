<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>

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
        gap: 15px;
    }

    h1 {
        margin-bottom: 20px;
        color: #333;
    }

    button {
        text-decoration: none;
        background-color: #343a40;
        color: white;
        padding: 12px 25px;
        border-radius: 5px;
        font-size: 16px;
        width: 200px;
        text-align: center;
        transition: background-color 0.3s;
    }

    button:hover {
        background-color: #23272b;
    }
</style>
</head>

<body>
    <div class="container">
        <h1>ADMIN PAGE</h1>

    
         <form action="controller" method="post">
           

            <button  name="action" value="create_exam"> Create Exam</button>
            <button  name="action" value="retire_exam"> Retire Exam</button>
        </form>
    </div>
</body>
</html>
