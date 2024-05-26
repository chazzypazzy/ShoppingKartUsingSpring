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
		url("https://images.pexels.com/photos/8829445/pexels-photo-8829445.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
	background-size: cover;
	background-position: center;
}

.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 50);
	text-align: center;
}
</style>
</head>
<body>
	<%@ include file="../Components/navbar.jsp"%>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="car paint-card">
					<div class="card-body">
						<h3>CUSTOMER VERIFY OTP</h3>
						${failOTP }<br>
						<form action="${pageContext.request.contextPath}/verify_otp">
							<input type="text" name="otp" placeholder="Enter Your OTP"><br>
							<br> <input type="submit" value="Verify"
								class="btn btn-danger"><br> <br>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>