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

<title>Sales</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<br>
		<form action="AddSale" method="post">
			<div class="row">
				<div class="col-md-10">
					<h3 class="page-header">Sales</h3>
				</div>
				<div class="col-md-2 form-group">
					<input type="date" class="form-control" name="date" value="${date}" id="date" onchange="fetchRecords()">
				</div>
			</div>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">#</th>
						<th scope="col">Product</th>
						<th scope="col">Rate/kg</th>
						<th scope="col">Total Quantity(kg)</th>
						<th scope="col">Total Amount(Rs.)</th>
						<th scope="col">Action</th>
					</tr>
					<c:if test="${sales ne null}">
						<c:set var="count" value="${0}"></c:set>
						<c:forEach items="${sales}" var="sale">
							<c:set var="count" value="${count+1}"></c:set>
							<tr>
								<td scope="col">${count}</td>
								<td scope="col">${sale.getProduct()}</td>
								<td scope="col">${sale.getRatePerKg()}</td>
								<td scope="col">${sale.getQuantityOfSale()}</td>
								<td scope="col">${sale.getTotalAmount()}</td>
								<td scope="col"><button type="button"
										class="btn btn-primary col-md-8">Edit</button></td>
							</tr>
						</c:forEach>
					</c:if>
					<tr>
						<td><h1>*</h1></td>
						<td>
							<div class="form-group">
								<select name="product" class="form-control" id="prdt" nchange="calcAmount()">
									<option selected>Choose...</option>
									<c:if test="${products ne null}">
										<c:forEach items="${products}" var="product">
											<option>${product.getProduct()}</option>
										</c:forEach>
									</c:if>
								</select>
							</div>
						</td>
						<td>
							<div class="form-group">
								<input type="text" class="form-control" name="rateperkg" id="rpk" onchange="calcAmount()">
							</div>
						</td>
						<td>
							<div class="form-group">
								<input type="text" class="form-control" name="quantity" id="qt" onchange="calcAmount()">
							</div>
						</td>
						<td>
							<div class="form-group">
								<input type="text" class="form-control" name="amount" id="amt">
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
		<c:if test="${sales.size() eq 0}">
			<p>
			<div class="text-info">No Records found</div>
			</p>
		</c:if>
	</div>
</body>
<script>
function fetchRecords(){
	var date = document.getElementById("date").value;
	window.location = "Sales?date="+date;
}
function calcAmount(){
	var prdt = document.getElementById("prdt").value
 	var rpk = parseFloat(document.getElementById("rpk").value);
 	var qt = parseFloat(document.getElementById("qt").value);
 	if(rpk != null & qt != null & prdt!="Choose...")
 		document.getElementById("amt").value = rpk*qt;
}
</script>
</html>