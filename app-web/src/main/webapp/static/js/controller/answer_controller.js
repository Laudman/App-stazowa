
angular.module('mainApp.answer.controllers', [])
        .controller('AnswerListController', function($scope, $state, $stateParams, popupService, Task, $window, Answer) {
  $scope.answers = Answer.query(); 
  Task.get({ id_task: $stateParams.id_task }, function(task) {
            $scope.currentTask = task;
            });
            
            $scope.deleteAnswer = function(answer) {
    if (popupService.showPopup('Really delete this?')) {
         answer.$delete(function() {
        $state.go("home");
      });
    }
  };
 
 
}).controller('AnswerViewController', function($scope, $stateParams, Answer) {
  $scope.answer = Answer.get({ id_answer: $stateParams.id_answer }); 
})
  .controller('NewAnswerController', function($scope, $state, Answer, $rootScope) {
  $scope.answer = new Answer();  
  $scope.addAnswer = function() { 
      
    $scope.answer.id_user = $rootScope.currentUser.id;
    $scope.answer.id_task = $rootScope.currentTask.id_task;
    
    $scope.answer.$save(function() {
      $state.go("showRequest",{id_task: $scope.answer.id_task}); 
    });  
  };

}).controller('AnswerEditController', function($scope, popupService, $rootScope, $state, $stateParams, Answer, Vote) {
  $scope.updateAnswer = function() { 
      $scope.answer.$update(function() {
      $state.go("showRequest",{id_task: $scope.answer.id_task});
    });
  };
//  $scope.upVote = function (answer) {
//        $scope.vote = new Vote();
//        $scope.vote.id_user = $rootScope.currentUser.id;
//        $scope.vote.id_answer = answer.id_answer;
//        $scope.vote.votePkt = 1;
//        $scope.vote.$save;
//    };
//
//    $scope.downVote = function () {
//        $scope.vote--;
//    };
  $scope.deleteAnswer = function(answer) {
    if (popupService.showPopup('Really delete this?')) {
         answer.$delete(function() {
        $state.go("showRequest",{id_task: $scope.answer.id_task});
      });
    }
  };
  
  $scope.loadAnswer = function() {
    $scope.answer = Answer.get({ id_answer: $stateParams.id_answer });
  };

  $scope.loadAnswer(); 
})

//.controller('VoteCtrl', function ($scope) {
//    
//    $scope.upVote = function () {
//        $scope.vote = new Vote();
//    };
//
//    $scope.downVote = function () {
//        $scope.vote--;
//    };
//
////    $scope.vote = 0;
//});

