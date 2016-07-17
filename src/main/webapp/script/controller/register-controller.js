/**
 * Created by wangyong on 2016/7/16.
 */
'use strict';

//define registerController controller
registerModule.controller('registerController', ['$scope', '$http', '$window', function ($scope, $http, $window) {


    $scope.registerAction = function () {

        var user = {
            username: this.username,
            password: this.password,
            repassword: this.repassword
        };

        //console.log(user);
        //$scope.tip = 'hello angular...';
        // angular.element(document.querySelector("#tipModal")).modal('show');

        console.log(user.username);
        console.log(user.password);
        console.log(user.repassword);
        //验证参数
        if (user.username == undefined || user.username == "") {
            $scope.text = '用户名必填..';
            $("#tipModal").modal('show');
            return;
        }
        if (user.password == undefined || user.password == "") {
            $scope.text = '密码必填..';
            $("#tipModal").modal('show');
            return;
        }
        if (user.password != user.repassword) {
            $scope.text = '两次输入的密码不一致...';
            $("#tipModal").modal('show');
            return;
        }

        $http({
            method: 'POST',
            url: '/register',
            params: user
        }).then(function successCallback(response) {
            var data = response.data;

            if (data.resultCode == 'INVAILDPARAM') {
                $scope.text = data.resultMsg;
                $("#tipModal").modal('show');
                return;
            }
            if (data.resultCode == 'USEREXIST') {
                $scope.text = data.resultMsg;
                $("#tipModal").modal('show');
                return;
            }
            if (data.resultCode == 'USEREXIST') {
                $scope.text = data.resultMsg;
                $("#tipModal").modal('show');
                return;
            }
            if (data.resultCode == 'OK') {
                $window.location.href = '/static/login.html';
                return;
            }


        }, function errorCallback(response) {

        });


        return false;

    }

    /* $scope.showModal = false;
     $scope.registerAction = function(){
     $scope.showModal = !$scope.showModal;
     };
     */

    /*   registerModule.directive('modal', function () {
     return {
     template: '<div class="modal fade">' +
     '<div class="modal-dialog">' +
     '<div class="modal-content">' +
     '<div class="modal-header">' +
     '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>' +
     '<h4 class="modal-title">{{ title }}</h4>' +
     '</div>' +
     '<div class="modal-body" ng-transclude></div>' +
     '</div>' +
     '</div>' +
     '</div>',
     restrict: 'E',
     transclude: true,
     replace: true,
     scope: true,
     link: function postLink(scope, element, attrs) {
     scope.title = attrs.title;

     scope.$watch(attrs.visible, function (value) {
     if (value == true)
     $(element).modal('show');
     else
     $(element).modal('hide');
     });

     $(element).on('shown.bs.modal', function () {
     scope.$apply(function () {
     scope.$parent[attrs.visible] = true;
     });
     });

     $(element).on('hidden.bs.modal', function () {
     scope.$apply(function () {
     scope.$parent[attrs.visible] = false;
     });
     });
     }
     };
     });*/

}]);

/*
 registerModule.directive('modal', function () {
 return {
 template: '<div class="modal fade">' +
 '<div class="modal-dialog">' +
 '<div class="modal-content">' +
 '<div class="modal-header">' +
 '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>' +
 '<h4 class="modal-title">{{ title }}</h4>' +
 '</div>' +
 '<div class="modal-body" ng-transclude></div>' +
 '</div>' +
 '</div>' +
 '</div>',
 restrict: 'E',
 transclude: true,
 replace: true,
 scope: true,
 link: function postLink(scope, element, attrs) {
 scope.title = attrs.title;

 scope.$watch(attrs.visible, function (value) {
 if (value == true)
 $(element).modal('show');
 else
 $(element).modal('hide');
 });

 $(element).on('shown.bs.modal', function () {
 scope.$apply(function () {
 scope.$parent[attrs.visible] = true;
 });
 });

 $(element).on('hidden.bs.modal', function () {
 scope.$apply(function () {
 scope.$parent[attrs.visible] = false;
 });
 });
 }
 };
 });*/
