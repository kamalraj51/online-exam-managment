<%@page import="com.vastpro.onlineexam.dto.ExamHistoryDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<%@ page import="java.util.List, com.vastpro.onlineexam.dao.ExamHistoryDAO,com.vastpro.onlineexam.dto.ExamHistoryDTO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>

<style>
    body { font-family: Arial; background: #f4f6f8; }
    table { width: 100%; border-collapse: collapse; }
    th, td { padding: 10px; border-bottom: 1px solid #ccc; text-align: center; }
    th { background: #2c3e50; color: white; }
    .btn { padding: 6px 12px; background: #27ae60; color: white; border: none; }
</style>

<title>home</title>
<link rel="stylesheet" href="css/style.css"/>

</head>

<body>
	<jsp:include page="/common/header.jsp"></jsp:include>
	<div class="container">
	
	<form action="controller" method="post" class="user_form">
		<h1>Select Topics to attend</h1>

		
		
		<%
			List<String> topics = (List<String>) request.getAttribute("topics");
			if(topics.size()!=0){
				%>
		<select name="userSelectedOption">
			<option value="">Select Topic</option>		
				<%
			for(String topic : topics){
		%>
		<option value="<%=topic %>"><%=topic %></option>
		
		<%
			}
		%>
			
		</select>
		<button name="action" value="select_exam">Select</button>
			<%
			}else{
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
			<th>Exam Topic</th>
			<th>Exam Name</th>
			<th>Description</th>
			<th>Duration (mins)</th>
			<th>Total Marks</th>
			<th>Pass Marks</th>
			<th>Your Marks</th>
			<th>Duration Taken</th>
			<th>Result</th>

		</tr>

		<%
List<ExamHistoryDTO> examHistory = (List<ExamHistoryDTO>)request.getAttribute("history");
    if (examHistory.isEmpty()) {
%>

<tr>
    <td colspan="9">No History available</td>
</tr>

		

		<%

} else {
        for (ExamHistoryDTO exam : examHistory) {
%>
		<tr>

			<td><%= exam.getExamTopic() %></td>
			<td><%= exam.getExamName() %></td>
			<td><%= exam.getDescription() %></td>
			<td><%= exam.getDuration() %></td>
			<td><%= exam.getTotalMarks() %></td>
			<td><%= exam.getPassMarks() %></td>
			<td><%= exam.getYourMarks() %></td>
			<td><%= exam.getDurationTaken() %></td>
			<td><%= exam.getResult() %></td>



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