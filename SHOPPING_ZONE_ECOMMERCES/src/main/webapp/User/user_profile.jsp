<%@page import="java.util.List"%>
<%@page import="com.org.daoImplementation.UserDaoImplement"%>
<%@page import="com.org.dao.UserDao"%>
<%@page import="com.org.dto.User"%>
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
	<%@ include file="../Components/user_navbar.jsp"%>
	<h1>Profile</h1>
	<%
	User user = (User)session.getAttribute("profile");
	if (user != null) {
	%>
	<table border="2" class="table">
		<tr>
			<td>Name</td>
			<td>Mobile</td>
			<td>Email</td>
			<td>Address</td>
		</tr>
		<tr>
			<td><%=user.getName()%></td>
			<td><%=user.getMobile()%></td>
			<td><%=user.getEmail() %></td>
			<td><%=user.getAddress() %></td>
		</tr>
	</table>

	<%
	}
	%>

</body>
</html>