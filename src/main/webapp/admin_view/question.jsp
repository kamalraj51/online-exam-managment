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

<body style="background: radial-gradient(
  circle farthest-corner at center,
  #4fe3b1 0%,
  #2fbf9b 30%,
  #0f6f5f 55%,
  #061318 100%
);

">
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

			<div class="label-style">
			<textarea rows="3" name="question_id<%=i%>" required="required" placeholder=""></textarea>
			<label for = "question_id<%=i%>">enter the question...</label>
			</div>
       

			<h3>Answer</h3>
			<div style="display: flex; gap:20px" >
			<input type="radio" name="correct_option_1<%=i %>" value="true" required> <lable> Correct </lable>
			<input type="radio" name="correct_option_1<%=i %>" value="false" required> <lable> Wrong</lable>
			</div>
			<div class="label-style">
			<input type="text" name="option_1<%=i %>" required placeholder=""> 
			<label for = "option_1<%=i %>">enter the option a</label>
			</div>
			<div style="display: flex; gap:20px">
			<input type="radio" name="correct_option_2<%=i %>" value="true" required> <lable> Correct </lable>
			<input type="radio" name="correct_option_2<%=i %>" value="false" required> <lable> Wrong</lable>
			</div>
			<div class="label-style">
			<input type="text" name="option_2<%=i %>" required placeholder=""> 
			<label for = "option_2<%=i %>">enter the option b</label>
			</div>
		    <div style="display: flex; gap:20px">
		    <input type="radio" name="correct_option_3<%=i %>" value="true" required> <lable> Correct </lable>
			<input type="radio" name="correct_option_3<%=i %>" value="false" required> <lable> Wrong</lable>
			</div>
			<div class="label-style">
		    <input type="text" name="option_3<%=i %>" required placeholder=""> 
		    <label for = "option_3<%=i %>">enter the option c</label>
		    </div>
		    <div style="display: flex; gap:20px">
		    <input type="radio" name="correct_option_4<%=i %>" value="true" required> <lable> Correct </lable>
			<input type="radio" name="correct_option_4<%=i %>" value="false" required> <lable> Wrong</lable>
			</div>
			<div class="label-style">
		    <input type="text" name="option_4<%=i %>" required placeholder=""><br> 
		    <label for = "option_4<%=i %>">enter the option d</label>
			</div>
			

			<%
			}
			%>

			<button name="action" value="submit">Submit</button>
		</form>
	</div>
</body>
</html>