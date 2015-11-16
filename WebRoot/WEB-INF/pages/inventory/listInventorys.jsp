<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.inventory-resources" />
<html>
<head>
<title>Inventory Management</title>
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
			window.location.replace("./indexInventory");
		} else if (window.location.href.indexOf("save") > -1) {
			window.location.replace("./indexInventory");
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
			<a class='button'></a>
			<h1>
				<span class="glyphicon glyphicon-list-alt"></span> Inventory
				Management
			</h1>
			<h2>Easily manage your inventory items in one place!</h2>
			<table id="listTable" class="table table-striped table-bordered">
				<thead>
					<tr>
						<th class="thead" id="actions" width="1%">Actions</th>
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
					<c:forEach items="${inventorys}" var="current" varStatus="i">
						<c:choose>
							<c:when test="${(i.count) % 2 == 0}">
								<c:set var="rowclass" value="rowtwo" />
							</c:when>
							<c:otherwise>
								<c:set var="rowclass" value="rowone" />
							</c:otherwise>
						</c:choose>
						<tr class="${rowclass}">
							<td><a class="btn btn-primary btn-primary" title="View Item"
								href="${pageContext.request.contextPath}/selectInventory?inventoryIdKey=${current.inventoryId}&"><span
									class="glyphicon glyphicon-eye-open"></span> View</a> <a
								class="btn btn-primary btn-warning popupbtn cboxElement"
								title="Edit Item"
								href="${pageContext.request.contextPath}/editInventory?inventoryIdKey=${current.inventoryId}&"><span
									class="glyphicon glyphicon-pencil"></span> Edit</a> <a
								class="btn btn-primary btn-danger popupbtn cboxElement"
								title="Delete Item"
								href="${pageContext.request.contextPath}/confirmDeleteInventory?inventoryIdKey=${current.inventoryId}&"><span
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
			<a href="./newInventory"
				class="btn btn-primary btn-success popupbtn cboxElement"><span
				class="glyphicon glyphicon-plus"></span> New Inventory Item </a>
		</div>
	</div>
	<script>
		$(document)
				.ready(
						function() {
							//Side Menu
							$('.button').on('click', function() {
								$('.content').toggleClass('isOpen');
							});
							
							//Color Coding
							var stockLevel = 0;
							var lowThreshold = 0;
							//For each table low
							$('#listTable tr').each(
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
							
							//Notifier set up
							alertify.set('notifier', 'position', 'top-right');

							//Alert success or error notifications based on previous URL
							if (document.referrer.indexOf("deleteInventory") > -1) {
								alertify.success('Inventory Item was deleted!');
							} else if (document.referrer
									.indexOf("saveInventory") > -1) {
								alertify.success('Inventory Item Saved!');
							}

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

							//Pop Up Colorbox
							$(".popupbtn").colorbox({
								onClosed : function() {
								}
							});
						});
	</script>
</body>
</html>