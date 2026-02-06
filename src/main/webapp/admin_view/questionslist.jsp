<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.vastpro.onlineexam.dto.QuestionDTO"%>
<%@ page import="com.vastpro.onlineexam.dto.AnswerDTO"%>
<%@ page import="java.util.List"%>    
    <%@ page
	import="java.util.List,com.vastpro.onlineexam.dao.LoadAllExamsDAO,com.vastpro.onlineexam.dto.ExamDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Questions List</title>
<link rel="stylesheet" href="css/style.css" />
<style>
td,tr{
	text-align: left;
}
</style>
</head>
<body>
<jsp:include page="/common/header.jsp"></jsp:include>
<div  class="retire_container">
<h2 style="color:white; text-align: center;">Questions List</h2>
		<table style="text-align: left;">
			<tr>
				<th>Question Description</th>
				<th>Option A</th>
				<th>Option B</th>
				<th>Option C</th>
				<th>Option D</th>
				<th>Action</th>
			</tr>
 
			<%
			List<QuestionDTO> questions = (List<QuestionDTO>) request.getSession().getAttribute("editQuestionsData");
			if (questions.isEmpty()) {
			%>
 
			<tr>
				<td colspan="3">No History available</td>
			</tr>
 
 
 
			<%
			} else {
			for (QuestionDTO question : questions) {
			%>
			<tr>
 
 
				<td style="text-align: left;"><%=question.getQuestionText()%></td>
				
				<td><%=question.getAnswers().get(0)%></td>
				<td><%=question.getAnswers().get(1)%></td>
				<td><%=question.getAnswers().get(2)%></td>
				<td><%=question.getAnswers().get(3)%></td>
				<td>
				<form action="controller" method="post">
				<input type="hidden" name="questionId" value="<%= question.getQuestionId() %>">
				
				 <button class="active_btn" name="action" value="edit_question">Edit</button>
				</form>
				</td>
			</tr>
			<%
			}
			}
			%>
 
		</table>
	<form action="controller" method="post">
			<button name="action" value="edit_exam">Back To Edit Exam</button>
		</form>
</div>
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>
 