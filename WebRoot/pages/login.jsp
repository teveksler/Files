<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/login_new.css" />
<link href='http://fonts.googleapis.com/css?family=Courgette'
	rel='stylesheet' type='text/css' />
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Courgette" />
<style>
body {
	background-image: url(../images/bg.jpg);
	background-color: #3090C7;
}

h2 {
	color: #337AB7;
}

#rememberme {
	color: #337AB7;
}
</style>
</head>
<body>
	<div class="container">
		<form class="form-signin" name='f'
			action='${pageContext.request.contextPath}/j_spring_security_check'
			method='POST'>
			<img src="../images/colombus_logo.png" alt="Colombus Roofing"
				align="center" width="100%"> <h2
					class="form-signin-heading" align="center"><strong>
					Welcome! <br> Please Sign In:</strong>
				</h2> <label for="inputUsername" class="sr-only">Username</label> <input
				type='text' name='j_username'
				value='<c:out value="${SPRING_SECURITY_LAST_USERNAME}"/>'
				id="inputEmail" class="form-control" placeholder="Username" required
				autofocus> <label for="inputPassword" class="sr-only">Password</label>
			<input type='password' name='j_password' id="inputPassword"
				class="form-control" placeholder="Password" required>
			<div class="checkbox">
				<label id="rememberme"> <input type="checkbox"
					name='_spring_security_remember_me' /><strong>Remember me</strong>
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block inputbutton"
				type="submit" name="submit" value="Submit">Sign in</button>
		</form>
		<c:if test="${not empty param.login_error}">
			<div class="error" align="center">
				<strong style="color: red;">Your login attempt was not
					successful.<br /> Reason: <c:out
						value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
				</strong>
			</div>
		</c:if>
	</div>
</body>
</html>