//'use strict';

angular.module('app.controllers')
        
        .controller('UserController', function ($scope, $window, $http, User) {
            $scope.users = User.query();
            
        })
        .controller('AdminController', function ($scope, $window, User) {
            $scope.users = User.query();
        })
        
        .controller('UserCreateController', function ($scope, User) {
            $scope.user = new User();

            $scope.addUser = function () {
                $scope.user.$save(function () {
                });
            };
        })
        .controller('UserViewController', function($scope, $stateParams, User) {
        $scope.user = User.get({ id: $stateParams.id }); //Get a single user.Issues a GET to /App/users/:id
        })

        .controller('UserEditController', function($scope, $state, popupService, $window, $stateParams, User) {
            $scope.updateUser = function() { 
                
                $scope.user.$update(function() {  
                $state.go('user'); 
                });
            };
            
            $scope.loadUser = function() { 
            $scope.user = User.get({ id: $stateParams.id });
            $scope.editUser = new User();
            $scope.editUser.id = $scope.user.id;
            $scope.editUser.login = $scope.user.login;
            $scope.editUser.password = $scope.user.password;
            $scope.editUser.email = $scope.user.email;
            };           
            $scope.loadUser();
            
//            $scope.loadUser({login: $stateParams.login, password: $stateParams.password, email: $stateParams.email});
//            $scope.loadUser({id: $stateParams.id, login: $stateParams.login, password: $stateParams.password, email: $stateParams.email});
//        })
//        .controller('UserDelController', function($scope, $state, popupService, $window, User) {
//            $scope.deleteUser = function() {
//            if (popupService.showPopup('Really delete this?')) {
//                $scope.user.$delete(function() {
//                    $window.location.href = ''; 
//                });
//            }
//        };
            $scope.deleteUser = function() {
            $scope.user.$delete({ id: $stateParams.id });$window.location.href = '/';};
        });
        
        
//        .controller('UserListController', function($scope, $state, popupService, $window, User) {
//            $scope.users = User.query(); //fetch all users. Issues a GET to /App/users
//
//            $scope.deleteUser = function(user) { // Delete a user. Issues a DELETE to /App/users/:id
//             if (popupService.showPopup('Really delete this?')) {
//            user.$delete(function() {
//            $window.location.href = ''; //redirect to home
//      });
//    }
//  };
//        });


