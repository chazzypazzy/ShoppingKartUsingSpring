<%@page import="com.org.daoImplementation.UserDaoImplement"%>
<%@page import="com.org.dto.User"%>
<%@page import="com.org.dto.Item"%>
<%@page import="com.org.daoImplementation.ProductDaoImplementation"%>
<%@page import="com.org.dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dto.Seller"%>
<%@page import="com.org.daoImplementation.SellerDaoImplementation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../Components/bootstrapLink.jsp"%>
</head>
<body>
	<%@ include file="../Components/user_navbar.jsp"%>
	<h1>Welcome To Payment Gateway</h1>
	<%
	Product product = (Product) session.getAttribute("buy");
	int userId = (int) session.getAttribute("userId");
	User user = new UserDaoImplement().FetchUserByID(userId);
	
	%>
	<center>${failpayment }</center>
	<table border="2" class="table">
		<tr>
			<td><b>PRODUCT'S NAME</b></td>
			<td><b>PRODUCT'S PRICE</b></td>
			<td><b>PRODUCT'S DESCRIPTION</b></td>
			<td><b>CUSTOMER NAME</b></td>
			<td><b>MOBILE</b></td>
			<td><b>EMAIL</b></td>
			<td><b>ADDRESS</b></td>
		</tr>
		<tr>
			<td><%=product.getName()%></td>
			<td><%=product.getPrice()%></td>
			<td><%=product.getDescription()%></td>
			<td><%=user.getName()%></td>
			<td><%=user.getMobile() %></td>
			<td><%=user.getEmail() %></td>
			<td><%=user.getAddress() %></td>			
		</tr>
	</table>
	<center>
		<p><b>Price Details</b></p>
		<p>Price : <%=product.getPrice()%></p>
		<p>Delivery Charges : FREE Delivery</p><br><br>
		<p><b>Total Amount : $<%=product.getPrice()%></b></p>
		<a class="btn-primary btn" href="${pageContext.request.contextPath}/confirm_buy">Pay Now</a>
		<a class="btn btn-danger" href="${pageContext.request.contextPath}/User/user_home.jsp">Cancel</a>
	</center>
</body>
</html>