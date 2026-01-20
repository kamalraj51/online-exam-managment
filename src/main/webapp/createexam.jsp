<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Exam</title>
</head>
<body>
	<div style="height: 100vh; width: 100vw; display: flex; justify-content: center; align-items: center;">
	<form action="controller" method="post" style="border: 2px solid black; padding: 10px;">
		<input type="hidden" name="action" value="create_exam">
		<label>Exam Id</label>
		<input type="text" name="exam_id" required="required"><br><br>
		<label>Topic</label>
		<input type="text" name="exam_topic" required="required"><br><br>
		<label>Name</label>
		<input type="text" name="exam_name" required="required"><br><br>
		<label>Description</label>
		<input type="text" name="description" required="required"><br><br>
		<label>Status</label>
		<input type="checkbox" name="status" value="Active"><label>Active</label>
		<input type="checkbox" name="status" value="Retired"><label>Retired</label><br><br>
		<label>Minimum Correct Answer</label>
		<input type="text" name="pass_min_correct" required="required"><br><br>
		<label>Total Marks</label>
		<input type="text" name="total_marks" required="required"><br><br>
		<label>Duration</label>
		<input type="text" name="duration_minutes"><br><br>
		<input type="hidden" name="user_id" value="1">
		<button>Create</button>
		
	</form>
	
	</div>
	
</body>
</html>