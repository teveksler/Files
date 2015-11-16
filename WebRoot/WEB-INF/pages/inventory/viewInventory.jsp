<%@page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.inventory-resources" />
<html>
<head>
<title>View Inventory</title>
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
								window.location.replace("./selectInventory?inventoryIdKey=" + ${inventory.inventoryId} + "&");
							} else if (window.location.href.indexOf("save") > -1) {
								window.location.replace("./selectInventory?inventoryIdKey=" + ${inventory.inventoryId} + "&");
							}
	</script>
	<div class='wrapper'>
		<div class='sidebar'>
			<div class='title'>AXI</div>
			<ul class='nav'>
				<li><a href="./">Home</a></li>
				<li><a href="./indexClient">Client Management</a></li>
				<li><a href="./indexQuote">Quote Management</a></li>
				<li><a href="./indexInventory" class='active'>Inventory
						Management</a></li>
				<li><a href="./indexPurchaseOrder">Purchase Order
						Management</a></li>
				<li><a href="./indexWorkOrder">Work Order Management</a></li>
				<li><a href="./indexEmployee">Employee Management</a></li>
				<li><a href="./j_spring_security_logout">Logout</a></li>
			</ul>
		</div>
		<div class='content'>
			<a class='button'></a><br> <br> <br> <a
				href="${pageContext.request.contextPath}/indexInventory"
				class="btn btn-primary"> <span
				class="glyphicon glyphicon-arrow-left"></span> Back
			</a> <br>
			<h1>
				<span class="glyphicon glyphicon-list-alt"></span> Inventory Item
				Details
			</h1>
			<table id="inventoryItemTable"
				class="table table-striped table-bordered" style="width: 1%">
				<tbody>
					<tr>
						<td><fmt:message key="inventory.inventoryid.title" />:</td>
						<td>${inventory.inventoryId}</td>
					</tr>
					<tr>
						<td><fmt:message key="inventory.inventoryproductname.title" />:</td>
						<td>${inventory.inventoryProductName}</td>
					</tr>
					<tr>
						<td><fmt:message key="inventory.inventoryname.title" />:</td>
						<td>${inventory.inventoryName}</td>
					</tr>
					<tr>
						<td><fmt:message key="inventory.inventoryprice.title" />:</td>
						<td>${inventory.inventoryPrice}</td>
					</tr>
					<tr>
						<td><fmt:message key="inventory.inventorystocklevel.title" />:</td>
						<td class="stockLevel">${inventory.inventoryStockLevel}</td>
					</tr>
					<tr>
						<td><fmt:message key="inventory.inventoryunit.title" />:</td>
						<td>${inventory.inventoryUnit}</td>
					</tr>
					<tr>
						<td><fmt:message key="inventory.inventorylowthreshold.title" />:</td>
						<td class="lowThreshold">${inventory.inventoryLowThreshold}</td>
					</tr>
					<tr>
						<td><fmt:message key="inventory.inventorylocation.title" />:</td>
						<td>${inventory.inventoryLocation}</td>
					</tr>
				</tbody>
			</table>
			<h1>
				<span class="glyphicon glyphicon-user"></span> Vendor Information
			</h1>
			<c:if test='${inventory.client != null}'>
				<table id="clientTable" class="table table-striped table-bordered" style="width: 1%">
					<tbody>
						<tr>
							<td><fmt:message key="client.clientid.title" />:</td>
							<td>${inventory.client.clientId}</td>
						</tr>
						<tr>
							<td><fmt:message key="client.clienttype.title" />:</td>
							<td>${inventory.client.clientType}</td>
						</tr>
						<tr>
							<td><fmt:message key="client.clientname.title" />:</td>
							<td>${inventory.client.clientName}</td>
						</tr>
						<tr>
							<td><fmt:message key="client.clientphonenum.title" />:</td>
							<td><a href="tel:+1${current.clientPhoneNum}?call"
								class="btn btn-primary btn-success"><span
									class="glyphicon glyphicon-phone"></span> ${inventory.client.clientPhoneNum}</a></td>
						</tr>
						<tr>
							<td><fmt:message key="client.clientext.title" />:</td>
							<td>${inventory.client.clientExt}</td>
						</tr>
						<tr>
							<td><fmt:message key="client.clientemail.title" />:</td>
							<td><a
								href="mailto:${client.clientEmail}?Subject=Colombus&Roofing"
								class="btn btn-primary btn-success"><span
									class="glyphicon glyphicon-envelope"></span> ${inventory.client.clientEmail}</a></td>
						</tr>
						<tr>
							<td><fmt:message key="client.clientaddress.title" />:</td>
							<td><a
								href="http://maps.google.com/?q=${inventory.client.clientAddress} ${inventory.client.clientCity} ${inventory.client.postalCode}"
								class="btn btn-primary btn-success"><span
									class="glyphicon glyphicon-map-marker"></span> ${inventory.client.clientAddress}</a></td>
						</tr>
						<tr>
							<td><fmt:message key="client.clientcity.title" />:</td>
							<td>${inventory.client.clientCity}</td>
						</tr>
						<tr>
							<td><fmt:message key="client.postalcode.title" />:</td>
							<td>${inventory.client.postalCode}</td>
						</tr>
						<tr>
							<td><fmt:message key="client.clientcomment.title" />:</td>
							<td>${inventory.client.clientComment}</td>
						</tr>
					</tbody>
				</table>
				<div>
					<a class="btn btn-primary btn-warning popupbtn cboxElement"
						href="${pageContext.request.contextPath}/editInventoryClient?inventory_inventoryId=${inventory.inventoryId}&client_clientId=${inventory.client.clientId}&"><span
						class="glyphicon glyphicon-pencil"></span> Edit </a> <a
						class="btn btn-primary btn-danger popupbtn cboxElement"
						href="${pageContext.request.contextPath}/confirmDeleteInventoryClient?inventory_inventoryId=${inventory.inventoryId}&related_client_clientId=${inventory.client.clientId}&"><span
						class="glyphicon glyphicon-trash"></span> Delete </a>
				</div>
			</c:if>
			<c:if test='${inventory.client == null}'>
				<div>
					<a class="btn btn-primary btn-success  popupbtn cboxElement"
						href="${pageContext.request.contextPath}/newInventoryClient?inventory_inventoryId=${inventory.inventoryId}&"><span
						class="glyphicon glyphicon-plus"></span> New Vendor</a>
				</div>
				<br>
				<br>
			</c:if>
			<h1>
				<span class="glyphicon glyphicon-shopping-cart"></span> Related
				Purchase Orders
			</h1>
			<div>
				<a class="btn btn-primary btn-success popupbtn cboxElement"
					href="${pageContext.request.contextPath}/newInventoryPurchaseOrders?inventory_inventoryId=${inventory.inventoryId}&">
					<span class="glyphicon glyphicon-plus"></span> New Purchase Order
				</a>
			</div>
			<br> <br>
			<table id="purchaseOrderTable"
				class="table table-striped table-bordered">
				<thead>
					<tr>
						<th class="thead" id="actions" width="1%">Actions</th>
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
					<c:forEach items="${inventory.purchaseOrders}" var="current"
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
								href="${pageContext.request.contextPath}/selectPurchaseOrder?purchaseOrderIdKey=${current.purchaseOrderId}&"><span
									class="glyphicon glyphicon-eye-open"></span> View</a> <a
								class="btn btn-primary btn-warning popupbtn cboxElement"
								title=""
								href="${pageContext.request.contextPath}/editInventoryPurchaseOrders?inventory_inventoryId=${inventory.inventoryId}&purchaseorders_purchaseOrderId=${current.purchaseOrderId}&"><span
									class="glyphicon glyphicon-pencil"></span> Edit</a> <a
								class="btn btn-primary btn-danger popupbtn cboxElement" title=""
								href="${pageContext.request.contextPath}/confirmDeleteInventoryPurchaseOrders?inventory_inventoryId=${inventory.inventoryId}&related_purchaseorders_purchaseOrderId=${current.purchaseOrderId}&"><span
									class="glyphicon glyphicon-trash"></span> Delete</a></td>
							<td>${current.purchaseOrderId}</td>
							<td><a
								href="http://maps.google.com/?q=${current.purchaseOrderAddress}"
								class="btn btn-primary btn-success"><span
									class="glyphicon glyphicon-map-marker"></span>${current.purchaseOrderAddress}</a></td>
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
			<h1>
				<span class="glyphicon glyphicon-wrench"></span> Related Work Orders
			</h1>
			<div>
				<a class="btn btn-primary btn-success popupbtn cboxElement"
					href="${pageContext.request.contextPath}/newInventoryWorkOrders?inventory_inventoryId=${inventory.inventoryId}&">
					<span class="glyphicon glyphicon-plus"></span> New Work Order
				</a>
			</div>
			<br> <br>
			<table id="workOrderTable" class="table table-striped table-bordered">
				<thead>
					<tr>
						<th class="thead" id="actions1" width="1%">Actions</th>
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
					<c:forEach items="${inventory.workOrders}" var="current"
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
								href="${pageContext.request.contextPath}/selectWorkOrder?workOrderIdKey=${current.workOrderId}&"><span
									class="glyphicon glyphicon-eye-open"></span> View</a> <a
								class="btn btn-primary btn-warning popupbtn cboxElement"
								title=""
								href="${pageContext.request.contextPath}/editInventoryWorkOrders?inventory_inventoryId=${inventory.inventoryId}&workorders_workOrderId=${current.workOrderId}&"><span
									class="glyphicon glyphicon-pencil"></span> Edit</a> <a
								class="btn btn-primary btn-danger popupbtn cboxElement "
								title=""
								href="${pageContext.request.contextPath}/confirmDeleteInventoryWorkOrders?inventory_inventoryId=${inventory.inventoryId}&related_workorders_workOrderId=${current.workOrderId}&"><span
									class="glyphicon glyphicon-trash"></span> Delete</a></td>
							<td>${current.workOrderId}</td>
							<td>${current.workOrderScope}</td>
							<td><a
								href="http://maps.google.com/?q=${current.workOrderAddress}"
								class="btn btn-primary btn-success"><span
									class="glyphicon glyphicon-map-marker"></span>${current.workOrderAddress}</a></td>
							<td><fmt:formatDate dateStyle="short" type="date"
									value="${current.workOrderCreatedOn.time}" /></td>
							<td class="expectedEndDate"><fmt:formatDate
									dateStyle="short" type="date"
									value="${current.workOrderExpectedEndDate.time}" /></td>
							<td class="actualEndDate"><fmt:formatDate dateStyle="short"
									type="date" value="${current.workOrderEndDate.time}" /></td>
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
						//Color Coding for Inventory stock level
							var stockLevel = 0;
							var lowThreshold = 0;
										
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
										};
										
								//Compare Dates for Work Order	
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
								$('#workOrderTable tr')
										.each(
												function() {
													//Get dates
													expectedEndDate = $(this)
															.find(
																	'.expectedEndDate')
															.html();
													actualEndDate = $(this)
															.find(
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
												})

								//Work Order Status Color Coding
								$(
										"#workOrderTable td.status:contains('Completed')")
										.css('background-color', '#4ed377');
								$(
										"#workOrderTable td.status:contains('W.I.P.')")
										.css('background-color', '#eae06c');
								$(
										"#workOrderTable td.status:contains('Cancelled')")
										.css('background-color', '#d37676');

	
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
													expectedDeliveryDate = $(
															this)
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
							
							//Alertify Setup
							alertify.set('notifier', 'position', 'top-right');

							//Alert success or error notifications based on previous URL
							//Work Orders
							if (document.referrer.indexOf("deleteInventoryWorkOrders") > -1) {
								alertify.success('Work Order deleted!');
							} else if (document.referrer
									.indexOf("saveInventoryWorkOrders") > -1) {
								alertify.success('Work Order saved!');
							}
							if (document.referrer.indexOf("deleteInventoryPurchaseOrders") > -1) {
								alertify.success('Purchase Order deleted!');
							} else if (document.referrer
									.indexOf("saveInventoryPurchaseOrders") > -1) {
								alertify.success('Purchase Order saved!');
							}
							if (document.referrer.indexOf("deleteInventoryClient") > -1) {
								alertify.success('Vendor was deleted!');
							} else if (document.referrer
									.indexOf("saveInventoryClient") > -1) {
								alertify.success('Vendor was saved!');
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
							$('#purchaseOrderTable').stacktable({
								myClass : 'stacktable small-only'
							});

							$('#workOrderTable').stacktable({
								myClass : 'stacktable small-only'
							});

							//Remove sorting from actions column
							document.getElementById("actions1").className = "thead";
							document.getElementById("actions").className = "thead";
						});									
						
						//Mobile Search / Pagination
							$(function() {
								$("input").keydown(function() { //On Search Input
									$(".small-only").remove(); //Remove old stackable table
									$('#workOrderTable').stacktable({
										myClass : 'stacktable small-only'
									});

									$('#purchaseOrderTable').stacktable({
										myClass : 'stacktable small-only'
									});
								});

								$('#listTable_paginate').click(function() { //On pagination click
									$(".small-only").remove(); //Remove old stackable table
									$('#workOrderTable').stacktable({
										myClass : 'stacktable small-only'
									});

									$('#purchaseOrderTable').stacktable({
										myClass : 'stacktable small-only'
									});
								});
							});
	</script>
</body>
</html>