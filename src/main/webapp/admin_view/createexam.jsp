<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<% String examError = (String) request.getAttribute("examError"); %>
			<% if (examError != null) { %>
			<p class="error_message"><%=examError %></p>
			<%} %>

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

			<button class="login_btn">Create</button>
		</form>
		<form method="post" action="controller"
			style="display: flex; gap: 20px;">
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
    
    const nameRegex = /^[a-zA-Z0-9 ,._]+$/;
    const numberRegex = /^[1-9][0-9]*$/;
    
    const backendExamNameError = "<%= request.getAttribute("examNameError") != null ? request.getAttribute("examNameError") : "" %>";
    
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
        showError(emailInput, backendEmailError);
    }

    form.addEventListener("submit", function (e) {
        let isValid = true;

        if (examTopicInput.value.trim() === "") {
            showError(examTopicInput, "Exam topic is required");
            isValid = false;
        } else if (!nameRegex.test(examTopicInput.value.trim())) {
            showError(examTopicInput, "Enter a valid topic");
            isValid = false;
        }
        if (examNameInput.value.trim() === "") {
            showError(examNameInput, "Exam name is required");
            isValid = false;
        } else if (!nameRegex.test(examNameInput.value.trim())) {
            showError(examNameInput, "Enter a valid name");
            isValid = false;
        }

        if (descriptionInput.value.trim() === "") {
            showError(descriptionInput, "Description is required");
            isValid = false;
        } else if (!nameRegex.test(descriptionInput.value.trim())) {
            showError(descriptionInput, "Enter a valid description");
            isValid = false;
        }
        if (noOfQuestionInput.value.trim() === "") {
            showError(noOfQuestionInput, "Number of question is required");
            isValid = false;
        } else if (!numberRegex.test(noOfQuestionInput.value.trim())) {
            showError(noOfQuestionInput, "Enter a valid number more than 0");
            isValid = false;
        }

        if (minimumCorrectInput.value.trim() === "") {
            showError(minimumCorrectInput, "Minimum mark is required");
            isValid = false;
        } else if (!numberRegex.test(minimumCorrectInput.value.trim())) {
            showError(minimumCorrectInput, "Enter a valid mark more than 0");
            isValid = false;
        }
        if (eachQuestionMarkInput.value.trim() === "") {
            showError(eachQuestionMarkInput, "Each question mark is required");
            isValid = false;
        } else if (!numberRegex.test(eachQuestionMarkInput.value.trim())) {
            showError(eachQuestionMarkInput, "Enter a valid mark more than 0");
            isValid = false;
        }
        if (durationMinutesInput.value.trim() === "") {
            showError(durationMinutesInput, "Total duration is required");
            isValid = false;
        } else if (!numberRegex.test(durationMinutesInput.value.trim())) {
            showError(durationMinutesInput, "Enter a valid time in minutes");
            isValid = false;
        }
       
       

        if (!isValid) {
            e.preventDefault();
        }
    });
});

	

</script>
</html>
