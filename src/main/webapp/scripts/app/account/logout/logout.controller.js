'use strict';

angular.module('studentmanagementApp')
    .controller('LogoutController', function (Auth) {
        Auth.logout();
    });
