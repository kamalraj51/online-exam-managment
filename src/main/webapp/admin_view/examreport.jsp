<%@page import="com.vastpro.onlineexam.dto.ExamBasedHistoryDTO"%>
<%@page import="com.vastpro.onlineexam.dto.ExamDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page
	import="java.util.List,
	 com.vastpro.onlineexam.dto.ExamDTO,com.vastpro.onlineexam.dto.ExamBasedHistoryDTO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Exam Report</title>

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

<title>home</title>
<link rel="stylesheet" href="css/style.css" />

</head>

<body>
	<jsp:include page="/common/header.jsp"></jsp:include>
	<div class="container">

		<form action="controller" method="post" class="user_form">
			<h1>Select Exam</h1>



			<%
			List<ExamDTO> examList = (List<ExamDTO>) request.getAttribute("listOfExams");
				if (examList.size() != 0) {
			%>
			<select name="adminSelectedOption">
					<option value="000">Select Exam</option>
				<%
				for (ExamDTO exam : examList) {
				%>
				<option value="<%=exam.getExamId() %>"><%=exam.getExamName() %></option>

				<%
				}
				%>

			</select>
			<button name="action" value="select_exam_history">Select</button>
			<%
			} else {
			%>
			<select>
				<option value="No User Available">No Exam Report Available</option>
			</select>
			<%
			}
			%>


		</form>

		<!-- old code form home -->
		<h1>History</h1>
		<table>
			<tr>
				
				<th>User Name</th>
				<th>Date/Time</th>
				<th>Score</th>
				<th>Result</th>

			</tr>

			<%
			List<ExamBasedHistoryDTO> examHistory = (List<ExamBasedHistoryDTO>) request.getAttribute("examBasedHistory");
				if (examHistory.isEmpty()) {
			%>

			<tr>
				<td colspan="9">No History available</td>
			</tr>



			<%
			} else {
				for (ExamBasedHistoryDTO exam : examHistory) {
			%>
			<tr>
				
				
				<td><%=exam.getUserName()%></td>
				<td><%=exam.getDateTime()%></td>
				<td><%=exam.getScore()%></td>
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