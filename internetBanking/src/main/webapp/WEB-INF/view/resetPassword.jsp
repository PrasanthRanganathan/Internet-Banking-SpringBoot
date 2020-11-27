<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feather Bank</title>
<link rel="stylesheet" type="text/css" href="/css/resetPassword.css">
</head>
<body>
	<header>
		<img class="img" src="/images/logo1.jpg" alt="Logo of Feather Bank"
			width="60px" height="40px">
		<h1 class="name">Feather Bank</h1>
		<div class="link">
			<a class="a" href="indexPage">Home</a>
		</div>
	</header>

	<section>
		<div class="form">
			<h1>Reset Password</h1>
			<form onsubmit="return validate()"  action="changePassword" method="post">
				<label>New Password :</label> 
				<input  type="password" name="npwd" id="npwd" /><br>
				<br> <label>Conform Password :</label> 
				<input type="password" name="password" id="cpwd" /><br>
				<br>

				<button type="submit" class="btn">Submit</button>
			</form>
		</div>
	</section>
	<script src="/js/reset.js"></script>
</body>
</html>