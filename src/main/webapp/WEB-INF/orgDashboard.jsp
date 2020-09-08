<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "t" tagdir = "/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Organization Dash Board</title>
	</head>
	<body>
		<t:orglogin>
			<h1>Hello: <c:out value="${organization.orgName}"></c:out></h1>
			<h4>Your Organization Dash Board</h4>
		</t:orglogin>
	</body>
</html>