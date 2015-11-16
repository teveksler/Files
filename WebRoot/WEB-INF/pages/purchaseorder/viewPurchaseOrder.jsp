
<%@page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.purchaseorder-resources" />
<html>
<head>
<title>View <fmt:message key="purchaseorder.title" />
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
		//Go back to selectClient after saving or deleting related entities
		if (window.location.href.indexOf("delete") > -1) {
			window.location.replace("./selectPurchaseOrder?purchaseOrderIdKey="
					+ ${purchaseorder.purchaseOrderId} + "&");
		} else if (window.location.href.indexOf("save") > -1) {
			window.location.replace("./selectPurchaseOrder?purchaseOrderIdKey="
					+ ${purchaseorder.purchaseOrderId} + "&");
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
			<a class='button'></a><br> <br> <br> <a
				href="${pageContext.request.contextPath}/indexPurchaseOrder"
				class="btn btn-primary"><span
				class="glyphicon glyphicon-arrow-left"></span> Back</a><br> <br>
			<h1>
				<span class="glyphicon glyphicon-shopping-cart"></span> Purchase
				Order Details
			</h1>
			<table style="width: 1%" id="purchaseOrderTable"
				class="table table-striped table-bordered">
				<tbody>
					<tr>
						<td><fmt:message key="purchaseorder.purchaseorderid.title" />:</td>
						<td>${purchaseorder.purchaseOrderId}</td>
					</tr>
					<tr>
						<td><fmt:message
								key="purchaseorder.purchaseorderaddress.title" />:</td>
						<td><a
							href="http://maps.google.com/?q=${purchaseorder.purchaseOrderAddress}"
							class="btn btn-primary btn-success"><span
								class="glyphicon glyphicon-map-marker"></span>
								${purchaseorder.purchaseOrderAddress}</a></td>
					</tr>
					<tr>
						<td><fmt:message
								key="purchaseorder.purchaseordercreateddate.title" />:</td>
						<td><fmt:formatDate dateStyle="short" type="date"
								value="${purchaseorder.purchaseOrderCreatedDate.time}" /></td>
					</tr>
					<tr>
						<td><fmt:message
								key="purchaseorder.purchaseorderexpecteddate.title" />:</td>
						<td class="expectedEndDate"><fmt:formatDate dateStyle="short"
								type="date"
								value="${purchaseorder.purchaseOrderExpectedDate.time}" /></td>
					</tr>
					<tr>
						<td><fmt:message
								key="purchaseorder.purchaseorderrecieveddate.title" />:</td>
						<td class="actualEndDate"><fmt:formatDate dateStyle="short"
								type="date"
								value="${purchaseorder.purchaseOrderRecievedDate.time}" /></td>
					</tr>
					<tr>
						<td><fmt:message
								key="purchaseorder.purchaseorderstatus.title" />:</td>
						<td class="status">${purchaseorder.purchaseOrderStatus}</td>
					</tr>
				</tbody>
			</table>
			<h1>
				<span class="glyphicon glyphicon-user"></span> Related Clients
			</h1>
			<div class="navitem">
				<a class="btn btn-primary btn-success popupbtn cboxElement"
					href="${pageContext.request.contextPath}/newPurchaseOrderClients?purchaseorder_purchaseOrderId=${purchaseorder.purchaseOrderId}&s">
					<span class="glyphicon glyphicon-plus"></span> New Client
				</a>
			</div>
			<br> <br>
			<table id="clientTable" class="table table-striped table-bordered">
				<thead>
					<tr>
						<th class="thead" id="actions" width="1%">Actions</th>
						<th class="thead"><fmt:message key="client.clientid.title" />
						</th>
						<th class="thead"><fmt:message key="client.clienttype.title" />
						</th>
						<th class="thead"><fmt:message key="client.clientname.title" />
						</th>
						<th class="thead"><fmt:message
								key="client.clientphonenum.title" /></th>
						<th class="thead"><fmt:message key="client.clientext.title" />
						</th>
						<th class="thead"><fmt:message key="client.clientemail.title" />
						</th>

						<th class="thead"><fmt:message
								key="client.clientaddress.title" /></th>
						<th class="thead"><fmt:message key="client.clientcity.title" />
						</th>
						<th class="thead"><fmt:message key="client.postalcode.title" />
						</th>
						<th class="thead"><fmt:message
								key="client.clientcomment.title" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${purchaseorder.clients}" var="current"
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
							<td><a class="btn btn-primary btn-primary" title=""
								href="${pageContext.request.contextPath}/selectClient?clientIdKey=${current.clientId}&"><span
									class="glyphicon glyphicon-eye-open"></span> View</a> <a
								class="btn btn-primary btn-warning popupbtn cboxElement"
								title=""
								href="${pageContext.request.contextPath}/editPurchaseOrderClients?purchaseorder_purchaseOrderId=${purchaseorder.purchaseOrderId}&clients_clientId=${current.clientId}&"><span
									class="glyphicon glyphicon-pencil"></span> Edit</a> <a
								class="btn btn-primary btn-danger popupbtn cboxElement" title=""
								href="${pageContext.request.contextPath}/confirmDeletePurchaseOrderClients?purchaseorder_purchaseOrderId=${purchaseorder.purchaseOrderId}&related_clients_clientId=${current.clientId}&"><span
									class="glyphicon glyphicon-trash"></span> Delete</a></td>
							<td>${current.clientId}</td>
							<td>${current.clientType}</td>
							<td>${current.clientName}</td>
							<td><a href="tel:+1${current.clientPhoneNum}?call"
								class="btn btn-primary btn-success"><span
									class="glyphicon glyphicon-phone"></span>
									${current.clientPhoneNum}</a></td>
							<td>${current.clientExt}</td>
							<td><a
								href="mailto:${client.clientEmail}?Subject=Colombus&Roofing"
								class="btn btn-primary btn-success"><span
									class="glyphicon glyphicon-envelope"></span>
									${current.clientEmail}</a></td>
							<td><a
								href="http://maps.google.com/?q=${current.clientAddress}${current.clientCity}${current.postalCode}"
								class="btn btn-primary btn-success"><span
									class="glyphicon glyphicon-map-marker"></span>
									${current.clientAddress}</a></td>
							<td>${current.clientCity}</td>
							<td>${current.postalCode}</td>
							<td>${current.clientComment}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<h1>
				<span class="glyphicon glyphicon-list-alt"></span> Ordered Inventory
				Items
			</h1>
			<div class="navitem">
				<a class="btn btn-primary btn-success popupbtn cboxElement"
					href="${pageContext.request.contextPath}/newPurchaseOrderInventories?purchaseorder_purchaseOrderId=${purchaseorder.purchaseOrderId}&">
					<span class="glyphicon glyphicon-plus"></span> New Inventory Item
				</a>
			</div>
			<br> <br>
			<table id="inventoryItemTable"
				class="table table-striped table-bordered">
				<thead>
					<tr>
						<th class="thead" id="actions1" width="1%">Actions</th>
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
					<c:forEach items="${purchaseorder.inventories}" var="current"
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
							<td><a class="btn btn-primary btn-primary" title=""
								href="${pageContext.request.contextPath}/selectInventory?inventoryIdKey=${current.inventoryId}&"><span
									class="glyphicon glyphicon-eye-open"></span> View</a> <a
								class="btn btn-primary btn-warning popupbtn cboxElement"
								title=""
								href="${pageContext.request.contextPath}/editPurchaseOrderInventories?purchaseorder_purchaseOrderId=${purchaseorder.purchaseOrderId}&inventories_inventoryId=${current.inventoryId}&"><span
									class="glyphicon glyphicon-pencil"></span> Edit</a> <a
								class="btn btn-primary btn-danger popupbtn cboxElement" title=""
								href="${pageContext.request.contextPath}/confirmDeletePurchaseOrderInventories?purchaseorder_purchaseOrderId=${purchaseorder.purchaseOrderId}&related_inventories_inventoryId=${current.inventoryId}&"><span
									class="glyphicon glyphicon-trash"></span> Delete</a></td>
							<td>${current.inventoryId}</td>
							<td>${current.inventoryProductName}</td>
							<td>${current.inventoryName}</td>
							<td>${current.inventoryPrice}</td>
							<td class="stockLevel">${current.inventoryStockLevel}</td>
							<td>${current.inventoryUnit}</td>
							<td class="lowThreshold">${current.inventoryLowThreshold}</td>
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
							if (document.referrer.indexOf("deletePurchaseOrderClients") > -1) {
								alertify.success('Client deleted!');
							} else if (document.referrer
									.indexOf("savePurchaseOrderClients") > -1) {
								alertify.success('Client saved!');
							}
							if (document.referrer.indexOf("deletePurchaseOrderInventories") > -1) {
								alertify.success('Inventory Item deleted!');
							} else if (document.referrer
									.indexOf("savePurchaseOrderInventories") > -1) {
								alertify.success('Inventory Item saved!');
							}
		
							// Purchase Order low stock inventory colouring
							var stockLevel = 0;
							var lowThreshold = 0;
							//For each table low
							$('#inventoryItemTable tr').each(
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
								//Delayed Purchase Order Color Coding
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
							$('#inventoryItemTable').DataTable({
								dom : 'Bfrtip',
								buttons : [ {
									extend : 'pdfHtml5',
									orientation : 'landscape',
									exportOptions : {
										columns : ':visible'
									}
								}, 'excelHtml5', 'colvis' ]
							});

							$('#clientTable').DataTable({
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
							$('#clientTable').stacktable({
								myClass : 'stacktable small-only'
							});

							$('#inventoryItemTable').stacktable({
								myClass : 'stacktable small-only'
							});
							
							//Remove sorting from actions column
							document.getElementById("actions1").className = "thead";
							document.getElementById("actions").className = "thead";

							
							//Mobile Search / Pagination [BUGGY!]
							$(function() {
								$("input").keydown(function() { //On Search Input
									$(".small-only").remove(); //Remove old stackable table
									$('#clientTable').stacktable({
										myClass : 'stacktable small-only'
									});

									$('#inventoryItemTable').stacktable({
										myClass : 'stacktable small-only'
									});

								$('#clientTable_paginate').click(function() { //On pagination click
									$(".small-only").remove(); //Remove old stackable table
									$('#clientTable').stacktable({  //Create New Stackable table
										myClass : 'stacktable small-only'
									});

									$('#inventoryItemTable').stacktable({
										myClass : 'stacktable small-only'
									});
									});
								
								$('#inventoryItemTable_paginate').click(function() { //On pagination click
									$(".small-only").remove(); //Remove old stackable table
									$('#clientTable').stacktable({  //Create New Stackable table
										myClass : 'stacktable small-only'
									});

									$('#inventoryItemTable').stacktable({
										myClass : 'stacktable small-only'
									});
									});
								});
							});
						});
	</script>
</body>
</html>