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
<style>
body {
	font-family: Arial;
	background: #f4f6f8;
}

table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	padding: 10px;
	border-bottom: 1px solid #ccc;
	text-align: center;
}

th {
	background: #2c3e50;
	color: white;
}

.btn {
	padding: 6px 12px;
	background: #27ae60;
	color: white;
	border: none;
}
</style>
<link rel="stylesheet" href="css/style.css" />

</head>

<body>
	<jsp:include page="/common/header.jsp"></jsp:include>
	<div class="container">

		<form action="controller" method="post" class="user_form">
			<h1>Select Topics to attend</h1>



			<%
			List<String> topics = (List<String>) request.getAttribute("topics");
			if (topics.size() != 0) {
			%>
			<select name="userSelectedOption">
				<option value="">Select Topic</option>
				<%
				for (String topic : topics) {
				%>
				<option value="<%=topic%>"><%=topic%></option>

				<%
				}
				%>

			</select>
			<button name="action" value="select_exam">Select</button>
			<%
			} else {
			%>
			<select>
				<option value="No Topics Available">No Topics Available</option>
			</select>
			<%
			}
			%>


		</form>

		<!-- old code form home -->
		<h1>History</h1>
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
				<td><%=exam.getDateTime()%></td>
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
</html>