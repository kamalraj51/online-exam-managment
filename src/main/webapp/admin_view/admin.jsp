<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>
<link rel="stylesheet" href="css/style.css"/>
</head>


<body  style="background-image: url('assets/bgplain.jpg'); background-size: 100%; background-repeat: no-repeat;">
    <jsp:include page="/common/header.jsp"/>
       <div class="nav_container">
    
         <form action="controller" method="post" class="admin_form">
           

            <button  name="action" value="create_exam"> Create Exam</button>
            <button  name="action" value="activeretire_exam"> Active/Retire Exam</button>
            <button  name="action" value="user_based_history"> User History</button>
            <button  name="action" value="exam_based_history"> Exam History</button>
            <!-- kamal added this signup button  -->
            <button  name="action" value="signup_admin">Admin SignUp</button>

        </form>
    </div>
     <div id="toast" class="<%= session.getAttribute("adminToastStatus") != null 
             ? session.getAttribute("adminToastStatus") 
             : "" %>">
        		<%=(session.getAttribute("adminToast")!=null)?session.getAttribute("adminToast"):"" %>
        </div>
    <jsp:include page="/common/footer.jsp"/>
    </body>
    <script >

	window.onload = function(){
	var message = "<%=session.getAttribute("adminToast")%>";
	if(message && message !=="null"){
		var toast = document.getElementById("toast");
		toast.classList.add("show");
		
		setTimeout(function(){
			toast.classList.remove("show");
		}, 3000);
	}
};
	
</script>

<%
    session.removeAttribute("adminToast");
%>
</html>
