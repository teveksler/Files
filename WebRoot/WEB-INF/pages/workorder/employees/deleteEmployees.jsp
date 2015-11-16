<%@page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.employee-resources" />
<html>
<head>
<title>Delete <fmt:message key="employee.title" />
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
		<h1>Confirm Employee Delete</h1>
		<table id="viewTable" class="table table-bordered">
			<tbody>
				<tr>
					<td><fmt:message key="employee.employeeid.title" />:</td>
					<td>${employee.employeeId}</td>
				</tr>
				<tr>
					<td><fmt:message key="employee.employeename.title" />:</td>
					<td>${employee.employeeName}</td>
				</tr>
				<tr>
					<td><fmt:message key="employee.employeephonenum.title" />:</td>
					<td>${employee.employeePhoneNum}</td>
				</tr>
				<tr>
					<td><fmt:message key="employee.employeeemail.title" />:</td>
					<td>${employee.employeeEmail}</td>
				</tr>
				<tr>
					<td><fmt:message key="employee.employeecomment.title" />:</td>
					<td>${employee.employeeComment}</td>
				</tr>
			</tbody>
		</table>
		<a id="delete" class="btn btn-success"
			href="${pageContext.request.contextPath}/deleteWorkOrderEmployees?workorder_workOrderId=${workorder_workOrderId}&related_employees_employeeId=${employee.employeeId}&"><span
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
				alertify.error('Employee was not deleted!');
			});
		});
	</script>
</body>
</html>