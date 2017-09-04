<!doctype html>
<html ng-app="login">
<head>
<title>Login Page</title>
<script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.min.js"></script>
<script src="js/login.js"></script>
</head>
<body>
	<div ng-controller="logincontroller">
		<form><!-- action="LoginServlet">-->
			Please enter your username <input type="text" name="uname" ng-model="uname"/><br>
			Please enter your password <input type="password" name="pass" ng-model="pass"/> <input
				ng-click="authenticate();" type="submit" value="submit">
		</form>
	</div>
</body>
</html>