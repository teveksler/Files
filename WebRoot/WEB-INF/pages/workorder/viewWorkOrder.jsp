<%@page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.workorder-resources" />
<html>
<head>
<title>Work Order Details</title>
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
		//Go back to selectWorkOrder after saving or deleting related entities
		if (window.location.href.indexOf("delete") > -1) {
			window.location.replace("./selectWorkOrder?workOrderIdKey="
					+ ${workorder.workOrderId} + "&");
		} else if (window.location.href.indexOf("save") > -1) {
			window.location.replace("./selectWorkOrder?workOrderIdKey="
					+ ${workorder.workOrderId} + "&");
		}
	</script>
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
				<li><a href="./indexWorkOrder"  class='active'>Work Order Management</a></li>
				<li><a href="./indexEmployee">Employee Management</a></li>
				<li><a href="./j_spring_security_logout">Logout</a></li>
			</ul>
		</div>
		<div class='content'>
			<a class='button'></a> <br> <br> <a
				href="${pageContext.request.contextPath}/indexWorkOrder"
				class="btn btn-primary"><span
				class="glyphicon glyphicon-arrow-left"></span> Back</a> <br>
			<h1>
				<span class="glyphicon glyphicon-wrench"></span>
				<fmt:message key="workorder.title" />
				Details
			</h1>
			<table id="mainTable" class="table table-striped table-bordered"
				style="width: 1%">
				<tbody>
					<tr>
						<td><fmt:message key="workorder.workorderid.title" />:</td>
						<td>${workorder.workOrderId}</td>
					</tr>
					<tr>
						<td><fmt:message key="workorder.workorderscope.title" />:</td>
						<td>${workorder.workOrderScope}</td>
					</tr>
					<tr>
						<td><fmt:message key="workorder.workorderaddress.title" />:
						</td>
						<td><a
							href="http://maps.google.com/?q=${workorder.workOrderAddress}"
							class="btn btn-primary btn-success"><span
								class="glyphicon glyphicon-map-marker"></span>
								${workorder.workOrderAddress}</a></td>
					</tr>
					<tr>
						<td><fmt:message key="workorder.workordercreatedon.title" />:
						</td>
						<td><fmt:formatDate dateStyle="short" type="date"
								value="${workorder.workOrderCreatedOn.time}" /></td>
					</tr>
					<tr>
						<td><fmt:message
								key="workorder.workorderexpectedenddate.title" />:</td>
						<td class="expectedEndDate"><fmt:formatDate dateStyle="short"
								type="date" value="${workorder.workOrderExpectedEndDate.time}" /></td>
					</tr>
					<tr>
						<td><fmt:message key="workorder.workorderenddate.title" />:
						</td>
						<td class="actualEndDate"><fmt:formatDate dateStyle="short"
								type="date" value="${workorder.workOrderEndDate.time}" /></td>
					</tr>
					<tr>
						<td><fmt:message key="workorder.workorderstatus.title" />:</td>
						<td class="status">${workorder.workOrderStatus}</td>
					</tr>
				</tbody>
			</table>
			<h1>
				<span class="glyphicon glyphicon-user"></span> Customer
			</h1>
			<c:if test='${workorder.client != null}'>
				<table id="customerTable" class="table table-striped table-bordered"
					style="width: 1%">
					<tbody>
						<tr>
							<td><fmt:message key="client.clientid.title" />:</td>
							<td>${workorder.client.clientId}</td>
						</tr>
						<tr>
							<td><fmt:message key="client.clienttype.title" />:</td>
							<td id="clientType">${workorder.client.clientType}</td>
						</tr>
						<tr>
							<td><fmt:message key="client.clientname.title" />:</td>
							<td>${workorder.client.clientName}</td>
						</tr>
						<tr>
							<td><fmt:message key="client.clientphonenum.title" />:</td>
							<td><a href="tel:+1${workorder.client.clientPhoneNum}?call"
								class="btn btn-primary btn-success"><span
									class="glyphicon glyphicon-phone"></span>
									${workorder.client.clientPhoneNum}</a></td>
						</tr>
						<tr>
							<td><fmt:message key="client.clientext.title" />:</td>
							<td>${workorder.client.clientExt}</td>
						</tr>
						<tr>
							<td><fmt:message key="client.clientemail.title" />:</td>
							<td><a
								href="mailto:${workorder.client.clientEmail}?Subject=Colombus&Roofing"
								class="btn btn-primary btn-success"><span
									class="glyphicon glyphicon-envelope"></span>
									${workorder.client.clientEmail}</a></td>
						</tr>
						<tr>
							<td><fmt:message key="client.clientaddress.title" />:</td>
							<td><a
								href="http://maps.google.com/?q=${workorder.client.clientAddress} ${workorder.client.clientCity} ${workorder.client.postalCode}"
								class="btn btn-primary btn-success"><span
									class="glyphicon glyphicon-map-marker"></span>
									${workorder.client.clientAddress}</a></td>
						</tr>
						<tr>
							<td><fmt:message key="client.clientcity.title" />:</td>
							<td>${workorder.client.clientCity}</td>
						</tr>
						<tr>
							<td><fmt:message key="client.postalcode.title" />:</td>
							<td>${workorder.client.postalCode}</td>
						</tr>
						<tr>
							<td><fmt:message key="client.clientcomment.title" />:</td>
							<td>${workorder.client.clientComment}</td>
						</tr>
					</tbody>
				</table>
				<div>
					<a class="btn btn-primary btn-warning popupbtn cboxElement"
						href="${pageContext.request.contextPath}/editWorkOrderClient?workorder_workOrderId=${workorder.workOrderId}&client_clientId=${workorder.client.clientId}&"><span
						class="glyphicon glyphicon-pencil"></span> Edit</a> <a
						class="btn btn-primary btn-danger popupbtn cboxElement"
						href="${pageContext.request.contextPath}/confirmDeleteWorkOrderClient?workorder_workOrderId=${workorder.workOrderId}&related_client_clientId=${workorder.client.clientId}&"><span
						class="glyphicon glyphicon-trash"></span> Delete</a>
				</div>
			</c:if>
			<c:if test='${workorder.client == null}'>
				<div class="navitem">
					<a class="btn btn-primary btn-success popupbtn cboxElement"
						href="${pageContext.request.contextPath}/newWorkOrderClient?workorder_workOrderId=${workorder.workOrderId}&"><span
						class="glyphicon glyphicon-plus"></span> New Customer</a>
				</div>
			</c:if>
			<div class="clear"></div>
			<div class="spacer"></div>
			<h1>
				<span class="glyphicon glyphicon-user"></span> Assigned Employees
			</h1>
			<div class="navitem">
				<a class="btn btn-primary btn-success popupbtn cboxElement"
					href="${pageContext.request.contextPath}/newWorkOrderEmployees?workorder_workOrderId=${workorder.workOrderId}&">
					<span class="glyphicon glyphicon-plus"></span> New Employee
				</a>
			</div>
			<br>
			<table id="employeeTable" class="table table-striped table-bordered">
				<thead>
					<tr>
						<th class="thead " id="actions1" width="1%">Actions</th>
						<th class="thead"><fmt:message
								key="employee.employeeid.title" /></th>
						<th class="thead"><fmt:message
								key="employee.employeename.title" /></th>
						<th class="thead"><fmt:message
								key="employee.employeephonenum.title" /></th>
						<th class="thead"><fmt:message
								key="employee.employeeemail.title" /></th>
						<th class="thead"><fmt:message
								key="employee.employeecomment.title" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${workorder.employees}" var="current"
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
							<td><a class="btn btn-primary btn-primary "
								title="View Employee"
								href="${pageContext.request.contextPath}/selectEmployee?employeeIdKey=${current.employeeId}&"><span
									class="glyphicon glyphicon-eye-open"></span> View</a> <a
								class="btn btn-primary btn-warning popupbtn cboxElement"
								title="Edit Employee"
								href="${pageContext.request.contextPath}/editWorkOrderEmployees?workorder_workOrderId=${workorder.workOrderId}&employees_employeeId=${current.employeeId}&"><span
									class="glyphicon glyphicon-pencil"></span> Edit</a> <a
								class="btn btn-primary btn-danger popupbtn cboxElement"
								title="Delete Employee"
								href="${pageContext.request.contextPath}/confirmDeleteWorkOrderEmployees?workorder_workOrderId=${workorder.workOrderId}&related_employees_employeeId=${current.employeeId}&"><span
									class="glyphicon glyphicon-trash"></span> Delete</a></td>
							<td>${current.employeeId}</td>
							<td>${current.employeeName}</td>
							<td>${current.employeePhoneNum}</td>
							<td>${current.employeeEmail}</td>
							<td>${current.employeeComment}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<h1>
				<span class="glyphicon glyphicon-list-alt"></span> Inventory
				Required
			</h1>
			<div class="navitem">
				<a class="btn btn-primary btn-success popupbtn cboxElement"
					href="${pageContext.request.contextPath}/newWorkOrderInventories?workorder_workOrderId=${workorder.workOrderId}&">
					<span class="glyphicon glyphicon-plus"></span> New Inventory Item
				</a>
			</div>
			<br>
			<table id="inventoryTable" class="table table-striped table-bordered">
				<thead>
					<tr>
						<th class="thead" id="actions2" width="1%">Actions</th>
						<th class="thead"><fmt:message
								key="inventory.inventoryid.title" /></th>
						<th class="thead"><fmt:message
								key="inventory.inventoryproductname.title" /></th>
						<th class="thead"><fmt:message
								key="inventory.inventoryname.title" /></th>
						<th class="thead"><fmt:message
								key="inventory.inventoryprice.title" /></th>
						<th class="thead"><fmt:message
								key="inventory.inventorystocklevel.title" /></th>
						<th class="thead"><fmt:message
								key="inventory.inventoryunit.title" /></th>
						<th class="thead"><fmt:message
								key="inventory.inventorylowthreshold.title" /></th>
						<th class="thead"><fmt:message
								key="inventory.inventorylocation.title" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${workorder.inventories}" var="current"
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
							<td><a class="btn btn-primary btn-primary"
								title="View Inventory Item"
								href="${pageContext.request.contextPath}/selectInventory?inventoryIdKey=${current.inventoryId}&"><span
									class="glyphicon glyphicon-eye-open"></span> View</a> <a
								class="btn btn-primary btn-warning popupbtn cboxElement" title="Edit Inventory Item"
								href="${pageContext.request.contextPath}/editWorkOrderInventories?workorder_workOrderId=${workorder.workOrderId}&inventories_inventoryId=${current.inventoryId}&"><span
									class="glyphicon glyphicon-pencil"></span> Edit</a> <a
								class="btn btn-primary btn-danger popupbtn cboxElement" title="Delete Inventory Item"
								href="${pageContext.request.contextPath}/confirmDeleteWorkOrderInventories?workorder_workOrderId=${workorder.workOrderId}&related_inventories_inventoryId=${current.inventoryId}&"><span
									class="glyphicon glyphicon-trash"></span> Delete</a></td>
							<td>${current.inventoryId}</td>
							<td>${current.inventoryProductName}</td>
							<td>${current.inventoryName}</td>
							<td>${current.inventoryPrice}</td>
							<td>${current.inventoryStockLevel}</td>
							<td>${current.inventoryUnit}</td>
							<td>${current.inventoryLowThreshold}</td>
							<td>${current.inventoryLocation}</td>
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
							//Purchase Orders
							if (document.referrer
									.indexOf("deleteWorkOrderClient") > -1) {
								alertify.success('Client deleted!');
							} else if (document.referrer
									.indexOf("saveWorkOrderClient") > -1) {
								alertify.success('Client saved!');
							}

							//Inventory
							if (document.referrer
									.indexOf("deleteWorkOrderInventories") > -1) {
								alertify.success('Inventory item deleted!');
							} else if (document.referrer
									.indexOf("saveWorkOrderInventories") > -1) {
								alertify.success('Inventory item saved!');
							}
							
							//Employees
							if (document.referrer.indexOf("deleteWorkOrderEmployees") > -1) {
								alertify.success('Employee deleted!');
							} else if (document.referrer
									.indexOf("saveWorkOrderEmployees") > -1) {
								alertify.success('Employee saved!');
							}

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
							
												//Get dates
												expectedEndDate = $(this).find(
														'.expectedEndDate')
														.html();
												actualEndDate = $(this).find(
														'.actualEndDate')
														.html();

												//Color + Markers Based On Values
												if ((actualEndDate !== "")
														& (expectedEndDate < actualEndDate)) { //Later than expected
													$(this)
															.find(
																	'.actualEndDate')
															.css(
																	'background-color',
																	'#eae06c'); //YELLOW COLOR
													$(this)
															.find(
																	'.expectedEndDate')
															.css(
																	'background-color',
																	'#eae06c'); //YELLOW COLOR
													$(this)
															.find(
																	'.actualEndDate')
															.append(
																	" (Delayed!)") //Delayed Marker
												} else if ((actualEndDate !== "")
														& (actualEndDate <= expectedEndDate)) { //Same day or earlier than expected
													$(this)
															.find(
																	'.expectedEndDate')
															.css(
																	'background-color',
																	'#4ed377'); //GREEN COLOR
													$(this)
															.find(
																	'.actualEndDate')
															.css(
																	'background-color',
																	'#4ed377'); //GREEN COLOR										
												} else if ((actualEndDate == "") // No actual end date and today is later than expected
														& (expectedEndDate < today)) {
													$(this)
															.find(
																	'.expectedEndDate')
															.css(
																	'background-color',
																	'#eae06c'); //YELLOW COLOR
													$(this)
															.find(
																	'.expectedEndDate')
															.append(
																	" (Delayed!)") //Delayed Marker
												} else if ((actualEndDate == "") // No actual end date and today is earlier than expected
														& (expectedEndDate > today)) {
													$(this)
															.find(
																	'.expectedEndDate')
															.css(
																	'background-color',
																	'#4ed377'); //GREEN COLOR
												}
							//Work Order Status Color Coding
							$("#mainTable td.status:contains('Completed')")
									.css('background-color', '#4ed377');
							$("#mainTable td.status:contains('W.I.P.')")
									.css('background-color', '#eae06c');
							$("#mainTable td.status:contains('Cancelled')")
									.css('background-color', '#d37676');

							//Inventory Stock Colorcoding
							var stockLevel = 0;
							var lowThreshold = 0;
							//For each table low
							$('#inventoryTable tr').each(
									function() {
										lowThreshold = parseInt($(this).find(
												'.lowThreshold').html());
										stockLevel = parseInt($(this).find(
												'.stockLevel').html());
										//Color Based On Values
										if ((stockLevel > 0)
												& (stockLevel < lowThreshold)) { //LOW!
											$(this).find('.stockLevel').css(
													'background-color',
													'#eae06c');//YELLOW COLOR
											$(this).find('.stockLevel').append(
													" (Low Stock!)")
										} else if (stockLevel >= lowThreshold) { //GOOD STOCK
											$(this).find('.stockLevel').css(
													'background-color',
													'#4ed377'); //GREEN COLOR
										} else if (stockLevel == 0) { //ZERO STOCK!
											$(this).find('.stockLevel').css(
													'background-color',
													'#d37676'); //RED COLOR
											$(this).find('.stockLevel').append(
													" (Out of Stock!)")
										}
									});

							//DataTables
							$('#employeeTable').DataTable({
								dom : 'Bfrtip',
								buttons : [ {
									extend : 'pdfHtml5',
									orientation : 'landscape',
									exportOptions : {
										columns : ':visible'
									}
								}, 'excelHtml5', 'colvis' ]
							});

							$('#inventoryTable').DataTable({
								dom : 'Bfrtip',
								buttons : [ {
									extend : 'pdfHtml5',
									orientation : 'landscape',
									exportOptions : {
										columns : ':visible'
									}
								}, 'excelHtml5', 'colvis' ]
							});

							//Side Menu
							$('.button').on('click', function() {
								$('.content').toggleClass('isOpen');
							});

							//Stackable
							$('#employeeTable').stacktable({
								myClass : 'stacktable small-only'
							});

							$('#inventoryTable').stacktable({
								myClass : 'stacktable small-only'
							});

							//Pop Up Colorbox
							$(".popupbtn").colorbox();

							//Mobile Search / Pagination
							$(function() {
								$("input").keydown(function() { //On Search Input
									$(".small-only").remove(); //Remove old stackable table
									$('#employeeTable').stacktable({
										myClass : 'stacktable small-only'
									});

									$('#inventoryTable').stacktable({
										myClass : 'stacktable small-only'
									});
								});

								$('#employeeTable_paginate').click(function() { //On pagination click
									$(".small-only").remove(); //Remove old stackable table
									$('#employeeTable').stacktable({
										myClass : 'stacktable small-only'
									});

									$('#inventoryTable').stacktable({
										myClass : 'stacktable small-only'
									});
								});
								
								$('#inventoryTable_paginate').click(function() { //On pagination click
									$(".small-only").remove(); //Remove old stackable table
									$('#employeeTable').stacktable({
										myClass : 'stacktable small-only'
									});

									$('#inventoryTable').stacktable({
										myClass : 'stacktable small-only'
									});
								});
							});
							//Remove sorting from actions column
							document.getElementById("actions1").className = "thead";
							document.getElementById("actions2").className = "thead";
						});
	</script>
</body>
</html>