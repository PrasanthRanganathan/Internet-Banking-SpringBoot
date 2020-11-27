<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feather Bank - Recharge</title>
<link rel="stylesheet" type="text/css" href="/css/recharge.css">
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

        <h1>Mobile Recharge</h1>
        <form:form onsubmit="return validate()" modelAttribute="moneyTrans" action="mobileRecharge" method="post">
            <form:hidden path="remitteraccount" name="saccno" id="saccno"/><br><br>
            <label>Select Operator :</label>
            <form:select path="name" name="operator" id="operator">
                <form:option style="display: none;" value=""></form:option>
                <form:option value="Jio" >JIO</form:option>
                <form:option value="Airtel" >AIRTEL</form:option>
                <form:option value="VI" >VI (VODAFONE-IDEA)</form:option>
                <form:option value="BSNL" >BSNL</form:option>
                <form:option value="Other" >Other</form:option>
            </form:select>   <br><br>
			<form:hidden path="beneficiaryaccount" name="num" id="num"/>
            <label>Mobile Number :</label>
            <input type="number" name="number" id="number"/><br><br>

            <label>Recharge Amount :</label>
            <form:input path="amount" type="number" name="amount" id="amount"/><br><br>
			<form:hidden path="paymentmode" value="online payment" name="numb" id="numb"/>
            <label>Password :</label>
            <form:input path="remarks" type="password" name="password" id="password"/><br><br>

            <button type="submit">Submit</button>
            
        </form:form>
    </section>
    
<script src="/js/recharge.js"></script>
</body>
</html>