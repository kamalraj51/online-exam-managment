<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Exam</title>
<link rel="stylesheet" href="css/style.css"/>

</head>

<body style="background-image: url('assets/bgplain.jpg'); background-size: 100%; background-repeat: no-repeat;">
    <div class="exam_container">
            <h2>Create Exam</h2>
        <form action="controller" method="post" class="createexam_form">

            <input type="hidden" name="action" value="create_exam_user">
           
            <input type="text" name="exam_topic" required placeholder="enter the topic">

            <input type="text" name="exam_name" required placeholder="enter the exam name">

            <input type="text" name="description" required placeholder="enter the description">

			<input type="text" name="add_question" required placeholder="number of questions">
            <input type="text" name="pass_min_correct" required placeholder="enter the minimum marks">

            <input type="text" name="total_marks" required placeholder="enter the total marks">
			 <input type="text" name="duration_minutes" required="required" placeholder="enter the total duration">

        

            <button>Create</button>
        </form>
    </div>
</body>
</html>
