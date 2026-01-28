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
			List<ExamDTO> examList = (List<ExamDTO>) request.getAttribute("listOfExams");
				if (examList.size() != 0) {
			%>
			<select name="adminSelectedOption">
					<option value="000">--Select Exam--</option>
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
				<td><%=exam.getDate()%> / <%=exam.getTime()%></td>
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