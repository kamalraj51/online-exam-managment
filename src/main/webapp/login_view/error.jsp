<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<title>Error</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f8f9fa;
	text-align: center;
	padding-top: 100px;
}

.error-box {
	background: #fff;
	padding: 30px;
	width: 500px;
	margin: auto;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h2 {
	color: #dc3545;
}

.login_btn {
	background-color: #061E29;
	border: none;
	color: white;
	height: 40px;
	width: 30%;
	border-radius: 10px;
	font-size: 18px;
	font-weight: bold;
	border-radius: 10px;
	padding: 10px;
	transition: background-color 0.3s;
}
</style>

</head>
<body>
	<form action="controller" method="post">
		<input type="hidden" value="authorize" name="action">

		<div class="error-box">
			<h2>Something went wrong 😞</h2>

			<p>${errorMessage != null ? errorMessage : "Unexpected error occurred. Please try again later."}
			</p>

			<button class="login_btn">Go To Home</button>
		</div>
	</form>
</body>
</html>
