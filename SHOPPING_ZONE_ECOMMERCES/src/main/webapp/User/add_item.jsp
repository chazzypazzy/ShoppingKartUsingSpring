<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register For Seller</title>
<%@ include file="../Components/bootstrapLink.jsp"%>
</head>
<body>
	<%@ include file="../Components/user_navbar.jsp"%>
	${success}
	<form:form action="${pageContext.request.contextPath}/add_item" method="post" modelAttribute="item">
	<form:input path="name" placeholder="Enter Your Product Name"/><br><br>
	<form:input path="price" placeholder="Enter Your Product Price"/><br><br>
	<form:input path="category" placeholder="Enter Your Prodyct Category"/><br><br>
	<form:input path="description" placeholder="Enter Your Product Description"/><br><br>
	<form:input path="stockLeft" placeholder="Enter Your Quantity"/><br><br>
	<form:hidden path="id"/>
	<form:button>Submit</form:button>
	</form:form>
</body>
</html>