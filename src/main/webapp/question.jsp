<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question</title>
</head>
<body>
	<div style="height: 100vh; width: 100vw; display: flex; justify-content: center; align-items: center;">
	<form action="controller" method="post" style="border: 2px solid black; padding: 10px;">
		
		<label>Question Id</label>
		<input type="text" name="question_id" required="required"><br><br>
		<label>Exam Id</label>
		<input type="text" name="exam_id" required="required"><br><br>
		<label>Question</label><br>
		<textarea rows="5" cols="30" name="question_text" required="required"></textarea><br><br>
		<label>Marks</label>
		<input type="text" name="marks"><br><br>
		
		
		<input type="submit" name="action" value="Answers">
		
		
	</form>
	</div>
</body>
</html>