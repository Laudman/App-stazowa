angular.module('userApp', ['ui.router', 'ngResource', 'userApp.controllers', 'userApp.services']);

angular.module('userApp').config(function($stateProvider) {
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
  });
}).run(function($state) {
  $state.go('users'); //make a transition to user state when app starts
});