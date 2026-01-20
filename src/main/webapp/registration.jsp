<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/exam/controller" method="post">
	<input type="hidden" value="/login" name="/action">
	
	<label for="username">UserName: </label>
	<input type="text" name="username">
	<label for="username">Email   : </label>
	<input type="email" name="email">
	<label for="password">Password: </label>
	<input type="password" name="password">
	<input type="hidden" value="2" name="role_id">
	
	<button type="submit">SignUp</button>
	</form>
</body>
</html>