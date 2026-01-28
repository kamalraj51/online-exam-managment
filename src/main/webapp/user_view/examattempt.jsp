<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*,com.vastpro.onlineexam.dto.ExamDTO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Dashboard</title>
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
<jsp:include page="/common/header.jsp"/>
<div class="home_container">
<h2>Available Exams</h2>
<div class = "common">
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

   </div>
   </div>
   <jsp:include page="/common/footer.jsp"/>
</body>
</html>
