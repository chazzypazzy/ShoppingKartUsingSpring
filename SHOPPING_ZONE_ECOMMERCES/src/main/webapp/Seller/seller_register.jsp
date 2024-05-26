<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register For Seller</title>
<%@ include file="../Components/bootstrapLink.jsp"%>
<style type="text/css">
body{
background-image : url("https://images.pexels.com/photos/5632371/pexels-photo-5632371.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
background-size: cover;
background-position: center;
}
.paint-card {
	box-shadow: 0 0 50px 0 rgba(10, 10, 10, 20);
	text-align: center;
}
</style>

</head>
<body>
	<%@ include file="../Components/navbar.jsp"%>
	<div class="container p-4">
		<div class="row">
			<div class="col-md-4 offset-md-1">
				<div class="car paint-card">
					<div class="card-body">
					<h3>SELLER REGISTERATION</h3><br>
						<form:form action="submitForm" method="post"
							modelAttribute="seller">
							<form:input path="name" placeholder="Enter Your Name" />
							<br>
							<br>
							<form:input path="mobile" placeholder="Enter Your Number" />
							<br>
							<br>
							<form:input path="email" placeholder="Enter Your Email" />
							<br>
							<br>
							<form:password path="password" placeholder="Enter Your Password" />
							<br>
							<br>
							<form:input path="address" placeholder="Enter Your Address" />
							<br>
							<br>
							<form:button class="btn btn-danger">Submit</form:button>
						</form:form>
						<br> <label>Already Account?<a
							href="${pageContext.request.contextPath }/Seller/seller_login.jsp">
								Sign In</a></label>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>