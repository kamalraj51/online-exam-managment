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
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f4f6f8;
        }

        .result-summary {
            max-width: 600px;
            margin: 0 auto 30px auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 6px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }

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

        table th, table td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: left;
        }

        table th {
            background-color: #007bff;
            color: white;
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
<body>
<jsp:include page="/common/header.jsp"/>
<div class="result-summary">
    <p>Total Questions: <%= totalQuestions %></p>
    <p>Attempted: <%= correct + incorrect %></p>
    <p>Correct Answers: <%= correct %></p>
    <p>Incorrect Answers: <%= incorrect %></p>
    <p>Unanswered: <%= unanswered %></p>
    <p>Your Score: <%= score %></p>
    <p>Result: <b class="<%= passed ? "pass" : "fail" %>"><%= passed ? "PASS" : "FAIL" %></b></p>
</div>

<h3>Detailed Feedback</h3>
<table>
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
<jsp:include page="/common/footer.jsp"/>
</body>
</html>
