<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.vastpro.onlineexam.dto.ExamResponse" %>

<%
   // String examName = (String) request.getAttribute("examName");
    int totalQuestions = (Integer) request.getAttribute("totalQuestions");
    int correct = (Integer) request.getAttribute("correct");
    int incorrect = (Integer) request.getAttribute("incorrect");
    int unanswered = (Integer) request.getAttribute("unanswered");
    int score = (Integer) request.getAttribute("score");
    boolean passed = (Boolean) request.getAttribute("passed");
    //int passMinCorrect = (Integer) request.getAttribute("passMinCorrect");
    List<ExamResponse> responses = (List<ExamResponse>) request.getAttribute("responses");
%>

<html>
<head>
    <title>Exam Result</title>
</head>
<body>


<p>Total Questions: <%= totalQuestions %></p>
<p>Attempted: <%= correct + incorrect %></p>
<p>Correct Answers: <%= correct %></p>
<p>Incorrect Answers: <%= incorrect %></p>
<p>Unanswered: <%= unanswered %></p>

<p>Your Score: <%= score %></p>
<p>Result: <b><%= passed ? "PASS" : "FAIL" %></b></p>

<h3>Detailed Feedback:</h3>
<table border="1" cellpadding="5">
    <tr>
        <th>Question</th>
        <th>Your Answer</th>
        <th>Correct Answer</th>
        <th>Status</th>
    </tr>
<%
    for (ExamResponse r : responses) {
%>
    <tr>
        <td><%= r.getQuestionText() %></td>
        <td><%= r.getSelectedOptionText() != null ? r.getSelectedOptionText() : "Unanswered" %></td>
        <td><%= r.getCorrectOptionText() %></td>
        <td>
            <%= r.getSelectedOptionId() == null ? "Unanswered" : (r.isCorrect() ? "Correct" : "Incorrect") %>
        </td>
    </tr>
<%
    }
%>
</table>

</body>
</html>
