//'use strict';

angular.module('mainApp.task.services', []).factory('Task', function($resource) {
  return $resource('/tasks/:id_task', { id_task: '@_id_task' }, {
      
    queryGuest:{
        method: 'GET', isArray: true,
        url:'/tasks/guest'
    },
    queryForSubs:{
        method: 'GET', isArray: true,
        url:'/tasks/submited/:id_user'
    },
    query:{
        method: 'GET', isArray: true,
        url:'/tasks/:id_user'
    },
    get:{
        method: 'GET',
        url:'/tasks/task/:id_task'
    },
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
