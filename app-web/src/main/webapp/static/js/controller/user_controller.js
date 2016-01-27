//'use strict';

angular.module('app.controllers')
        
        .controller('UserController', function ($scope, User) {
            $scope.users = User.query();
            
        })
        .controller('CurrentUser', function ($scope, User, $rootScope, $stateParams){
        $scope.loadUser = function() { 
            User.get({ id: $stateParams.id }, function(user) {
            $scope.user = user; 
            });
            };
            $scope.loadUser();
            
            $scope.isOwner = function (user) {
               if (user.id == $rootScope.currentUser.id || $rootScope.currentUser.admin) {
                        return true;
                    };
                };
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
        $scope.user = User.get({ id: $stateParams.id }); 
        })

        .controller('UserEditController', function($scope, $state, $window, $stateParams, User) {
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
            
            $scope.deleteUser = function() {
            $scope.editUser.$delete({ id: $stateParams.id });$window.location.href = '/';};
        
        }).controller('UserMailboxController', function ($scope, $rootScope, $window, Information) {
            $scope.informations = Information.queryMailbox({id_user: $rootScope.currentUser.id});
            
            $scope.deleteInformation = function(information) { 
            information.$delete(function() {
            $window.location.reload(true);
            });
         };
            
        })
        
;
        
  


