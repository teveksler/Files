
<%@page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.purchaseorder-resources" />
<html>
<head>
<title>Add/Edit Client</title>
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
		<h1>New / Edit Client</h1>
		<form:form
			action="${pageContext.request.contextPath}/savePurchaseOrderClients"
			method="POST" modelAttribute="client">
			<table id="viewTable" class="table table-bordered">
				<tbody>
					<tr>
						<form:hidden id="client_clientId" path="clientId" />
					</tr>
					<tr>
						<td class="required"><fmt:message key="client.clienttype.title" />:</td>
						<td><form:select id="client_clientType" required="required" class="form-control" path="clientType"
								cssStyle="width:300px;" placeholder="Select client type">
								<option>Vendor</option>
								<option>Builder</option>
							</form:select>
								</td>
					</tr>					
					<tr>
						<td class="required"><fmt:message key="client.clientname.title" />:</td>
						<td><form:input id="client_clientName" path="clientName"
						class="form-control" required="required"
								cssStyle="width:300px;" placeholder="Enter client name"/></td>
					</tr>
					<tr>
						<td><fmt:message key="client.clientphonenum.title" />:</td>
						<td><form:input id="client_clientPhoneNum"
						class="form-control"
								path="clientPhoneNum" cssStyle="width:300px;" placeholder="Enter client phone number" type="number" min="0"/></td>
					</tr>
					<tr>
						<td><fmt:message key="client.clientext.title" />:</td>
						<td><form:input id="client_clientExt" path="clientExt"
						class="form-control"
								cssStyle="width:300px;" type="number" min="0" placeholder="Enter client phone extension" /></td>
					</tr>
					<tr>
						<td><fmt:message key="client.clientemail.title" />:</td>
						<td><form:input id="client_clientEmail" path="clientEmail"
						class="form-control" type="email"
								cssStyle="width:300px;" placeholder="Enter client e-mail"/></td>
					</tr>
					<tr>
						<td class="required"><fmt:message key="client.clientaddress.title" />:</td>
						<td><form:input id="client_clientAddress"
						class="form-control" required="required"
								path="clientAddress" cssStyle="width:300px;" placeholder="Enter client address" /></td>
					</tr>
					<tr>
						<td class="required"><fmt:message key="client.clientcity.title" />:</td>
						<td><form:input id="client_clientCity" path="clientCity"
						class="form-control" required="required"
								cssStyle="width:300px;" placeholder="Enter client city"/></td>
					</tr>
					<tr>
						<td class="required"><fmt:message key="client.postalcode.title" />:</td>
						<td><form:input id="client_postalCode" path="postalCode"
						class="form-control" required="required"
								cssStyle="width:300px;" placeholder="Enter client postal code"/></td>
					</tr>
					<tr>
						<td><fmt:message key="client.clientcomment.title" />:</td>
						<td><form:input id="client_clientComment"
						class="form-control"
								path="clientComment" cssStyle="width:300px;" placeholder="Enter cliet additional comments"/></td>
					</tr>
				</tbody>
			</table>
			<input type="hidden" name="purchaseorder_purchaseOrderId"
				value="${purchaseorder_purchaseOrderId}">				
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
				alertify.error('Client not saved!');
			});

		});
	</script>	
</body>
</html>