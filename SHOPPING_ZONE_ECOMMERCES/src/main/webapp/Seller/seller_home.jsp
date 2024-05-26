<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../Components/bootstrapLink.jsp"%>
</head>
<body>
	<%@ include file="../Components/seller_navbar.jsp"%>
	<%
	Object obj = session.getAttribute("sellerId");
	if (obj != null) {
	%>
	<h1>Welcome to Seller home page</h1>
	<%
	}
	else{
	RequestDispatcher rd = request.getRequestDispatcher("seller_login.jsp");
	rd.forward(request, response);
	}
	%>
</body>
</html>