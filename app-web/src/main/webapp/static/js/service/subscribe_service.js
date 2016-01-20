angular.module('mainApp.subscribe.services', []).factory('Subscribe', function($resource) {
  return $resource('/subscribes/:idSub', { idSub: '@_idSub' }, {
    delete: {
      method: 'POST',
      url: '/subscribes/delete'
    },
    save: {
      method: 'POST',
      url: '/subscribes/:idSub'
    }
    });
});

