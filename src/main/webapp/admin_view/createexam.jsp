<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import ="com.vastpro.onlineexam.dto.ExamDTO" %>
<%

String examTopic = null;
String examName = null;
String description = null;
Integer passMinCorrect = null;
Integer durationMinutes = null;
Integer createdBy = null;
Integer totalMark = null; 
Integer noOfQuestion = null;
Integer eachQuestionMark = null;
ExamDTO exam = (ExamDTO) request.getSession().getAttribute("createExamData");
if(exam!=null){
examTopic = exam.getExamTopic();
examName = exam.getExamName();
description = exam.getDescription();
passMinCorrect = exam.getPassMarks();
durationMinutes = exam.getDuration();
createdBy = exam.getCreatedBy();
totalMark = exam.getTotalMarks();
noOfQuestion = exam.getNumberOfQuestion();
eachQuestionMark = exam.getEachMark();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Exam</title>
<link rel="stylesheet" href="css/style2.css"/>
</head>

<body>
	<div class="exam_container">
		<h2>Create Exam</h2>
		<form action="controller" method="post" class="createexam_form">

			<input type="hidden" name="action" value="create_exam_user">
			
			
			<div class="label-style">
				<input type="text" name="exam_topic" placeholder=""
					value="<%=(examTopic!= null) ? examTopic: ""%>">
				<label for="exam_topic">Enter the topic</label>
			</div>
			<% String examTopicError = (String) request.getAttribute("examTopicError"); %>
		        <% if (examTopicError != null) { %>
		        <p class="error_message"><%= examTopicError %></p>
		        <% } %>
			

			<div class="label-style">
				<input type="text" name="exam_name" placeholder="" 
				     value="<%=(examName!= null) ? examName: ""%>" >
				<label for="exam_name">Enter the exam name</label>
			</div>
			<% String examError = (String) request.getAttribute("examNameError"); %>
			<% if (examError != null) { %>
			<p class="error_message"><%=examError %></p>
			<%} %>

			<div class="label-style">
				<input type="text" name="description" placeholder=""
					value="<%=(description!= null) ? description: ""%>">
				<label for="description">Enter the description</label>
			</div>
			<% String descriptionError = (String) request.getAttribute("descriptionError"); %>
		        <% if (descriptionError != null) { %>
		        <p class="error_message"><%= descriptionError %></p>
		        <% } %>

			<div class="label-style">
				<input type="number" name="no_of_question" placeholder=""
					value="<%=(noOfQuestion!= null) ? noOfQuestion: ""%>">
				<label for="no_of_question">Number of questions</label>
			</div>
			<% String addQuestionError = (String) request.getAttribute("addQuestionError"); %>
		        <% if (addQuestionError != null) { %>
		        <p class="error_message"><%= addQuestionError %></p>
		        <% } %>

			<div class="label-style">
				<input type="number" name="pass_min_correct" placeholder=""
					value="<%=(passMinCorrect!= null) ? passMinCorrect: ""%>">
				<label for="pass_min_correct">Enter the minimum pass percentage</label>
			</div>
			<% String minCorrectError = (String) request.getAttribute("minCorrectError"); %>
		        <% if ( minCorrectError != null) { %>
		        <p class="error_message"><%=  minCorrectError %></p>
		        <% } %>
			<div class="label-style">
				<input type="number" name="each_question_mark"  placeholder=""
					value="<%=(eachQuestionMark!= null) ? eachQuestionMark: ""%>">
				<label for="each_question_mark">Enter the each question mark</label>
			</div>
			<% String eachQuestionMarkError = (String) request.getAttribute("eachQuestionMarkError"); %>
		        <% if ( eachQuestionMarkError != null) { %>
		        <p class="error_message"><%= eachQuestionMarkError %></p>
		        <% } %>

			<div class="label-style">
				<input type="number" name="duration_minutes" placeholder=""
					value="<%=(durationMinutes!= null) ? durationMinutes: ""%>">
				<label for="duration_minutes">Enter the total duration</label>
			</div>
			<% String durationMinError = (String) request.getAttribute("durationMinError"); %>
		        <% if ( durationMinError != null) { %>
		        <p class="error_message"><%= durationMinError %></p>
		        <% } %>
			
			<button class="login_btn">Create</button>
		</form>
		<form method="post" action="controller"
			style="display: flex; gap: 20px; ">
			<button name="action" value="cancel" class="login_btn">Cancel</button>
		</form>
	</div>
</body>
<script type="text/javascript">
document.addEventListener("DOMContentLoaded", function () {

    const form = document.querySelector(".createexam_form");
    const examTopicInput = form.querySelector('input[name="exam_topic"]');
    const examNameInput = form.querySelector('input[name="exam_name"]');
    const descriptionInput = form.querySelector('input[name="description"]');
    const noOfQuestionInput = form.querySelector('input[name="no_of_question"]');
    const minimumCorrectInput = form.querySelector('input[name="pass_min_correct"]');
    const eachQuestionMarkInput = form.querySelector('input[name="each_question_mark"]');
    const durationMinutesInput = form.querySelector('input[name="duration_minutes"]');
    
    const nameRegex = /^(?=.*[a-zA-Z])[a-zA-Z0-9 ]{3,}$/;
    const minimumMarkRegex = /^(?:[1-9][0-9]?|100)$/;
    const numberofQuestionRegex = /^(?:[1-9]|1[0-9]|20)$/;
    const durationRegex = /^(?:[1-9]|1[0-9]|180)$/;
    
    const backendExamNameError = "<%= request.getAttribute("examError") != null ? request.getAttribute("examError") : "" %>";
    
    function showError(input, message) {
        removeError(input);

        const error = document.createElement("p");
        error.className = "js-error";
        error.innerText = message;

        input.classList.add("input-error");
        input.parentElement.appendChild(error);
    }

    function removeError(input) {
        input.classList.remove("input-error");
        const error = input.parentElement.querySelector(".js-error");
        if (error) error.remove();
    }

    
    examTopicInput.addEventListener("input", () => removeError(examTopicInput));
    examNameInput.addEventListener("input", () => removeError(examNameInput));
    descriptionInput.addEventListener("input", () => removeError(descriptionInput));
    noOfQuestionInput.addEventListener("input", () => removeError(noOfQuestionInput));
    minimumCorrectInput.addEventListener("input", () => removeError(minimumCorrectInput));
    eachQuestionMarkInput.addEventListener("input", () => removeError(eachQuestionMarkInput));
    durationMinutesInput.addEventListener("input", () => removeError(durationMinutesInput));
    
  
    if (backendExamNameError !== "") {
        showError(examNameInput, backendExamNameError);
    }

    form.addEventListener("submit", function (e) {
        let isValid = true;

        if (examTopicInput.value.trim() === "") {
            showError(examTopicInput, "Exam topic is required");
            isValid = false;
        } else if (!nameRegex.test(examTopicInput.value.trim())) {
            showError(examTopicInput, "Must start with a letter and be at least 4 characters long");
            isValid = false;
        }
        if (examNameInput.value.trim() === "") {
            showError(examNameInput, "Exam name is required");
            isValid = false;
        } else if (!nameRegex.test(examNameInput.value.trim())) {
            showError(examNameInput, "Must start with a letter and be at least 4 characters long");
            isValid = false;
        }

        if (descriptionInput.value.trim() === "") {
            showError(descriptionInput, "Description is required");
            isValid = false;
        } else if (!nameRegex.test(descriptionInput.value.trim())) {
            showError(descriptionInput, "Must start with a letter and be at least 4 characters long");
            isValid = false;
        }
        if (noOfQuestionInput.value.trim() === "") {
            showError(noOfQuestionInput, "Number of question is required");
            isValid = false;
        } else if (!numberofQuestionRegex.test(noOfQuestionInput.value.trim())) {
            showError(noOfQuestionInput, "Enter a valid number 1-20");
            isValid = false;
        }

        if (minimumCorrectInput.value.trim() === "") {
            showError(minimumCorrectInput, "Minimum pass percentage is required");
            isValid = false;
        } else if (!minimumMarkRegex.test(minimumCorrectInput.value.trim())) {
            showError(minimumCorrectInput, "Enter a valid percentage between 10% and 100%");
            isValid = false;
        }
        if (eachQuestionMarkInput.value.trim() === "") {
            showError(eachQuestionMarkInput, "Each question mark is required");
            isValid = false;
        } else if (!numberofQuestionRegex.test(eachQuestionMarkInput.value.trim())) {
            showError(eachQuestionMarkInput, "Enter a valid mark 1-20 ");
            isValid = false;
        }
        if (durationMinutesInput.value.trim() === "") {
            showError(durationMinutesInput, "Total duration is required");
            isValid = false;
        } else if (!durationRegex.test(durationMinutesInput.value.trim())) {
            showError(durationMinutesInput, "Enter a valid time in minutes less than 180 minutes");
            isValid = false;
        }
       
       

        if (!isValid) {
            e.preventDefault();
        }
    });
});

	

</script>
</html>
