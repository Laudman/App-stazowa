//'use strict';
angular.module('mainApp.user.controllers', [])
        .controller('UserListController', function($scope, $state, popupService, $window, User) {
  $scope.users = User.query(); //fetch all users. Issues a GET to /App/users

  $scope.deleteUser = function(user) { // Delete a user. Issues a DELETE to /App/users/:id
    if (popupService.showPopup('Really delete this?')) {
         user.$delete(function() {
        $window.location.href = ''; //redirect to home
      });
    }
  };
}).controller('UserViewController', function($scope, $stateParams, User) {
  $scope.user = User.get({ id_user: $stateParams.id_user }); //Get a single user.Issues a GET to /App/users/:id
})
.controller('UserStateDropDown', ['$scope', function($scope) {
   $scope.data = {
    availableOptions: [
      {name: 'user'},
      {name: 'admin'}
    ],
    selectedOption: {name: 'user'}
       };
}])
        .controller('UserCreateController', function($scope, $state, $stateParams, User) {
  $scope.user = new User();  //create new user instance. Properties will be set via ng-model on UI
  $scope.addUser = function() { //create a new user. Issues a POST to /App/users
    $scope.user.$save(function() {
      $state.go('users'); // on success go back to home i.e. users state.
    });
  };
}).controller('UserEditController', function($scope, $state, $stateParams, User) {
  $scope.updateUser = function() { //Update the edited user. Issues a PUT to /App/users/:id
      $scope.user.$update(function() {
      $state.go('users'); // on success go back to home i.e. user state.
    });
  };
   $scope.loadUser = function() { //Issues a GET request to /App/users/:id to get a user to update
    $scope.user = User.get({ id_user: $stateParams.id_user });
  };

  $scope.loadUser(); // Load a user which can be edited on UI
})
;
//;
//
//.controller('LoginCtrl', function($scope, $state, $modalInstance, $window, Auth ) {
//	$scope.credentials = {};
//	$scope.loginForm = {};
//	$scope.error = false;
//	
//	//when the form is submitted
//	$scope.submit = function() {
//		$scope.submitted = true;
//		if (!$scope.loginForm.$invalid) {
//			$scope.login($scope.credentials);
//		} else {
//			$scope.error = true;
//			return;
//		}
//	};
//
//	//Performs the login function, by sending a request to the server with the Auth service
//	$scope.login = function(credentials) {
//		$scope.error = false;
//		Auth.login(credentials, function(user) {
//			//success function
//			$modalInstance.close();
//			$state.go('users');
//		}, function(err) {
//			console.log("error");
//			$scope.error = true;
//		});
//	};
//	
//	// if a session exists for current user (page was refreshed)
//	// log him in again
//	if ($window.sessionStorage["userInfo"]) {
//		var credentials = JSON.parse($window.sessionStorage["userInfo"]);
//		$scope.login(credentials);
//	}
//
//} )
//
// .controller('ParentController', function($scope, $rootScope, $modal, Auth, AUTH_EVENTS, USER_ROLES){
//	// this is the parent controller for all controllers.
//	// Manages auth login functions and each controller
//	// inherits from this controller	
//
//	
//	$scope.modalShown = false;
//	var showLoginDialog = function() {
//		if(!$scope.modalShown){
//			$scope.modalShown = true;
//			var modalInstance = $modal.open({
//				templateUrl : 'static/views/login.html',
//				controller : "LoginCtrl",
//				backdrop : 'static'
//			});
//
//			modalInstance.result.then(function() {
//				$scope.modalShown = false;
//			});
//		}
//	};
//	
//	var setCurrentUser = function(){
//		$scope.currentUser = $rootScope.currentUser;
//	};
//	
//	var showNotAuthorized = function(){
//		alert("Not Authorized");
//	};
//	
//	$scope.currentUser = null;
//	$scope.userRoles = USER_ROLES;
//	$scope.isAuthorized = Auth.isAuthorized;
//
//	//listen to events of unsuccessful logins, to run the login dialog
//	$rootScope.$on(AUTH_EVENTS.notAuthorized, showNotAuthorized);
//	$rootScope.$on(AUTH_EVENTS.notAuthenticated, showLoginDialog);
//	$rootScope.$on(AUTH_EVENTS.sessionTimeout, showLoginDialog);
//	$rootScope.$on(AUTH_EVENTS.logoutSuccess, showLoginDialog);
//	$rootScope.$on(AUTH_EVENTS.loginSuccess, setCurrentUser);
//	
//} );


////  
////  