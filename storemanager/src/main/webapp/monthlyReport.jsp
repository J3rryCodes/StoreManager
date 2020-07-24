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

<title>Monthly Report</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
	<br>
	<form action="AddStock" method="post">
		<div class="row">
			<div class="col-md-10">
				<h3 class="page-header">Monthly Report</h3>
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
					<th scope="col">Date</th>
					<th scope="col">Income</th>
					<th scope="col">Expenses</th>
					<th scope="col">Profit</th>
				</tr>
				<c:if test="${data ne null}">
					<c:set var="count" value="${0}"></c:set>
					<c:forEach items="${data}" var="d">
						<c:set var="count" value="${count+1}"></c:set>
						<tr>
							<td scope="col">${count}</td>
							<td scope="col">${d.getDate()}</td>
							<td scope="col">${d.getInome()}</td>
							<td scope="col">${d.getExpenses()}</td>
							<td scope="col">${d.getProfit()}</td>
					</c:forEach>
				</c:if>
			</thead>
		</table>
		<c:if test="${data.size() eq 0}">
			<p>
			<div class="text-info">No Records found</div>
			</p>
		</c:if>
		</form>
	</div>
</body>
<script>
function fetchRecords(){
	var date = document.getElementById("date").value;
	window.location = "Stock?date="+date;
}
</script>
</html>