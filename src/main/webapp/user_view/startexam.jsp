<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.vastpro.onlineexam.dto.QuestionDTO" %>
<%@ page import="com.vastpro.onlineexam.dto.AnswerDTO" %>
<%@ page import="java.util.List" %>

<%
QuestionDTO question = (QuestionDTO) request.getAttribute("question");
boolean isFirst = Boolean.TRUE.equals(request.getAttribute("isFirst"));
boolean isLast = Boolean.TRUE.equals(request.getAttribute("isLast"));
int currentQNo = (Integer) request.getAttribute("currentQNo");
int totalQuestions = (Integer) request.getAttribute("totalQuestions");
Long remainingSeconds = (Long) request.getAttribute("remainingSeconds");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Start Exam</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            margin: 0;
            padding: 20px;
        }

        .container {
            max-width: 700px;
            margin: 0 auto;
            background-color: #ffffff;
            padding: 25px 30px;
            border-radius: 6px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }

        h3 {
            color: #333;
        }

        .question-number {
            font-weight: bold;
            margin-bottom: 15px;
        }

        .answers {
            margin-top: 15px;
        }

        .answers label {
            display: block;
            margin-bottom: 10px;
            font-size: 16px;
            cursor: pointer;
        }

        button {
            padding: 10px 20px;
            margin-right: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        button[name="nav"][value="next"] {
            background-color: #007bff;
            color: white;
        }

        button[name="nav"][value="back"] {
            background-color: #6c757d;
            color: white;
        }

        button[name="nav"][value="submit"] {
            background-color: #28a745;
            color: white;
        }

        button:hover {
            opacity: 0.9;
        }
    </style>
</head>
<body>

<div class="container">
	<!-- timer code -->
	<div style="float:right; font-weight:bold; color:red;">
    Time Left:
    <span id="timer"></span>
</div>
<!--  -->
    <div class="question-number">
        Question <%= currentQNo %> of <%= totalQuestions %>
    </div>
    <h3><%= question.getQuestionText() %></h3>

    <form action="controller" method="post" class="answers">

        <%
        List<AnswerDTO> answers = question.getAnswers();
        for (AnswerDTO ans : answers) {
        %>
            <label>
                <input type="radio" name="answerId" value="<%= ans.getAnswerId() %>">
                <%= ans.getOptionText() %>
            </label>
        <%
        }
        %>

        <div style="margin-top: 20px;">
        <%
            if (totalQuestions == 1) { // Only one question
        %>
            <input type="hidden" name="examId" value="<%= request.getParameter("examId") %>"/>
            <button type="submit" name="nav" value="submit">Submit</button>
        <%
            } else if (isFirst) { // First question, more than 1
        %>
            <button type="submit" name="nav" value="next">Next</button>
        <%
            } else if (isLast) { // Last question
        %>
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
        </div>

        <input type="hidden" name="action" value="start_exam"/>
        <input type="hidden" name="examId" value="<%= request.getParameter("examId") %>"/>

    </form>
</div>

</body>
<script>
let remaining = <%= remainingSeconds != null ? remainingSeconds : 0 %>;
let submitted = false;   

let timerId = setInterval(function () {

    if (remaining <= 0 && !submitted) {
        submitted = true;
        clearInterval(timerId); 

        alert("Time is up! Exam will be submitted.");

       
        let buttons = document.querySelectorAll("button");
        buttons.forEach(btn => btn.disabled = true);

        document.forms[0].submit();
        return;
    }

    let min = Math.floor(remaining / 60);
    let sec = remaining % 60;

    document.getElementById("timer").innerText =
        min + ":" + (sec < 10 ? "0" + sec : sec);

    remaining--;

}, 1000);
</script>

</html>
