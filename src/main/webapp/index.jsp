<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Exam</title>
<link rel="stylesheet" href="css/style.css"/>
<style>


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
	display: flex;
	flex-direction: column;
	gap: 10px;
	height: 200px;
	padding: 30px 40px;
	border-radius: 6px;
	box-shadow: 0 4px 6px black;
	text-align: center;
	justify-content: center;
	align-items: center;
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
