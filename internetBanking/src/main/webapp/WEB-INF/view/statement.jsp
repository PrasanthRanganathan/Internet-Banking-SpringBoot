<%@page import="java.util.List"%>
<%@page import= "com.prasanth.internetBanking.dto.Statement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feather Bank - Statement</title>
<link rel="stylesheet" type="text/css" href="/css/welcome.css">
</head>
<body class="statement">

	<header>
		<img class="img" src="/images/logo1.jpg" alt="Logo of Feather Bank"
			width="60px" height="40px">
		<h1 class="name">Feather Bank</h1>
		<div class="link">
			<img src="/images/login.png" alt="Img" width="15px" height="15px">
			<a class="a" href="indexPage">SignOut</a>
		</div>
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
    
	<section style="padding-left: 10%; padding-right: 20%; color: black;">
		<h1>Statement</h1>
		<br>
		<table border="2px"
			style="border-collapse: collapse; text-align: center;">
			<tr>
				<th style="padding: 10px; width: 200px;">Remitter Account</th>
				<th style="padding: 10px; width: 200px;">Beneficiary Account</th>
				<th style="padding: 10px; width: 200px;">Beneficiary Name</th>
				<th style="padding: 10px; width: 200px;">Payment Mode</th>
				<th style="padding: 10px; width: 200px;">Amount</th>
				<th style="padding: 10px; width: 200px;">Remarks</th>
			</tr>

			<%
				List<String> list = (List<String>) request.getSession().getAttribute("statement");
				int k = 0;
				for (int i = 0; i < list.size() / 6; i++) {
			%>
			<tr>
				<%
					for (int j = 6; j > 0; j--) {
				%>
				<td style="padding: 10px; width: 200px;"><%=list.get(k++)%></td>

				<%
					}
				%>
			</tr>
			<%
				}
			%>

		</table>
	</section>
</body>
</html>