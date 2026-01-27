<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="header">
  <h1>Online Exam Management</h1>

  <nav>
    <div>
      <a href="#">Profile</a>
      <h3>Welcome <%=session.getAttribute("username") %></h3>
    </div>

    <div class="menu">
      <a href="user_view/frontview.jsp">Home</a>
      <a href="#">About</a>
      <a href="#">Logout</a>
     
    </div>
  </nav>
</div>

