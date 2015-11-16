
<%@page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.purchaseorder-resources" />
<html>
<head>
<title>Delete <fmt:message key="purchaseorder.title" />
</title>
<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.colorbox.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/datatables.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link href='http://fonts.googleapis.com/css?family=Courgette'
	rel='stylesheet' type='text/css' />
</head>
<body>
	<div class='content'>
		<br>
		<h1>Confirm Delete</h1>
		<table id="viewTable" class="table table-bordered">
			<tbody>
				<tr>
					<td><fmt:message
							key="purchaseorder.purchaseorderaddress.title" />:</td>
					<td>${purchaseorder.purchaseOrderAddress}</td>
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
					<td><fmt:formatDate dateStyle="short" type="date"
							value="${purchaseorder.purchaseOrderExpectedDate.time}" /></td>
				</tr>
				<tr>
					<td><fmt:message
							key="purchaseorder.purchaseorderrecieveddate.title" />:</td>
					<td><fmt:formatDate dateStyle="short" type="date"
							value="${purchaseorder.purchaseOrderRecievedDate.time}" /></td>
				</tr>
				<tr>
					<td><fmt:message
							key="purchaseorder.purchaseorderstatus.title" />:</td>
					<td>${purchaseorder.purchaseOrderStatus}</td>
				</tr>
			</tbody>
		</table>
		<a id="delete" class="btn btn-success"
			href="${pageContext.request.contextPath}/deletePurchaseOrder?purchaseOrderIdKey=${purchaseorder.purchaseOrderId}&"><span
			class="glyphicon glyphicon-trash"></span> Confirm Delete</a> <a
			id="cancel" class="btn btn-danger"><span
			class="glyphicon glyphicon-floppy-remove"></span> Cancel</a>
	</div>
	<script>
		$(document).ready(function() {
			$("#delete").click(function() {
				jQuery('#cboxClose').click();
				$(this).closest('form').submit()
			});

			$("#cancel").click(function() {
				jQuery('#cboxClose').click();
				alertify.error('Purchase Order was not deleted!');
			});
		});
	</script>
</body>
</html>