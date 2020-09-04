<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "t" tagdir = "/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Developer Login</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	</head>
	<body>
		<t:wrapper>
			<div class="container">
				<h1>Welcome Back, Developer!</h1>
				<h4>Let's Connect You To A Job!</h4>
				<div class="row">
					<div class="col">
						<p>${ loginError }</p>
						<form method="POST" action="/devlogin">
							<div class="form-group">
						    	<label>Email:</label>
						    	<input class="form-control" type="email" name="email">
						    </div>
						    <div class="form-group">
						    	<label>Password:</label>
						    	<input class="form-control" type="password" name="password">
						    </div>
						    <button class="btn btn-danger">Log In</button>
						</form>
					</div>
				</div>
			</div>
		</t:wrapper>
	</body>
</html>