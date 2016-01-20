
angular.module('mainApp.subscribe.controllers', [])
        .controller('SubscribeListController', function($scope, $window, Subscribe) {
  $scope.subscribes = Subscribe.query(); 
  $scope.deleteSubscribe = function(subscribe) { 
         subscribe.$delete(function() {
        $window.location.reload(true);
      });
    
  };
            
}).controller('NewSubscribeController', function($scope, $window, Subscribe, $rootScope) {

    
    $scope.isSubscribed = function (task) {
                if (task.subscribed) {
                        $scope.subscribed = new Subscribe();
                        $scope.subscribed.idUserSubscribe = $rootScope.currentUser.id;
                        $scope.subscribed.idTask = task.id_task;
                        $scope.subscribed.$save(function() {
                        $window.location.reload(true);
                        });
                    };
                if (!task.subscribed){
                        $scope.subscribed = new Subscribe();
                        $scope.subscribed.idUserSubscribe = $rootScope.currentUser.id;
                        $scope.subscribed.idTask = task.id_task;
                        $scope.subscribed.$delete(function() {
                        $window.location.reload(true);
                    });
                };
                
                
}});






