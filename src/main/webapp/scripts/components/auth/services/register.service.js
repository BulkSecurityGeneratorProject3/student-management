'use strict';

angular.module('studentmanagementApp')
    .factory('Register', function ($resource) {
        return $resource('api/register', {}, {
        });
    });


