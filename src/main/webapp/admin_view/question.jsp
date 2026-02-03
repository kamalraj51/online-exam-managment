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
.label-style textarea:focus+label, .label-style textarea:not(:placeholder-shown)+label
	{
	top: 0;
	font-size: 12px;
	color: black;
	background-color: white;
	padding: 4px;
	border-radius: 5px;
}
</style>
<link rel="stylesheet" href="css/style.css"/>
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
			<textarea rows="3" name="question_id<%=i%>" placeholder="" 
			value="<%=request.getParameter("question_id"+i)!= null ? request.getParameter("question_id"+i) : ""%>"></textarea>
			<label for = "question_id<%=i%>">enter the question...</label>
			</div>
			
			<% String questionError = (String) request.getAttribute("questionError"); %>
		        <% if (questionError != null) { %>
		        <p class="error_message"><%= questionError %></p>

		        <% } %>

			
            <div class="label-style">
			<input type="number" name="marks<%=i%>" placeholder=""
			value="<%=request.getParameter("marks"+i)!= null ? request.getParameter("marks"+i) : ""%>">
			<label for = "marks<%=i%>">enter the mark</label>
            </div>
            
            <% String marksError = (String) request.getAttribute("marksError"); %>
		        <% if (marksError != null) { %>
		        <p class="error_message"><%= marksError %></p>

		        <% } %>


			<h3>Answer</h3>
			<div style="display: flex; gap:20px" >
			<input type="radio" name="correct_option_1<%=i %>" value="true" required > <lable> Correct </lable>
			<input type="radio" name="correct_option_1<%=i %>" value="false" required> <lable> Wrong</lable>
			</div>
			
			<div class="label-style">
			<input type="text" name="option_1<%=i %>" placeholder=""
			value="<%=request.getParameter("option_1"+i)!= null ? request.getParameter("option_1"+i) : ""%>"> 
			<label for = "option_1<%=i %>">enter the option a</label>
			</div>
			<% String option1_error = (String) request.getAttribute("option1_error"); %>
		        <% if (option1_error != null) { %>
		        <p class="error_message"><%= option1_error %></p>

		        <% } %>
			<div style="display: flex; gap:20px">
			<input type="radio" name="correct_option_2<%=i %>" value="true" required> <lable> Correct </lable>
			<input type="radio" name="correct_option_2<%=i %>" value="false" required> <lable> Wrong</lable>
			</div>
			<div class="label-style">
			<input type="text" name="option_2<%=i %>" placeholder=""
			value="<%=request.getParameter("option_2"+i)!= null ? request.getParameter("option_2"+i) : ""%>"> 
			<label for = "option_2<%=i %>">enter the option b</label>
			</div>
			<% String option2_error = (String) request.getAttribute("option2_error"); %>
		        <% if (option2_error != null) { %>
		        <p class="error_message"><%= option2_error %></p>

		        <% } %>
			
		    <div style="display: flex; gap:20px">
		    <input type="radio" name="correct_option_3<%=i %>" value="true" required> <lable> Correct </lable>
			<input type="radio" name="correct_option_3<%=i %>" value="false" required> <lable> Wrong</lable>
			</div>
			<div class="label-style">
		    <input type="text" name="option_3<%=i %>" placeholder=""
		    value="<%=request.getParameter("option_3"+i)!= null ? request.getParameter("option_3"+i) : ""%>"> 
		    <label for = "option_3<%=i %>">enter the option c</label>
		    </div>
		    <% String option3_error = (String) request.getAttribute("option3_error"); %>
		        <% if (option3_error != null) { %>
		        <p class="error_message"><%= option3_error %></p>

		        <% } %>
		    
		    <div style="display: flex; gap:20px">
		    <input type="radio" name="correct_option_4<%=i %>" value="true" required> <lable> Correct </lable>
			<input type="radio" name="correct_option_4<%=i %>" value="false" required> <lable> Wrong</lable>
			</div>
			<div class="label-style">
		    <input type="text" name="option_4<%=i %>" placeholder=""
		    value="<%=request.getParameter("option_4"+i)!= null ? request.getParameter("option_4"+i) : ""%>">
		    <label for = "option_4<%=i %>">enter the option d</label>
			</div>
			<% String option4_error = (String) request.getAttribute("option4_error"); %>
		        <% if (option4_error != null) { %>
		        <p class="error_message"><%= option4_error %></p>

		        <% } %>

			<%
			}
			%>

			<button name="action" value="submit">Submit</button>
		</form>
	</div>     <div id="toast" class="<%= session.getAttribute("questionToastStatus") != null 
             ? session.getAttribute("questionToastStatus") 
             : "" %>">
        		<%=(session.getAttribute("questionToast")!=null)?session.getAttribute("questionToast"):"" %>
        </div>

    </body>
    <script >

	window.onload = function(){
	var message = "<%=session.getAttribute("questionToast")%>";
	if(message && message !=="null"){
		var toast = document.getElementById("toast");
		toast.classList.add("show");
		
		setTimeout(function(){
			toast.classList.remove("show");
		}, 3000);
	}
};
</script>
<%
    session.removeAttribute("questionToast");
%>
	

</html>