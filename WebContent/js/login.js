angular.module('login', [])
.controller('logincontroller', function($scope, $http) {

	  $scope.authenticate = function() {
		  //alert("token before login:"+window.localStorage.getItem('jwt_token'));
		  var parameter = JSON.stringify({uname:$scope.uname, pass:$scope.pass});
		  $http.post('http://localhost:8080/JWTDemoApp/rest/authenticate/user', parameter).
		    success(function(data, status, headers, config) {
		    	//alert(data);
		    	if(data.jwt_token!=null){
		    	//	alert("Response received: JWT token: "+data.jwt_token+" Expires in:"+data.expires_in);
		    		window.localStorage.setItem('jwt_token', data.jwt_token);
		    		//window.localStorage.setItem('refresh_token', data.refresh_token);
		    		 window.location.href="HomePage.jsp";
		    	}
		      }).
		      error(function(data, status, headers, config) {
		    	  alert(data);
		        // called asynchronously if an error occurs
		        // or server returns response with an error status	.
		      });
	  };
  
});

