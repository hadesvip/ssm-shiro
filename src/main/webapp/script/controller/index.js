/**
 * Created by wangyong on 2016/7/15.
 */
"use strict";

var indexModule = angular.module('indexModule', []);
indexModule.controller('indexController', ['$scope', function ($scope) {
    $scope.data = [
        {id: 1, name: '张三'},
        {id: 2, name: '李四'},
        {id: 3, name: '王五'}
    ];

    $scope.selected = [];
    $scope.updateSelect = function ($event, id) {
        console.log($event);
        var target = $event.target;
        var action = target.checked ? 'add' : 'remove';
        console.log(target);
        console.log(action);

        if (action == 'add' && $scope.selected.lastIndexOf(id) == -1) {
            $scope.selected.push(id);
        }

        if (action == 'remove' && $scope.selected.lastIndexOf(id) != -1) {
            var index = $scope.selected.lastIndexOf(id);
            $scope.selected.splice(index, 1);
        }

        console.log($scope.selected);

    };
}]);
