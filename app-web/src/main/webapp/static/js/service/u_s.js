angular.module('userApp.services', []).factory('User', function($resource) {
  return $resource('/App/users/:id', { id: '@_id' }, {
    update: {
      method: 'PUT'
    }
  });
});