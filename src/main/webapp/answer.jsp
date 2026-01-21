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
		
		<label>Answer Id</label>
		<input type="text" name="answer_id"><br><br>
		<label>Options</label><br>
		<textarea rows="5" cols="30" name="option_text" required="required"></textarea><br><br>
		<label>Question Id</label>
		<input type="text" name="question_id" required="required"><br><br>
		
		<input type="radio" name="is_correct" value="true"><label>Correct</label>
		<input type="radio" name="is_correct" value="false"><label>Wrong</label>
		<br><br>
		
		<input type="submit" name="action" value="Add">
		<input type="submit" name="action" value="Done">
		
	</form>
	</div>
</body>
</html>