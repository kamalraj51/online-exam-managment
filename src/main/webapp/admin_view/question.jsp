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
<link rel="stylesheet" href="css/style.css"/>
<style>
lable{
color:white;
text-shadow: 2px 1px black;
}
</style>
</head>

<body style="background-image: url('assets/bgplain.jpg'); background-size: 100%; background-repeat: no-repeat; background-attachment : fixed;">
	<div class="question_container">
			<h2>Add Questions</h2>
		<form action="controller" method="post" class="createquestion_form">
			<%
			int questions = (Integer) session.getAttribute("noOfQuestions");
			for (int i = 1; i <= questions; i++) {
			%>
			<h3>
				Question No.
				<%=i%></h3>

			<input type="hidden" name="exam_id"
				value=<%=request.getAttribute("examId")%> required="required">

			
			<textarea rows="3" name="question_id<%=i%>" required="required" placeholder="enter the question..."></textarea>

			 <input type="text" name="marks<%=i%>" placeholder="enter the mark"><br>


			<h3>Answer</h3>
			<div style="display: flex; gap:20px">
			<input type="radio" name="correct_option_1<%=i %>" value="true"> <lable> Correct </lable>
			<input type="radio" name="correct_option_1<%=i %>" value="false"> <lable> Wrong</lable>
			</div>
			<input type="text" name="option_1<%=i %>" required placeholder="enter the option a"> <br>
			<div style="display: flex; gap:20px">
			<input type="radio" name="correct_option_2<%=i %>" value="true"> <lable> Correct </lable>
			<input type="radio" name="correct_option_2<%=i %>" value="false"> <lable> Wrong</lable>
			</div>
			<input type="text" name="option_2<%=i %>" required placeholder="enter the option b"> 
		    <div style="display: flex; gap:20px">
		    <input type="radio" name="correct_option_3<%=i %>" value="true"> <lable> Correct </lable>
			<input type="radio" name="correct_option_3<%=i %>" value="false"> <lable> Wrong</lable>
			</div>
		    <input type="text" name="option_3<%=i %>" required placeholder="enter the option c"> 
		    <div style="display: flex; gap:20px">
		    <input type="radio" name="correct_option_4<%=i %>" value="true"> <lable> Correct </lable>
			<input type="radio" name="correct_option_4<%=i %>" value="false"> <lable> Wrong</lable>
			</div>
		    <input type="text" name="option_4<%=i %>" required placeholder="enter the option d"><br> 
			
			

			<%
			}
			%>

			<button name="action" value="submit">Submit</button>
		</form>
	</div>
</body>
</html>