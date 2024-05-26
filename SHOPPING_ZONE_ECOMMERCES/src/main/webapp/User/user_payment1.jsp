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
<style>
.flex-container {
	display: flex;
	justify-content: center;
	align-content: center;
}

.price {
	margin-right: 300px;
}
</style>
</head>
<body>
	<%@ include file="../Components/user_navbar.jsp"%>
	<h1>View Cart</h1>
	<%
	int userId = (int) session.getAttribute("userId");
	List<Item> item = new UserDaoImplement().FetchUserByID(userId).getItems();
	Long cost = 0l;
	%>
	<div class="flex-container">
		<div class="price">
			<c:forEach var="i" items="<%=item%>">
				<p>
					<b>Products : ${i.getName()} ---> $${i.getPrice()}</b>
				<p>
			</c:forEach>
		</div>
		<div class="price">
			<center>
				<h1>Total Bill</h1>
				<c:set var="total" value="0" />
				<c:forEach var="p" items="<%=item%>">
					<h6>$${p.getPrice()}</h6>
					<c:set var="bill" value="${bill + p.getPrice()}" />
				</c:forEach>
				<hr>
				<h4>
					<b> $${bill} </b>
				</h4><br><br>
				<p><b>Price details</b></p>
				<p>Total Price : $${bill}</p>
				<p>Delivery Charges : Free Delivery</p>
			</center>
		</div>
	</div>
	<center>
		<a class="btn btn-primary" href="#">Pay Now</a> <a
			class="btn btn-danger"
			href="${pageContext.request.contextPath}/User/view_cart.jsp">Cancel
			Payment</a>
	</center>
</body>
</html>