
<%@page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.inventory-resources" />
<html>
<head>
<title>New/Edit Vendor <fmt:message key="inventory.title" /> <fmt:message
		key="client.title" />
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
	<div class="content">
		<br>
		<h1>New/Edit Vendor</h1>
		<form:form
			action="${pageContext.request.contextPath}/saveInventoryClient"
			method="POST" modelAttribute="client">
			<table id="viewTable"
				class="table table-bordered" class="table table-bordered">
				<tbody>
					<tr>
						<form:hidden id="client_clientId" path="clientId" />
					</tr>
					<tr>
						<td class="required"><fmt:message key="client.clienttype.title" />:</td>
						<td><form:select id="client_clientType" required="required" class="form-control" path="clientType"
								cssStyle="width:300px;">
								<option>Vendor</option>
							</form:select>
								</td>
					</tr>
					<tr>
						<td class="required"><fmt:message key="client.clientname.title" />:</td>
						<td><form:input id="client_clientName" class="form-control"  required="required" path="clientName" 
								cssStyle="width:300px;" placeholder="Enter vendor name" /></td>
					</tr>
					<tr>
						<td>Phone #:</td>
						<td><form:input id="client_clientPhoneNum" class="form-control" 
						type="number" min="1"
								path="clientPhoneNum" cssStyle="width:300px;" placeholder="Enter vendor phone number" /></td>
					</tr>
					<tr>
						<td><fmt:message key="client.clientext.title" />:</td>
						<td><form:input id="client_clientExt" class="form-control"  path="clientExt"
						type="number" min="0"
								cssStyle="width:300px;" placeholder="Enter phone number extension"/></td>
					</tr>
					<tr>
						<td><fmt:message key="client.clientemail.title" />:</td>
						<td><form:input id="client_clientEmail" class="form-control"  path="clientEmail"
						type ="email"
								cssStyle="width:300px;" placeholder="Enter vendor e-mail"/></td>
					</tr>
					<tr>
						<td class="required"><fmt:message key="client.clientaddress.title" />:</td>
						<td><form:input id="client_clientAddress" class="form-control" required="required" 
								path="clientAddress" cssStyle="width:300px;" placeholder="Enter vendor address"/></td>
					</tr>
					<tr>
						<td class="required"><fmt:message key="client.clientcity.title" />:</td>
						<td><form:input id="client_clientCity" class="form-control"  path="clientCity" required="required"
								cssStyle="width:300px;" placeholder="Enter vendor city"/></td>
					</tr>
					<tr>
						<td class="required"><fmt:message key="client.postalcode.title" />:</td>
						<td><form:input id="client_postalCode" class="form-control"  path="postalCode" required="required"
								cssStyle="width:300px;" placeholder="Enter vendor postal code"/></td>
					</tr>
					<tr>
						<td><fmt:message key="client.clientcomment.title" />:</td>
						<td><form:input id="client_clientComment" class="form-control" 
								path="clientComment" cssStyle="width:300px;" placeholder="Enter vendor additional comments"/></td>
					</tr>
				</tbody>
			</table>
			<input id="submit_handle" type="submit" style="display: none">
			<a id="save" class="btn btn-success"><span
				class="glyphicon glyphicon-floppy-save"></span> Save</a>
			<input type="hidden" name="inventory_inventoryId"
				value="${inventory_inventoryId}">
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
				alertify.error('Vendor was not saved!');
			});

		});
	</script>
</body>
</html>