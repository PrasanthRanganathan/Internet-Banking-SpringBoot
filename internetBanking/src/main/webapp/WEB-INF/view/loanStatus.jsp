<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feather Bank - Loans</title>
<link rel="stylesheet" type="text/css" href="/css/loans.css">
</head>
<body>
	<header>
        <img class="img" src="/images/logo1.jpg" alt="Logo of Feather Bank" width="60px" height="40px">
        <h1 class="name">Feather Bank</h1>
        <div class="link"> <img src="/images/login.png" alt="Img" width="15px" height="15px"> <a class="a" href="indexPage">SignOut</a></div>
    </header>
     <nav>
        <br>
        <a href="welcome">Home</a>
        <a href="viewStatement">View Statement</a>
        <a href="moneyTransfer" >Money Transfer</a>
        <a href="recharge" >Recharge</a>
        <a href="cards" >Cards</a>
        <a href="loans" >Loans</a>
    </nav>
    
    <section>
            <h1>Loan Status</h1><br>
            
            <div class="status">Loan application : <%=session.getAttribute("status") %></div>
    </section>
    
</body>
</html>
