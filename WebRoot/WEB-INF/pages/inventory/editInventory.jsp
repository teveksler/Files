
<%@page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.inventory-resources" />
<html>
<head>
<title>New / Edit Item</title>
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
		<h1>New / Edit Inventory</h1>
		<form:form action="${pageContext.request.contextPath}/saveInventory"
			method="POST" modelAttribute="inventory">
			<table id="viewTable" class="table table-bordered">
				<tbody>
					<tr>
						<form:hidden id="inventory_inventoryId" path="inventoryId" />
					</tr>
					<tr>
						<td class="required"><fmt:message
								key="inventory.inventoryproductname.title" />:</td>
						<td><form:input required="required"
								id="inventory_inventoryProductName" class="form-control"
								path="inventoryProductName" cssStyle="width:300px;"
								placeholder="Enter inventory item product name" /></td>
					</tr>
					<tr>
						<td class="required"><fmt:message
								key="inventory.inventoryname.title" />:</td>
						<td><form:input required="required"
								id="inventory_inventoryName" class="form-control"
								path="inventoryName" cssStyle="width:300px;"
								placeholder="Enter inventory item name" /></td>
					</tr>
					<tr>
						<td class="required"><fmt:message
								key="inventory.inventoryprice.title" />:</td>
						<td><form:input required="required"
								id="inventory_inventoryPrice" class="form-control"
								path="inventoryPrice" cssStyle="width:300px;" type="number"
								step="0.01" min="0" placeholder="Enter inventory item price" /></td>
					</tr>
					<tr>
						<td class="required"><fmt:message
								key="inventory.inventorystocklevel.title" />:</td>
						<td><form:input required="required"
								id="inventory_inventoryStockLevel" class="form-control"
								path="inventoryStockLevel" type="number" min="0"
								cssStyle="width:300px;"
								placeholder="Enter inventory item stock level" /></td>
					</tr>
					<tr>
						<td class="required"><fmt:message
								key="inventory.inventoryunit.title" />:</td>
						<td><form:select required="required"
								id="inventory_inventoryUnit" class="form-control"
								path="inventoryUnit" cssStyle="width:300px;">
								<option>Boxes</option>
								<option>Units</option>
								<option>Skids</option>
								<option>Bundles</option>
								<option>Sq./ft.</option>
							</form:select></td>
					</tr>
					<tr>
						<td class="required"><fmt:message
								key="inventory.inventorylowthreshold.title" />:</td>
						<td><form:input required="required"
								id="inventory_inventoryLowThreshold" class="form-control"
								path="inventoryLowThreshold" type="number" min="0"
								cssStyle="width:300px;"
								placeholder="Enter inventory item low threshold" /></td>
					</tr>
					<tr>
						<td><fmt:message key="inventory.inventorylocation.title" />:</td>
						<td><form:input id="inventory_inventoryLocation"  class="form-control" placeholder="Enter inventory item location"
								path="inventoryLocation" cssStyle="width:300px;" /></td>
					</tr>
				</tbody>
			</table>
			<input id="submit_handle" type="submit" style="display: none">
			<a id="save" class="btn btn-success"><span
				class="glyphicon glyphicon-floppy-save"></span> Save</a>
			<a id="cancel" class="btn btn-danger"><span
				class="glyphicon glyphicon-floppy-remove"></span> Cancel</a>
		</form:form>
		<br>
	</div>
	<script>
		$(document).ready(function() {
			$("#save").click(function() {
				$('#submit_handle').click();
			});

			$("#cancel").click(function() {
				jQuery('#cboxClose').click();
				alertify.error('Inventory item was not saved!');
			});
		});
	</script>
</body>
</html>