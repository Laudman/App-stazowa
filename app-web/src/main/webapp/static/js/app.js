//'use strict';
angular.module('mainApp', [ 'ui.router', 
                            'ngResource', 
                            'mainApp.user.controllers', 
                            'mainApp.user.services', 
                            'mainApp.task.controllers', 
                            'mainApp.task.services',
                            'mainApp.authenticate.controllers',
                            'mainApp.authenticate.services'
                        ]);
//----------------------------Userapp----------------------------------------
        angular.module('mainApp')
.config(function($stateProvider) {    
            
  $stateProvider.state('users', { 
    url: '/users',
    templateUrl: 'views/users.html',
    controller: 'UserListController',
   data: {
        requireLogin: false
      }
  }).state('viewUser', { 
    url: '/users/:id_user/view',
    templateUrl: 'views/user-view.html',
    controller: 'UserViewController',
    data: {
        requireLogin: false
      }
  }).state('newUser', { 
    url: '/users/new',
    templateUrl: 'views/user-add.html',
    controller: 'UserCreateController',
    data: {
        requireLogin: false
      }
  }).state('editUser', { 
    url: '/users/:id_user/edit',
    templateUrl: 'views/user-edit.html',
    controller: 'UserEditController',
    data: {
        requireLogin: false
      }
  })
// ---------------------------Contactapp-------------------------------------  
    .state('contact', {
    url: '/contact',
    templateUrl: 'views/contact.html',
    data: {
        requireLogin: false
      }
  })
  //--------------------------Login------------------
  .state('login', { 
    url: '/login',
    templateUrl: 'views/login.html',
    data: {
        requireLogin: false
      }
  })
  //--------------------------Signup-----------------------
  .state('signup', { 
    url: '/signup',
    templateUrl: 'views/signup.html',
    data: {
        requireLogin: false
      }
  })

     //--------------------------------------------------------------------------   
//        .run(function($state) {
//  $state.go('users'); //make a transition to user state when app starts
//})
//-----------------------Taskapp-------------------------------------------------
.state('tasks', { // state for showing all tasks
    url: '/tasks',
    templateUrl: 'views/tasks.html',
    controller: 'TaskListController',
    data: {
        requireLogin: false
      }
  }).state('viewTask', { //state for showing single task
    url: '/tasks/:id_task/view',
    templateUrl: 'views/task-view.html',
    controller: 'TaskViewController',
    data: {
        requireLogin: false
      }
  }).state('newTask', { //state for adding a new task
    url: '/tasks/new',
    templateUrl: 'views/task-add.html',
    controller: 'TaskCreateController',
    data: {
        requireLogin: false
      }
  }).state('editTask', { //state for updating a task
    url: '/tasks/:id_task/edit',
    templateUrl: 'views/task-edit.html',
    controller: 'TaskEditController',
    data: {
        requireLogin: false
      }
  });
});


angular.module('mainApp')
.config(function($httpProvider){
            $httpProvider.interceptors.push(function ($timeout, $q, $injector) {
    var loginModal, $http, $state;

    // this trick must be done so that we don't receive
    // `Uncaught Error: [$injector:cdep] Circular dependency found`
    $timeout(function () {
      loginModal = $injector.get('loginModal');
      $http = $injector.get('$http');
      $state = $injector.get('$state');
    });

    return {
      responseError: function (rejection) {
        if (rejection.status !== 401) {
          return rejection;
        }

        var deferred = $q.defer();

        loginModal()
          .then(function () {
            deferred.resolve( $http(rejection.config) );
          })
          .catch(function () {
            $state.go('tasks');
            deferred.reject(rejection);
          });

        return deferred.promise;
      }
    };
  });

});


angular.module('mainApp')
.run(function ($rootScope, $state, loginModal) {

  $rootScope.$on('$stateChangeStart', function (event, toState, toParams) {
    var requireLogin = toState.data.requireLogin;

    if (requireLogin && typeof $rootScope.currentUser === 'undefined') {
      event.preventDefault();

      loginModal()
        .then(function () {
          return $state.go(toState.name, toParams);
        })
        .catch(function () {
          return $state.go('tasks');
        });
    }
  });
});
    
//        });
//.run(function($state) {
//  $state.go('users'); //make a transition to task state when app starts
//});
//.run(function($rootScope, user) {
//	// Initiate the user service with your UserApp App Id
//	// https://help.userapp.io/customer/portal/articles/1322336-how-do-i-find-my-app-id-
//	user.init({ appId: 'YOUR-USERAPP-APP-ID' });
//});

