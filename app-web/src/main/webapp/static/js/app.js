angular.module('mainApp', ['ui.router', 'ngResource', 'mainApp.user.controllers', 'mainApp.user.services', 
                            'mainApp.task.controllers', 'mainApp.task.services']);
//----------------------------Userapp----------------------------------------
angular.module('mainApp').config(function($stateProvider) {
  $stateProvider.state('users', { // state for showing all users
    url: '/users',
    templateUrl: 'views/users.html',
    controller: 'UserListController'
  }).state('viewUser', { //state for showing single user
    url: '/users/:id_user/view',
    templateUrl: 'views/user-view.html',
    controller: 'UserViewController'
  }).state('newUser', { //state for adding a new user
    url: '/users/new',
    templateUrl: 'views/user-add.html',
    controller: 'UserCreateController'
  }).state('editUser', { //state for updating a user
    url: '/users/:id_user/edit',
    templateUrl: 'views/user-edit.html',
    controller: 'UserEditController'
  })
// ---------------------------Contactapp-------------------------------------  
            .state('contact', { //state for adding a new user
    url: '/contact',
    templateUrl: 'views/contact.html'
    //controller: 'UserCreateController'
  })

     //--------------------------------------------------------------------------   
//        .run(function($state) {
//  $state.go('users'); //make a transition to user state when app starts
//})
//-----------------------Taskapp-------------------------------------------------
.state('tasks', { // state for showing all tasks
    url: '/tasks',
    templateUrl: 'views/tasks.html',
    controller: 'TaskListController'
  }).state('viewTask', { //state for showing single task
    url: '/tasks/:id_task/view',
    templateUrl: 'views/task-view.html',
    controller: 'TaskViewController'
  }).state('newTask', { //state for adding a new task
    url: '/tasks/new',
    templateUrl: 'views/task-add.html',
    controller: 'TaskCreateController'
  }).state('editTask', { //state for updating a task
    url: '/tasks/:id_task/edit',
    templateUrl: 'views/task-edit.html',
    controller: 'TaskEditController'
  });
}).run(function($state) {
  $state.go('users'); //make a transition to task state when app starts
})

//----------------------------------------------------------------------------

;

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