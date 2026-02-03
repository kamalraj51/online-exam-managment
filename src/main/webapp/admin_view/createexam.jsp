<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Exam</title>


<style>
input:required::after {
    content: '';
    display: none; /* Hide the red asterisk */
}

input:required:invalid {
    border-color: red;  /* This will make the border red if the field is invalid */
}

input:required:focus {
    border-color: #4CAF50;  /* Make border green when the field is focused (optional) */
}

label::after {
    content: '*'; 
    color: red;
    margin-left: 5px;  /* Space between label and asterisk */
}

</style>
<link rel="stylesheet" href="css/style.css"/>
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
				<input type="text" name="exam_topic" placeholder=""
					value="<%=request.getParameter("exam_topic")!= null ? request.getParameter("exam_topic") : ""%>">
				<label for="exam_topic">Enter the topic</label>
			</div>
			<% String examTopicError = (String) request.getAttribute("examTopicError"); %>
		        <% if (examTopicError != null) { %>
		        <p class="error_message"><%= examTopicError %></p>
		        <% } %>
			

			<div class="label-style">
				<input type="text" name="exam_name" placeholder="" 
				     value="<%=request.getParameter("exam_name")!= null ? request.getParameter("exam_name") : ""%>" >
				<label for="exam_name">Enter the exam name</label>
			</div>
			<% String examNameError = (String) request.getAttribute("examNameError"); %>
		        <% if (examNameError != null) { %>
		        <p class="error_message"><%= examNameError %></p>
		        <% } %>

			<div class="label-style">
				<input type="text" name="description" placeholder=""
					value="<%=request.getParameter("description")!= null ? request.getParameter("description") : ""%>">
				<label for="description">Enter the description</label>
			</div>
			<% String descriptionError = (String) request.getAttribute("descriptionError"); %>
		        <% if (descriptionError != null) { %>
		        <p class="error_message"><%= descriptionError %></p>
		        <% } %>

			<div class="label-style">
				<input type="number" name="no_of_question" placeholder=""
					value="<%=request.getParameter("no_of_question")!= null ? request.getParameter("no_of_question") : ""%>">
				<label for="no_of_question">Number of questions</label>
			</div>
			<% String addQuestionError = (String) request.getAttribute("addQuestionError"); %>
		        <% if (addQuestionError != null) { %>
		        <p class="error_message"><%= addQuestionError %></p>
		        <% } %>

			<div class="label-style">
				<input type="number" name="pass_min_correct" placeholder=""
					value="<%=request.getParameter("pass_min_correct")!= null ? request.getParameter("pass_min_correct") : ""%>">
				<label for="pass_min_correct">Enter the minimum marks</label>
			</div>
			<% String minCorrectError = (String) request.getAttribute("minCorrectError"); %>
		        <% if ( minCorrectError != null) { %>
		        <p class="error_message"><%=  minCorrectError %></p>
		        <% } %>
			<div class="label-style">
				<input type="number" name="each_question_mark"  placeholder=""
					value="<%=request.getParameter("each_question_mark")!= null ? request.getParameter("each_question_mark") : ""%>">
				<label for="each_question_mark">Enter the each question mark</label>
			</div>
			<% String eachQuestionMarkError = (String) request.getAttribute("eachQuestionMarkError"); %>
		        <% if ( eachQuestionMarkError != null) { %>
		        <p class="error_message"><%= eachQuestionMarkError %></p>
		        <% } %>

			<div class="label-style">
				<input type="number" name="duration_minutes" placeholder=""
					value="<%=request.getParameter("duration_minutes")!= null ? request.getParameter("duration_minutes") : ""%>">
				<label for="duration_minutes">Enter the total duration</label>
			</div>
			<% String durationMinError = (String) request.getAttribute("durationMinError"); %>
		        <% if ( durationMinError != null) { %>
		        <p class="error_message"><%= durationMinError %></p>
		        <% } %>

			<button>Create</button>
		</form>
		<form method="post" action="controller"
			style="display: flex; gap: 20px;">
			<button name="action" value="cancel">Cancel</button>
		</form>
	</div>
</body>
</html>
