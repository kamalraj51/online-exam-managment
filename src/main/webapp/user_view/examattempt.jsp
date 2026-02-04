<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*,com.vastpro.onlineexam.dto.ExamDTO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Dashboard</title>
<link rel="stylesheet" href="css/style.css"/>
</head>

<body>
<jsp:include page="/common/header.jsp"/>
<div class="home_container">

<h2 style="text-align: center">Available Exams</h2>

<table>
<tr>
    <th>Exam Name</th>
    <th>Description</th>
    <th>Duration (mins)</th>
    <th>Pass Marks</th>
    <th>Action</th>
    
</tr>

<%
List<ExamDTO> exams = (List<ExamDTO>)request.getAttribute("examList");

    if (exams.isEmpty()) {
%>
<tr>
    <td colspan="5">No exams available</td>
</tr>
<%
} else {
        for (ExamDTO exam : exams) {
%>
<tr>
    <td><%= exam.getExamName() %></td>
    <td><%= exam.getDescription() %></td>
    <td><%= exam.getDuration() %></td>
    <td><%= exam.getPassMarks() %></td>
    
    <td>
        <form action="controller" method="post">

            <input type="hidden" name="action" value="start_exam">

            <input type="hidden" name="examId" value="<%= exam.getExamId() %>">
           
            <button class="attempt_btn">Start Exam</button>
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
   
   <jsp:include page="/common/footer.jsp"/>
</body>
</html>
