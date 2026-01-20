<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <h2>Login Page</h2>

  <form action = "controller" method = "post">
     
     <input type = "hidden" value = "login" name = "action">
     username:<input type = "text" name = "email" required><br><br>
     password:<input type = "password" name = "password"><br><br>
     <input type = "submit" value = "Login">
  </form>
  
   <form action = "/exam/controller" method = "post">
       <input type = "hidden" value = "logout" name = "action"/>
       <input type = "submit" value = "Logout">
       
   </form>

</body>
</html>