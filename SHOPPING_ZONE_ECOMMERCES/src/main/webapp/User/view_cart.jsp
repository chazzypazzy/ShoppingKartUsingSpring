<%@page import="com.org.dto.Item"%>
<%@page import="java.util.List"%>
<%@page import="com.org.daoImplementation.UserDaoImplement"%>
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
	<center>
	<h1>View Cart</h1><br>
	<a href="<%=request.getContextPath()%>/User/user_payment1.jsp" class="btn btn-danger">Click To Pay All</a></center><br>
	<%
	int userId = (int) session.getAttribute("userId");
	List<Item> item = new UserDaoImplement().FetchUserByID(userId).getItems();
	%>
	<table border="2" class="table">
		<tr>
			<th>Name</th>
			<th>Price</th>
			<th>Category</th>
			<th>Description</th>
			<th>StockLeft</th>
			<th>Remove</th>
			<th>Buy Now</th>
		</tr>
		<c:forEach var="p" items="<%=item%>">
			<tr>
				<td>${p.getName()}</td>
				<td>${p.getPrice()}</td>
				<td>${p.getCategory()}</td>
				<td>${p.getDescription()}</td>
				<td>${p.getStockLeft()}</td>
				<td><a href="${pageContext.request.contextPath}/remove_item?itemId=${p.getId()}">Remove From Cart?</a></td>
				<td><a href="${pageContext.request.contextPath}/buy_item?itemId=${p.getId()}">Buy Now</a></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>