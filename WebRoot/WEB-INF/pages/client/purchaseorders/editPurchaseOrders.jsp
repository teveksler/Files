
<%@page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.client-resources" />
<html>
<head>
<title>New / Edit Purchase Order</title>
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
		<h1>New / Edit Purchase Order</h1>
		<form:form
			action="${pageContext.request.contextPath}/saveClientPurchaseOrders"
			method="POST" modelAttribute="purchaseorder">
			<table id="viewTable" class="table table-bordered">
				<tbody>
					<form:hidden id="purchaseorder_purchaseOrderId"
						path="purchaseOrderId" />
					<tr>
						<td class="required"><fmt:message
								key="purchaseorder.purchaseorderaddress.title" />:</td>
						<td><form:input required="required"
								id="purchaseorder_purchaseOrderAddress"
								path="purchaseOrderAddress" cssStyle="width:300px;"
								placeholder="Enter purchase order address" class="form-control" /></td>
					</tr>
					<tr>
						<td class="required"><fmt:message
								key="purchaseorder.purchaseordercreateddate.title" />:</td>
						<td><input required="required"
							id="purchaseorder_purchaseOrderCreatedDate"
							name="purchaseOrderCreatedDate" type="text"
							class="form-control picker__input date"
							value="<fmt:formatDate value="${purchaseorder.purchaseOrderCreatedDate.time}" pattern="yyyy-MM-dd"/>"
							style="width: 300px;" placeholder="Enter current date" /></td>
					</tr>
					<tr>
						<td class="required"><fmt:message
								key="purchaseorder.purchaseorderexpecteddate.title" />:</td>
						<td><input required="required"
							id="purchaseorder_purchaseOrderExpectedDate"
							name="purchaseOrderExpectedDate" type="text"
							class="form-control picker__input date"
							value="<fmt:formatDate value="${purchaseorder.purchaseOrderExpectedDate.time}" pattern="yyyy-MM-dd"/>"
							style="width: 300px;" placeholder="Enter expected delivery date" /></td>
					</tr>
					<tr>
						<td><fmt:message
								key="purchaseorder.purchaseorderrecieveddate.title" />:</td>
						<td><input id="purchaseorder_purchaseOrderRecievedDate"
							name="purchaseOrderRecievedDate" type="text"
							class="form-control picker__input date"
							value="<fmt:formatDate value="${purchaseorder.purchaseOrderRecievedDate.time}" pattern="yyyy-MM-dd"/>"
							style="width: 300px;" placeholder="Enter received on date" /></td>
					</tr>
					<tr>
						<td class="required"><fmt:message
								key="purchaseorder.purchaseorderstatus.title" />:</td>
						<td><form:select id="purchaseorder_purchaseOrderStatus"
								class="form-control" path="purchaseOrderStatus"
								cssStyle="width:300px;"
								placeholder="Select purchase order status">
								<option>Completed</option>
								<option>W.I.P.</option>
								<option>Cancelled</option>
							</form:select></td>
					</tr>
				</tbody>
			</table>
			<input type="hidden" name="client_clientId"
				value="${client_clientId}">
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
			$('#purchaseorder_purchaseOrderCreatedDate').datepicker();
			$('#purchaseorder_purchaseOrderExpectedDate').datepicker();
			$('#purchaseorder_purchaseOrderRecievedDate').datepicker();

			//Button handling
			$("#save").click(function() {
				$('#submit_handle').click();
			});

			$("#cancel").click(function() {
				jQuery('#cboxClose').click();
				alertify.error('Purchase order was not saved!');
			});
		});
	</script>
</body>
</html>