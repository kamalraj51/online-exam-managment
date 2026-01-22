<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.vastpro.onlineexam.dto.Question" %>
<%@ page import="com.vastpro.onlineexam.dto.Answer" %>
<%@ page import="java.util.List" %>

<%
    Question question = (Question) request.getAttribute("question");
    boolean isFirst = Boolean.TRUE.equals(request.getAttribute("isFirst"));
    boolean isLast = Boolean.TRUE.equals(request.getAttribute("isLast"));
    int currentQNo = (Integer) request.getAttribute("currentQNo");
    int totalQuestions = (Integer) request.getAttribute("totalQuestions");
%>

<html>
<head>
    <title>Start Exam</title>
</head>
<body>

<h3>Question <%= currentQNo %> of <%= totalQuestions %></h3>
<h3><%= question.getQuestionText() %></h3>

<form action="controller" method="post">

<%
    List<Answer> answers = question.getAnswers();
    for (Answer ans : answers) {
%>
    <input type="radio" name="answerId" value="<%= ans.getAnswerId() %>" required>
    <%= ans.getOptionText() %><br/>
<%
    }
%>

<br/>

<%-- Navigation buttons logic --%>
<%
    if (totalQuestions == 1) { // Only one question
%>
	<input type="hidden" name="examId" value="<%= request.getParameter("examId") %>"/>
 	<input type="hidden" name="action" value="show_result"/>
    <button type="submit" name="nav" value="submit">Submit</button>
<%
    } else if (isFirst) { // First question, more than 1
%>

    <button type="submit" name="nav" value="next">Next</button>
<%
    } else if (isLast) { // Last question
%>
<input type="hidden" name="action" value="show_result"/>
	<input type="hidden" name="examId" value="<%= request.getParameter("examId") %>"/>
    <button type="submit" name="nav" value="back">Back</button>
    <button type="submit" name="nav" value="submit">Submit</button>
<%
    } else { // Middle questions
%>
    <button type="submit" name="nav" value="back">Back</button>
    <button type="submit" name="nav" value="next">Next</button>
<%
    }
%>

<input type="hidden" name="action" value="start_exam"/>
<input type="hidden" name="examId" value="<%= request.getParameter("examId") %>"/>

</form>

</body>
</html>
