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
	<h1>Welcome User</h1>
	<%
	Object obj = session.getAttribute("userId");

	if (obj != null) {
		ProductDaoImplementation dao = new ProductDaoImplementation();
		List<Product> product = dao.FetchAllProducts();
	%>
	<table border="2" class="table">
		<tr>
			<th>Name</th>
			<th>Price</th>
			<th>Category</th>
			<th>Description</th>
			<th>StockLeft</th>
			<th>Add Cart</th>
			<th>Buy Now</th>
		</tr>
		<c:forEach var="p" items="<%=product%>">
			<tr>
				<td>${p.getName()}</td>
				<td>${p.getPrice()}</td>
				<td>${p.getCategory()}</td>
				<td>${p.getDescription()}</td>
				<td>${p.getStockLeft()}</td>
				<td><a
					href="${pageContext.request.contextPath}/add_item?productId=${p.getId()}">Add
						To Cart</a></td>
				<td><a
					href="${pageContext.request.contextPath}/buy_item?productId=${p.getId()}">Buy
						Now</a></td>
			</tr>
		</c:forEach>
	</table>
	<%
	}
	else{
		RequestDispatcher rd = request.getRequestDispatcher("user_login.jsp");
		rd.forward(request, response);
		}
	%>
	<center>
	${success}
	</center>
</body>
</html>