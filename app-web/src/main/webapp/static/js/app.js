//'use strict';

var mainApp = angular.module('mainApp', ['ui.router','mainApp.task.controllers','mainApp.task.services', 'ngResource', 'app.controllers', 'app.services', 'app.constants']);

mainApp.config(['$stateProvider', '$urlRouterProvider', '$httpProvider', function ($stateProvider, $urlRouterProvider, $httpProvider) {

//        $locationProvider.html5Mode(true);

        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
        $urlRouterProvider.otherwise("/");
        $stateProvider
          .state('/', {
            url:'/tasks',
            templateUrl: 'views/tasks.html'
        }).state('currentUser', {
            url:'/user/:id',
            templateUrl: 'views/user_authentication.html',
            controller: 'CurrentUser'
        }).state('admin', {
            url:'/',
            templateUrl: 'views/admin_authentication.html',
            controller: 'AdminController'
        }).state('signup', {
            url:'/signup',
            templateUrl: 'views/signup.html',
            controller: 'UserCreateController'
        }).state('login', {
            url:'/login',
            templateUrl: 'views/login.html',
            controller: 'AppController'
        }).state('editUser', { 
            url: '/user/:id/edit',
            templateUrl: 'views/user.html',
            controller: 'UserEditController'
        })
                
                .state('newTask', {
            url:'/tasks/new-task',
            templateUrl: 'views/task-new.html',
            controller: 'NewTaskController'
        });

    }]);



//var mainApp = angular.module('mainApp', ['ngRoute', 'ngResource', 'app.controllers', 'app.services', 'app.constants']);
//
//mainApp.config(['$routeProvider', '$locationProvider', '$httpProvider', function ($routeProvider, $locationProvider, $httpProvider) {
//
//        $locationProvider.html5Mode(true);
//
//        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
//
//        $routeProvider.when('/', {
//            title: 'Home',
//            templateUrl: 'views/no_authentication.html'
//        }).when('/user', {
//            title: 'Settings',
//            templateUrl: 'views/user_authentication.html',
//        }).when('/admin', {
//            title: 'Admin',
//            templateUrl: 'views/admin_authentication.html',
//            controller: 'AdminController'
//        }).when('/signup', {
//            title: 'User Registration',
//            templateUrl: 'views/signup.html',
//            controller: 'UserCreateController'
//        }).when('/login', {
//            title: 'Login',
//            templateUrl: 'views/login.html',
//            controller: 'AppController'
//        }).when('/user/update/:id', { 
//            title: 'View',
//            templateUrl: 'views/user.html',
//            controller: 'UserViewController'
//        }).when('viewUser', { 
//            url: '/user/:id/view',
//            templateUrl: 'views/user.html',
//            controller: 'UserEditController'
//        }).when('/user/update', { 
//            title: 'update',
//            templateUrl: 'views/user.html',
//            controller: 'UserEditController'
//            
// 
//        }).otherwise({redirectTo: "/"});
//
//    }]);