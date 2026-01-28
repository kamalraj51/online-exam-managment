<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.List, com.vastpro.onlineexam.dao.ExamHistoryDAO,com.vastpro.onlineexam.dto.UserBasedHistoryDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Retire Exam</title>
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
	<div class="retire_container">

		<form action="controller" method="post" class="retire_form">
			<h2>Select Exam</h2>



			<%
			List<String> aExam = (List<String>) request.getAttribute("activeExam");
			if(aExam.size()!=0){
				%>
			<select name="exam_name">
				<option value="">--Select Exam--</option>
				<%
			for(String exam : aExam){
		%>
				<option value="<%=exam %>"><%=exam %></option>

				<%
			}
		%>

			</select>
			<button name="action" value="retire_exam_user">Retire</button>
			<%
			}else{
			 %>
			<select>
				<option value="No Exams Retired">No Active Exams Found</option>
			</select>
			<%
			}
			%>


		</form>
	</div>
	<jsp:include page="/common/footer.jsp" />
</body>
</html>