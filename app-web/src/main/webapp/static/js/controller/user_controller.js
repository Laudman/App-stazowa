angular.module('userApp.controllers', [])
        .controller('UserListController', function($scope, $state, popupService, $window, User) {
  $scope.users = User.query(); //fetch all users. Issues a GET to /App/users

  $scope.deleteUser = function(user) { // Delete a user. Issues a DELETE to /App/users/:id
    if (popupService.showPopup('Really delete this?')) {
         user.$delete(function() {
        $window.location.href = ''; //redirect to home
      });
    }
  };
}).controller('UserViewController', function($scope, $stateParams, User) {
  $scope.user = User.get({ id_user: $stateParams.id_user }); //Get a single user.Issues a GET to /App/users/:id
})
        .controller('UserCreateController', function($scope, $state, $stateParams, User) {
  $scope.user = new User();  //create new user instance. Properties will be set via ng-model on UI
  $scope.addUser = function() { //create a new user. Issues a POST to /App/users
    $scope.user.$save(function() {
      $state.go('users'); // on success go back to home i.e. users state.
    });
  };
}).controller('UserEditController', function($scope, $state, $stateParams, User) {
  $scope.updateUser = function() { //Update the edited user. Issues a PUT to /App/users/:id
      $scope.user.$update(function() {
      $state.go('users'); // on success go back to home i.e. user state.
    });
  };

  $scope.loadUser = function() { //Issues a GET request to /App/users/:id to get a user to update
    $scope.user = User.get({ id_user: $stateParams.id_user });
  };

  $scope.loadUser(); // Load a user which can be edited on UI
});