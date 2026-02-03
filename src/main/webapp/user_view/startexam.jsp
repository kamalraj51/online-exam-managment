<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.vastpro.onlineexam.dto.QuestionDTO"%>
<%@ page import="com.vastpro.onlineexam.dto.AnswerDTO"%>
<%@ page import="java.util.List"%>

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
.container {
	width: 100%;
	height: 100vh;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	border-radius: 6px;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

h3 {
	color: #333;
}

.question-number {
	font-weight: bold;
	margin-bottom: 15px;
}

.answers {
	padding: 30px 40px;
	border-radius: 6px;
	box-shadow: 0 4px 6px black;
	width: 420px;
	backdrop-filter: blur(5px);
}

.answers label {
	display: block;
	margin-bottom: 10px;
	font-size: 16px;
	cursor: pointer;
}

button {
	/*padding: 10px 20px;
            margin-right: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            */
	text-transform: capitalize;
	letter-spacing: 2px;
	background-color: #061E29;
	transition: background-color 0.3s;
	font-weight: bold;
	border-radius: 10px;
	padding: 10px;
	color: white;
	border: none;
	cursor: pointer;
}

button:hover {
	background-color: #234C6A;
	color: white;
}
/*
        button[name="nav"][value="next"] {
            background-color: #007bff;
            color: white;
        }

        button[name="nav"][value="back"] {
            background-color: #6c757d;
            color: white;
        }
*/
</style>
</head>
<body>

	<div class="container">


		<form action="controller" method="post" class="answers">
			<div
				style="display: flex; justify-content: space-between; flex-direction: row; width: 100%; align-items: center;">
				<div>
					<h2>
						Question
						<%= currentQNo %>
						of
						<%= totalQuestions %></h2>
				</div>

				<div style="float: right; font-weight: bold; color: red;">
					Time Left: <span id="timer"></span>
				</div>
			</div>
			<h3><%= question.getQuestionText() %></h3>
			<%
        List<AnswerDTO> answers = question.getAnswers();
        for (AnswerDTO ans : answers) {
        %>
			<label> <input type="radio" name="answerId"
				value="<%= ans.getAnswerId() %>"> <%= ans.getOptionText() %>
			</label>
			<%
        }
        %>

			<div style="margin-top: 20px;">
				<%
            if (totalQuestions == 1) { // Only one question
        %>
				<input type="hidden" name="examId"
					value="<%= request.getParameter("examId") %>" />
				<button type="submit" name="nav" value="submit">Submit</button>
				<%
            } else if (isFirst) { // First question, more than 1
        %>
				<button type="submit" name="nav" value="next">Next</button>
				<%
            } else if (isLast) { // Last question
        %>
				<input type="hidden" name="examId"
					value="<%= request.getParameter("examId") %>" />
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

			<input type="hidden" name="action" value="start_exam" /> <input
				type="hidden" name="examId"
				value="<%= request.getParameter("examId") %>" />

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
