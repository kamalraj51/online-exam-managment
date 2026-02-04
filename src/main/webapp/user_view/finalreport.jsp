<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.vastpro.onlineexam.dto.ExamResponseDTO" %>

<%
    int totalQuestions = (Integer) request.getAttribute("totalQuestions");
    int correct = (Integer) request.getAttribute("correct");
    int incorrect = (Integer) request.getAttribute("incorrect");
    int unanswered = (Integer) request.getAttribute("unanswered");
    int score = (Integer) request.getAttribute("score");
    boolean passed = (Boolean) request.getAttribute("passed");
    List<ExamResponseDTO> responses = (List<ExamResponseDTO>) request.getAttribute("responses");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Exam Result</title>
   
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<jsp:include page="/common/header.jsp"/>
<div class="report_container">
<div>
	<h2 style="text-align: center;">Final Report</h2>
<div class="result-summary">
    <p class="report_content">Total Questions: <%= totalQuestions %></p>
    <p class="report_content">Attempted: <%= correct + incorrect %></p>
    <p class="report_content">Correct Answers: <%= correct %></p>
    <p class="report_content">Incorrect Answers: <%= incorrect %></p>
    <p class="report_content">Unanswered: <%= unanswered %></p>
    <p class="report_content">Your Score: <%= score %></p>
    <p class="report_content">Result: <b class="<%= passed ? "pass" : "fail" %>"><%= passed ? "PASS" : "FAIL" %></b></p>
</div>

</div>
<table >
<caption style="margin-bottom: 10px;">Detailed Feedback</caption>
<thead>
    <tr>
        <th>Question</th>
        <th>Your Answer</th>
        <th>Correct Answer</th>
        <th>Status</th>
    </tr>
</thead>
<tbody>
<%
    for (ExamResponseDTO r : responses) {
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
</tbody>
</table>
		<form action="controller" method="post">
			<button name="action" value="authorize">Back to Home</button>
		</form>

</div>
	<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>
