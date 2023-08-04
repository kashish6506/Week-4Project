<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Details</title>
</head>
<body>
<h3 align="center">LOAN DETAILS</h3>
	<%
	session = request.getSession();
	out.println("Loan ID: " + session.getAttribute("lid"));
	out.println("<pre> </pre>");
	out.println("Loan Type: " + session.getAttribute("l_type"));
	out.println("<pre> </pre>");
	out.println("Tenure: " + session.getAttribute("tenure"));
	out.println("<pre> </pre>");
	out.println("Rate of Interest: " + session.getAttribute("interest"));
	out.println("<pre> </pre>");
	out.println("Description: " + session.getAttribute("description"));
	out.println("<pre> </pre>");
	%>

	<br>
	<br>
	<a href="Home.jsp">Click here to Redirect </a>
</body>
</html>