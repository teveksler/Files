
<%@page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.quote-resources" />
<html>
<head>
<title>View <fmt:message key="quote.title" />
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
		//Go back to selectQuote after saving or deleting related entities
		if (window.location.href.indexOf("delete") > -1) {
			window.location.replace("./selectQuote?quoteIdKey="
					+ ${quote.quoteId} + "&");
		} else if (window.location.href.indexOf("save") > -1) {
			window.location.replace("./selectQuote?quoteIdKey="
					+ ${quote.quoteId} + "&");
		}
	</script>
	<div class="wrapper">
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
			<a class='button'></a><br> <br> <a
				href="${pageContext.request.contextPath}/indexQuote"
				class="btn btn-primary"><span
				class="glyphicon glyphicon-arrow-left"></span> Back</a>
			<h1>
				<span class="glyphicon glyphicon-list-alt"></span> Quote Details
			</h1>
			<table id="mainTable" class="table table-striped table-bordered">
				<tbody>
					<tr>
						<td style="width: 1%"><fmt:message key="quote.quoteid.title" />:</td>
						<td>${quote.quoteId}</td>
					</tr>
					<tr>
						<td><fmt:message key="quote.quotedate.title" />:</td>
						<td><fmt:formatDate dateStyle="short" type="date"
								value="${quote.quoteDate.time}" /></td>
					</tr>
					<tr>
						<td><fmt:message key="quote.quotepdf.title" />:</td>
						<td><a href="${pageContext.request.contextPath}/downloadQuote?quote_id=${quote.quoteId}&"><span class="glyphicon glyphicon-list-alt"></span> Download File</a></td>
					</tr>
				</tbody>
			</table>
			<h1>
				<span class="glyphicon glyphicon-user"></span> Client Details
			</h1>
			<c:if test='${quote.client != null}'>
				<table id="customerTable" class="table table-striped table-bordered">
					<tbody>
						<tr>
							<td style="width: 1%"><fmt:message
									key="client.clientid.title" />:</td>
							<td>${quote.client.clientId}</td>
						</tr>
						<tr>
							<td><fmt:message key="client.clienttype.title" />:</td>
							<td>${quote.client.clientType}</td>
						</tr>
						<tr>
							<td><fmt:message key="client.clientname.title" />:</td>
							<td>${quote.client.clientName}</td>
						</tr>
						<tr>
							<td><fmt:message key="client.clientphonenum.title" />:</td>
							<td><a href="tel:+1${quote.client.clientPhoneNum}?call"
								class="btn btn-primary btn-success"><span
									class="glyphicon glyphicon-phone"></span>
									${quote.client.clientPhoneNum}</a></td>
						</tr>
						<tr>
							<td><fmt:message key="client.clientext.title" />:</td>
							<td>${quote.client.clientExt}</td>
						</tr>
						<tr>
							<td><fmt:message key="client.clientemail.title" />:</td>
							<td><a
								href="mailto:${quote.client.clientEmail}?Subject=Colombus&Roofing"
								class="btn btn-primary btn-success"><span
									class="glyphicon glyphicon-envelope"></span>
									${quote.client.clientEmail}</a></td>
						</tr>
						<tr>
							<td><fmt:message key="client.clientaddress.title" />:</td>
							<td><a
								href="http://maps.google.com/?q=${quote.client.clientAddress} ${quote.client.clientCity} ${quote.client.postalCode}"
								class="btn btn-primary btn-success"><span
									class="glyphicon glyphicon-map-marker"></span>
									${quote.client.clientAddress}</a></td>
						</tr>
						<tr>
							<td><fmt:message key="client.clientcity.title" />:</td>
							<td>${quote.client.clientCity}</td>
						</tr>
						<tr>
							<td><fmt:message key="client.postalcode.title" />:</td>
							<td>${quote.client.postalCode}</td>
						</tr>
						<tr>
							<td><fmt:message key="client.clientcomment.title" />:</td>
							<td>${quote.client.clientComment}</td>
						</tr>
					</tbody>
				</table>
				<div class="navitem">
					<a class="btn btn-primary btn-warning popupbtn"
						href="${pageContext.request.contextPath}/editQuoteClient?quote_quoteId=${quote.quoteId}&client_clientId=${quote.client.clientId}&"><span
						class="glyphicon glyphicon-pencil"></span><span> <fmt:message
								key="navigation.edit" /></span></a> <a
						class="btn btn-primary btn-danger popupbtn"
						href="${pageContext.request.contextPath}/confirmDeleteQuoteClient?quote_quoteId=${quote.quoteId}&related_client_clientId=${quote.client.clientId}&"><span
						class="glyphicon glyphicon-trash"></span><span> <fmt:message
								key="navigation.delete" /></span></a>
				</div>
			</c:if>
			<c:if test='${quote.client == null}'>
				<div class="navitem">
					<a class="btn btn-primary btn-success popupbtn"
						href="${pageContext.request.contextPath}/newQuoteClient?quote_quoteId=${quote.quoteId}&"><span
						class="glyphicon glyphicon-plus"></span> New Customer</a>
				</div>
			</c:if>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			//Alertify Setup
			alertify.set('notifier', 'position', 'top-right');
			
			//Alert success or error notifications based on previous URL
			if (document.referrer.indexOf("deleteQuoteClient") > -1) {
								alertify.success('Client deleted!');
							} else if (document.referrer
									.indexOf("saveQuoteClient") > -1) {
								alertify.success('Client saved!');
							}

			//Side Menu
			$('.button').on('click', function() {
				$('.content').toggleClass('isOpen');
			});

			//Pop Up Colorbox
			$(".popupbtn").colorbox();
		});
	</script>
</body>
</html>
