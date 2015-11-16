<%@page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.quote-resources" />
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
	<div class="content">
		<h1>
			Confirm
			<fmt:message key="quote.title" />
			Delete
		</h1>
		<table id="viewTable" class="table table-bordered">
			<tbody>
				<tr>
					<td><fmt:message key="quote.quoteid.title" />:</td>
					<td>${quote.quoteId}</td>
				</tr>
				<tr>
					<td><fmt:message key="quote.quotedate.title" />:</td>
					<td><fmt:formatDate dateStyle="short" type="date"
							value="${quote.quoteDate.time}" /></td>
				</tr>
				<tr>
					<td><fmt:message key="quote.quotepdf.title" />:</td>
					<td>${quote.quotePdf}</td>
				</tr>
			</tbody>
		</table>
		<a id="delete" class="btn btn-success"
			href="${pageContext.request.contextPath}/deleteQuote?quoteIdKey=${quote.quoteId}&"><span
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
				alertify.error('Quote was not deleted!');
			});
		});
	</script>
</body>
</html>