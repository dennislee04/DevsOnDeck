<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "t" tagdir = "/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Languages</title>
		<link rel="stylesheet" type="text/css" href="/css/main.css">
	</head>
	<body>
		<t:devlogin>
			<div id="container">
				<div class="row">
					<div class="col">
						<h2>Hello: <c:out value="${user.firstName}"></c:out> <c:out value="${user.lastName}"></c:out></h2>
					</div>
					<div class="col">
					</div>
				</div>
				<div class="row">
					<div class="col">
						<h3>Add Your Skills!</h3>
					</div>
					<div class="col">
						<p>Skill bar location holder!</p>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<h3>Pick Your Top 5 Languages</h3>
					</div>
					<div class="col">
						<table class="table table-dark">
							<tr>
								<c:if test="${user.skillFive != null}">
									<td><img id="skillfive" class="langIcons" src="/img/${user.skillFive}.png" alt="Skill Five"></td>
								</c:if>
								<c:if test="${user.skillFour != null}">
									<td><img id="skillfour" class="langIcons" src="/img/${user.skillFour}.png" alt="Skill Four"></td>
								</c:if>
								<c:if test="${user.skillThree != null}">
									<td><img id="skillthree" class="langIcons" src="/img/${user.skillThree}.png" alt="Skill Three"></td>
								</c:if>
								<c:if test="${user.skillTwo != null}">
									<td><img id="skilltwo" class="langIcons" src="/img/${user.skillTwo}.png" alt="Skill Two"></td>
								</c:if>
								<c:if test="${user.skillOne != null}">
									<td><img id="skillone" class="langIcons" src="/img/${user.skillOne}.png" alt="Skill ONe"></td>
								</c:if>
							</tr>
						</table>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<table class="table table-dark">
								<c:choose>
									<c:when test="${type == 'languages'}">
										<tr>	
											<td>
												<img id="java" class="langIcons" src="/img/java.png" alt="java Icon">
												<img id="css" class="langIcons" src="/img/css.png" alt="css Icon">
												<img id="javascript" class="langIcons" src="/img/javascript.png" alt="javscript Icon">
											</td>
		                    			</tr>
		                    			<tr>
		                    				<td>
		                    					<img id="javascript" class="langIcons" src="/img/javascript.png" alt="javscript Icon">
		                    				</td>
		                    			</tr>
									</c:when>
									<c:when test="${type == 'frameworks'}">
										<tr>
											<td>
												<img id="django" class="langIcons" src="/img/django.png" alt="django Icon">
											</td>
										</tr>
										<tr>
											<td>
												<img id="django" class="langIcons" src="/img/django.png" alt="django Icon">
											</td>
										</tr>
									</c:when>
									<c:otherwise>
										<tr>
											<td>No Skill Options Available</td>
										</tr>
									</c:otherwise>
								</c:choose>
						</table>
					</div>
					<div class="col">
						<c:choose>
							<c:when test="${type == 'languages'}">
								<h3>Short Bio!</h3>
								<textarea id="bio" name="bio" rows="10" cols="50"></textarea>
							</c:when>
							<c:when test="${type == 'frameworks' }">
								<textarea readonly id="bio" name="bio" rows="10" cols="50">
									Success doesn't just find you. You have to go and get it.
								</textarea>
							</c:when>
						</c:choose>
					</div>
				</div>
				<div class="row">
					<c:choose>
						<c:when test="${type == 'languages'}">
							<a href="http://localhost:8080/devs/skills/frameworks"><button>Skill This</button></a>
							<a href="http://localhost:8080/devs/skills/frameworks"><button>NEXT STEP: Frameworks and Libraries</button></a>
						</c:when>
						<c:when test="${type == 'frameworks' }">
							<a href="http://localhost:8080/devs/skills/languages"><button>Back to Languages</button></a>
							<a href="http://localhost:8080/devs/skills/frameworks"><button>COMPLETE Profile</button></a>
						</c:when>
					</c:choose>
				</div>
			</div>
		</t:devlogin>
	</body>
</html>