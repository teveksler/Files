
<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.employee-resources" />
<html>

<head>
<title>List <fmt:message key="employee.title" />s
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
		//Go back to indexEmployee after saving or deleting 
		if (window.location.href.indexOf("deleteEmployee") > -1) {
			window.location.replace("./indexEmployee");
		} else if (window.location.href.indexOf("saveEmployee") > -1) {
			window.location.replace("./indexEmployee");
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
				<li><a href="./indexWorkOrder">Work Order Management</a></li>
				<li><a href="./indexEmployee" class='active'>Employee
						Management</a></li>
				<li><a href="./j_spring_security_logout">Logout</a></li>
			</ul>
		</div>
		<div class='content'>
			<a class='button'></a>
			<h1>
				<span class="glyphicon glyphicon-user"></span> Employee Management
			</h1>
			<h2>Manage employees of your company!</h2>
			<table id="listTable" class="table table-striped table-bordered">
				<thead>
					<tr>
						<th class="thead" width="1%" id="actions">Actions</th>
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
					<c:forEach items="${employees}" var="current" varStatus="i">
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
								title="View Employee"
								href="${pageContext.request.contextPath}/selectEmployee?employeeIdKey=${current.employeeId}&"><span
									class="glyphicon glyphicon-eye-open"></span> View</a> <a
								class="btn btn-primary btn-warning popupbtn cboxElement"
								title="Edit Employee"
								href="${pageContext.request.contextPath}/editEmployee?employeeIdKey=${current.employeeId}&"><span
									class="glyphicon glyphicon-pencil"></span> Edit</a> <a
								class="btn btn-primary btn-danger popupbtn cboxElement"
								title="Delete Employee"
								href="${pageContext.request.contextPath}/confirmDeleteEmployee?employeeIdKey=${current.employeeId}&"><span
									class="glyphicon glyphicon-trash"></span> Delete</a></td>
							<td>${current.employeeId}</td>
							<td>${current.employeeName}</td>
							<td><a href="tel:+1${current.employeePhoneNum}?call"
								class="btn btn-primary btn-success"><span
									class="glyphicon glyphicon-phone"></span>
									${current.employeePhoneNum}</a></td>
							<td><a
								href="mailto:${current.employeeEmail}?Subject=Colombus&Roofing"
								class="btn btn-primary btn-success"><span
									class="glyphicon glyphicon-envelope"></span>
									${current.employeeEmail}</a></td>
							<td>${current.employeeComment}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a title="New Employee" href="./newEmployee"
				class="btn btn-primary btn-success popupbtn cboxElement"><span
				class="glyphicon glyphicon-plus"></span> New Employee</a>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			//Notifier set up
			alertify.set('notifier', 'position', 'top-right');

			//Go back to indexEmployee after saving or deleting 
			if (window.location.href.indexOf("deleteEmployee") > -1) {
				window.location.replace("./indexEmployee");
			} else if (window.location.href.indexOf("saveEmployee") > -1) {
				window.location.replace("./indexEmployee");
			}

			//Alert success or error notifications based on previous URL
			if (document.referrer.indexOf("deleteEmployee") > -1) {
				alertify.success('Employee deleted!');
			} else if (document.referrer.indexOf("saveEmployee") > -1) {
				alertify.success('Employee saved!');
			}

			//Side Menu
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

			//Pop Up Colorbox
			$(".popupbtn").colorbox();
			
			//Remove sorting from actions column
			document.getElementById("actions").className = "thead";

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
		});
	</script>
</body>
</html>