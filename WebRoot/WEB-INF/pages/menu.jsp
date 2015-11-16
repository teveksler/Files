<%@page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.quote-resources" />
<html>
<head>
<title>Client Management</title>
<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="js/datatables.js"></script>
<script type="text/javascript" src="js/stacktable.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-tour.min.js"></script>
<script type="text/javascript" src="js/jquery.colorbox.js"></script>
<script type="text/javascript" src="js/alertify.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap-tour.min.css">
<link rel="stylesheet" type="text/css" href="css/datatables.css" />
<link rel="stylesheet" type="text/css" href="css/stacktable.css" />
<link rel="stylesheet" type="text/css" href="css/style_menu.css" />
<link rel='stylesheet' type='text/css'
	href='http://fonts.googleapis.com/css?family=Courgette' />
<link rel="stylesheet" type='text/css' href="css/colorbox.css" />
<link rel="stylesheet" href="css/alertify.min.css" />
<link rel="stylesheet" href="css/themes/bootstrap.css" />
<style>
body {
	background-image: url(./images/bg.jpg);
	background-color: #3090C7;
}
</style>
</head>
<body>
	<div class='wrapper'>
		<div class="content" align="center">
			<img src="./images/colombus_logo.png" alt="Colombus Roofing"
				width="20%">
			<h1 align="center">Welcome to AXI Solutions!</h1>
			<h2 align="center">Choose what you want to do:</h2>
			<ul class='nav' style="color: #0000FF" align="left">
				<li><a href="./indexClient">Client Management</a></li>
				<li><a href="./indexQuote">Quote Management</a></li>
				<li><a href="./indexInventory">Inventory Management</a></li>
				<li><a href="./indexPurchaseOrder">Purchase Order
						Management</a></li>
				<li><a href="./indexWorkOrder">Work Order Management</a></li>
				<li><a href="./indexEmployee">Employee Management</a></li>
				<li><a href="./j_spring_security_logout">Logout</a></li>
			</ul>
		</div>
	</div>
	<script>
		//Notifier set up
		alertify.set('notifier', 'position', 'top-right');
		alertify.success('Welcome!');
	</script>
</body>
</html>