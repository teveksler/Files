<%@page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.employee-resources" />
<html>
<head>
<title>View <fmt:message key="employee.title" />
</title>
<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="js/datatables.js"></script>
<script type="text/javascript" src="js/stacktable.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-tour.min.js"></script>
<script type="text/javascript" src="js/jquery.colorbox.js"></script>
<script type="text/javascript" src="js/alertify.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap-tour.min.css">
<link rel="stylesheet" type="text/css" href="css/datatables.css" />
<link rel="stylesheet" type="text/css" href="css/stacktable.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel='stylesheet' type='text/css'
	href='http://fonts.googleapis.com/css?family=Courgette' />
<link rel="stylesheet" type='text/css' href="css/colorbox.css" />
<link rel="stylesheet" href="css/alertify.min.css" />
<link rel="stylesheet" href="css/themes/bootstrap.css" />
</head>
<body>
	<div class='wrapper'>
		<div class='sidebar'>
			<div class='title'>AXI</div>
			<ul class='nav'>
				<li><a href="./">Home</a></li>
				<li><a href="./indexClient">Client
						Management</a></li>
				<li><a href="./indexQuote">Quote Management</a></li>
				<li><a href="./indexInventory">Inventory Management</a></li>
				<li><a href="./indexPurchaseOrder">Purchase Order
						Management</a></li>
				<li><a href="./indexWorkOrder">Work Order Management</a></li>
				<li><a href="./indexEmployee" class='active'>Employee Management</a></li>
				<li><a href="./j_spring_security_logout">Logout</a></li>
			</ul>
		</div>
		<div class='content'>
			<a class='button'></a> <br> <br> <a
				href="${pageContext.request.contextPath}/indexEmployee"
				class="btn btn-primary"><span
				class="glyphicon glyphicon-arrow-left"></span> Back</a> <br>
			<h1>
				<span class="glyphicon glyphicon-user"></span> Employee Details
			</h1>
			<table id="mainTable" class="table table-striped table-bordered" style="width: 1%">
				<tbody>
					<tr >
						<td><fmt:message
								key="employee.employeeid.title" />:</td>
						<td>${employee.employeeId}</td>
					</tr>
					<tr>
						<td><fmt:message key="employee.employeename.title" />:</td>
						<td>${employee.employeeName}</td>
					</tr>
					<tr>
						<td><fmt:message key="employee.employeephonenum.title" />:</td>
						<td><a href="tel:+1${employee.employeePhoneNum}?call"
							class="btn btn-primary btn-success"><span
								class="glyphicon glyphicon-phone"></span>
								${employee.employeePhoneNum}</a></td>
					</tr>
					<tr>
						<td><fmt:message key="employee.employeeemail.title" />:</td>
						<td><a
							href="mailto:${employee.employeeEmail}?Subject=Colombus&Roofing"
							class="btn btn-primary btn-success"><span
								class="glyphicon glyphicon-envelope"></span>
								 ${employee.employeeEmail}</a></td>
					</tr>
					<tr>
						<td><fmt:message key="employee.employeecomment.title" />:</td>
						<td>${employee.employeeComment}</td>
					</tr>
				</tbody>
			</table>
			<h1>
				<span class="glyphicon glyphicon-wrench"></span> Related Work Orders
			</h1>
			<a class="btn btn-primary btn-success popupbtn cboxElement "
				href="${pageContext.request.contextPath}/newEmployeeWorkOrders?employee_employeeId=${employee.employeeId}&">
				<span class="glyphicon glyphicon-plus"></span> New Work Order
			</a> <br> <br>
			<table id="workOrderTable" class="table table-striped table-bordered">
				<thead>
					<tr>
						<th class="thead" id="actions" width="1%">Actions</th>
						<th class="thead"><fmt:message
								key="workorder.workorderid.title" /></th>
						<th class="thead"><fmt:message
								key="workorder.workorderscope.title" /></th>
						<th class="thead"><fmt:message
								key="workorder.workorderaddress.title" /></th>
						<th class="thead"><fmt:message
								key="workorder.workordercreatedon.title" /></th>
						<th class="thead"><fmt:message
								key="workorder.workorderexpectedenddate.title" /></th>
						<th class="thead"><fmt:message
								key="workorder.workorderenddate.title" /></th>
						<th class="thead"><fmt:message
								key="workorder.workorderstatus.title" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${employee.workOrders}" var="current"
						varStatus="i">
						<c:choose>
							<c:when test="${(i.count) % 2 == 0}">
								<c:set var="rowclass" value="rowtwo" />
							</c:when>
							<c:otherwise>
								<c:set var="rowclass" value="rowone" />
							</c:otherwise>
						</c:choose>
						<tr class="${rowclass}">
							<td><a class="btn btn-primary btn-primary popupbtn cboxElement"
								href="${pageContext.request.contextPath}/selectEmployeeWorkOrders?employee_employeeId=${employee.employeeId}&workorders_workOrderId=${current.workOrderId}&"><span
									class="glyphicon glyphicon-eye-open"></span> View</a> <a
								class="btn btn-primary btn-warning popupbtn cboxElement"
								href="${pageContext.request.contextPath}/editEmployeeWorkOrders?employee_employeeId=${employee.employeeId}&workorders_workOrderId=${current.workOrderId}&"><span
									class="glyphicon glyphicon-pencil"></span> Edit</a> <a
								class="btn btn-primary btn-danger popupbtn cboxElement"
								href="${pageContext.request.contextPath}/confirmDeleteEmployeeWorkOrders?employee_employeeId=${employee.employeeId}&related_workorders_workOrderId=${current.workOrderId}&"><span
									class="glyphicon glyphicon-trash"></span> Delete</a></td>
							<td>${current.workOrderId}</td>
							<td>${current.workOrderScope}</td>
							<td>${current.workOrderAddress}</td>
							<td><fmt:formatDate dateStyle="short" type="date"
									value="${current.workOrderCreatedOn.time}" /></td>
							<td><fmt:formatDate dateStyle="short" type="date"
									value="${current.workOrderExpectedEndDate.time}" /></td>
							<td><fmt:formatDate dateStyle="short" type="date"
									value="${current.workOrderEndDate.time}" /></td>
							<td class="status">${current.workOrderStatus}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<script>
		$(document)
				.ready(
						function() {
							//Alertify Setup
							alertify.set('notifier', 'position', 'top-right');

							//Alert success or error notifications based on previous URL
							//Work Orders
							if (document.referrer
									.indexOf("deleteClientWorkOrders") > -1) {
								alertify.success('Work Order deleted!');
							} else if (document.referrer
									.indexOf("saveClientWorkOrders") > -1) {
								alertify.success('Work Order saved!');
							}

							//Work Order Status Color Coding
							$("#workOrderTable td.status:contains('Completed')")
									.css('background-color', '#4ed377');
							$("#workOrderTable td.status:contains('W.I.P.')")
									.css('background-color', '#eae06c');
							$("#workOrderTable td.status:contains('Cancelled')")
									.css('background-color', '#d37676');

							//Initialize dates
							var expectedDeliveryDate = new Date();
							var actualDeliveryDate = new Date();

							//Today Date
							var today = new Date();
							var dd = today.getDate();
							var mm = today.getMonth() + 1;
							var yyyy = today.getFullYear();

							if (dd < 10) {
								dd = '0' + dd
							}

							if (mm < 10) {
								mm = '0' + mm
							}

							today = mm + '/' + dd + '/' + yyyy;

							//Side Menu
							$('.button').on('click', function() {
								$('.content').toggleClass('isOpen');
							});

							//Stackable
							$('#workOrderTable').stacktable({
								myClass : 'stacktable small-only'
							});

							//Pop Up Colorbox
							$(".popupbtn").colorbox();

							$('#workOrderTable').DataTable({
								dom : 'Bfrtip',
								buttons : [ {
									extend : 'pdfHtml5',
									orientation : 'landscape',
									exportOptions : {
										columns : ':visible'
									}
								}, 'excelHtml5', 'colvis' ]
							});

							//Stackable
							$('#workOrderTable').stacktable({
								myClass : 'stacktable small-only'
							});

							//Mobile Search / Pagination [BUGGY!]
							$(function() {
								$("input").keydown(function() { //On Search Input
									$(".small-only").remove(); //Remove old stackable table
									$('#workOrderTable').stacktable({
										myClass : 'stacktable small-only'
									});
								});

								$('#workOrderTable_paginate').click(function() { //On pagination click
									$(".small-only").remove(); //Remove old stackable table
									$('#workOrderTable').stacktable({
										myClass : 'stacktable small-only'
									});
								});
							});
							//Remove sortable from actions column
							document.getElementById("actions").className = "thead";
						});
	</script>
</body>
</html>