<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
/*Toast*/
#toast{
	visibility: hidden;
	width:250px;
	background-color: #28a745;
	color:#fff;
	text-align: center;
	padding: 15px;
	border-radius: 4px;
	position:fixed;
	z-index:999;
	left: 50%;
	 bottom: 30px;
  transform: translateX(-50%);
  font-size: 16px;
}

#toast.show{
	visibility: visible;
	 animation: fadein 0.5s, fadeout 0.5s 2.5s;
} 
#toast.success{
  background-color: #28a745;
  }
#toast.failed {
    background-color: #dc3545;
}

@keyframes fadein {
  from { bottom: 0; opacity: 0; }
  to { bottom: 30px; opacity: 1; }
}

@keyframes fadeout {
  from { bottom: 30px; opacity: 1; }
  to { bottom: 0; opacity: 0; }
}</style>
<link rel="stylesheet" href="css/style2.css"/>

</head>

<body style="background-color: #f9f5f0;">
	<div class="container">

		<div class="img_container">
			<img class="img_style" alt="no image" src="./assets/bgplain.jpg" />
		</div>
		<div class="form_container">
			<h2>Login as user</h2>

			<form action="controller" method="post" class="login_form">


				<input type="hidden" value="login_user" name="action">

				<div class="label-style">
					<input type="text" name="email" class="text" placeholder=""
						value="<%= request.getParameter("email") != null ? request.getParameter("email") : "" %>">
					<label for="email">Enter your email</label>
				</div>
				

				<div class="label-style password-wrapper">
					<input type="password" name="password" id="loginPassword" class="password" placeholder=""
						value="<%= request.getParameter("password") != null ? request.getParameter("password") : "" %>">
					<label for="password">Enter your password</label>
					<span class="toggle-password" onclick="togglePassword('loginPassword', this)">👁</span>
				</div>

				<button class="login_btn">Login</button>
			</form>
			<form class="new_user" action="controller" method="post">

				<p class="login_text">New user -</p>
				<button name="action" value="signup" class="signup_button">Signup
				</button>
			</form>
		</div>
	
		    
       
        </div>
        <div id="toast">
        		<%=(session.getAttribute("createAccToast")!=null)?session.getAttribute("createAccToast"):"hello" %>
        </div>

</body>

<script>
	window.onload = function(){
	var message = "<%=session.getAttribute("createAccToast")%>";
	if(message && message !=="null"){
		var toast = document.getElementById("toast");
		toast.classList.add("show");
		setTimeout(function(){
			toast.classList.remove("show");
		}, 3000);
	}
};
document.addEventListener("DOMContentLoaded", function () {

    const form = document.querySelector(".login_form");
    const emailInput = form.querySelector('input[name="email"]');
    const passwordInput = form.querySelector('input[name="password"]');
    
    const userRegex = /^[a-zA-Z][a-zA-Z0-9_]{4,14}$/;
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/;
    const passRegex = /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d).{8,}$/;
    
    const backendEmailError = "<%= request.getAttribute("loginErrorEmail") != null ? request.getAttribute("loginErrorEmail") : "" %>";
    const backendPasswordError = "<%= request.getAttribute("loginErrorPassword") != null ? request.getAttribute("loginErrorPassword") : "" %>";

    function showError(input, message) {
        removeError(input);

        const error = document.createElement("p");
        error.className = "js-error";
        error.innerText = message;

        input.classList.add("input-error");
        input.parentElement.appendChild(error);
    }

    function removeError(input) {
        input.classList.remove("input-error");
        const error = input.parentElement.querySelector(".js-error");
        if (error) error.remove();
    }

    emailInput.addEventListener("input", () => removeError(emailInput));
    passwordInput.addEventListener("input", () => removeError(passwordInput));

  
    if (backendEmailError !== "") {
        showError(emailInput, backendEmailError);
    }

    if (backendPasswordError !== "") {
        showError(passwordInput, backendPasswordError);
    }

    form.addEventListener("submit", function (e) {
        let isValid = true;

        if (emailInput.value.trim() === "") {
            showError(emailInput, "Email is required");
            isValid = false;
        } else if (!emailRegex.test(emailInput.value.trim())) {
            showError(emailInput, "Enter a valid email address");
            isValid = false;
        }

        if (passwordInput.value.trim() === "") {
            showError(passwordInput, "Password is required");
            isValid = false;
        }

        if (!isValid) {
            e.preventDefault();
        }
    });
});

   function togglePassword(inputId, eyeIcon) {
      const input = document.getElementById(inputId);

         if (input.type === "password") {
              input.type = "text";
              eyeIcon.textContent = "👀";
         } else {
              input.type = "password";
              eyeIcon.textContent = "👁";
    }
}	

</script>



<%
    session.removeAttribute("createAccToast");
%>
</html>
