angular
		.module('demo', [])
		.controller(
				'Home',
				function($scope, $http) {
					$scope.t1 = 0;
					$scope.t2 = 0;
					$scope.getHello = function() {
						$http
								.get(
										'http://localhost:8080/JWTDemoApp/rest/UserService/hello')
								.then(function(response) {
									$scope.greeting = response.data;
									//   alert(response.data);
								});
					};

					$scope.getEmpDetails = function() {
						//alert("Token in home:"+);
						var token = window.localStorage.getItem('jwt_token');
						$http.defaults.headers.common['Authorization'] = 'Bearer '
								+ token;

						$http
								.get(
										'http://localhost:8080/JWTDemoApp/rest/UserService/users')
								.then(function(response) {
									if (response.data == null) {
										alert('Expired');
										$scope.logout();
									} else {
										$scope.t1 = 1;
										$scope.t2 = 0;
										$scope.users = response.data;
									
									}
								});
					};

					$scope.getContactDetails = function() {
						var token = window.localStorage.getItem('jwt_token');
						$http.defaults.headers.common['Authorization'] = 'Bearer '
								+ token;

						$http
								.get(
										'http://localhost:8080/JWTDemoApp/rest/UserService/contactdetails')
								.then(function(response) {
									if (response.data == null) {
										alert('Expired');
										$scope.logout();
									} else {
										$scope.t1 = 0;
										$scope.t2 = 1;
										$scope.users = response.data;
									}
								});
					};

					$scope.logout = function() {
						var token = window.localStorage.setItem('jwt_token',
								'null');
						window.location.href = "LoginPage.jsp";
					};
				});

/**
 * 


 function show(nr) {
 if(nr==1){
 document.getElementById("table2").style.display="none";
 document.getElementById("table"+nr).style.display="block";
 $(document).ready(function() {
 $.ajax({
 url: 'http://localhost:8080/JWTDemoApp/rest/UserService/users',
 type: 'GET',
 dataType: 'xml',
 success: function(xml) {
 alert("Yay!"+xml);
 alert($(xml).find("id").text());
 $(xml).find("id").each(function(index,id){
 console.log( $(id).text());
 })
 $(xml).find("name").each(function(index,name){
 console.log( $(name).text());
 })
 $(xml).find("profession").each(function(index,profession){
 console.log( $(profession).text());
 })
 //  $('.table1').append(data.users);
 },
 error: function(jqXHR, textStatus, errorThrown){
 alert(textStatus, errorThrown);
 }
 });

 });
 }
 }
 */
