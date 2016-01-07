//'use strict';

angular.module('app.controllers')
        
        .controller('UserController', function ($scope, $window, $http, User) {
            $scope.users = User.query();
            
        })
        .controller('AdminController', function ($scope, $window, User) {
            $scope.users = User.query();
        })
        .controller('CurrentUser', function ($scope, User, $stateParams){
        $scope.loadUser = function() { 
            User.get({ id: $stateParams.id }, function(user) {
            $scope.user = user; 
            });
            };
            $scope.loadUser();
        })
        .controller('UserCreateController', function ($scope, $state, User) {
            $scope.user = new User();

            $scope.addUser = function () {
                $scope.user.$save(function () {
                    $state.go('login');
                });
            };
        })
        .controller('UserViewController', function($scope, $stateParams, User) {
        $scope.user = User.get({ id: $stateParams.id }); //Get a single user.Issues a GET to /App/users/:id
        })

        .controller('UserEditController', function($scope, $state, popupService, $window, $stateParams, User) {
            $scope.updateUser = function() { 
                
                $scope.editUser.$update(function() {  
                $state.go('/'); 
                });
            };
          
            $scope.loadUser = function() { 
            User.get({id: $stateParams.id}, function (data) {
                    $scope.editUser = new User();
                    $scope.editUser.id = data.id;
                    $scope.editUser.login = data.login;
                    $scope.editUser.password = data.password;
                    $scope.editUser.email = data.email;
                });
            };           
            $scope.loadUser();
            
//            $scope.loadUser({login: $stateParams.login, password: $stateParams.password, email: $stateParams.email});
//            $scope.loadUser({id: $stateParams.id, login: $stateParams.login, password: $stateParams.password, email: $stateParams.email});

            $scope.deleteUser = function() {
            $scope.editUser.$delete({ id: $stateParams.id });$window.location.href = '/';};
        });
        
  


