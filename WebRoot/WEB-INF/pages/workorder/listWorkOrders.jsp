<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.workorder-resources" />
<html>
<head>
<title>Work Order Management</title>
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
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Courgette" />
<link rel="stylesheet" type="text/css" href="css/colorbox.css" />
<link rel="stylesheet" href="css/alertify.min.css" />
<link rel="stylesheet" href="css/themes/bootstrap.css" />
</head>
<body>
	<script>
		//Go back to indexWorkOrder after saving or deleting
		if (window.location.href.indexOf("deleteWorkOrder") > -1) {
			window.location.replace("./indexWorkOrder");
		} else if (window.location.href.indexOf("saveWorkOrder") > -1) {
			window.location.replace("./indexWorkOrder");
		}
	</script>
	<div class='wrapper'>
		<div class='sidebar'>
			<div class='title'>AXI</div>
			<ul class='nav'>
				<li><a href="./">Home</a></li>
				<li><a href="./indexClient">Client Management</a></li>
				<li><a href="./indexQuote">Quote Management</a></li>
				<li><a href="./indexInventory">Inventory Management</a></li>
				<li><a href="./indexPurchaseOrder">Purchase Order
						Management</a></li>
				<li><a href="./indexWorkOrder" class='active'>Work Order
						Management</a></li>
				<li><a href="./indexEmployee">Employee Management</a></li>
				<li><a href="./j_spring_security_logout">Logout</a></li>
			</ul>
		</div>
		<div class='content'>
			<a class='button'></a>
			<h1>
				<span class="glyphicon glyphicon-wrench"></span> Work Order
				Management
			</h1>
			<h2>Create, manage and track your work orders!</h2>
			<table id="listTable" class="table table-striped table-bordered">
				<thead>
					<tr>
						<th class="thead" id="actions" width="1%">Actions</th>
						<th class="thead"><fmt:message
								key="workorder.workorderid.title" /></th>
						<th class="thead"><fmt:message
								key="workorder.workorderstatus.title" /></th>
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
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${workorders}" var="current" varStatus="i">
						<c:choose>
							<c:when test="${(i.count) % 2 == 0}">
								<c:set var="rowclass" value="rowtwo" />
							</c:when>
							<c:otherwise>
								<c:set var="rowclass" value="rowone" />
							</c:otherwise>
						</c:choose>
						<tr class="${rowclass}">
							<td><a class="btn btn-primary btn-primary"
								title="View Work Order"
								href="${pageContext.request.contextPath}/selectWorkOrder?workOrderIdKey=${current.workOrderId}&"><span
									class="glyphicon glyphicon-eye-open"></span> View</a> <a
								class="btn btn-primary btn-warning popupbtn cboxElement"
								title="Edit Work Order"
								href="${pageContext.request.contextPath}/editWorkOrder?workOrderIdKey=${current.workOrderId}&"><span
									class="glyphicon glyphicon-pencil"></span> Edit</a> <a
								class="btn btn-primary btn-danger popupbtn cboxElement"
								title="Delete Work Order"
								href="${pageContext.request.contextPath}/confirmDeleteWorkOrder?workOrderIdKey=${current.workOrderId}&"><span
									class="glyphicon glyphicon-trash"></span> Delete</a></td>
							<td>${current.workOrderId}</td>
							<td class="status">${current.workOrderStatus}</td>
							<td>${current.workOrderScope}</td>
							<td><a
								href="http://maps.google.com/?q=${current.workOrderAddress}"
								class="btn btn-primary btn-success"><span
									class="glyphicon glyphicon-map-marker"></span>
									${current.workOrderAddress}</a></td>
							<td><fmt:formatDate dateStyle="short" type="date"
									value="${current.workOrderCreatedOn.time}" /></td>
							<td class="expectedEndDate"><fmt:formatDate
									dateStyle="short" type="date"
									value="${current.workOrderExpectedEndDate.time}" /></td>
							<td class="actualEndDate"><fmt:formatDate dateStyle="short"
									type="date" value="${current.workOrderEndDate.time}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="./newWorkOrder" id="newWorkOrder"
				class="btn btn-primary btn-success popupbtn cboxElement"><span
				class="glyphicon glyphicon-plus"></span> New Work Order</a>
		</div>
	</div>
	<script>
		$(document).ready(
				function() {

					//Alertify Setup
					alertify.set('notifier', 'position', 'top-right');

					//Delayed Work Order Color Coding
					//Initialize dates
					var expectedEndDate = new Date();
					var actualEndDate = new Date();

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

					//For each table low
					$('#listTable tr').each(
							function() {
								//Get dates
								expectedEndDate = $(this).find(
										'.expectedEndDate').html();
								actualEndDate = $(this).find('.actualEndDate')
										.html();

								//Color + Markers Based On Values
								if ((actualEndDate !== "")
										& (expectedEndDate < actualEndDate)) { //Later than expected
									$(this).find('.actualEndDate').css(
											'background-color', '#eae06c'); //YELLOW COLOR
									$(this).find('.expectedEndDate').css(
											'background-color', '#eae06c'); //YELLOW COLOR
									$(this).find('.actualEndDate').append(
											" (Delayed!)") //Delayed Marker
								} else if ((actualEndDate !== "")
										& (actualEndDate <= expectedEndDate)) { //Same day or earlier than expected
									$(this).find('.expectedEndDate').css(
											'background-color', '#4ed377'); //GREEN COLOR
									$(this).find('.actualEndDate').css(
											'background-color', '#4ed377'); //GREEN COLOR										
								} else if ((actualEndDate == "") // No actual end date and today is later than expected
										& (expectedEndDate < today)) {
									$(this).find('.expectedEndDate').css(
											'background-color', '#eae06c'); //YELLOW COLOR
									$(this).find('.expectedEndDate').append(
											" (Delayed!)") //Delayed Marker
								} else if ((actualEndDate == "") // No actual end date and today is earlier than expected
										& (expectedEndDate > today)) {
									$(this).find('.expectedEndDate').css(
											'background-color', '#4ed377'); //GREEN COLOR
								}
							})

					//Status Color Coding
					$("#listTable td.status:contains('Completed')").css(
							'background-color', '#4ed377');
					$("#listTable td.status:contains('W.I.P.')").css(
							'background-color', '#eae06c');
					$("#listTable td.status:contains('Cancelled')").css(
							'background-color', '#d37676');

					//Alert success or error based on previous URL
					if (document.referrer.indexOf("delete") > -1) {
						alertify.success('Work Order deleted!');
					} else if (document.referrer.indexOf("save") > -1) {
						alertify.success('Work Order saved!');
					}

					//Side Menu Slide
					$('.button').on('click', function() {
						$('.content').toggleClass('isOpen');
					});

					//DataTables
					$('#listTable').DataTable({
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
					$('#listTable').stacktable({
						myClass : 'stacktable small-only'
					});

					//Mobile Search / Pagination 
					$(function() {
						$("input").keydown(function() { //On Search Input
							$(".small-only").remove(); //Remove old stackable table
							$('#listTable').stacktable({ //Create new stackable Table
								myClass : 'stacktable small-only'
							});
						});

						$('#listTable_paginate').click(function() { //On pagination click
							$(".small-only").remove(); //Remove old stackable table
							$('#listTable').stacktable({ //Create new stackable Table
								myClass : 'stacktable small-only'
							});
						});
					});

					//Remove sorting from actions column
					document.getElementById("actions").className = "thead";

					//Pop Ups
					$(".popupbtn").colorbox();
				});
	</script>
</body>
</html>