<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.vastpro.onlineexam.dao.ExamHistoryDAO,com.vastpro.onlineexam.dto.UserBasedHistoryDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>active Exam</title>
<link rel="stylesheet" href="css/style.css"/>
</head>
<body>
	
	
		<jsp:include page="/common/header.jsp"></jsp:include>
	<div class="container">
	
	<form action="controller" method="post" class="user_form">
		<h1>Select Exam:</h1>

		
		
		<%
			List<String> rExam = (List<String>) request.getAttribute("retiredExam");
			if(rExam.size()!=0){
				%>
		<select name="exam_name">
				
				<%
			for(String exam : rExam){
		%>
		<option value="<%=exam %>"><%=exam %></option>
		
		<%
			}
		%>
			
		</select>
		<button name="action" value="active_exam_user">Active</button>
			<%
			}else{
			 %>
			 <select>
			<option value="No Exams Retired">No Retired Exams Found</option>
			</select>	
			<%
			}
			%>
		
		
	</form>
</body>
</html>