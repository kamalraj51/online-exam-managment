<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Exam</title>
<link rel="stylesheet" href="css/style.css" />

</head>

<body
	style="background: radial-gradient(circle farthest-corner at center, #4fe3b1 0%, #2fbf9b 30%, #0f6f5f 55%, #061318 100%);">
	<div class="exam_container">
		<h2>Create Exam</h2>
		<form action="controller" method="post" class="createexam_form">

			<input type="hidden" name="action" value="create_exam_user">
			<% String examError = (String) request.getAttribute("examError"); %>
			<% if (examError != null) { %>
			<p class="error_message"><%=examError %></p>
			<%} %>
			<div class="label-style">
				<input type="text" name="exam_topic" required placeholder=""
					value="<%=request.getParameter("exam_topic")!= null ? request.getParameter("exam_topic") : ""%>">
				<label for="exam_topic">enter the topic</label>
			</div>

			<div class="label-style">
				<input type="text" name="exam_name" required placeholder="">
				<label for="exam_name">enter the exam name</label>
			</div>

			<div class="label-style">
				<input type="text" name="description" required placeholder=""
					value="<%=request.getParameter("description")!= null ? request.getParameter("description") : ""%>">
				<label for="description">enter the description</label>
			</div>

			<div class="label-style">
				<input type="number" name="add_question" required placeholder=""
					value="<%=request.getParameter("add_question")!= null ? request.getParameter("add_question") : ""%>">
				<label for="add_question">number of questions</label>
			</div>

			<div class="label-style">
				<input type="number" name="pass_min_correct" required placeholder=""
					value="<%=request.getParameter("pass_min_correct")!= null ? request.getParameter("pass_min_correct") : ""%>">
				<label for="pass_min_correct">enter the minimum marks</label>
			</div>

			<div class="label-style">
				<input type="number" name="total_marks" required placeholder=""
					value="<%=request.getParameter("total_marks")!= null ? request.getParameter("total_marks") : ""%>">
				<label for="total_marks">enter the total marks</label>
			</div>

			<div class="label-style">
				<input type="number" name="duration_minutes" required="required"
					placeholder=""
					value="<%=request.getParameter("duration_minutes")!= null ? request.getParameter("duration_minutes") : ""%>">
				<label for="duration_minutes">enter the total duration</label>
			</div>



			<button>Create</button>
		</form>
		<form method="post" action="controller"
			style="display: flex; gap: 20px;">
			<button name="action" value="cancel">Cancel</button>
		</form>
	</div>
</body>
</html>
