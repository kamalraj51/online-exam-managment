<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.vastpro.onlineexam.dto.QuestionDTO"%>
<%@ page import="com.vastpro.onlineexam.dto.AnswerDTO"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>

<%
QuestionDTO question = (QuestionDTO) request.getAttribute("question");
boolean isFirst = Boolean.TRUE.equals(request.getAttribute("isFirst"));
boolean isLast = Boolean.TRUE.equals(request.getAttribute("isLast"));
int currentQNo = (Integer) request.getAttribute("currentQNo");
int totalQuestions = (Integer) request.getAttribute("totalQuestions");
Long remainingSeconds = (Long) request.getAttribute("remainingSeconds");

Map<Integer, Integer> userSelectedAnswers =
        (Map<Integer, Integer>) session.getAttribute("userAnswers");


Integer selectedAnswerId = null;
if (userSelectedAnswers != null && question != null) {
    selectedAnswerId = userSelectedAnswers.get(question.getQuestionId());
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Start Exam</title>

<style>
.container {
    width: 100%;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
}

.answers {
    width: 420px;
    padding: 30px 40px;
    background: #ffffffcc;
    border-radius: 8px;
    box-shadow: 0 4px 10px #000;
}

.answers label {
    display: block;
    margin-bottom: 10px;
    cursor: pointer;
}

button {
    background-color: #061E29;
    color: white;
    border: none;
    padding: 10px 16px;
    margin-right: 10px;
    border-radius: 8px;
    cursor: pointer;
    font-weight: bold;
}

button:hover {
    background-color: #234C6A;
}
</style>
</head>

<body style="background: radial-gradient(circle, #4fe3b1, #061318);">

<div class="container">

<form action="controller" method="post" class="answers">

    <div style="display:flex; justify-content:space-between;">
        <h3>Question <%= currentQNo %> of <%= totalQuestions %></h3>
        <div style="color:red;font-weight:bold;">
            Time Left: <span id="timer"></span>
        </div>
    </div>

    <h4><%= question.getQuestionText() %></h4>


    <%
    List<AnswerDTO> answers = question.getAnswers();
    for (AnswerDTO ans : answers) {

        boolean checked =
            (selectedAnswerId != null &&
             selectedAnswerId == ans.getAnswerId());
    %>
        <label>
            <input type="radio"
                   name="answerId"
                   value="<%= ans.getAnswerId() %>"
                   <%= checked ? "checked" : "" %> />
            <%= ans.getOptionText() %>
        </label>
    <%
    }
    %>


    <div style="margin-top:20px;">
        <%
        if (totalQuestions == 1) {
        %>
            <button type="submit" name="nav" value="submit">Submit</button>

        <%
        } else if (isFirst) {
        %>
            <button type="submit" name="nav" value="next">Next</button>

        <%
        } else if (isLast) {
        %>
            <button type="submit" name="nav" value="back">Back</button>
            <button type="submit" name="nav" value="submit">Submit</button>

        <%
        } else {
        %>
            <button type="submit" name="nav" value="back">Back</button>
            <button type="submit" name="nav" value="next">Next</button>
        <%
        }
        %>
    </div>


    <input type="hidden" name="action" value="start_exam" />
    <input type="hidden" name="examId" value="<%= request.getParameter("examId") %>" />

</form>
</div>

<script>
let remaining = <%= remainingSeconds != null ? remainingSeconds : 0 %>;
let submitted = false;

let timerId = setInterval(function () {

    if (remaining <= 0 && !submitted) {
        submitted = true;
        clearInterval(timerId);

        alert("Time is up! Exam will be submitted.");
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

</body>
</html>
