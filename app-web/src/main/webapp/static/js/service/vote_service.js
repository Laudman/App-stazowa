angular.module('mainApp.vote.services', []).factory('Vote', function($resource) {
  return $resource('/votes/:id_vote', { id_vote: '@_id_vote' }, {
    
    save: {
      method: 'POST',
      url: '/votes/:id_vote'
    }
    });
});
