angular.module('userApp.services', []).factory('User', function($resource) {
  return $resource('/users/:id_user', { id_user: '@_id_user' }, {
    delete: {
      method: 'POST',
      url: '/users/delete/:id_user'
    },
    update: {
      method: 'POST',
      url: '/users/update/:id_user'
    }
    });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});