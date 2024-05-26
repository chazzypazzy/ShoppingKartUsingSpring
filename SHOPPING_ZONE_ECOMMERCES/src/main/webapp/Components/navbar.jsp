<nav class="navbar navbar-expand-lg navbar-dark bg-secondary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Shopi-FY</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="<%=request.getContextPath()%>/Main/index.jsp">Home</a></li>

					<div class="dropdown">
						<button class="btn btn-secondary dropdown-toggle" type="button"
							id="dropdownMenuButton1" data-bs-toggle="dropdown"
							aria-expanded="false">Customer</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
							<li><a class="dropdown-item" href="<%= request.getContextPath() %>/emptyUser">Sign Up</a></li>
							<li><a class="dropdown-item" href="<%=request.getContextPath()%>/User/user_login.jsp">Sign In</a></li>
						</ul>
					</div>
					<div class="dropdown">
						<button class="btn btn-secondary dropdown-toggle" type="button"
							id="dropdownMenuButton1" data-bs-toggle="dropdown"
							aria-expanded="false">Seller</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
							<li><a class="dropdown-item" href="${pageContext.request.contextPath}/emptySeller">Sign Up</a></li>
							<li><a class="dropdown-item" href="${pageContext.request.contextPath}/Seller/seller_login.jsp">Sign In</a></li>
						</ul>
					</div>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">About Us</a></li>
				</ul>
			</div>
		</div>
	</nav>