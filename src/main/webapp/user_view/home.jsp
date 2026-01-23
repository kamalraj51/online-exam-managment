<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*,com.vastpro.onlineexam.dto.ExamDTO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Dashboard</title>
<style>
    body { font-family: Arial; background: #f4f6f8; }
    table { width: 100%; border-collapse: collapse; }
    th, td { padding: 10px; border-bottom: 1px solid #ccc; text-align: center; }
    th { background: #2c3e50; color: white; }
    .btn { padding: 6px 12px; background: #27ae60; color: white; border: none; }
</style>
</head>

<body>


<h2>Available Exams</h2>

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
           
            <button class="btn">Start Exam</button>
        </form>
    </td>
</tr>
<%
        }
    }
%>

</table>
<div style="height: 200px; width: 100vw; display: flex; justify-content: center; align-items: center;flex-direction: column;">
  <form action = "/exam/controller" method = "post">
       <input type = "hidden" value = "logout" name = "action"/>
       <input type = "submit" value = "Logout">
       
   </form>
   </div>
</body>
</html>
