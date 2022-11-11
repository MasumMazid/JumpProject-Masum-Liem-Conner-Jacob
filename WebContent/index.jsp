<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>

<!-- can use bootstrap styling -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

</head>
<body>

	<div class="container">

		<!-- copy jumbotron code from bootstrap website or just include h1 tag at top of page to give the page a title -->
		<div class="jumbotron jumbotron-fluid">
			<div class="container">
				<h1 class="display-4">Login Page</h1>
				<p class="lead">Welcome! Please login below. Make sure to fill
					in all fields.</p>
			</div>
		</div>

		<!-- copy login form from bootstrap or create your own form -->
		<!-- make sure to set both inputs with required attribute -->
		<form action="LoginServlet" method="get">
			<div class="form-group">
				<label for="user-email">Email</label> 
				<input type="email" id="user-email" name = "user-email" class="form-control" required>
			</div>
			
			<div class="form-group">
				<label for="pw">Password</label> 
				<input type="password" id="pw" name = "pw" class="form-control" required>
			</div>
			
			<input type="submit" value="Login" class="btn btn-primary"> 
		</form>


	</div>

</body>
</html>