<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Login Page</title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>

<style>
body {
	background-color: #CFE3E2;
}

span {
	color: red;
}

#logoutmsg {
	color: green;
}
</style>

<body>

	<div class="container">
		<form method="POST" action="${contextPath}/login" class="form-signin">
			<center>
				<h2 class="form-heading">Log in</h2>
			</center>

			<div class="form-group ${error != null ? 'has-error' : ''}">
				<span id=logoutmsg>${message}</span> <input name="username" type="text"
					class="form-control" placeholder="Username" autofocus="true" /> <br />
				<input name="password" type="password" class="form-control"
					placeholder="Password" /> <span>${error}</span> <input
					type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<br />
				<center>
					<button class="btn btn-lg btn-primary" type="submit">Log
						In</button>
				</center>
				<hr />
				<h4 class="text-center">
					<a href="${contextPath}/register">Create an account</a>
				</h4>
			</div>
		</form>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>