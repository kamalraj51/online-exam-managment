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
<title>Edit Exam</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body style="background: radial-gradient(
  circle farthest-corner at center,
  #4fe3b1 0%,
  #2fbf9b 30%,
  #0f6f5f 55%,
  #061318 100%
);
">
<jsp:include page="/common/header.jsp"></jsp:include>
<div  class="retire_container">
<h2 style="color:white; text-align: center;">Edit Exam</h2>
		<table>
			<tr>
				<th>Question Description</th>
				<th>Options</th>
				<th>Action</th>
			</tr>

			<%
			List<QuestionDTO> questions = (List<QuestionDTO>) request.getSession().getAttribute("questions");
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


				<td><%=question.getQuestionText()%></td>
				
				<td><%=question.getAnswers()%></td>
				<td>
				<form action="controller" method="post">
				<input type="hidden" name="examName" value="<%= question.getQuestionId() %>">
				
				 <button class="active_btn" name="actions" value="edit">Edit</button>
				</form>
				</td>
			</tr>
			<%
			}
			}
			%>

		</table>
		<form action="controller" method="post">
			<button name="action" value="authorize">Back to Home</button>
		</form>
</div>
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>