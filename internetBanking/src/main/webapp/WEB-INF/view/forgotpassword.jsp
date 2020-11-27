<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feather Bank</title>
<link rel="stylesheet" type="text/css" href="/css/forgotpassword.css">
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
			<form:form onsubmit="return validate()" action="reset" modelAttribute="forgotpass" method="post">
				<label>User ID :</label> 
				<form:input path="id" type="number" name="id" id="id"/><br><br>
				 <label>Mobile number :</label> 
				 <form:input path="number" type="number" name="number" id="number"/><br><br>

				<button type="submit" class="btn">Submit</button>
			</form:form>
			<br>
		</div>
	</section>
	<script src="/js/forgotpass.js"></script>
</body>
</html>