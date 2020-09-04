<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
		<title></title>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col">
					<h1>Devs On Deck</h1>
				</div>
				<div class="col">
					<a href="/devs/login">Dev Login</a>
				</div>
				<div class="col">
					<a href="/orgs/login">Org Login</a>
				</div>
			</div>
			<jsp:doBody/>
		</div>
	</body>
</html>