/**
 * Created by wangyong on 2016/7/17.
 */
'use strict';
loginModule.controller('loginController', ['$scope', '$http', function ($scope, $http) {
    $scope.loginAction = function () {
        var user = {
            username: $scope.username,
            password: $scope.password
        }

        console.log(data.username + "-->" + data.password);

        //参数校验


        $http({
            method: 'POST',
            url: '/login',
            params: user
        }).then(function successCallback(response) {
            var status = response.status;
            var data = response.data;
            response.console.log("success...,status:" + status + "data:" + data)

        }, function errorCallback(response) {

        });

        return false;

    }

}]);