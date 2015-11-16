<%@page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.quote-resources" />
<html>
<head>
<title>Edit <fmt:message key="quote.title" />
</title>
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
		<h1>New / Edit Quote</h1>
		<form method="post" action="${pageContext.request.contextPath}/saveClientQuotes" enctype="multipart/form-data" modelAttribute="quote">
			<table id="viewTable" class="table table-bordered">
					<tr>
						<td class="required"><fmt:message key="quote.quotedate.title" />:</td>
						<td> <input id="quote_quoteDate" required="required" 
							placeholder="Enter quote date" name="quoteDate" type="text"
							class="form-control date picker__input"
							value="<fmt:formatDate value="${quote.quoteDate.time}" pattern="yyyy-MM-dd"/>"
							style="width: 300px;" /></td>
					</tr>
					<tr>
						<td class="required"><fmt:message key="quote.quotepdf.title" />:</td>
						<td> <input style="width: 300px;" required="required"  value="${quote.quotePdf}" type="file" name="datafile" size="40"></td>
					</tr>
			</table>
			<br>
			<input id="submit_handle" type="submit" style="display: none">
			<a id="save" class="btn btn-success"><span
				class="glyphicon glyphicon-floppy-save"></span> Save</a>
			<a id="cancel" class="btn btn-danger"><span
				class="glyphicon glyphicon-floppy-remove"></span> Cancel</a>
				<input type="hidden" name="client_clientId" value="${client_clientId}">
		</form>
		<br>
	</div>
	<script>
		$(document).ready(function() {
			//DatePicker
			$('#quote_quoteDate').datepicker();

			//Handling save and cancel buttons
			$("#save").click(function() {
				$('#submit_handle').click();
			});

			$("#cancel").click(function() {
				jQuery('#cboxClose').click();
				alertify.error('Quote  was not saved!');
			});
		});
	</script>
</body>
</html>
