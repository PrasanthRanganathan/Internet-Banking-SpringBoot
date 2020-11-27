<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feather Bank - Home</title>
<link rel="stylesheet" type="text/css" href="/css/welcome.css">
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
        <h1>Account Summary</h1>
            <h2 class="h2">Welcome <%=(session.getAttribute("name")) %></h2>
        <div> Savings Account
        <span class="span1">Account Balance : &#x20b9; <%= session.getAttribute("balance") %></span></div>
         
        
         <p>         
         Note:	 <br><br>
	The Available Balance displayed includes the credit balance and overdraft limit (if any) in your account.<br>
   (i) It does not include Uncleared Funds.<br>
   (ii) It includes amount marked for hold.<br>
	The Hold Balance may also include pending service charges due to be recovered from your account.<br>
	Savings account customers can now receive their statements monthly, by email, for free.<br>
	What's New ! Now recharge your Prepaid Mobile and DTH connections through BillPay and Recharge!
         </p>
        
    </section>
</body>
</html>