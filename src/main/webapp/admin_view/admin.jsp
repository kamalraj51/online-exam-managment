<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>

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
       <div class="nav_container">
    
         <form action="controller" method="post" class="admin_form">
           

            <button  name="action" value="create_exam"> Create Exam</button>
            <button name="action" value="edit_exam">Edit Exam</button>
            <button  name="action" value="activeretire_exam"> Active/Retire Exam</button>
            <button  name="action" value="user_based_history"> User History</button>
            <button  name="action" value="exam_based_history"> Exam History</button>
            <!-- kamal added this signup button  -->
            <button  name="action" value="signup_admin">Admin SignUp</button>

        </form>
    </div>
    <jsp:include page="/common/footer.jsp"/>
</body>
</html>
