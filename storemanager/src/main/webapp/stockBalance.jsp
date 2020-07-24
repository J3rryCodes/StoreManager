<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
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

<title>Add Stock</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
	<br>
		<div class="row">
			<div class="col-md-10">
				<h3 class="page-header">Stock Balance</h3>
			</div>
		</div>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Product</th>
					<th scope="col">Rate/kg.</th>
					<th scope="col">Total Quantity</th>
					<th scope="col">Last update
				</tr>
				<c:if test="${stocks ne null}">
					<c:set var="count" value="${0}"></c:set>
					<c:forEach items="${stocks}" var="s">
						<c:set var="count" value="${count+1}"></c:set>
						<tr>
							<td scope="col">${count}</td>
							<td scope="col">${s.getProduct()}</td>
							<td scope="col">${s.getRatePerKg()}Rs/kg</td>
							<td scope="col">${s.getTotalQuantity()}kg</td>
							<td scope="col">${s.getDate()}</td>
						</tr>
					</c:forEach>
				</c:if>
			</thead>
		</table>
		<c:if test="${productPayments.size() eq 0}">
			<p>
			<div class="text-info">No Records found</div>
			</p>
		</c:if>
	</div>
</body>
<script>
</script>
</html>