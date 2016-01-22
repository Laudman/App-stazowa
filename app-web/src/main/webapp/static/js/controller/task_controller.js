//'use strict';

angular.module('mainApp.task.controllers', [])
        .controller('TaskListController', function($scope, $rootScope, popupService, $window, Task, taskConstant) {
  $scope.tasks = Task.query({id_user: $rootScope.currentUser.id});
  
  $scope.typeOfJobs = taskConstant.typeOfJob;
  $scope.typeOfQuestions = taskConstant.typeOfQuestion;
  $scope.typeOfSpeaks = taskConstant.typeOfSpeak;
  
  $rootScope.currentTask = "";
  $scope.deleteTask = function(task) { 
    if (popupService.showPopup('Really delete this?')) {
         task.$delete(function() {
        $window.location.href = ''; 
      });
    }
  };
}).controller('TaskListJoinController', function($scope, $rootScope, Task, taskConstant) {
  $scope.tasks = Task.queryForSubs({id_user: $rootScope.currentUser.id});
  
  $scope.typeOfJobs = taskConstant.typeOfJob;
  $scope.typeOfQuestions = taskConstant.typeOfQuestion;
  $scope.typeOfSpeaks = taskConstant.typeOfSpeak;

      
}).controller('TaskViewController', function($scope, $stateParams, Task, $rootScope, taskConstant) {
  $scope.task = Task.get({ id_task: $stateParams.id_task });
  $scope.typeOfJobs = taskConstant.typeOfJob;
  $scope.typeOfQuestions = taskConstant.typeOfQuestion;
  $scope.typeOfSpeaks = taskConstant.typeOfSpeak;
  Task.get({ id_task: $stateParams.id_task }, function(task) {
            $rootScope.currentTask = task;
            });

})
  .controller('NewTaskController', function($scope, $state, Task, $rootScope) {
  $scope.task = new Task();  
  $scope.addTask = function() { 
      
    $scope.task.id_user = $rootScope.currentUser.id;
    $scope.task.addDate = new Date();
    
    $scope.task.$save(function() {
      $state.go('/'); 
    });  
  };
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
}).controller('TaskEditController', function($scope, $state, $stateParams, Task) {
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
    ]
       };
  $scope.updateTask = function() { 
      $scope.task.$update(function() {
      $state.go('home'); 
    });
    
  };

  $scope.loadTask = function() { 
    $scope.task = Task.get({ id_task: $stateParams.id_task });
  };

  $scope.loadTask(); 
});