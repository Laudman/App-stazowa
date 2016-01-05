angular.module('app.controllers').controller('AppController', ['$http', '$state', '$rootScope', '$scope',   function ($http,  $state, $rootScope, $scope) {

                var authenticate = function (credentials, callback) {
  
                    var headers = credentials ? {authorization: "Basic "
                                + btoa(credentials.username + ":" + credentials.password)
                    } : {};
                  
                    $http.get('/user/retrive', {headers: headers}).success(function (data) {
                       
                        if (data.name) {
                            $rootScope.authenticated = true;
                            $rootScope.currentUser = data;
                            $scope.admin = data && data.roles && data.roles.indexOf("ROLE_ADMIN")>0;
                        } else {
                            $rootScope.authenticated = false;
                            $scope.admin = false;
                        }
                        callback && callback();
                    }).error(function (data) {
                        $rootScope.authenticated = false;
                        callback && callback();
                    });

                };

                authenticate();  
                $scope.credentials = {};     
                $scope.login = function () {
                    authenticate($scope.credentials, function () {              
                        if ($rootScope.authenticated) {
                            $state.go("/");
                            $scope.error = false;
                        } else {
                            $state.go("login");
                            $scope.error = true;
                        }
                    });
                };
                
                $scope.logout = function () {
                    $http.post('logout', {}).success(function () {
                        $rootScope.authenticated = false;
                        $scope.admin = false;
                        $state.go("/");
                    }).error(function (data) {
                        $rootScope.authenticated = false;
                        $scope.authenticated = false;
                        $scope.admin = false;
                    });
                };

            }]);
                
