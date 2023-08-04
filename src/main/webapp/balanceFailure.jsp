<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Balance Failure</title>
</head>
<body>
<h1>
<%
session = request.getSession();
out.println("Dear " + session.getAttribute("cust_name")+ ", your balance coild not be fetch");

%></h1>

</body>
</html>