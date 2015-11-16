<%@page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.inventory-resources" />
<html>
<head>
<title>Delete Inventory Item</title>
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
		<h1>Confirm Item Delete</h1>
		<table id="viewTable" class="table table-bordered">
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
					<td>${inventory.inventoryStockLevel}</td>
				</tr>
				<tr>
					<td><fmt:message key="inventory.inventoryunit.title" />:</td>
					<td>${inventory.inventoryUnit}</td>
				</tr>
				<tr>
					<td><fmt:message key="inventory.inventorylowthreshold.title" />:</td>
					<td>${inventory.inventoryLowThreshold}</td>
				</tr>
				<tr>
					<td><fmt:message key="inventory.inventorylocation.title" />:</td>
					<td>${inventory.inventoryLocation}</td>
				</tr>
			</tbody>
		</table>
		<a id="delete" class="btn btn-success"
			href="${pageContext.request.contextPath}/deleteInventory?inventoryIdKey=${inventory.inventoryId}&"><span
			class="glyphicon glyphicon-trash"></span> Confirm Delete</a> <a
			id="cancel" class="btn btn-danger"><span
			class="glyphicon glyphicon-floppy-remove"></span> Cancel</a>
	</div>
	<script>
		$(document).ready(function() {
			$("#delete").click(function() {
				$(this).closest('form').submit()
			});
			$("#cancel").click(function() {
				jQuery('#cboxClose').click();
				alertify.error('Inventory item was not deleted!');
			});
		});
	</script>
</body>
</html>