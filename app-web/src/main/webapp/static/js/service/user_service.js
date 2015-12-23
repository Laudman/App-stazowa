/* global _ */

'use strict';
angular.module('mainApp.user.services', []).factory('User', function($resource) {
  return $resource('/users/:id', { id: '@_id' }, {
    delete: {
      method: 'POST',
      url: '/users/delete/:id'
    },
    update: {
      method: 'POST',
      url: '/users/update/:id'
    },
     login: {
      method: 'POST',
      url: '/login'
    }
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

