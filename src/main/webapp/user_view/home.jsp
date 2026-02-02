<%@page import="com.vastpro.onlineexam.dto.UserBasedHistoryDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page
	import="java.util.List,com.vastpro.onlineexam.dao.ExamHistoryDAO,com.vastpro.onlineexam.dto.UserBasedHistoryDTO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>home</title>
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
	<jsp:include page="/common/header.jsp"></jsp:include>
	<div  class="retire_container">

		<form action="controller" method="post" class="user_form">
		<div class="select_container">
			<h2 style="color:black;">Select Exam Topic</h2>



			<%
			List<String> topics = (List<String>) request.getAttribute("topics");
			if (topics.size() != 0) {
			%>
			<select name="userSelectedOption" id="topic_select" onchange="selectButton()">
				<option value="">--Select Topic--</option>
				<%
				for (String topic : topics) {
				%>
				<option value="<%=topic%>"><%=topic%></option>

				<%
				}
				%>

			</select>
			<button  name="action" value="select_exam" disabled id="select_btn">Select</button>
			<%
			} else {
			%>
			<select>
				<option value="No Topics Available">No Topics Available</option>
			</select>
			<%
			}
			%>

		</div>

		</form>

		<!-- old code form home -->
		<h2 style="color:white; text-align: center;	">History</h2>
		<table>
			<tr>
				<th>Exam Name</th>
				<th>Date/Time</th>
				<th>Score</th>
				<th>Correct Answer</th>
				<th>Incorrect Answer</th>
				<th>Unanswered</th>
				<th>Result</th>

			</tr>

			<%
			List<UserBasedHistoryDTO> examHistory = (List<UserBasedHistoryDTO>) request.getAttribute("history");
			if (examHistory.isEmpty()) {
			%>

			<tr>
				<td colspan="9">No History available</td>
			</tr>



			<%
			} else {
			for (UserBasedHistoryDTO exam : examHistory) {
			%>
			<tr>


				<td><%=exam.getExamName()%></td>
				<td><%=exam.getDate()%> / <%=exam.getTimeStamp()%></td>
				<td><%=exam.getYourMarks()%></td>
				<td><%=exam.getCorrect()%></td>
				<td><%=exam.getIncorrect()%></td>
				<td><%=exam.getUnanswered()%></td>
				<td><%=exam.getResult()%></td>




			</tr>
			<%
			}
			}
			%>

		</table>
		
	</div>

	<jsp:include page="/common/footer.jsp"></jsp:include>
	<!--  -->
</body>
<script type="text/javascript">
	function selectButton(){
		const select=document.getElementById("topic_select");
		const button=document.getElementById("select_btn");
		button.disabled=(select.value==="");
	}
</script>
</html>