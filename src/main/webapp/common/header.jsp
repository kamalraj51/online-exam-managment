<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="header">

  <nav>
    <div class="profile_img_div">
      <img src="assets/Person-Icon.jpg" class="profile_img">
      <h3>Welcome <%=session.getAttribute("username") %></h3>
    </div>
  <h1  style="color:white">Online Exam Management</h1>

    <div class="menu">
      <form action="controller" method="post">
      <button name="action" value="load_history">Home</button>
      <button name="action" value="about">About</button>
      <button name="action" value="logout">Logout</button>
      </form>

     
     
    </div>
  </nav>
</div>

