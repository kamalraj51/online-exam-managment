<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="height: 100vh; width: 100vw; display: flex; justify-content: center; align-items: center;">
	<form action="controller" method="post" style="border: 2px solid black; padding: 10px;">
		
		<label>Enter the Exam Id</label>
		<input type="text" name="exam_id"><br><br>
		<input type="hidden" name="action" value="retire_exam_user">
		<button>Submit</button>
		
	</form>
	</div>
</body>
</html>