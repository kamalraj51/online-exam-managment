<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question</title>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        background-color: #f4f6f8;
    }

    .container {
        min-height: 100vh;
        width: 100vw;
        display: flex;
        justify-content: center;
        align-items: flex-start;
        padding-top: 40px;
        box-sizing: border-box;
    }

    form {
        background-color: #ffffff;
        border: 1px solid #ccc;
        padding: 25px 30px;
        border-radius: 6px;
        box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        width: 420px;
        box-sizing: border-box;
    }

    h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }

    label {
        display: block;
        font-weight: bold;
        margin-bottom: 5px;
        color: #555;
    }

    input[type="text"],
    textarea {
        width: 100%;
        padding: 8px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        font-family: Arial, sans-serif;
    }

    textarea {
        resize: vertical;
    }

    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #007bff;
        border: none;
        color: white;
        font-size: 16px;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }
</style>
</head>

<body>
    <div class="container">
        <form action="controller" method="post">
            <h2>Add Question</h2>

            <label>Question Id</label>
            <input type="text" name="question_id" required="required">

            <label>Exam Id</label>
            <input type="text" name="exam_id" required="required">

            <label>Question</label>
            <textarea rows="5" name="question_text" required="required"></textarea>

            <label>Marks</label>
            <input type="text" name="marks">

            <input type="submit" name="action" value="Answers">
        </form>
    </div>
</body>
</html>
