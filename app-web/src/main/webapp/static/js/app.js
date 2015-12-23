
'use strict';

var mainApp = angular.module('mainApp', [ 'ui.router',
                            'ngResource',                          
                            'mainApp.user.controllers', 
                            'mainApp.user.services', 
                            'mainApp.task.controllers', 
                            'mainApp.task.services',
                            'mainApp.Auth',
                            'mainApp.AuthInterceptor',
                            'mainApp.Session',
                            'ui.bootstrap'
                        ])
       .constant('USER_ROLES', {
	admin : 'admin',
	user : 'user'
}).constant('AUTH_EVENTS', {
	loginSuccess : 'auth-login-success',
	loginFailed : 'auth-login-failed',
	logoutSuccess : 'auth-logout-success',
	sessionTimeout : 'auth-session-timeout',
	notAuthenticated : 'auth-not-authenticated',
	notAuthorized : 'auth-not-authorized'
})

//----------------------------Userapp----------------------------------------

.config(function($stateProvider, $urlRouterProvider, USER_ROLES) {    
            
  $urlRouterProvider.otherwise("/users");
  
  $stateProvider.state('users', { 
    url: '/users',
    templateUrl: 'views/users.html',
    controller: 'UserListController',
   data: {
                authorizedRoles: []
    }
    
    }).state('user', { 
    url: '/user',
    templateUrl: 'views/user.html',
    
   data: {
                authorizedRoles: []
    }
   

}).state('login', { 
    url: '/login',
    templateUrl: 'views/login.html',
    controller: 'LoginCtrl',
    data: {
                authorizedRoles: []
    }
  
  }).state('viewUser', { 
    url: '/users/:id/view',
    templateUrl: 'views/user-view.html',
    controller: 'UserViewController',
    data: {
                authorizedRoles: []
    }
    
  }).state('newUser', { 
    url: '/users/new',
    templateUrl: 'views/user-add.html',
    controller: 'UserCreateController',
    data: {
                authorizedRoles: []
    }
    
  }).state('editUser', { 
    url: '/users/:id/edit',
    templateUrl: 'views/user-edit.html',
    controller: 'UserEditController',
    data: {
                authorizedRoles: []
    }
    
  })
// ---------------------------Contactapp-------------------------------------  
    .state('contact', {
    url: '/contact',
    templateUrl: 'views/contact.html',
    data: {
                authorizedRoles: [USER_ROLES.user]
    }
    
  })
  .state('signup', { 
    url: '/signup',
    templateUrl: 'views/signup.html',
 controller: 'UserCreateController',
 data: {
                authorizedRoles: []
    }
 
  })

     //--------------------------------------------------------------------------   

//-----------------------Taskapp-------------------------------------------------
.state('tasks', { // state for showing all tasks
    url: '/tasks',
    templateUrl: 'views/tasks.html',
    controller: 'TaskListController',
    data: {
                authorizedRoles: []
    }
    
  }).state('viewTask', { //state for showing single task
    url: '/tasks/:id_task/view',
    templateUrl: 'views/task-view.html',
    controller: 'TaskViewController',
    data: {
                authorizedRoles: []
    }
    
  }).state('newTask', { //state for adding a new task
    url: '/tasks/new',
    templateUrl: 'views/task-add.html',
    controller: 'TaskCreateController',
    data: {
                authorizedRoles: []
    }
    
  }).state('editTask', { //state for updating a task
    url: '/tasks/:id_task/edit',
    templateUrl: 'views/task-edit.html',
    controller: 'TaskEditController',
    data: {
                authorizedRoles: []
    }
    
  });
  
})

.run(function($rootScope, $state, Auth, AUTH_EVENTS) {
	
	$rootScope.$on('$stateChangeStart', function (event, next) {
	    var authorizedRoles = next.data.authorizedRoles;
	    if (!Auth.isAuthorized(authorizedRoles)&& authorizedRoles != 0) {
	      event.preventDefault();
	      if (Auth.isAuthenticated()) {
	        $rootScope.$broadcast(AUTH_EVENTS.notAuthorized);
	      } else {
	        $rootScope.$broadcast(AUTH_EVENTS.notAuthenticated);
	      }
	    }
	  });
	
	$rootScope.getClass = function(path) {
		if ($state.current.name == path) {
			return "active";
		} else {
			return "";
		}
	}
	
	$rootScope.logout = function(){
		Auth.logout();
	};

})
.directive('formAutofillFix', function ($timeout) {
  return function (scope, element, attrs) {
    element.prop('method', 'post');
    if (attrs.ngSubmit) {
      $timeout(function () {
        element
          .unbind('submit')
          .bind('submit', function (event) {
            event.preventDefault();
            element
              .find('input, textarea, select')
              .trigger('input')
              .trigger('change')
              .trigger('keydown');
            scope.$apply(attrs.ngSubmit);
          });
      });
    }
  };
});
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //.run(function($state) {
//  $state.go('users'); //make a transition to user state when app starts
//});