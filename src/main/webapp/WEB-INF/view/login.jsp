<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<%--  <script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script> --%>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>

	<div class="container">


		<header> </header>
		<div class="row">
			<div class="col-md-4 form" style="margin: auto;">
				<form method="post" action="login">
					<h3>Please Sign In</h3>
					<br /> Username: <input type="text" class="form-control"
						name="userName" value="${cookie.userName.value}"> <br /> Password: <input type="password"
						class="form-control" name="password"><br /> 
					<div class="checkbox">
						<label> Remember me</label>
						<input type="checkbox" name="rememberMe"
					<c:if test="${cookie.containsKey('USERNAME')}">checked</c:if>>
					</div>
					<br />
					<input type="submit" value="Login"
						class="btn btn-success btn-block">

				</form>
				
				<P class="error">${err_msg}</P>

			</div>
			
		</div>
	</div>
</body>
</html>