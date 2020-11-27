<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Feather Bank - Internet Banking</title>
<link rel="stylesheet" type="text/css" href="/css/index.css">
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
			<br>
			<h1>NetBanking LogIn</h1>

			<form:form onsubmit="return validate()" action="login" modelAttribute="SignIn" method="post">
                <label>User ID :</label>
                <form:input path="id" type="number" name="id" id="id"/><br><br>

                <label>Password :</label>
                <form:input path="password" type="password" name="pass" id="pass"/><br><br>

                <button type="submit" class="btn">SignIn</button>
            </form:form><br><br>

			<a href="forgotpassword" class="a">Forgot Password</a>
		</div>
	</section>
	<script src="/js/login.js"></script>
</body>
</html>