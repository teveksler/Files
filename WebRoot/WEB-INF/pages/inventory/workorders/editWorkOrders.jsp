
<%@page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.inventory-resources" />
<html>
<head>
<title>New/Edit Work Order</title>
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
	<div class="content">
		<br>
		<h1>New / Edit Work Order</h1>
		<form:form
			action="${pageContext.request.contextPath}/saveInventoryWorkOrders"
			method="POST" modelAttribute="workorder">
			<table id="viewTable" class="table table-bordered">
				<tbody>
					<tr>
						<form:hidden id="workorder_workOrderId" path="workOrderId" />
					</tr>
					<tr>
						<td class="required"><fmt:message
								key="workorder.workorderscope.title" />:</td>
						<td><form:input id="workorder_workOrderScope"
								path="workOrderScope" cssStyle="width:300px;"
								class="form-control" placeholder="Enter work order scope" /></td>
					</tr>
					<tr>
						<td class="required"><fmt:message
								key="workorder.workorderaddress.title" />:</td>
						<td><form:input id="workorder_workOrderAddress"
								path="workOrderAddress" cssStyle="width:300px;"
								class="form-control" placeholder="Enter address" /></td>
					</tr>
					<tr>
						<td class="required"><fmt:message
								key="workorder.workordercreatedon.title" />:</td>
						<td><input id="workorder_workOrderCreatedOn"
							name="workOrderCreatedOn" type="text"
							class="form-control picker__input date"
							placeholder="Enter work order created on date"
							value="<fmt:formatDate value="${workorder.workOrderCreatedOn.time}" pattern="yyyy-MM-dd"/>"
							style="width:300px;" /></td>
					</tr>
					<tr>
						<td class="required"><fmt:message
								key="workorder.workorderexpectedenddate.title" />:</td>
						<td><input id="workorder_workOrderExpectedEndDate"
							name="workOrderExpectedEndDate" type="text"
							class="form-control picker__input date"
							placeholder="Enter work order expected end date"
							value="<fmt:formatDate value="${workorder.workOrderExpectedEndDate.time}" pattern="yyyy-MM-dd"/>"
							style="width:300px;" /></td>
					</tr>
					<tr>
						<td class="required"><fmt:message
								key="workorder.workorderenddate.title" />:</td>
						<td><input id="workorder_workOrderEndDate"
							name="workOrderEndDate" type="text"
							class="form-control picker__input date"
							placeholder="Enter work order end date"
							value="<fmt:formatDate value="${workorder.workOrderEndDate.time}" pattern="yyyy-MM-dd"/>"
							style="width:300px;" /></td>
					</tr>
					<tr>
						<td class="required"><fmt:message
								key="workorder.workorderstatus.title" />:</td>
						<td><form:select required="required" class="form-control"
								id="workorder_workOrderStatus" path="workOrderStatus"
								cssStyle="width:300px;" placeholder="Select Status">
								<option>Completed</option>
								<option>W.I.P.</option>
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
			<input type="hidden" name="inventory_inventoryId"
				value="${inventory_inventoryId}">
		</form:form>
		<br>
	</div>
	<script>
		$(document).ready(function() {

			//DatePicker
			$('#workorder_workOrderCreatedOn').datepicker();
			$('#workorder_workOrderExpectedEndDate').datepicker();
			$('#workorder_workOrderEndDate').datepicker();

			//Button handling
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