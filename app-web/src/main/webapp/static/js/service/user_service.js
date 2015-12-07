angular.module('userApp.services', []).factory('User', function($resource) {
  return $resource('users/:id_user', { id_user: '@_id_user' }, {
    update: {
      method: 'PUT'
          }
    });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});