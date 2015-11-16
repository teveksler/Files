<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.quote-resources" />
<html>
<head>
<title>Quote Management</title>
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
		//Go back to indexQuote after saving or deleting 
		if (window.location.href.indexOf("deleteQuote") > -1) {
			window.location.replace("./indexQuote");
		} else if (window.location.href.indexOf("quoteUpload") > -1) {
			window.location.replace("./indexQuote");
		}
	</script>
	<div class='wrapper'>
		<div class='sidebar'>
			<div class='title'>AXI</div>

			<ul class='nav'>
				<li><a href="./">Home</a></li>

				<li><a href="./indexClient">Client Management</a></li>

				<li><a href="./indexQuote" class='active'>Quote Management</a></li>

				<li><a href="./indexInventory">Inventory Management</a></li>


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
				<span class="glyphicon glyphicon-list-alt"></span> Quote Management
			</h1>
			<h2>Keep track of your quotes!</h2>

			<table id="listTable"
				class="table table-striped table-bordered no-spacing">
				<thead>
					<tr>
						<th class="thead" id="actions" width="1%">Actions</th>
						<th class="thead"><fmt:message key="quote.quoteid.title" /></th>
						<th class="thead"><fmt:message key="quote.quotedate.title" />
						</th>
						<th class="thead"><fmt:message key="quote.quotepdf.title" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${quotes}" var="current" varStatus="i">
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
								title="View Quote"
								href="${pageContext.request.contextPath}/selectQuote?quoteIdKey=${current.quoteId}&"><span
									class="glyphicon glyphicon-eye-open"></span> View</a> <a
								class="btn btn-primary btn-warning popupbtn cboxElement"
								title="Edit Quote"
								href="${pageContext.request.contextPath}/editQuote?quoteIdKey=${current.quoteId}&"><span
									class="glyphicon glyphicon-pencil"></span> Edit</a> <a
								class="btn btn-primary btn-danger popupbtn cboxElement"
								title="Delete Quote"
								href="${pageContext.request.contextPath}/confirmDeleteQuote?quoteIdKey=${current.quoteId}&"><span
									class="glyphicon glyphicon-trash popupbtn cboxElement"></span>
									Delete</a></td>
							<td>${current.quoteId}</td>
							<td><fmt:formatDate dateStyle="full" type="date"
									value="${current.quoteDate.time}" /></td>
							<td><a href="${pageContext.request.contextPath}/downloadQuote?quote_id=${current.quoteId}&"><span class="glyphicon glyphicon-list-alt"></span> Download File</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="./newQuote"
				class="btn btn-primary btn-success popupbtn cboxElement"><span
				class="glyphicon glyphicon-plus"></span> New Quote</a>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			//Notifier set up
			alertify.set('notifier', 'position', 'top-right');

			//Alert success or error notifications based on previous URL
			if (document.referrer.indexOf("deleteQuote") > -1) {
				alertify.success('Quote deleted!');
			} else if (document.referrer.indexOf("saveQuote") > -1) {
				alertify.success('Quote saved!');
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

			//Pop Up Colorbox
			$(".popupbtn").colorbox();
			//Remove sorting from actions column
			document.getElementById("actions").className = "thead";
		});
	</script>
</body>
</html>