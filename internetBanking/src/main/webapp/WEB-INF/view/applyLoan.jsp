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
            <h1>Apply Loan</h1><br>
            
                    <form:form onsubmit="return validate()" action="loanApplication" modelAttribute="loan" method="POST">
                        <label>Name :</label>
                        <form:input path="name" type="text" name="name" id="name"/><br><br>

                        <label>Date of Birth :</label>
                        <form:input path="date" type="date" name="dob" id="dob"/><br><br>

                        <label>Phone Number :</label>
                        <form:input path="number" type="number" name="number" id="number"/><br><br>

                        <label>Address :</label>
                        <form:textarea path="address" name="address" id="address" cols="30" rows="3"></form:textarea><br><br>

                        <label>Salary Statement :</label>
                        <form:input path="statement" type="file" name="statement" id="statement"/><br><br>

                        <label>Passport size photo :</label>
                        <form:input path="photo" type="file" name="photo" id="photo"/><br><br>

                        <label>Sign :</label>
                        <form:input path="sign" type="file" name="sign" id="sign"/><br><br>

                        <button type="submit">Submit</button>
                    </form:form>
    </section>
    
</body>
<script src="/js/applyLoan.js"></script>
</html>
