
<%@page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.client-resources" />
<html>
<head>
<title>Edit <fmt:message key="client.title" />
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
		<h1>New / Edit Client</h1>
		<form:form action="${pageContext.request.contextPath}/saveQuoteClient"
			method="POST" modelAttribute="client">
			<table id="viewTable" class="table table-bordered">
				<tbody>
					<form:hidden id="client_clientId" path="clientId"
						value="${client.clientId}" />
					<tr>
						<td class="required"><fmt:message
								key="client.clienttype.title" />:</td>
						<td><form:select id="client_clientType" path="clientType"
								required="required" class="form-control" cssStyle="width:300px;">
								<option>Home Owner / Customer</option>
								<option>Vendor</option>
								<option>Builder</option>
							</form:select></td>
					</tr>
					<tr>
						<td class="required"><fmt:message
								key="client.clientname.title" />:</td>
						<td><form:input type="text" required="required"
								class="form-control" id="client_clientName" path="clientName"
								cssStyle="width:300px;" placeholder="Enter client name" /></td>
					</tr>
					<tr>
						<td><fmt:message key="client.clientphonenum.title" />:</td>
						<td><form:input id="client_clientPhoneNum"
								class="form-control" path="clientPhoneNum" type="number" min="1"
								cssStyle="width:300px;" placeholder="Enter client phone number" /></td>
					</tr>
					<tr>
						<td><fmt:message key="client.clientext.title" />:</td>
						<td><form:input id="client_clientExt" path="clientExt"
								class="form-control" cssStyle="width:300px;" type="number"
								min="1" pattern="[0-9]*"
								placeholder="Enter client phone extension" /></td>
					</tr>
					<tr>
						<td><fmt:message key="client.clientemail.title" />:</td>
						<td><form:input type="email" id="client_clientEmail"
								class="form-control" path="clientEmail" cssStyle="width:300px;"
								placeholder="Enter client email" /></td>
					</tr>
					<tr>
						<td class="required"><fmt:message
								key="client.clientaddress.title" />:</td>
						<td><form:input required="required" id="client_clientAddress"
								class="form-control" path="clientAddress"
								cssStyle="width:300px;" placeholder="Enter client address" /></td>
					</tr>
					<tr>
						<td class="required"><fmt:message
								key="client.clientcity.title" />:</td>
						<td><form:input required="required" id="client_clientCity"
								class="form-control" path="clientCity" cssStyle="width:300px;"
								placeholder="Enter client city" /></td>
					</tr>
					<tr>
						<td class="required"><fmt:message
								key="client.postalcode.title" />:</td>
						<td><form:input required="required" id="client_postalCode"
								class="form-control" path="postalCode" cssStyle="width:300px;"
								placeholder="Enter client postal code" /></td>
					</tr>
					<tr>
						<td><fmt:message key="client.clientcomment.title" />:</td>
						<td><form:input id="client_clientComment"
								path="clientComment" cssStyle="width:300px;"
								class="form-control" placeholder="Add comment" /></td>
					</tr>
				</tbody>
			</table>
			<input type="hidden" name="quote_quoteId" value="${quote_quoteId}">
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
				alertify.error('Client was not saved!');
			});

		});
	</script>
</body>
</html>