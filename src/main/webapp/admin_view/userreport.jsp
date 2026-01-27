<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page
	import="java.util.List,
	 com.vastpro.onlineexam.dao.ExamHistoryDAO,com.vastpro.onlineexam.dto.UserBasedHistoryDTO,com.vastpro.onlineexam.dto.UserDTO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>

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
			<h1>Select User</h1>



			<%
			List<UserDTO> userList = (List<UserDTO>) request.getAttribute("userList");
				if (userList.size() != 0) {
			%>
			<select name="userSelectedOption">
					<option value="000">Select User</option>
				<%
				for (UserDTO user : userList) {
				%>
				<option value="<%=user.getUserId()%>"><%=user.getUsername()%></option>

				<%
				}
				%>

			</select>
			<button name="action" value="select_user_history">Select</button>
			<%
			} else {
			%>
			<select>
				<option value="No User Available">No User Available</option>
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
				<th>Your Marks</th>
				<th>Correct Answer</th>
				<th>Incorrect Answer</th>
				<th>Unanswered</th>
				<th>Result</th>

			</tr>

			<%
			List<UserBasedHistoryDTO> examHistory = (List<UserBasedHistoryDTO>) request.getAttribute("userBasedHistory");
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
				<td><%=exam.getCorrect() %></td>
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