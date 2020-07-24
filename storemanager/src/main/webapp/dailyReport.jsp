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

<title>Daily Report</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<br>
		<div class="row">
			<div class="col-md-10">
				<h3 class="page-header">Daily Report</h3>
			</div>
			<div class="col-md-2 form-group">
				<input type="date" class="form-control" name="date" value="${date}"
					id="date" onchange="fetchRecords()">
			</div>
		</div>
		<h4 class="page-header">Income</h4>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Product</th>
					<th scope="col">Quantity</th>
					<th scope="col">Selling Rate</th>
					<th scope="col">Total Amount</th>
					<th scope="col">Profit</th>
				</tr>
				<c:set var="totalAmount" value="${0}"></c:set>
				<c:set var="totalProfit" value="${0}"></c:set>
				<c:if test="${data ne null}">
					<c:set var="count" value="${0}"></c:set>
					<c:forEach items="${data}" var="d">
						<c:set var="count" value="${count+1}"></c:set>
						<tr>
							<td scope="col">${count}</td>
							<td scope="col">${d.getProduct()}</td>
							<td scope="col">${d.getSellingQt()}</td>
							<td scope="col">${d.getSellingRate()}</td>
							<td scope="col">${d.getTotalAmount()}</td>
							<td scope="col">${d.getProfit()}</td>

							<c:set var="totalAmount"
								value="${totalAmount+d.getTotalAmount()}"></c:set>
							<c:set var="totalProfit" value="${totalProfit+d.getProfit()}"></c:set>
						</tr>
					</c:forEach>
				</c:if>
				<tr>
					<th scope="col">Total</th>
					<th scope="col">-</th>
					<th scope="col">-</th>
					<th scope="col">-</th>
					<th scope="col">${totalAmount}</th>
					<th scope="col">${totalProfit}</th>
				</tr>
			</thead>
		</table>
<hr>
		<h4 class="page-header">Full Expenses</h4>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">For</th>
					<th scope="col">Total Amount</th>
				</tr>
				<c:set var="otherPayment" value="${0}"></c:set>
				<c:set var="eTotalAmount" value="${0}"></c:set>
				<c:if test="${legger ne null}">
					<c:set var="count" value="${0}"></c:set>
					<c:forEach items="${legger}" var="l">
						<c:set var="count" value="${count+1}"></c:set>
						<tr>
							<td scope="col">${count}</td>
							<td scope="col">${l.getPaymentFor()}</td>
							<td scope="col">${l.getAmount()}</td>

							<c:set var="eTotalAmount" value="${eTotalAmount+l.getAmount()}"></c:set>
						</tr>
						<c:if test="${l.getType() eq 'OCR'}">
							<c:set var="otherPayment" value="${otherPayment+l.getAmount()}"></c:set>
						</c:if>
					</c:forEach>
				</c:if>
				<tr>
					<th scope="col">Total</th>
					<th scope="col">-</th>
					<th scope="col">${eTotalAmount}</th>
				</tr>
			</thead>
		</table>
<hr>
		<h3 class="page-header">Final Profit</h3>
		<h4>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Profit</th>
					<th scope="col">-</th>
					<th scope="col">Expenses</th>
					<th scope="col">=</th>
					<th scope="col">Final Profit</th>
				</tr>
				<tr class="bg-success">
					<td>${totalProfit}</td>
					<td>-</td>
					<td>${otherPayment}</td>
					<td>=</td>
					<td>${totalProfit-otherPayment}
				</tr>
			</thead>
		</table>
		</h4>
		<c:if test="${data.size() eq 0}">
			<p>
			<div class="text-info">No Records found</div>
			</p>
		</c:if>
	</div>
</body>
<script>
	function fetchRecords() {
		var date = document.getElementById("date").value;
		window.location = "DailyReport?date=" + date;
	}
</script>
</html>