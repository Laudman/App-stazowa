//'use strict';

var mainApp = angular.module('mainApp', ['ui.router', 'mainApp.subscribe.services', 'mainApp.subscribe.controllers','mainApp.vote.controllers', 'mainApp.vote.services', 'mainApp.answer.services' ,'mainApp.answer.controllers' ,'mainApp.task.controllers','mainApp.task.services', 'ngResource', 'app.controllers', 'app.services', 'app.constants']);

mainApp.config(['$stateProvider', '$urlRouterProvider', '$httpProvider', function ($stateProvider, $urlRouterProvider, $httpProvider) {

//        $locationProvider.html5Mode(true);

        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
        $urlRouterProvider.otherwise("/");
        $stateProvider
//---------------------USER-------------------------------------------
          .state('/', {
            url:'/tasks',
            templateUrl: 'views/tasks/tasks.html',
            controller: 'TaskListController'
        }).state('home', {
            url:'/tasks',
            templateUrl: 'views/tasks/tasks.html',
            controller: 'TaskListController'
        }).state('currentUser', {
            url:'/user/:id',
            templateUrl: 'views/users/user_authentication.html',
            controller: 'CurrentUser'
        }).state('signup', {
            url:'/signup',
            templateUrl: 'views/users/signup.html',
            controller: 'UserCreateController'
        }).state('login', {
            url:'/login',
            templateUrl: 'views/users/login.html',
            controller: 'AppController'
        }).state('editUser', { 
            url: '/user/:id/edit',
            templateUrl: 'views/users/user.html',
            controller: 'UserEditController'
        })
// --------------------TASK-----------------------------------------    

            .state('showMyTasks', {
            url:'/my-tasks',
            templateUrl: 'views/tasks/myTasks.html',
            controller: 'TaskListController'
        }).state('newTask', {
            url:'/tasks/new-task',
            templateUrl: 'views/tasks/task-new.html',
            controller: 'NewTaskController'
        }).state('showRequest', {
            url:'/tasks/{id_task}',
            views:{
                'taskView':{
                    url:'tasks/answers',
                    templateUrl: 'views/tasks/task.html',
                    controller: 'TaskViewController'
                    
                },
                'answerView':{
                    templateUrl: 'views/answers/answer.html',
                    controller: 'AnswerListController'
                }
                
            }
        }).state('editTask', { 
            url: '/tasks/:id_task/edit',
            templateUrl: 'views/tasks/task-edit.html',
            controller: 'TaskEditController'
        }).state('showMySubscribed', { 
            url: '/tasks-subscribed',
            templateUrl: 'views/tasks/mySubscribedTasks.html',
            controller: 'TaskListJoinController'
        })
//------------------------ANSWER--------------------------------------------------       
            .state('newAnswer', {
            url:'/tasks-new-answer/{id_task}',
            views:{
                'taskView':{
                    templateUrl: 'views/tasks/task.html',
                    controller: 'TaskViewController'
                },
                'answerView':{
                    templateUrl: 'views/answers/answer-new.html',
                    controller: 'NewAnswerController'
                }
                
            }
        }).state('editAnswer', { 
            url: '/answers/:id_answer/edit',
            templateUrl: 'views/answers/answer-edit.html',
            controller: 'AnswerEditController'
        }).state('deleteAnswer', { 
            url: '/answers/:id_answer/delete',
            templateUrl: 'views/answers/answer-edit.html',
            controller: 'AnswerListController'
        })
          
        
;
    }]);
