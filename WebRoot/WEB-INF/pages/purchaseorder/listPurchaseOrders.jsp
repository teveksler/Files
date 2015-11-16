<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.purchaseorder-resources" />
<html>
<head>
<title>List <fmt:message key="purchaseorder.title" />s
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
	<script>
		//Go back to selectInventory after saving or deleting related entities
		if (window.location.href.indexOf("delete") > -1) {
			window.location.replace("./indexPurchaseOrder");
		} else if (window.location.href.indexOf("save") > -1) {
			window.location.replace("./indexPurchaseOrder");
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


				<li><a href="./indexPurchaseOrder" class='active'>Purchase
						Order Management</a></li>

				<li><a href="./indexWorkOrder">Work Order Management</a></li>

				<li><a href="./indexEmployee">Employee Management</a></li>
				<li><a href="./j_spring_security_logout">Logout</a></li>
			</ul>
		</div>
		<div class='content'>
			<a class='button'></a>
			<h1>
				<span class="glyphicon glyphicon-shopping-cart"></span> Purchase
				Order Management
			</h1>
			<h2>Easily manage your purchase orders in one place!</h2>
			<br>
			<table id="purchaseOrderTable"
				class="table table-striped table-bordered">
				<thead>
					<tr>
						<th class="thead" id="actions1" width="1%">Actions</th>
						<th class="thead"><fmt:message
								key="purchaseorder.purchaseorderid.title" /></th>
						<th class="thead"><fmt:message
								key="purchaseorder.purchaseorderaddress.title" /></th>
						<th class="thead"><fmt:message
								key="purchaseorder.purchaseordercreateddate.title" /></th>
						<th class="thead"><fmt:message
								key="purchaseorder.purchaseorderexpecteddate.title" /></th>
						<th class="thead"><fmt:message
								key="purchaseorder.purchaseorderrecieveddate.title" /></th>
						<th class="thead"><fmt:message
								key="purchaseorder.purchaseorderstatus.title" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${purchaseorders}" var="current" varStatus="i">
						<c:choose>
							<c:when test="${(i.count) % 2 == 0}">
								<c:set var="rowclass" value="rowtwo" />
							</c:when>
							<c:otherwise>
								<c:set var="rowclass" value="rowone" />
							</c:otherwise>
						</c:choose>
						<tr class="${rowclass}">
							<td><a class="btn btn-primary btn-primary "
								title=""
								href="${pageContext.request.contextPath}/selectPurchaseOrder?purchaseOrderIdKey=${current.purchaseOrderId}&"><span
									class="glyphicon glyphicon-eye-open"></span> View</a> <a
								class="btn btn-primary btn-warning popupbtn cboxElement"
								title=""
								href="${pageContext.request.contextPath}/editPurchaseOrder?purchaseOrderIdKey=${current.purchaseOrderId}&"><span
									class="glyphicon glyphicon-pencil"></span> Edit</a> <a
								class="btn btn-primary btn-danger popupbtn cboxElement"
								title=""
								href="${pageContext.request.contextPath}/confirmDeletePurchaseOrder?purchaseOrderIdKey=${current.purchaseOrderId}&"><span
									class="glyphicon glyphicon-trash"></span> Delete</a></td>
							<td>${current.purchaseOrderId}</td>
							<td><a
								href="http://maps.google.com/?q=${current.purchaseOrderAddress}"
								class="btn btn-primary btn-success"><span
									class="glyphicon glyphicon-map-marker"></span> ${current.purchaseOrderAddress}</a></td>
							<td><fmt:formatDate dateStyle="short" type="date"
									value="${current.purchaseOrderCreatedDate.time}" /></td>
							<td class="expectedDeliveryDate"><fmt:formatDate
									dateStyle="short" type="date"
									value="${current.purchaseOrderExpectedDate.time}" /></td>
							<td class="actualDeliveryDate"><fmt:formatDate
									dateStyle="short" type="date"
									value="${current.purchaseOrderRecievedDate.time}" /></td>
							<td class="status">${current.purchaseOrderStatus}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="./newPurchaseOrder"
				class="btn btn-primary btn-success popupbtn cboxElement"><span
				class="glyphicon glyphicon-plus"></span> New Purchase Order </a>
		</div>
	</div>
	<script>
		$(document)
				.ready(
						function() {

							//Delayed Purchase Order Color Coding
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

							//For each table low
							$('#purchaseOrderTable tr')
									.each(
											function() {
												//Get dates
												expectedDeliveryDate = $(this)
														.find(
																'.expectedDeliveryDate')
														.html();
												actualDeliveryDate = $(this)
														.find(
																'.actualDeliveryDate')
														.html();

												//Color + Markers Based On Values
												if ((actualDeliveryDate !== "")
														& (expectedDeliveryDate < actualDeliveryDate)) { //Later than expected
													$(this)
															.find(
																	'.actualDeliveryDate')
															.css(
																	'background-color',
																	'#eae06c'); //YELLOW COLOR
													$(this)
															.find(
																	'.expectedDeliveryDate')
															.css(
																	'background-color',
																	'#eae06c'); //YELLOW COLOR
													$(this)
															.find(
																	'.actualDeliveryDate')
															.append(
																	" (Delayed!)") //Delayed Marker
												} else if ((actualDeliveryDate !== "")
														& (actualDeliveryDate <= expectedDeliveryDate)) { //Same day or earlier than expected
													$(this)
															.find(
																	'.expectedDeliveryDate')
															.css(
																	'background-color',
																	'#4ed377'); //GREEN COLOR
													$(this)
															.find(
																	'.actualDeliveryDate')
															.css(
																	'background-color',
																	'#4ed377'); //GREEN COLOR										
												} else if ((actualDeliveryDate == "") // No actual end date and today is later than expected
														& (expectedDeliveryDate < today)) {
													$(this)
															.find(
																	'.expectedDeliveryDate')
															.css(
																	'background-color',
																	'#eae06c'); //YELLOW COLOR
													$(this)
															.find(
																	'.expectedDeliveryDate')
															.append(
																	" (Delayed!)") //Delayed Marker
												} else if ((actualDeliveryDate == "") // No actual end date and today is earlier than expected
														& (expectedDeliveryDate > today)) {
													$(this)
															.find(
																	'.expectedDeliveryDate')
															.css(
																	'background-color',
																	'#4ed377'); //GREEN COLOR
												}
											})

							//Purchase Order Status Color Coding
							$(
									"#purchaseOrderTable td.status:contains('Completed')")
									.css('background-color', '#4ed377');
							$(
									"#purchaseOrderTable td.status:contains('W.I.P.')")
									.css('background-color', '#eae06c');
							$(
									"#purchaseOrderTable td.status:contains('Cancelled')")
									.css('background-color', '#d37676');

							//Notifier set up
							alertify.set('notifier', 'position', 'top-right');

							//Alert success or error notifications based on previous URL
							if (document.referrer
									.indexOf("deletePurchaseOrder") > -1) {
								alertify.success('Purchase Order was deleted!');
							} else if (document.referrer
									.indexOf("savePurchaseOrder") > -1) {
								alertify.success('Purchase Order was saved!');
							}

							//DataTables
							$(
									'.table table-striped table-bordered dataTable no-footer stacktable small-only')
									.DataTable({
										dom : 'Bfrtip',
										buttons : [ {
											extend : 'pdfHtml5',
											orientation : 'landscape',
											exportOptions : {
												columns : ':visible'
											}
										}, 'excelHtml5', 'colvis' ],
										"columnDefs" : [ {
											"targets" : 'no-sort',
											"orderable" : false,
										} ]
									});

							//Side Menu
							$('.button').on('click', function() {
								$('.content').toggleClass('isOpen');
							});

							//Pop Up Colorbox
							$(".popupbtn").colorbox({
								onClosed : function() {
								}
							});

							//DataTables
							$('#purchaseOrderTable').DataTable({
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
							$('#purchaseOrderTable').stacktable({
								myClass : 'stacktable small-only'
							});

							//Remove sorting from actions column
							document.getElementById("actions1").className = "thead";

							//Mobile Search / Pagination 
							$(function() {
								$("input").keydown(function() { //On Search Input
									$(".small-only").remove(); //Remove old stackable table
									$('#purchaseOrderTable').stacktable({ //Create new stackable Table
										myClass : 'stacktable small-only'
									});
								});

								$('#listTable_paginate').click(function() { //On pagination click
									$(".small-only").remove(); //Remove old stackable table
									$('#purchaseOrderTable').stacktable({ //Create new stackable Table
										myClass : 'stacktable small-only'
									});
								});
							});
						});
	</script>
</body>
</html>