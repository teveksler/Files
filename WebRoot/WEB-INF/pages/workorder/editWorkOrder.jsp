
<%@page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.workorder-resources" />
<html>
<head>
<title>New / Edit Work Order</title>
<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.colorbox.js"></script>
<script type="text/javascript" src="js/picker.js"></script>
<script type="text/javascript" src="js/picker.date.js"></script>
<link rel="stylesheet" href="css/datepicker.css">
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/datatables.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link href='http://fonts.googleapis.com/css?family=Courgette'
	rel='stylesheet' type='text/css' />
</head>
<body>
	<div class='content'>
		<br>
		<h1>New / Edit Work Order</h1>
		<form:form action="${pageContext.request.contextPath}/saveWorkOrder"
			method="POST" modelAttribute="workorder">
			<table id="viewTable" class="table table-bordered">
				<tbody>
					<form:hidden id="workOrder_workOrderId" path="workOrderId"
						value="${workOrder.workOrderId}" />
					<tr>
						<td class="required"><fmt:message
								key="workorder.workorderscope.title" />:</td>
						<td><form:input required="required"
								placeholder="Enter work order scope"
								id="workorder_workOrderScope" path="workOrderScope"
								class="form-control" cssStyle="width:300px;" /></td>
					</tr>
					<tr>
						<td class="required"><fmt:message key="workorder.workorderaddress.title" />:
						</td>
						<td><form:input required="required"
								placeholder="Enter work order address"
								id="workorder_workOrderAddress" path="workOrderAddress"
								class="form-control" cssStyle="width:300px;" /></td>
					</tr>
					<tr>
						<td class="required"><fmt:message
								key="workorder.workordercreatedon.title" />:</td>
						<td><input id="workorder_workOrderCreatedOn"
							placeholder="Enter created on date" required="required"
							name="workOrderCreatedOn" type="text"
							class="form-control picker__input date"
							value="<fmt:formatDate value="${workorder.workOrderCreatedOn.time}" pattern="yyyy-MM-dd"/>"
							style="width: 300px;" /></td>
					</tr>
					<tr>
						<td class="required"><fmt:message
								key="workorder.workorderexpectedenddate.title" />:</td>
						<td><input id="workorder_workOrderExpectedEndDate"
							required="required" placeholder="Enter expected end date"
							name="workOrderExpectedEndDate" type="text"
							class="form-control date picker__input"
							value="<fmt:formatDate value="${workorder.workOrderExpectedEndDate.time}" pattern="yyyy-MM-dd"/>"
							style="width: 300px;" /></td>
					</tr>
					<tr>
						<td><fmt:message key="workorder.workorderenddate.title" />:
						</td>
						<td><input id="workorder_workOrderEndDate"
							placeholder="Enter actual end date" name="workOrderEndDate"
							class="form-control date picker__input"
							value="<fmt:formatDate value="${workorder.workOrderEndDate.time}" pattern="yyyy-MM-dd"/>"
							type="text" style="width: 300px;" /></td>
					</tr>
					<tr>
						<td class="required"><fmt:message
								key="workorder.workorderstatus.title" />:</td>
						<td><form:select id="workorder_workOrderStatus"
								class="form-control" path="workOrderStatus" required="required"
								cssStyle="width:300px;">
								<option>W.I.P.</option>
								<option>Completed</option>
								<option>Cancelled</option>
							</form:select></td>
					</tr>
				</tbody>
			</table>
			<input id="submit_handle" type="submit" style="display: none">
			<a id="save" class="btn btn-success"><span
				class="glyphicon glyphicon-floppy-save"></span> Save</a>
			<a id="cancel" class="btn btn-danger"><span
				class="glyphicon glyphicon-floppy-remove"></span> Cancel</a>
		</form:form>
	</div>
	<script>
		$(document).ready(function() {
			//DatePicker
			$('#workorder_workOrderCreatedOn').datepicker();
			$('#workorder_workOrderExpectedEndDate').datepicker();
			$('#workorder_workOrderEndDate').datepicker();

			//Handling save and cancel buttons
			$("#save").click(function() {
				$('#submit_handle').click();
			});

			$("#cancel").click(function() {
				jQuery('#cboxClose').click();
				alertify.error('Work Order was not saved!');
			});
		});
	</script>
</body>
</html>