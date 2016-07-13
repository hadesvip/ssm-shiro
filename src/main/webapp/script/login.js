/**
 * Created by wangyong on 2016/7/13.
 */

var loginModule = angular.module('loginModule', []);
loginModule.controller('loginCtrl', ['$scope', '$http', function ($scope, $http) {

    $scope.loginAction = function () {

        var data = {
            username: $scope.username,
            password: $scope.password
        }

        console.log(data.username + "-->" + data.password);

        $http({
            method: 'POST',
            url: '/login',
            params: data
        }).then(function successCallback(response) {
            var status = response.status;
            var data = response.data;
            response.console.log("success...,status:" + status + "data:" + data)

        }, function errorCallback(response) {

        });

    }

}]);
