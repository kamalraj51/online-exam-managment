<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Exam</title>

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
        align-items: flex-start;   /* FIX */
        padding-top: 40px;         /* FIX */
        box-sizing: border-box;
    }

    form {
        background-color: #ffffff;
        border: 1px solid #ccc;
        padding: 30px 40px;
        border-radius: 6px;
        box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        width: 420px;
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

    input[type="text"] {
        width: 100%;
        padding: 8px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    .radio-group {
        margin-bottom: 15px;
    }

    .radio-group label {
        display: inline;
        font-weight: normal;
        margin-right: 10px;
    }

    button {
        width: 100%;
        padding: 10px;
        background-color: #28a745;
        border: none;
        color: white;
        font-size: 16px;
        border-radius: 4px;
        cursor: pointer;
    }

    button:hover {
        background-color: #218838;
    }
</style>
</head>

<body>
    <div class="container">
        <form action="controller" method="post">
            <h2>Create Exam</h2>

            <input type="hidden" name="action" value="create_exam_user">

            <label>Exam Id</label>
            <input type="text" name="exam_id" required>

            <label>Topic</label>
            <input type="text" name="exam_topic" required>

            <label>Name</label>
            <input type="text" name="exam_name" required>

            <label>Description</label>
            <input type="text" name="description" required>

            <label>Status</label>
            <div class="radio-group">
                <input type="radio" name="status" value="ACTIVE"> Active
                <input type="radio" name="status" value="RETIRED"> Retired
            </div>

            <label>Minimum Correct Answer</label>
            <input type="text" name="pass_min_correct" required>

            <label>Total Marks</label>
            <input type="text" name="total_marks" required>

            <label>Duration</label>
            <input type="text" name="duration_minutes">

            <input type="hidden" name="user_id" value="1">

            <button>Create</button>
        </form>
    </div>
</body>
</html>
