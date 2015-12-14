//'use strict';

angular.module('mainApp.authenticate.controllers', [])
.controller('LoginModalCtrl', function ($scope, UsersApi) {

  this.cancel = $scope.$dismiss;

  this.submit = function (email, password) {
    UsersApi.login(email, password).then(function (user) {
      $scope.$close(user);
    });
  };

});












//
//angular.module('mainApp.authenticate.controllers', [])
//	.controller('MyCtrl1', function() {
//
//	})
//	.controller('MyCtrl2', function() {
//
//	});