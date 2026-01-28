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
    <style>

       
        .result-summary p {
            margin: 8px 0;
            font-size: 16px;
        }

        .result-summary b {
            font-size: 18px;
        }

        h3 {
            text-align: center;
            color: #333;
        }

        table {
            width: 90%;
            max-width: 900px;
            margin: 0 auto 40px auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }

     

        table tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .pass {
            color: green;
            font-weight: bold;
        }

        .fail {
            color: red;
            font-weight: bold;
        }
    </style>
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
<div class="report_container">
<div class="result-summary">
    <p class="report_content">Total Questions: <%= totalQuestions %></p>
    <p class="report_content">Attempted: <%= correct + incorrect %></p>
    <p class="report_content">Correct Answers: <%= correct %></p>
    <p class="report_content">Incorrect Answers: <%= incorrect %></p>
    <p class="report_content">Unanswered: <%= unanswered %></p>
    <p class="report_content">Your Score: <%= score %></p>
    <p class="report_content">Result: <b class="<%= passed ? "pass" : "fail" %>"><%= passed ? "PASS" : "FAIL" %></b></p>
</div>


<table>
<caption style="margin-bottom: 10px;">DETAILED FEEDBACK</caption>
    <tr>
        <th>Question</th>
        <th>Your Answer</th>
        <th>Correct Answer</th>
        <th>Status</th>
    </tr>
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
</table>
</div>
<jsp:include page="/common/footer.jsp"/>
</body>
</html>
