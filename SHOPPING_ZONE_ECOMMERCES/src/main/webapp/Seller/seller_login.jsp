<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../Components/bootstrapLink.jsp"%>
<style type="text/css">
body {
	background-image:
		url("https://images.pexels.com/photos/5632371/pexels-photo-5632371.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
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
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-1">
				<div class="car paint-card">
					<div class="card-body">
						<h3>SELLER LOGIN</h3>
						${fail}${sellerOTP}${sellerverifyOTP}${sellerconfirmpwd}${sellerviewproduct}${sellerlogout}${addproduct }
						${addproduct}${updateproduct}${deleteproduct}${etyseller }<br>

						<form action="${pageContext.request.contextPath}/sellerLogin"
							method="post">
							<input type="email" placeholder="ENTER YOUR EMAIL" name="email"><br>
							<br> <input type="password"
								placeholder="ENTER YOUR PASSWORD" name="password"><br>
							<br> <input type="submit" value="SUBMIT" class="btn btn-danger">
						</form>
						<br> <label>Not Register?<a
							href="${pageContext.request.contextPath}/emptySeller"> Sign
								Up</a></label><br> <label><a
							href="${pageContext.request.contextPath}/Seller/seller_forgot_password.jsp">Forgot
								Password?</a></label>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>