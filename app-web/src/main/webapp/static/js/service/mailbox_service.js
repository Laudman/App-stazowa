angular.module('mainApp.information.services', []).factory('Information', function($resource) {
  return $resource('/informations/:idInformation', { idInformation: '@_idInformation' }, {
    delete: {
      method: 'POST',
      url: '/informations/delete'
    },
    queryMailbox: {
      method: 'GET', isArray: true,
      url: '/informations/:id_user'
    }
    });
});
