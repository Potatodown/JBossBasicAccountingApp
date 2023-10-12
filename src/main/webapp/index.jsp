<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Account Service</title>
</head>
<body>
<h1>Account Service
</h1>
<div class="main-content">
    <form action="<%= request.getContextPath()%>/account" method="post">
        <h3>Select your choice:</h3>
        <div class="radio">
            <input type="radio" id="deposit" name="transaction" value="Deposit">
            <label for="deposit">Deposit</label><br>
            <input type="radio" id="withdraw" name="transaction" value="Withdraw">
            <label for="withdraw">Withdraw</label><br>
        </div>
        <div class="amount">
            <label for="amount">Enter Amount:</label><br>
            <input type="number" step="0.01" id="amount" name="amount"><br>
        </div>
        <div class="options">
            <input type="submit" value="Submit">
            <input type="reset">
        </div>
    </form>
    <div class="uAmount">
        <h2>The Balance is: <% if (request.getAttribute("Balance") != null){%>$<%=request.getAttribute("Balance")%><%} else{%> $100<%}%></h2>
    </div>
</div>
</body>
</html>