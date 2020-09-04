<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "t" tagdir = "/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Organization Sign-Up</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	</head>
	<body>
		<t:wrapper>
			<div class="container">
				<h4>Organization Sign Up</h4>
				<div class="row">
					<div class="col">
						<form:form action="/orgs/register" method="post" modelAttribute="organization">
						    <div class="form-group">
						        <form:label path="orgName">Org Name</form:label>
						        <form:errors path="orgName"/>
						        <form:input class="form-control" path="orgName"/>
						    </div>
						    <div class="form-group">
						        <form:label path="firstName">First Name</form:label>
						        <form:errors path="firstName"/>
						        <form:input class="form-control" path="firstName"/>
						    </div>
						    <div class="form-group">
						        <form:label path="lastName">Last Name</form:label>
						        <form:errors path="lastName"/>
						        <form:input class="form-control" path="lastName"/>
						    </div>
						    <div class="form-group">
						        <form:label path="orgEmail">Contact Email</form:label>
						        <form:errors path="orgEmail"/>
						       <form:input type="orgEmail" class="form-control" path="orgEmail"/>
						    </div>
						    <div class="form-group">
						        <form:label path="orgAddress">Org Address</form:label>
						        <form:errors path="orgAddress"/>
						       <form:input type="orgAddress" class="form-control" path="orgAddress"/>
						    </div>
						    <div class="form-group">
						        <form:label path="orgCity">Org City</form:label>
						        <form:errors path="orgCity"/>
						       <form:input type="orgCity" class="form-control" path="orgCity"/>
						    </div>
						    <div class="form-group">
						        <form:label path="orgState">State</form:label>
						        <form:errors path="orgState"/>
						       <form:input type="orgState" class="form-control" path="orgState"/>
						    </div>
						    <div class="form-group">
						        <form:label path="password">Password</form:label>
						        <form:errors path="password"/>
						       <form:input type="password" class="form-control" path="password"/>
						    </div>
						    <div class="form-group">
						        <form:label path="confirmPassword">Confirm Password</form:label>
						        <form:errors path="confirmPassword"/>
						       <form:input type="confirmPassword" class="form-control" path="confirmPassword"/>
						    </div>
						    <input class="btn btn-danger" type="submit" value="Register"/>
						</form:form>
					</div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col">
						<h4><a href="/devs/register">Need to Sign Up as a Developer?</a></h4>
					</div>
				</div>
			</div>
		</t:wrapper>
	</body>
</html>