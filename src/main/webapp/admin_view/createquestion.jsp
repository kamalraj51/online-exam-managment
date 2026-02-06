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
<link rel="stylesheet" href="css/style2.css" />

</head>

<body>
	<div class="exam_container">
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
				value=<%=request.getSession().getAttribute("examId")%>
				required="required">

			<div class="label-style">
				<textarea rows="2" name="question_text<%=i%>" placeholder=""><%=request.getParameter("question_text" + i) != null ? request.getParameter("question_text" + i) : ""%></textarea>
				<label for="question_text<%=i%>">Enter the question...</label>
			</div>

			<%
			String questionError = (String) request.getAttribute("questionError");
			%>
			<%
			if (questionError != null) {
			%>
			<p class="error_message"><%=questionError%></p>

			<%
			}
			%>


			<h3>Answer</h3>
			<div class="option_container">
				<input type="radio" name="correct_option<%=i%>" value="1" required>
				<label> Option A </label>
			</div>

			<div class="label-style">
				<input type="text" name="option_1<%=i%>" placeholder=""
					value="<%=request.getParameter("option_1" + i) != null ? request.getParameter("option_1" + i) : ""%>">
				<label for="option_1<%=i%>">Enter the option a</label>
			</div>
			<%
			String option1_error = (String) request.getAttribute("option1_error");
			%>
			<%
			if (option1_error != null) {
			%>
			<p class="error_message"><%=option1_error%></p>

			<%
			}
			%>
			<div class="option_container">
				<input type="radio" name="correct_option<%=i%>" value="2" required>
				<label> Option B </label>
			</div>
			<div class="label-style">
				<input type="text" name="option_2<%=i%>" placeholder=""
					value="<%=request.getParameter("option_2" + i) != null ? request.getParameter("option_2" + i) : ""%>">
				<label for="option_2<%=i%>">Enter the option b</label>
			</div>
			<%
			String option2_error = (String) request.getAttribute("option2_error");
			%>
			<%
			if (option2_error != null) {
			%>
			<p class="error_message"><%=option2_error%></p>

			<%
			}
			%>

			<div class="option_container">
				<input type="radio" name="correct_option<%=i%>" value="3" required>
				<label> Option C </label>

			</div>
			<div class="label-style">
				<input type="text" name="option_3<%=i%>" placeholder=""
					value="<%=request.getParameter("option_3" + i) != null ? request.getParameter("option_3" + i) : ""%>">
				<label for="option_3<%=i%>">Enter the option c</label>
			</div>
			<%
			String option3_error = (String) request.getAttribute("option3_error");
			%>
			<%
			if (option3_error != null) {
			%>
			<p class="error_message"><%=option3_error%></p>

			<%
			}
			%>

			<div class="option_container">
				<input type="radio" name="correct_option<%=i%>" value="4" required>
				<label> Option-d </label>

			</div>
			<div class="label-style">
				<input type="text" name="option_4<%=i%>" placeholder=""
					value="<%=request.getParameter("option_4" + i) != null ? request.getParameter("option_4" + i) : ""%>">
				<label for="option_4<%=i%>">Enter the option d</label>
			</div>
			<%
			String option4_error = (String) request.getAttribute("option4_error");
			%>
			<%
			if (option4_error != null) {
			%>
			<p class="error_message"><%=option4_error%></p>

			<%
			}
			%>

			<%
			}
			%>

			<button name="action" value="submit" class="login_btn">Submit</button>
		</form>
		<form action="controller" method="post">
			<button name="action" value="create_exam" class="login_btn">Back To Exam</button>
		</form>
	</div>

</body>


</html>
