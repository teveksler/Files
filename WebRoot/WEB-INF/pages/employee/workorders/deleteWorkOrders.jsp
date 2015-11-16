
<%@page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.workorder-resources" />
<html>

<head>
<title>Delete <fmt:message key="workorder.title" />
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
		<h1>
			Confirm Work Order Delete
		</h1>

		<table id="viewTable" class="table table-bordered">
			<tbody>
				<tr>
					<td><fmt:message key="workorder.workorderid.title" />:</td>
					<td>${workorder.workOrderId}</td>
				</tr>
				<tr>
					<td><fmt:message key="workorder.workorderscope.title" />:</td>
					<td>${workorder.workOrderScope}</td>
				</tr>
				<tr>
					<td><fmt:message key="workorder.workorderaddress.title" />:</td>
					<td>${workorder.workOrderAddress}</td>
				</tr>
				<tr>
					<td><fmt:message key="workorder.workordercreatedon.title" />:
					</td>
					<td><fmt:formatDate dateStyle="short" type="date"
							value="${workorder.workOrderCreatedOn.time}" /></td>
				</tr>
				<tr>
					<td><fmt:message
							key="workorder.workorderexpectedenddate.title" />:</td>
					<td><fmt:formatDate dateStyle="short" type="date"
							value="${workorder.workOrderExpectedEndDate.time}" /></td>
				</tr>
				<tr>
					<td><fmt:message key="workorder.workorderenddate.title" />:</td>
					<td><fmt:formatDate dateStyle="short" type="date"
							value="${workorder.workOrderEndDate.time}" /></td>
				</tr>
				<tr>
					<td><fmt:message key="workorder.workorderstatus.title" />:</td>
					<td>${workorder.workOrderStatus}</td>
				</tr>
			</tbody>
		</table>
		<a id="delete" class="btn btn-success"
			href="${pageContext.request.contextPath}/deleteWorkOrder?workOrderIdKey=${workorder.workOrderId}&"><span
			class="glyphicon glyphicon-trash"></span> Confirm Delete</a> <a
			id="cancel" class="btn btn-danger"><span
			class="glyphicon glyphicon-floppy-remove"></span> Cancel</a>
	</div>
	<script>
		$(document).ready(function() {
			$(document).ready(function() {
				$("#delete").click(function() {
					$(this).closest('form').submit()
				});

				$("#cancel").click(function() {
					jQuery('#cboxClose').click();
					alertify.error('Work Order was not deleted!');
				});
			});
		});
	</script>
</body>


</html>