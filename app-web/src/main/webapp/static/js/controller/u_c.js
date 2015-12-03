angular.module('userApp.controllers', []).controller('UserListController', function($scope, $state, popupService, $window, Movie) {
  $scope.users = User.query(); //fetch all users. Issues a GET to /App/user

  $scope.deleteUser = function(user) { // Delete a user. Issues a DELETE to /App/user/:id
    if (popupService.showPopup('Really delete this?')) {
      user.$delete(function() {
        $window.location.href = ''; //redirect to home
      });
    }
  };
}).controller('UserViewController', function($scope, $stateParams, Movie) {
  $scope.user = User.get({ id: $stateParams.id }); //Get a single movie.Issues a GET to /api/movies/:id
}).controller('UserCreateController', function($scope, $state, $stateParams, Movie) {
  $scope.user = new User();  //create new user instance. Properties will be set via ng-model on UI

  $scope.addUser = function() { //create a new user. Issues a POST to /App/user
    $scope.user.$save(function() {
      $state.go('users'); // on success go back to home i.e. movies state.
    });
  };
}).controller('UserEditController', function($scope, $state, $stateParams, Movie) {
  $scope.updateUser = function() { //Update the edited movie. Issues a PUT to /App/user/:id
    $scope.user.$update(function() {
      $state.go('users'); // on success go back to home i.e. user state.
    });
  };

  $scope.loadUser = function() { //Issues a GET request to /App/user/:id to get a user to update
    $scope.user = User.get({ id: $stateParams.id });
  };

  $scope.loadUser(); // Load a user which can be edited on UI
});