//.run(function ($rootScope, $state, $stateParams) {
//        $rootScope.$state = $state;
//        $rootScope.$stateParams = $stateParams;
//    });

//----------------------------------------------------------------------------


//angular.module('mainApp', ['ui.router', 'ngResource', 'mainApp.controllers', 'mainApp.services']);
//
//angular.module('mainApp').config(function($stateProvider) {
//  $stateProvider.state('users', { // state for showing all users
//    url: '/users',
//    templateUrl: 'views/users.html',
//    controller: 'UserListController'
//  }).state('viewUser', { //state for showing single user
//    url: '/users/:id_user/view',
//    templateUrl: 'views/user-view.html',
//    controller: 'UserViewController'
//  }).state('newUser', { //state for adding a new user
//    url: '/users/new',
//    templateUrl: 'views/user-add.html',
//    controller: 'UserCreateController'
//  }).state('editUser', { //state for updating a user
//    url: '/users/:id_user/edit',
//    templateUrl: 'views/user-edit.html',
//    controller: 'UserEditController'
//  });
//}).run(function($state) {
//  $state.go('users'); //make a transition to user state when app starts
//});

//**********************************************************************************************

//.config(['$routeProvider',function($stateProvider) {
//  $stateProvider.state('users', {url: '/users',
//                                templateUrl: 'views/users.html', 
//                                controller: 'UserListController'});
//  $stateProvider.state('viewUser', { url: '/users/:id_user/view',
//                         templateUrl: 'views/user-view.html',
//                         controller: 'UserViewController'});
//  $stateProvider.state('newUser', { url: '/users/new',
//                        templateUrl: 'views/user-add.html',
//                        controller: 'UserCreateController'});
//  $stateProvider.state('editUser', { url: '/users/:id_user/edit',
//                         templateUrl: 'views/user-edit.html',
//                         controller: 'UserEditController'});
//// ---------------------------Contactapp-------------------------------------  
//    $stateProvider.state('contact', { url: '/contact',
//                        templateUrl: 'views/contact.html'});
//
////     --------------------------------------------------------------------------   
////        .run(function($state) {
////  $state.go('users'); //make a transition to user state when app starts
////})
////-----------------------Taskapp-------------------------------------------------
//$stateProvider.state('tasks', { url: '/tasks',
//                  templateUrl: 'views/tasks.html',
//                  controller: 'TaskListController'});
//$stateProvider.state('viewTask', { url: '/tasks/:id_task/view',
//                         templateUrl: 'views/task-view.html',
//                         controller: 'TaskViewController'});
//$stateProvider.state('newTask', { url: '/tasks/new',
//                        templateUrl: 'views/task-add.html',
//                        controller: 'TaskCreateController'});
//$stateProvider.state('editTask', { url: '/tasks/:id_task/edit',
//                         templateUrl: 'views/task-edit.html',
//                         controller: 'TaskEditController'});
//$stateProvider.otherwise({redirectTo: '/tasks'});
//}])
//        .run(function($state) {
//  $state.go('users'); //make a transition to task state when app starts
//})
////.run(function($rootScope, user) {
////	// Initiate the user service with your UserApp App Id
////	// https://help.userapp.io/customer/portal/articles/1322336-how-do-i-find-my-app-id-
////	user.init({ appId: 'YOUR-USERAPP-APP-ID' });
////});



//*******************************************************************************
//
//$routeProvider.when('/tasks', {
//                  url: '/tasks',
//                  templateUrl: 'views/tasks.html',
//                  controller: 'TaskListController'});
//$routeProvider.when('/task-view', { 
//                         url: '/tasks/:id_task/view',
//                         templateUrl: 'views/task-view.html',
//                         controller: 'TaskViewController'});
//$routeProvider.when('/task-add', { 
//                        url: '/tasks/new',
//                        templateUrl: 'views/task-add.html',
//                        controller: 'TaskCreateController'});
//$routeProvider.when('/task-edit', { 
//                         url: '/tasks/:id_task/edit',
//                         templateUrl: 'views/task-edit.html',
//                         controller: 'TaskEditController'});
//$routeProvider.otherwise({redirectTo: '/tasks'});
//}])
//.run(function($rootScope, user) {
//	// Initiate the user service with your UserApp App Id
//	// https://help.userapp.io/customer/portal/articles/1322336-how-do-i-find-my-app-id-
//	user.init({ appId: 'YOUR-USERAPP-APP-ID' });
//});