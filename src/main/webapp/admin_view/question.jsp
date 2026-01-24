<%@page import="java.util.ArrayList"%>
<%@page import="com.vastpro.onlineexam.dto.QuestionDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question</title>

<style>
body {
	margin: 0;
	padding: 0;
	font-family: Arial, sans-serif;
	background-color: #f4f6f8;
}

.container {
	min-height: 100vh;
	width: 100vw;
	display: flex;
	justify-content: center;
	align-items: flex-start;
	padding-top: 40px;
	box-sizing: border-box;
}

form {
	background-color: #ffffff;
	border: 1px solid #ccc;
	padding: 25px 30px;
	border-radius: 6px;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
	width: 420px;
	box-sizing: border-box;
}

h2 {
	text-align: center;
	margin-bottom: 20px;
	color: #333;
}

label {
	display: inline;
	font-weight: bold;
	margin-bottom: 5px;
	color: #555;
}

input[type="text"], textarea {
	width: 100%;
	padding: 8px;
	margin-bottom: 15px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	font-family: Arial, sans-serif;
}

textarea {
	resize: vertical;
}

input[type="submit"] {
	width: 100%;
	padding: 10px;
	background-color: #007bff;
	border: none;
	color: white;
	font-size: 16px;
	border-radius: 4px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #0056b3;
}
</style>
</head>

<body>
	<div class="container">
		<form action="controller" method="post">
			<h2>Add Question</h2>
			<%
			int questions = (Integer) session.getAttribute("questions");
			for (int i = 1; i <= questions; i++) {
			%>
			<h2>
				Question No.
				<%=i%></h2>

			<input type="hidden" name="exam_id"
				value=<%=request.getAttribute("examId")%> required="required">

			<label>Question</label>
			<textarea rows="5" name="question_id<%=i%>" required="required"></textarea>

			<label>Marks</label> <input type="text" name="marks<%=i%>">


			<h2>Answer</h2>

			
			<label>Option 1</label>
			<input type="radio" name="correct_option_1<%=i %>" value="true">Correct
			<input type="radio" name="correct_option_1<%=i %>" value="false">Wrong
			<input type="text" name="option_1<%=i %>" required> 
			<label>Option 2</label> 
			<input type="radio" name="correct_option_2<%=i %>" value="true">Correct
			<input type="radio" name="correct_option_2<%=i %>" value="false">Wrong
			<input type="text" name="option_2<%=i %>" required> 
		    <label>Option 3</label> 
		    <input type="radio" name="correct_option_3<%=i %>" value="true">Correct
			<input type="radio" name="correct_option_3<%=i %>" value="false">Wrong
		    <input type="text" name="option_3<%=i %>" required> 
		    <label>Option 4</label>
		    <input type="radio" name="correct_option_4<%=i %>" value="true">Correct
			<input type="radio" name="correct_option_4<%=i %>" value="false">Wrong
		     <input type="text" name="option_4<%=i %>" required>

			<%
			}
			%>

			<input type="submit" name="action" value="Submit">
		</form>
	</div>
</body>
</html>