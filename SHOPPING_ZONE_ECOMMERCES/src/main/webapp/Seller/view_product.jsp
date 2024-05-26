<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page import="com.org.dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dao.SellerDao"%>
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
	<%@ include file="../Components/seller_navbar.jsp"%>
	<%
	Object obj = session.getAttribute("sellerId");
	if(obj!=null)
	{
	int sellerId = (int) session.getAttribute("sellerId");
	Seller seller = new SellerDaoImplementation().FetchSellerById(sellerId);
	List<Product> product = seller.getProducts();
	%>
	<h1>View Your Products</h1>
	<table border="2" class="table">
		<tr>
			<th>Name</th>
			<th>Price</th>
			<th>Category</th>
			<th>Description</th>
			<th>StockLeft</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="p" items="<%=product%>">
			<tr>
				<td>${p.getName()}</td>
				<td>${p.getPrice()}</td>
				<td>${p.getCategory()}</td>
				<td>${p.getDescription()}</td>
				<td>${p.getStockLeft()}</td>
				<td><a href="${pageContext.request.contextPath}/update_product?productId=${p.getId()}">Update</a></td>
				<td><a href="${pageContext.request.contextPath}/delete_product?productId=${p.getId()}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<%}%>
</body>
</html>