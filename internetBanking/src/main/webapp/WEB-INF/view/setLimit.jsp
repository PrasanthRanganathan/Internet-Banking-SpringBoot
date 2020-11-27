<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feather Bank - Cards</title>
<link rel="stylesheet" type="text/css" href="/css/cards.css">
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
        <h1>Card Manager : Set withdrawal Limit</h1><br>

        <form onsubmit="return validate()" action="setCardLimit" method="post">
            <label>Set Limit</label>
            <select name="limit" id="limit">
                <option style="display: none;" value=""></option>
                <option value="5000">&#x20b9; 5000</option>
                <option value="10000">&#x20b9; 10000</option>
                <option value="20000">&#x20b9; 20000</option>
                <option value="30000">&#x20b9; 30000</option>
            </select><br><br>
            <button type="submit">Submit</button>
        </form>
    </section>
    
<script src="/js/setLimit.js"></script>
</body>
</html>