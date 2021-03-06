
angular.module('mainApp.vote.controllers', [])
        .controller('VoteListController', function($scope, Vote) {
  $scope.votes = Vote.query(); 
  
            
}).controller('VoteViewController', function($scope, $stateParams, Vote) {
  $scope.vote = Vote.get({ id_answer: $stateParams.id_answer }); 
})
  .controller('NewVoteController', function($scope, $window, Vote, $rootScope) {

$scope.upVote = function (answer) {
        $scope.vote = new Vote();
        $scope.vote.id_user = $rootScope.currentUser.id;
        $scope.vote.id_answer = answer.id_answer;
        $scope.vote.votePkt = 1;
        $scope.vote.$save(function() {
//      $state.go("showRequest",{id_task: $scope.answer.id_task});
        $window.location.reload(true);
    });
    };

    $scope.downVote = function (answer) {
        $scope.vote = new Vote();
        $scope.vote.id_user = $rootScope.currentUser.id;
        $scope.vote.id_answer = answer.id_answer;
        $scope.vote.votePkt = -1;
        $scope.vote.$save(function() {
        $window.location.reload(true);
    });
    };
})
.controller('NewVoteTaskController', function($scope, $window, Vote, $rootScope) {

$scope.upVote = function (task) {
        $scope.vote = new Vote();
        $scope.vote.id_user = $rootScope.currentUser.id;
        $scope.vote.id_task = task.id_task;
        $scope.vote.votePkt = 1;
        $scope.vote.$save(function() {
//      $state.go("showRequest",{id_task: $scope.answer.id_task});
        $window.location.reload(true);
    });
    };

    $scope.downVote = function (task) {
        $scope.vote = new Vote();
        $scope.vote.id_user = $rootScope.currentUser.id;
        $scope.vote.id_task = task.id_task;
        $scope.vote.votePkt = -1;
        $scope.vote.$save(function() {
        $window.location.reload(true);
    });
    };
});

 



