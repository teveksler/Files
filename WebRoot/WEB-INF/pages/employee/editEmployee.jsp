
<%@page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.employee-resources" />
<html>

<head>
<title>Edit <fmt:message key="employee.title" />
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

		<h1>New / Edit Employee</h1>
		<form:form action="${pageContext.request.contextPath}/saveEmployee"
			method="POST" modelAttribute="employee">
			<table id="viewTable" class="table table-bordered">
				<tbody>
					<tr>
						<form:hidden id="employee_employeeId" path="employeeId"
							value="${employee.employeeId}" />
					</tr>
					<tr>
						<td class="required"><fmt:message
								key="employee.employeename.title" />:</td>
						<td><form:input id="employee_employeeName" class="form-control"
								path="employeeName" type="text" required="required"
								cssStyle="width:300px;" placeholder="Enter employee name" /></td>
					</tr>
					<tr>
						<td><fmt:message key="employee.employeephonenum.title" />:</td>
						<td><form:input id="employee_employeePhoneNum"
								class="form-control" path="employeePhoneNum"
								cssStyle="width:300px;" type="number" min="0"
								placeholder="Enter employee phone number" /></td>
					</tr>
					<tr>
						<td><fmt:message key="employee.employeeemail.title" />:</td>
						<td><form:input id="employee_employeeEmail" class="form-control"
								path="employeeEmail" cssStyle="width:300px;" type="email"
								placeholder="Enter employee email" /></td>
					</tr>
					<tr>
						<td><fmt:message key="employee.employeecomment.title" />:</td>
						<td><form:input id="employee_employeeComment" class="form-control"
								path="employeeComment" cssStyle="width:300px;"
								placeholder="Enter employee comment" /></td>
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
				alertify.error('Employee was not saved!');
			});

		});
	</script>
</body>

</html>