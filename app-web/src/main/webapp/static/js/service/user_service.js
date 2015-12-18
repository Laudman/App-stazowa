'use strict';
angular.module('mainApp.user.services', []).factory('User', function($resource) {
  return $resource('/users/:id_user', { id_user: '@_id_user' }, {
    delete: {
      method: 'POST',
      url: '/users/delete/:id_user'
    },
    update: {
      method: 'POST',
      url: '/users/update/:id_user'
    },
//    login: {
//      method: 'POST',
//      url: '/users/login/'
//    }
    });
    });
//    .service('Session', function($rootScope, USER_ROLES) {
//
//	this.create = function(user) {
//		this.user = user;
//		this.userRole = user.userRole;
//	};
//	this.destroy = function() {
//		this.user = null;
//		this.userRole = null;
//	};
//	return this;
//});


//});