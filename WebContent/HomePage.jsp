<!doctype html>
<html ng-app="demo">
	<head>
		<title>Welcome</title>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.min.js"></script>
    	<script src="js/home.js"></script>
    		<script src="css/Bootstrap.css"></script>
	</head>

	<body>
		<div ng-controller="Home">
		
		 <a href="#" ng-click="getEmpDetails();">Employee details</a>
		<table ng-show="t1==1" border=1>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Domain</th>
			</tr>

			<tr ng-repeat="user in users">
				<td>{{ user.id }}</td>
				<td>{{ user.name }}</td>
				<td>{{ user.profession }}</td>
			</tr>
		</table>
		<br>
		 <a href="#" ng-click="getContactDetails();">Employee contacts</a>
		<table ng-show="t2==1" border=1>
			<tr>
				<th>Name</th>
				<th>Contact Number</th>
			</tr>

			<tr ng-repeat="user in users">
				<td>{{ user.name }}</td>
				<td>{{ user.contact }}</td>
			</tr>
		</table>
		</br>
		<button ng-click="logout();">Logout</button>
	</div>
	</body>
</html>







