
<%@page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.client-resources" />
<html>
<head>
<title>Client Details</title>
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
								window.location.replace("./selectClient?clientIdKey=" + ${client.clientId} + "&");
							} else if (window.location.href.indexOf("save") > -1) {
								window.location.replace("./selectClient?clientIdKey=" + ${client.clientId} + "&");
							}
	</script>
	<div class='wrapper'>
		<div class='sidebar'>
			<div class='title'>AXI</div>
			<ul class='nav'>
				<li><a href="./">Home</a></li>
				<li><a href="./indexClient" class='active'>Client
						Management</a></li>
				<li><a href="./indexQuote">Quote Management</a></li>
				<li><a href="./indexInventory">Inventory Management</a></li>
				<li><a href="./indexPurchaseOrder">Purchase Order
						Management</a></li>
				<li><a href="./indexWorkOrder">Work Order Management</a></li>
				<li><a href="./indexEmployee">Employee Management</a></li>
				<li><a href="./j_spring_security_logout">Logout</a></li>
			</ul>
		</div>
		<div class='content'>
			<a class='button'></a> <br> <br> <a
				href="${pageContext.request.contextPath}/indexClient"
				class="btn btn-primary"><span
				class="glyphicon glyphicon-arrow-left"></span> Back</a> <br>
			<h1>
				<span class="glyphicon glyphicon-user"></span> Client Details
			</h1>
			<table style="width: 1%" id="mainTable"
				class="table table-striped table-bordered">
				<tbody>
					<tr>
						<td><fmt:message key="client.clientid.title" />:</td>
						<td>${client.clientId}</td>
					</tr>
					<tr>
						<td><fmt:message key="client.clienttype.title" />:</td>
						<td id="clientType">${client.clientType}</td>
					</tr>
					<tr>
						<td><fmt:message key="client.clientname.title" />:</td>
						<td>${client.clientName}</td>
					</tr>
					<tr>
						<td><fmt:message key="client.clientphonenum.title" />:</td>
						<td><a href="tel:+1${client.clientPhoneNum}?call"
							class="btn btn-primary btn-success"><span
								class="glyphicon glyphicon-phone"></span>
								${client.clientPhoneNum}</a></td>
					</tr>
					<tr>
						<td><fmt:message key="client.clientext.title" />:</td>
						<td>${client.clientExt}</td>
					</tr>
					<tr>
						<td><fmt:message key="client.clientemail.title" />:</td>
						<td><a
							href="mailto:${client.clientEmail}?Subject=Colombus&Roofing"
							class="btn btn-primary btn-success"><span
								class="glyphicon glyphicon-envelope"></span>
								${client.clientEmail}</a></td>
					</tr>
					<tr>
						<td><fmt:message key="client.clientaddress.title" />:</td>
						<td><a
							href="http://maps.google.com/?q=${client.clientAddress} ${client.clientCity} ${client.postalCode}"
							class="btn btn-primary btn-success"><span
								class="glyphicon glyphicon-map-marker"></span>
								${client.clientAddress}</a></td>
					</tr>
					<tr>
						<td><fmt:message key="client.clientcity.title" />:</td>
						<td>${client.clientCity}</td>
					</tr>
					<tr>
						<td><fmt:message key="client.postalcode.title" />:</td>
						<td>${client.postalCode}</td>
					</tr>
					<tr>
						<td><fmt:message key="client.clientcomment.title" />:</td>
						<td>${client.clientComment}</td>
					</tr>
				</tbody>
			</table>
			<div class="clear"></div>
			<div class="spacer"></div>
			<div id="relatedWorkOrders" style="display: none">
				<h1>
					<span class="glyphicon glyphicon-wrench"></span> Related Work
					Orders
				</h1>
				<a class="btn btn-primary btn-success popupbtn cboxElement "
					href="${pageContext.request.contextPath}/newClientWorkOrders?client_clientId=${client.clientId}&">
					<span class="glyphicon glyphicon-plus"></span> New Work Order
				</a> <br> <br>
				<table id="workOrderTable"
					class="table table-striped table-bordered">
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
						<c:forEach items="${client.workOrders}" var="current"
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
									title="View Work Order"
									href="${pageContext.request.contextPath}/selectWorkOrder?workOrderIdKey=${current.workOrderId}&"><span
										class="glyphicon glyphicon-eye-open"></span> View</a> <a
									class="btn btn-primary btn-warning popupbtn cboxElement"
									title="Edit Work Order"
									href="${pageContext.request.contextPath}/editClientWorkOrders?client_clientId=${client.clientId}&workorders_workOrderId=${current.workOrderId}&"><span
										class="glyphicon glyphicon-pencil"></span> Edit</a> <a
									class="btn btn-primary btn-danger popupbtn cboxElement"
									title="Delete Work Order"
									href="${pageContext.request.contextPath}/confirmDeleteClientWorkOrders?client_clientId=${client.clientId}&related_workorders_workOrderId=${current.workOrderId}&"><span
										class="glyphicon glyphicon-trash"></span> Delete</a></td>
								<td>${current.workOrderId}</td>
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
								<td class="status">${current.workOrderStatus}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div id="relatedInventory" style="display: none">
				<h1>
					<span class="glyphicon glyphicon-user"></span> Vendor Inventory
				</h1>
				<a class="btn btn-primary btn-success popupbtn cboxElement"
					href="${pageContext.request.contextPath}/newClientInventories?client_clientId=${client.clientId}&">
					<span class="glyphicon glyphicon-plus"></span> New Inventory Item
				</a><br> <br>
				<table id="inventoryTable"
					class="table table-striped table-bordered">
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
						<c:forEach items="${client.inventories}" var="current"
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
									class="btn btn-primary btn-warning popupbtn cboxElement"
									title="Edit Inventory Item"
									href="${pageContext.request.contextPath}/editClientInventories?client_clientId=${client.clientId}&inventories_inventoryId=${current.inventoryId}&"><span
										class="glyphicon glyphicon-pencil "></span> Edit</a> <a
									class="btn btn-primary btn-danger popupbtn cboxElement"
									title="Delete Inventory Item"
									href="${pageContext.request.contextPath}/confirmDeleteClientInventories?client_clientId=${client.clientId}&related_inventories_inventoryId=${current.inventoryId}&"><span
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
			<div id="relatedPurchaseOrder" style="display: none">
				<h1>
					<span class="glyphicon glyphicon-shopping-cart"></span> Related
					Purchase Orders
				</h1>
				<div class="navitem">
					<a class="btn btn-primary btn-success popupbtn cboxElement"
						href="${pageContext.request.contextPath}/newClientPurchaseOrders?client_clientId=${client.clientId}&">
						<span class="glyphicon glyphicon-plus"></span> New Purchase Order
					</a><br> <br>
				</div>
				<table id="purchaseOrderTable"
					class="table table-striped table-bordered">
					<thead>
						<tr>
							<th class="thead" id="actions3" width="1%">Actions</th>
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
						<c:forEach items="${client.purchaseOrders}" var="current"
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
									title="View Purchase Order"
									href="${pageContext.request.contextPath}/selectPurchaseOrder?purchaseOrderIdKey=${current.purchaseOrderId}&"><span
										class="glyphicon glyphicon-eye-open "></span> View</a> <a
									class="btn btn-primary btn-warning popupbtn cboxElement"
									title="Edit Purchase Order"
									href="${pageContext.request.contextPath}/editClientPurchaseOrders?client_clientId=${client.clientId}&purchaseorders_purchaseOrderId=${current.purchaseOrderId}&"><span
										class="glyphicon glyphicon-pencil "></span> Edit</a> <a
									class="btn btn-primary btn-danger popupbtn cboxElement"
									title="Delete Purchase Order"
									href="${pageContext.request.contextPath}/confirmDeleteClientPurchaseOrders?client_clientId=${client.clientId}&related_purchaseorders_purchaseOrderId=${current.purchaseOrderId}&"><span
										class="glyphicon glyphicon-trash"></span> Delete</a></td>
								<td>${current.purchaseOrderId}</td>
								<td>${current.purchaseOrderAddress}</td>
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
			</div>
			<div id="relatedQuotes" style="display: none">
				<h1>
					<span class="glyphicon glyphicon-file"></span> Related Quotes
				</h1>
				<div class="navitem">
					<a class="btn btn-primary btn-success popupbtn cboxElement"
						href="${pageContext.request.contextPath}/newClientQuotes?client_clientId=${client.clientId}&">
						<span class="glyphicon glyphicon-plus"></span> New Quote
					</a><br> <br>
				</div>
				<table id="quoteTable" class="table table-striped table-bordered">
					<thead>
						<tr>
							<th class="thead" id="actions4" width="1%">Actions</th>
							<th class="thead"><fmt:message key="quote.quoteid.title" /></th>
							<th class="thead"><fmt:message key="quote.quotedate.title" />
							</th>
							<th class="thead"><fmt:message key="quote.quotepdf.title" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${client.quotes}" var="current" varStatus="i">
							<c:choose>
								<c:when test="${(i.count) % 2 == 0}">
									<c:set var="rowclass" value="rowtwo" />
								</c:when>
								<c:otherwise>
									<c:set var="rowclass" value="rowone" />
								</c:otherwise>
							</c:choose>
							<tr class="${rowclass}">
								<td><a
									class="btn btn-primary btn-primary popupbtn cboxElement"
									title="View Quote"
									href="${pageContext.request.contextPath}/selectQuote?quoteIdKey=${current.quoteId}&"><span
										class="glyphicon glyphicon-eye-open"></span> View</a> <a
									class="btn btn-primary btn-warning popupbtn cboxElement"
									title="Edit Quote"
									href="${pageContext.request.contextPath}/editClientQuotes?client_clientId=${client.clientId}&quotes_quoteId=${current.quoteId}&"><span
										class="glyphicon glyphicon-pencil "></span> Edit</a> <a
									class="btn btn-primary btn-danger popupbtn cboxElement"
									title="Delete Quote"
									href="${pageContext.request.contextPath}/confirmDeleteClientQuotes?client_clientId=${client.clientId}&related_quotes_quoteId=${current.quoteId}&"><span
										class="glyphicon glyphicon-trash"></span> Delete</a></td>
								<td>${current.quoteId}</td>
								<td><fmt:formatDate dateStyle="short" type="date"
										value="${current.quoteDate.time}" /></td>
								<td><a href="${pageContext.request.contextPath}/downloadQuote?quote_id=${current.quoteId}&"><span class="glyphicon glyphicon-list-alt"></span>
									 Download File</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
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
							if (document.referrer.indexOf("deleteClientWorkOrders") > -1) {
								alertify.success('Work Order deleted!');
							} else if (document.referrer
									.indexOf("saveClientWorkOrders") > -1) {
								alertify.success('Work Order saved!');
							}

							//Purchase Orders
							if (document.referrer
									.indexOf("deleteClientPurchaseOrders") > -1) {
								alertify.success('Purchase Order deleted!');
							} else if (document.referrer
									.indexOf("saveClientPurchaseOrders") > -1) {
								alertify.success('Purchase Order saved!');
							}

							//Inventory
							if (document.referrer
									.indexOf("deleteClientInventories") > -1) {
								alertify.success('Inventory item deleted!');
							} else if (document.referrer
									.indexOf("saveClientInventories") > -1) {
								alertify.success('Inventory item saved!');
							}

							//Quotes
							if (document.referrer.indexOf("deleteClientQuotes") > -1) {
								alertify.success('Quote deleted!');
							} else if (document.referrer.indexOf("saveClientQuotes") > -1) {
								alertify.success('Quote saved!');
							}

							if ($("#clientType").text() == 'Home Owner / Customer') {

								document.getElementById("relatedQuotes").style.display = "";
								document.getElementById("relatedWorkOrders").style.display = "";

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
							}
							if ($("#clientType").text() == 'Vendor') {

								document.getElementById("relatedInventory").style.display = "";
								document.getElementById("relatedPurchaseOrder").style.display = "";

								//Inventory Stock Colorcoding
								var stockLevel = 0;
								var lowThreshold = 0;
								//For each table low
								$('#inventoryTable tr')
										.each(
												function() {
													lowThreshold = parseInt($(
															this).find(
															'.lowThreshold')
															.html());
													stockLevel = parseInt($(
															this).find(
															'.stockLevel')
															.html());
													//Color Based On Values
													if ((stockLevel > 0)
															& (stockLevel < lowThreshold)) { //LOW!
														$(this)
																.find(
																		'.stockLevel')
																.css(
																		'background-color',
																		'#eae06c');//YELLOW COLOR
														$(this)
																.find(
																		'.stockLevel')
																.append(
																		" (Low Stock!)")
													} else if (stockLevel >= lowThreshold) { //GOOD STOCK
														$(this)
																.find(
																		'.stockLevel')
																.css(
																		'background-color',
																		'#4ed377'); //GREEN COLOR
													} else if (stockLevel == 0) { //ZERO STOCK!
														$(this)
																.find(
																		'.stockLevel')
																.css(
																		'background-color',
																		'#d37676'); //RED COLOR
														$(this)
																.find(
																		'.stockLevel')
																.append(
																		" (Out of Stock!)")
													}
												});

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
							}
							if ($("#clientType").text() == 'Builder') {

								document.getElementById("relatedPurchaseOrder").style.display = "";
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
							}

							//DataTables
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

							$('#quoteTable').DataTable({
								dom : 'Bfrtip',
								buttons : [ {
									extend : 'pdfHtml5',
									orientation : 'landscape',
									exportOptions : {
										columns : ':visible'
									}
								}, 'excelHtml5', 'colvis' ]
							});

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
							$('#workOrderTable').stacktable({
								myClass : 'stacktable small-only'
							});

							$('#inventoryTable').stacktable({
								myClass : 'stacktable small-only'
							});

							$('#purchaseOrderTable').stacktable({
								myClass : 'stacktable small-only'
							});

							$('#quoteTable').stacktable({
								myClass : 'stacktable small-only'
							});

							//Pop Up Colorbox
							$(".popupbtn").colorbox({
								onClosed : function() {
								}
							});

							//Mobile Search / Pagination [BUGGY!]
							$(function() {
								$("input").keydown(function() { //On Search Input
									$(".small-only").remove(); //Remove old stackable table
									$('#workOrderTable').stacktable({
										myClass : 'stacktable small-only'
									});

									$('#inventoryTable').stacktable({
										myClass : 'stacktable small-only'
									});

									$('#purchaseOrderTable').stacktable({
										myClass : 'stacktable small-only'
									});

									$('#quoteTable').stacktable({
										myClass : 'stacktable small-only'
									});
								});

								$('#listTable_paginate').click(function() { //On pagination click
									$(".small-only").remove(); //Remove old stackable table
									$('#workOrderTable').stacktable({
										myClass : 'stacktable small-only'
									});

									$('#inventoryTable').stacktable({
										myClass : 'stacktable small-only'
									});

									$('#purchaseOrderTable').stacktable({
										myClass : 'stacktable small-only'
									});

									$('#quoteTable').stacktable({
										myClass : 'stacktable small-only'
									});
								});
							});

							//Remove sorting from actions column
							document.getElementById("actions1").className = "thead";
							document.getElementById("actions2").className = "thead";
							document.getElementById("actions3").className = "thead";
							document.getElementById("actions4").className = "thead";
						});
	</script>
</body>
</html>