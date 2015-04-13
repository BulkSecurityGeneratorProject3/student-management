'use strict';

angular.module('studentmanagementApp')
    .controller('StudentController', function ($scope, Student) {
        $scope.students = [];
        $scope.loadAll = function() {
            Student.query(function(result) {
               $scope.students = result;
            });
        };
        $scope.loadAll();

        $scope.create = function () {
            Student.update($scope.student,
                function () {
                    $scope.loadAll();
                    $('#saveStudentModal').modal('hide');
                    $scope.clear();
                });
        };

        $scope.update = function (id) {
            Student.get({id: id}, function(result) {
                $scope.student = result;
                $('#saveStudentModal').modal('show');
            });
        };

        $scope.delete = function (id) {
            Student.get({id: id}, function(result) {
                $scope.student = result;
                $('#deleteStudentConfirmation').modal('show');
            });
        };

        $scope.confirmDelete = function (id) {
            Student.delete({id: id},
                function () {
                    $scope.loadAll();
                    $('#deleteStudentConfirmation').modal('hide');
                    $scope.clear();
                });
        };

        $scope.clear = function () {
            $scope.student = {FirstName: null, LastName: null, id: null};
            $scope.editForm.$setPristine();
            $scope.editForm.$setUntouched();
        };
    });
