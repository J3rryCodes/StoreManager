<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="bootstrap-4.5.0/css/bootstrap.min.css">
<script src="bootstrap-4.5.0/js/jquery-3.5.1.min.js"></script>
<script src="bootstrap-4.5.0/js/bootstrap.min.js"></script>
<script>
	$(document).ready(function() {
		$('.dropdown-toggle').dropdown();
	});
</script>

<title>Update</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
	<br>
		<h3 class="page-header">Add New Product</h3>
<br>
		<form action="AddProduct" method="get">
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">#</th>
						<th scope="col">Product</th>
						<th scope="col">Action</th>
					</tr>
					<c:if test="${products ne null}">
						<c:set var="count" value="${0}"></c:set>
						<c:forEach items="${products}" var="product">
							<c:set var="count" value="${count+1}"></c:set>
							<tr>
								<td scope="col">${count}</td>
								<td scope="col">${product.getProduct()}</td>
								<td scope="col"><button type="button" class="btn btn-primary col-md-8">Edit</button></td>
							</tr>
						</c:forEach>
					</c:if>
					<tr>
						<td><h1>*</h1></td>
						<td>
							<div class="form-group">
								<input type="text" class="form-control" name="product"
									placeholder="New Product">
							</div>
						</td>
						<td>
							<div class="form-group">
								<button type="submit" class="btn btn-success col-md-8">Add</button>
							</div>
						</td>
					</tr>
				</thead>
			</table>
		</form>
		<!-- <form action="AddProduct" method="get">
			<div class="form-row">
				<div class="form-group col-md-8">
					<input type="text" class="form-control" name="product"
						placeholder="New Product">
				</div>
				<div class="form-group col-md-2">
					<button type="submit" class="btn btn-primary col-md-8">Add</button>
				</div>
			</div>
		</form> -->
	</div>
</body>
</html>