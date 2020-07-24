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

<title>Payments</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
	<br>
	<form action="AddPayment" method="post">
		<div class="row">
			<div class="col-md-10">
				<h3 class="page-header">Other Payments</h3>
			</div>
			<div class="col-md-2 form-group">
				<input type="date" class="form-control" name="date" value="${date}"
					id="date" onchange="fetchRecords()">
			</div>
		</div>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Payment For</th>
					<th scope="col">Amount</th>
					<th scope="col">Action</th>
				</tr>
				<c:if test="${otherPayments ne null}">
					<c:set var="count" value="${0}"></c:set>
					<c:forEach items="${otherPayments}" var="payments">
						<c:set var="count" value="${count+1}"></c:set>
						<tr>
							<td scope="col">${count}</td>
							<td scope="col">${payments.getPaymentFor()}</td>
							<td scope="col">${payments.getAmount()} Rs</td>
							<td scope="col"><button type="button"
									class="btn btn-primary col-md-8">Edit</button></td>
						</tr>
					</c:forEach>
				</c:if>
				<tr>
						<td><h1>*</h1></td>
						<td>
							<div class="form-group">
								<input type="text" class="form-control" name="paymentFor">
							</div>
						</td>
						<td>
							<div class="form-group">
								<input type="text" class="form-control" name="amount">
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
		<c:if test="${otherPayments.size() eq 0}">
			
			<div class="text-info">No Records found</div>
			
		</c:if>
		</form>
	</div>
</body>
<script>
function fetchRecords(){
	var date = document.getElementById("date").value;
	window.location = "Payment?date="+date;
}
</script>
</html>