<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "t" tagdir = "/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Languages</title>
	</head>
	<body>
		<t:devlogin>
			<h1>Hello: <c:out value="${user.firstName}"></c:out> <c:out value="${user.lastName}"></c:out></h1>
			<h4>Select your language skills!</h4>
		</t:devlogin>
	</body>
</html>