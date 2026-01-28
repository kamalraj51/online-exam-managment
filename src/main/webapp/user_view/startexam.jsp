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

<div class="exam_container">
	<!-- timer code -->
	<div style="display: flex; justify-content: space-between;width: 50%;">
    <div >
       <h2>Question <%= currentQNo %> of <%= totalQuestions %></h2> 
    </div>
	
	<div style="float:right; font-weight:bold; color:red;">
    Time Left:
    <span id="timer"></span>
	</div>
<!--  -->
	</div>

    <form action="controller" method="post" class="retire_form">
    <h3><%= question.getQuestionText() %></h3>

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
