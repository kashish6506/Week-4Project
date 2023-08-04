<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<style type="text/css">
p {
  font-size: 25px;
  line-height: 29px;
  color: rgba(28, 54, 83, 0.6);
  padding-bottom: 20px; }
  h1 {
  font-size: 50px; }
  body {
  font-family: "Open Sans", sans-serif;
  font-weight: 300;
  color:black;
  -webkit-text-size-adjust: 100%; 
  background-color: #d5f5d6;
  }

h1 {
  margin: 0 0 30px 0;
  text-align: center;
}

a {
  color: #FF5274;
  -webkit-transition-timing-function: ease;
  transition-timing-function: ease;
  -webkit-transition-duration: 200ms;
  transition-duration: 200ms;
  -webkit-transition-property: color, border-color, background-color;
  transition-property: color, border-color, background-color; }
  .btn {
  font-size: 13px;
  border: solid 2px;
  border-radius: 40px;
  display: inline-block;
  text-transform: uppercase; }

.btn:hover, .btn:focus {
  color: #fff;
  border-color: #FF5274;
  background-color: #FF5274; }

.btn-white {
  font-size: 13px;
  border: solid 2px;
  border-radius: 40px;
  display: inline-block;
  border-color: #fff; }

.btn-white:hover, .btn-white:focus {
  color: #FF5274;
  border-color: #FF5274; }

.btn-fill {
  color: #fff;
  border: solid 2px #FF5274;
  border-radius: 40px;
  display: inline-block;
  text-transform: uppercase;
  background-color: #FF5274; }

.btn-fill:hover, .btn-fill:focus {
  color: #fff;
  background-color: #D7405D;
  border-color: #D7405D; }

.btn-small {
  padding: 8px 40px; }

.btn-large {
  padding: 15px 40px; }

.btn-margin-right {
  margin-right: 20px; }
  .no-padding {
  padding: 0; }

.no-margin {
  margin: 0; }
  
</style>
</head>

<body >
<h1 align="center" >Welcome to Bank Application</h1>
<br>
<br>
<div align="center">
<p >
<%
session = request.getSession();
String s1 = (String) session.getAttribute("customer_name");
out.println(s1 +" Welcome to your account. Please select an operation to perform");

%>
</p>
</div>
<p class="intro" ></p><br><br>
<div align="center">
	<a href="CheckBalance" align="center"class="btn btn-fill btn-large btn-margin-right" >Check Balance</a> 
	<a href="changePwd.html" class="btn btn-fill btn-large btn-margin-right" align="center">Change Password</a>
	<a href="Loan.jsp" class="btn btn-fill btn-large btn-margin-right" align="center">Apply Loan</a>
	<a href="Transfer.html" class="btn btn-fill btn-large btn-margin-right" align="center">Transfer Amount</a>
	<a href="viewTransfer.jsp" class="btn btn-fill btn-large btn-margin-right" align="center">View Transfer</a>
	<a href="Logout" class="btn btn-fill btn-large btn-margin-right" align="center">Logout</a>
	
</div>


</div>

</body>

</html>