'use strict';

angular.module('studentmanagementApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('student', {
                parent: 'entity',
                url: '/student',
                data: {
                    roles: ['ROLE_USER'],
                    pageTitle: 'studentmanagementApp.student.home.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/student/students.html',
                        controller: 'StudentController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('student');
                        return $translate.refresh();
                    }]
                }
            })
            .state('studentDetail', {
                parent: 'entity',
                url: '/student/:id',
                data: {
                    roles: ['ROLE_USER'],
                    pageTitle: 'studentmanagementApp.student.detail.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/student/student-detail.html',
                        controller: 'StudentDetailController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('student');
                        return $translate.refresh();
                    }]
                }
            });
    });
