<%@page import="java.util.ArrayList"%>
<%@page import="com.vastpro.onlineexam.dto.QuestionDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.vastpro.onlineexam.dao.LoadAllExamsDAO,com.vastpro.onlineexam.dto.ExamDTO"%>
<%
List<QuestionDTO> questions = (List<QuestionDTO>) request.getSession().getAttribute("editQuestionsData");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Question</title>
<link rel="stylesheet" href="css/style2.css" />
<style>




.label-style textarea {
    resize: vertical;
    min-height: 80px;
}



/* ===== Radio Buttons ===== */
input[type="radio"] {
    transform: scale(1.1);
    cursor: pointer;
}

lable {
    font-size: 12px;
    cursor: pointer;
}

/* ===== Radio Row ===== */
div[style*="display: flex"] {
    align-items: center;
    margin: 15px 0 6px;
}









</style>
</head>

<body>
<%if (questions.isEmpty()) {
	
 %>
 
 <%}else{ %>

	<div class="exam_container">
		<h2>Edit Question</h2>
		<form action="controller" method="post" class="createquestion_form">
			<%
			int noQuestion = (Integer) questions.size();
			int questionId = Integer.parseInt(request.getParameter("questionId"));
			for(QuestionDTO question : questions){
				if(question.getQuestionId()==questionId){
					
				
			int i=0;
			%>
			
				

			<input type="hidden" name="exam_id"
				value="<%=request.getSession().getAttribute("examId")%>">

			<div class="label-style">
				<textarea rows="2" name="question_text<%=i%>" placeholder="">
				
				<%=request.getParameter("question_text" + i) != null ? request.getParameter("question_text" + i) :(question.getQuestionText() != null ? question.getQuestionText() : "hello")%>
				</textarea>
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
				<input type="radio" name="correct_option<%=i%>" value="1" <%= question.getAnswers().get(0).isCorrect() ? "checked" : "" %> required >
				<label> Option A </label>
			</div>
			<div class="label-style">
				<input type="text" name="option_1<%=i%>" placeholder=""
					value="<%=request.getParameter("option_1" + i) != null ? request.getParameter("option_1" + i) : ((question.getAnswers().get(0).getOptionText()!=null)?question.getAnswers().get(0).getOptionText():"")%>">
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
				<input type="radio" name="correct_option<%=i%>" value="2" <%= question.getAnswers().get(1).isCorrect() ? "checked" : "" %> required>
				<label> Option B </label>
			</div>
			<div class="label-style">
				<input type="text" name="option_2<%=i%>" placeholder=""
					value="<%=request.getParameter("option_2" + i) != null ? request.getParameter("option_2" + i) : ((question.getAnswers().get(1).getOptionText()!=null)?question.getAnswers().get(1).getOptionText():"")%>">
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
				<input type="radio" name="correct_option<%=i%>" value="3" <%= question.getAnswers().get(2).isCorrect() ? "checked" : "" %> required>
				<label> Option C </label>

			</div>
			<div class="label-style">
				<input type="text" name="option_3<%=i%>" placeholder=""
					value="<%=request.getParameter("option_3" + i) != null ? request.getParameter("option_3" + i) : ((question.getAnswers().get(2).getOptionText()!=null)?question.getAnswers().get(2).getOptionText():"")%>">
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
				<input type="radio" name="correct_option<%=i%>" value="4" <%= question.getAnswers().get(3).isCorrect() ? "checked" : "" %> required>
				<label> Option-d </label>

			</div>
			<div class="label-style">
				<input type="text" name="option_4<%=i%>" placeholder=""
					value="<%=request.getParameter("option_4" + i) != null ? request.getParameter("option_4" + i) : ((question.getAnswers().get(3).getOptionText()!=null)?question.getAnswers().get(3).getOptionText():"")%>">
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
			}%>
		

			<button name="action" value="submit" class="login_btn">Submit</button>
		</form>
	<form action="controller" method="post">
			<button name="action" value="edit" class="login_btn">Back To Questions</button>
		</form>
	</div>
<%} %>
</body>


</html>
