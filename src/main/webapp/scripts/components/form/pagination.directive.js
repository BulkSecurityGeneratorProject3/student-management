/* globals $ */
'use strict';

angular.module('studentmanagementApp')
    .directive('studentmanagementAppPagination', function() {
        return {
            templateUrl: 'scripts/components/form/pagination.html'
        };
    });
