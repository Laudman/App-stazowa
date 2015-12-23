'use strict';

angular.module('mainApp.Auth', [])
.factory('Auth', function($http, $rootScope, $window, Session, AUTH_EVENTS) {
	var authService = {};
	
	
//	authService.login = function( login, password) {
//		$http.post('/login.html', { login: login, password: password })
//		.success(function (response) {
//              callback(response);
//		});
	authService.login = function(user, success, error) {
		$http.post('/login.html').success(function(data) {
		var users = data.users;
		if(users[user.login]){
			var loginData = users[user.login];
		
			if(user.login == loginData.login && user.password == loginData.login){
				
				$window.sessionStorage["userInfo"] = JSON.stringify(loginData);
				delete loginData.password;				
				Session.create(loginData);			
				$rootScope.currentUser = loginData;
				$rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
				success(loginData);
			} else{
				$rootScope.$broadcast(AUTH_EVENTS.loginFailed);
				error();
			}
		}	
		});
		
	};
	authService.isAuthenticated = function() {
		return !!Session.user;
	};
	authService.isAuthorized = function(authorizedRoles) {
		if (!angular.isArray(authorizedRoles) ) {
	      authorizedRoles = [authorizedRoles];
	    }
	    return (authService.isAuthenticated() &&
	      authorizedRoles.indexOf(Session.userRole) !== -1);
	};
	authService.logout = function(){
		Session.destroy();
		$window.sessionStorage.removeItem("userInfo");
		$rootScope.$broadcast(AUTH_EVENTS.logoutSuccess);
	};

	return authService;
} );
