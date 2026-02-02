<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page
	import="java.util.List,
	 com.vastpro.onlineexam.dao.ExamHistoryDAO,com.vastpro.onlineexam.dto.UserBasedHistoryDTO,com.vastpro.onlineexam.dto.UserDTO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>User Report</title>


<title>home</title>
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
			<h2>Select User</h2>



			<%
			List<UserDTO> userList = (List<UserDTO>) request.getAttribute("userList");
				if (userList.size() != 0) {
			%>
			<select name="userSelectedOption" id="topic_select" onchange="selectButton()">
					<option value="000">--Select User--</option>
				<%
				for (UserDTO user : userList) {
				%>
				<option value="<%=user.getUserId()%>"><%=user.getUsername()%></option>

				<%
				}
				%>

			</select>
			<button name="action" value="select_user_history" disabled id="select_btn">Select</button>
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
		<h1> User Based History</h1>
		<table >
		<thead>
			<tr>
				
				<th>Exam Name</th>
				<th>Date/Time</th>
				<th>Your Marks</th>
				<th>Correct Answer</th>
				<th>Incorrect Answer</th>
				<th>Unanswered</th>
				<th>Result</th>

			</tr>
	</thead>
	<tbody>
			<%
			List<UserBasedHistoryDTO> examHistory = (List<UserBasedHistoryDTO>) request.getAttribute("userBasedHistory");
				if (examHistory.isEmpty()) {
			%>

			<tr style="width:100%;background-color:red;">
				<td colspan="7">No History available</td>
			</tr>



			<%
			} else {
				for (UserBasedHistoryDTO exam : examHistory) {
			%>
			<tr>
				
				
				<td><%=exam.getExamName()%></td>
				<td><%=exam.getDate()%> / <%=exam.getTimeStamp()%></td>
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
</tbody>
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