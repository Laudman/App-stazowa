//'use strict';

angular.module('mainApp.task.controllers', [])
        .controller('TaskListController', function ($scope, taskConstant, popupService, $window, Task) {
            $scope.tasks = Task.query(); 
    
            $scope.typeOfJob = taskConstant.typeOfJob;

            $scope.deleteTask = function (task) { // Delete a task. Issues a DELETE to /App/tasks/:id
                if (popupService.showPopup('Really delete this?')) {
                    task.$delete(function () {
                        $window.location.href = ''; //redirect to home
                    });
                }
            };
        })
        .controller('TaskViewController', function ($scope, $stateParams, Task) {
            $scope.task = Task.get({id_task: $stateParams.id_task}); //Get a single task.Issues a GET to /App/tasks/:id
        })
        .controller('NewTaskController', function ($scope, $state, Task, $rootScope) {
            $scope.task = new Task();
            $scope.addTask = function () {

                $scope.task.id_user = $rootScope.currentUser.id;

                $scope.task.$save(function () {
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
                ]
            };
        }).controller('TaskEditController', function ($scope, $state, $stateParams, Task) {
    $scope.updateTask = function () { //Update the edited task. Issues a PUT to /App/tasks/:id
        $scope.task.$update(function () {
            $state.go('tasks'); // on success go back to home i.e. task state.
        });
    };

    $scope.loadTask = function () { //Issues a GET request to /App/tasks/:id to get a task to update
        $scope.task = Task.get({id_task: $stateParams.id_task});
    };

    $scope.loadTask(); // Load a task which can be edited on UI
});












//.controller('TypeOfJobController',  function($scope) {
//   $scope.data = {
//    repeatSelect: null,
//    availableOptions: [
//      {id: 1, name: 'Applications developer'},
//      {id: 2, name: 'Database administrator'},
//      {id: 3, name: 'Games developer'},
//      {id: 4, name: 'IT consultant'},
//      {id: 5, name: 'IT technical support officer'},
//      {id: 6, name: 'Network engineer'},
//      {id: 7, name: 'Software tester'},
//      {id: 8, name: 'Web developer'}
//    ]
////    selectedOption: {id: 2,name: 'user'}
//       };
//});
