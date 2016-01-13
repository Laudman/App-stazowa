//'use strict';

angular.module('app.services').factory('User', function ($resource) {
    return $resource('user/:id', {id_user: '@_id'}, {
        save:{
            method:'POST',
            url: '/user/register'
        },
        delete: {
            method: 'POST',
            url: '/user/delete/:id'
        },
        update: {
            method: 'POST',
            url: '/user/update/:id'
            
        }
        
    });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
        };
});

