<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>authorize</title>
</head>
<body>
	<form action="controller" method="post">
	
	<input type="hidden" name="role" value=<%=request.getAttribute("role") %>> 
	<input type="hidden" name="action" value="authorize">
	<input type="submit" value="submit">
	</form>
</body>
</html>