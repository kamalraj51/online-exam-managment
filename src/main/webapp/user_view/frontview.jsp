<%@page import="com.vastpro.onlineexam.dto.ExamHistoryDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.util.*, com.vastpro.onlineexam.dao.ExamHistoryDAO,com.vastpro.onlineexam.dto.ExamHistoryDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<body>
	<nav>nav bar</nav>

	<form action="controller" method="post">
		<h1>Select Topics to attend</h1>
		
		<select name="userSelectedOption">
			<option value="Core Java">Java</option>
			<option value="Statments">Sql</option>
			<option value="JavaScript">JavaScript</option>
		</select>
		
		<button name="action" value="select_exam">Select</button>
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
    <td colspan="5">No exams available</td>
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
    
    
   	
    <!-- <td>
        <form action="controller" method="post">

            <input type="hidden" name="action" value="start_exam">

            <input type="hidden" name="examId" value="<%= exam.getExamId() %>">
           
            <button class="btn">Start Exam</button>
        </form>
    </td> -->
</tr>
<%
        }
    }
%>

</table>
	<!--  -->
</body>
</html>