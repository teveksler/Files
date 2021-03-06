
<%@page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.client-resources" />
<html>
<head>
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
		<h1>
			Confirm
			<fmt:message key="client.title" />
			Delete
		</h1>
		<table id="viewTable" class="table table-bordered">
			<tbody>
				<tr>
					<td><fmt:message key="client.clientid.title" />:</td>
					<td>${client.clientId}</td>
				</tr>
				<tr>
					<td><fmt:message key="client.clienttype.title" />:</td>
					<td>${client.clientType}</td>
				</tr>
				<tr>
					<td><fmt:message key="client.clientname.title" />:</td>
					<td>${client.clientName}</td>
				</tr>
				<tr>
					<td><fmt:message key="client.clientphonenum.title" />:</td>
					<td>${client.clientPhoneNum}</td>
				</tr>
				<tr>
					<td><fmt:message key="client.clientext.title" />:</td>
					<td>${client.clientExt}</td>
				</tr>
				<tr>
					<td><fmt:message key="client.clientemail.title" />:</td>
					<td>${client.clientEmail}</td>
				</tr>
				<tr>
					<td><fmt:message key="client.clientaddress.title" />:</td>
					<td>${client.clientAddress}</td>
				</tr>
				<tr>
					<td><fmt:message key="client.clientcity.title" />:</td>
					<td>${client.clientCity}</td>
				</tr>
				<tr>
					<td><fmt:message key="client.postalcode.title" />:</td>
					<td>${client.postalCode}</td>
				</tr>
				<tr>
					<td><fmt:message key="client.clientcomment.title" />:</td>
					<td>${client.clientComment}</td>
				</tr>
			</tbody>
		</table>
		<a id="delete" class="btn btn-success"
			href="${pageContext.request.contextPath}/deleteWorkOrderClient?workorder_workOrderId=${workorder_workOrderId}&related_client_clientId=${client.clientId}&"><span
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
				alertify.error('Client was not deleted!');
			});
		});
	</script>
</body>
</html>