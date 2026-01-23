<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Exam (All-in-One)</title>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        background-color: #f4f6f8;
    }

    .container {
        min-height: 100vh;
        display: flex;
        justify-content: center;
        align-items: flex-start;
        padding-top: 30px;
    }

    form {
        background: #fff;
        width: 600px;
        padding: 30px;
        border-radius: 6px;
        box-shadow: 0 2px 10px rgba(0,0,0,0.1);
    }

    h2 {
        text-align: center;
        margin-bottom: 20px;
    }

    h3 {
        margin-top: 25px;
        border-bottom: 1px solid #ccc;
        padding-bottom: 5px;
    }

    label {
        display: block;
        margin-top: 10px;
        font-weight: bold;
    }

    input[type="text"],
    textarea {
        width: 100%;
        padding: 8px;
        margin-top: 5px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    textarea {
        resize: vertical;
    }

    .radio-group {
        margin-top: 10px;
    }

    .radio-group label {
        font-weight: normal;
        margin-right: 15px;
    }

    button {
        margin-top: 25px;
        width: 100%;
        padding: 12px;
        background: #28a745;
        border: none;
        color: #fff;
        font-size: 16px;
        border-radius: 4px;
        cursor: pointer;
    }

    button:hover {
        background: #218838;
    }
</style>
</head>

<body>
<div class="container">
<form action="controller" method="post">

    <h2>Create Exam (Complete)</h2>
    <input type="hidden" name="action" value="create_exam_user">

    <!-- ================= Exam Details ================= -->
    <h3>Exam Details</h3>
	 <input type="hidden" name="user_id" value="1">
    <label>Exam ID</label>
    <input type="text" name="exam_id" required>

    <label>Topic</label>
    <input type="text" name="exam_topic" required>

    <label>Exam Name</label>
    <input type="text" name="exam_name" required>

    <label>Description</label>
    <textarea name="description" rows="2"></textarea>

    <label>Status</label>
    <div class="radio-group">
        <input type="radio" name="status" value="ACTIVE" checked> Active
        <input type="radio" name="status" value="RETIRED"> Retired
    </div>

    <label>Minimum Correct Answers</label>
    <input type="text" name="pass_min_correct">

    <label>Total Marks</label>
    <input type="text" name="total_marks">

    <label>Duration (minutes)</label>
    <input type="text" name="duration_minutes">

    <!-- ================= Question ================= -->
    <h3>Question</h3>

    <label>Question ID</label>
    <input type="text" name="question_id" required>

    <label>Question Text</label>
    <textarea name="question_text" rows="4" required></textarea>

    <label>Marks</label>
    <input type="text" name="marks">

    <!-- ================= Answers ================= -->
    <h3>Answers</h3>

    
    <label>Option 1</label>
    <input type="radio" name="correct_option" value="1"> 
    <input type="text" name="option_1" required>

    <label>Option 2</label>
    <input type="radio" name="correct_option" value="2">
    <input type="text" name="option_2" required>

    <label>Option 3</label>
    <input type="radio" name="correct_option" value="3">
    <input type="text" name="option_3" required>

    <label>Option 4</label>
    <input type="radio" name="correct_option" value="4">
    <input type="text" name="option_4" required>

    <!-- ================= Submit ================= -->
    <button type="submit">Create Exam</button>

</form>
</div>
</body>
</html>
