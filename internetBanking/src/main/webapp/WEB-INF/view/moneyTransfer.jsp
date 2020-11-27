<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feather Bank</title>
<link rel="stylesheet" type="text/css" href="/css/moneyTransfer.css">
</head>
<body>

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
	
	<section>

        <h1>Money Transfer</h1>
        <form:form onsubmit="return validate()" modelAttribute="moneyTrans" action="transfer" method="post">
            <form:hidden path="remitteraccount" name="saccno" id="saccno"/><br><br>

            <label>Beneficiary Account number :</label>
            <form:input path="beneficiaryaccount" type="text" name="accno" id="accno"/><br><br>

            <label>Conform Beneficiary Account :</label>
            <input type="password" name="caccno" id="caccno"><br><br>

            <label>Beneficiary Name :</label>
            <form:input path="name" type="text" name="name" id="name"/><br><br>

            <label>Amount :</label>
            <form:input path="amount" type="text" name="amt" id="amt"/><br><br>

            <label>Payment Mode :</label>
            <form:select path="paymentmode" name="mode" id="mode">
                <form:option style="display: none;" value=""></form:option>
                <form:option value="NEFT" name="neft">NEFT</form:option>
                <form:option value="IMPS" name="imps">IMPS</form:option>
            </form:select><span id="msg6"></span><br><br>

            <label>Remarks :</label>
            <form:input path="remarks" type="text" name="remark" id="remark"/><br><br>

            <button type="submit">Submit</button>
            
        </form:form>
    </section>
    <script src="/js/moneyTransfer.js"></script>
</body>
</html>