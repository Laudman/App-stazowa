'use strict';

angular.module('mainApp.Session', [])
        .service('Session', function($rootScope, USER_ROLES) {

	this.create = function(user) {
		this.user = user;
		this.userRole = user.userRole;
	};
	this.destroy = function() {
		this.user = null;
		this.userRole = null;
	};
	return this;
})
.config(function ($httpProvider) {
  $httpProvider.interceptors.push([
    '$injector',
    function ($injector) {
      return $injector.get('AuthInterceptor');
    }
  ]);
});