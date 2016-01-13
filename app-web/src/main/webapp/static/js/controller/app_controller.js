angular.module('app.controllers').controller('AppController', ['$http', '$state', '$rootScope', '$scope',   function ($http,  $state, $rootScope, $scope) {

$scope.typeOfJob = {
    repeatSelect: null,
    availableOptions: [
      {id: 1, name: 'Applications developer'},
      {id: 2, name: 'Database administrator'},
      {id: 3, name: 'Games developer'},
      {id: 4, name: 'IT consultant'},
      {id: 5, name: 'IT technical support officer'},
      {id: 6, name: 'Network engineer'},
      {id: 7, name: 'Software tester'},
      {id: 8, name: 'Web developer'}
    ]
       };
       
       $scope.typeOfQuestion = {
    repeatSelect: null,
    availableOptions: [
      {id: 1, name: 'Applications'},
      {id: 2, name: 'Database'},
      {id: 3, name: 'Graphics'},
      {id: 4, name: 'Systems'}
    ]
       };
       
        $scope.typeOfSpeak = {
    repeatSelect: null,
    availableOptions: [
      {id: 1, name: 'Face to face'},
      {id: 2, name: 'Call'},
      {id: 3, name: 'Writing'},
      {id: 4, name: 'Skype'}
    ],
       };
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
                
