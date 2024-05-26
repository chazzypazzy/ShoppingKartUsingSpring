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
					<li class="nav-item"><a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/Seller/seller_home.jsp">Home</a></li>
					<li class="nav-item"><a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/emptyProduct">Add Products</a></li>
					<li class="nav-item"><a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/sellerviewProduct">View Products</a></li>
					<li class="nav-item"><a class="nav-link active" aria-current="page" href="#">Help?</a></li>
					<li class="nav-item"><a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath }/sellerlogout">Logout</a></li>
					
				</ul>
			</div>
		</div>
	</nav>