//'use strict';

angular.module('mainApp.answer.services', []).factory('Answer', function($resource) {
  return $resource('/answers/:id_answer', { id_answer: '@_id_answer' }, {
    
    delete: {
      method: 'POST',
      url: '/answers/delete/:id_answer'
    },
    update: {
      method: 'POST',
      url: '/answers/update/:id_answer'
    }
    });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    };
});

