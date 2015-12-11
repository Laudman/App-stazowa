angular.module('mainApp.task.services', []).factory('Task', function($resource) {
  return $resource('/tasks/:id_task', { id_task: '@_id_task' }, {
    delete: {
      method: 'POST',
      url: '/tasks/delete/:id_task'
    },
    update: {
      method: 'POST',
      url: '/tasks/update/:id_task'
    }
    });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    };
});
