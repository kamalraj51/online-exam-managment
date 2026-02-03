<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>

<link rel="stylesheet" href="css/style2.css"/>

</head>
<body>
	<div class="container">

		<div class="img_container">
			<img class="img_style" alt="no image" src="./assets/bgplain.jpg" />
		</div>
		<div class="form_container">
			<h2>Signup as user</h2>


			<form action="controller" method="post" class="login_form">

				<input type="hidden" value="signup_user" name="action">

				<div class="label-style">
					<input type="text" name="username" placeholder=""
						value="<%=request.getParameter("username") != null ? request.getParameter("username") : ""%>">
					<label for="username">Enter the username</label>
				</div>

				<div class="label-style">
					<input type="text" name="email" placeholder=""
						value="<%=request.getParameter("email") != null ? request.getParameter("email") : ""%>">
					<label for="email">Enter the email</label>
				</div>

				<div class="label-style">
					<input type="password" name="password" placeholder=""
						value="<%=request.getParameter("password") != null ? request.getParameter("password") : ""%>">
					<label for="password">Enter the password</label>
				</div>
				<div class="label-style">
					<input type="password" name="confirm_password" placeholder=""
					value="<%=request.getParameter("password") != null ? request.getParameter("confirm_password") : ""%>">
					<label for="confirm_password">Confirm the password</label>
				</div>
				<input type="hidden" value="2" name="role_id">

				<button type="submit" class="login_btn">Signup</button>
			</form>
			<form class="new_user" action="controller" method="post">

				<p class="login_text">Already signed up? -</p>
				<button name="action" value="login" class="signup_button">Login
				</button>
			</form>
		</div>
	</div>
</body>
<script>
document.addEventListener("DOMContentLoaded", function () {

    const form = document.querySelector(".login_form");
    const usernameInput = form.querySelector('input[name="username"]');
    const emailInput = form.querySelector('input[name="email"]');
    const passwordInput = form.querySelector('input[name="password"]');
    const confirmPasswordInput = form.querySelector('input[name="confirm_password"]');
	
    const backendEmailError = "<%= request.getAttribute("signupErrorEmail") != null ? request.getAttribute("signupErrorEmail") : "" %>";
    
    
    const userRegex = /^[a-zA-Z][a-zA-Z0-9_]{4,14}$/;
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/;
    const passRegex = /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d).{8,}$/;
    
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

    usernameInput.addEventListener("input", () => removeError(usernameInput));
    emailInput.addEventListener("input", () => removeError(emailInput));
    passwordInput.addEventListener("input", () => removeError(passwordInput));
    confirmPasswordInput.addEventListener("input", () => removeError(confirmPasswordInput));

    if (backendEmailError !== "") {
        showError(emailInput, backendEmailError);
    }
    form.addEventListener("submit", function (e) {
        let isValid = true;

        // Username validation
        if (usernameInput.value.trim() === "") {
            showError(usernameInput, "Username is required");
            isValid = false;
        } else if (!userRegex.test(usernameInput.value.trim())) {
            showError(
                usernameInput,
                "Username must start with a letter and be 5–15 characters"
            );
            isValid = false;
        }

        // Email validation
        if (emailInput.value.trim() === "") {
            showError(emailInput, "Email is required");
            isValid = false;
        } else if (!emailRegex.test(emailInput.value.trim())) {
            showError(emailInput, "Enter a valid email address");
            isValid = false;
        }

        // Password validation
        if (passwordInput.value.trim() === "") {
            showError(passwordInput, "Password is required");
            isValid = false;
        } else if (!passRegex.test(passwordInput.value.trim())) {
            showError(
                passwordInput,
                "Password must be at least 8 characters with uppercase, lowercase & number"
            );
            isValid = false;
        }
     // Confirm password validation
        if (confirmPasswordInput.value.trim() === "") {
            showError(confirmPasswordInput, "Confirm password is required");
            isValid = false;
        } else if (passwordInput.value !== confirmPasswordInput.value) {
            showError(confirmPasswordInput, "Passwords do not match");
            isValid = false;
        }

        if (!isValid) {
            e.preventDefault();
        }
    });
});
</script>

<style>
.js-error {
	color: #e63946;
	font-size: 12px;
	margin-top: 5px;
	font-weight: 600;
}
</style>
</html>
