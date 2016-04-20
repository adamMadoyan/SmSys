'use strict';


SMSys.app.controllers.controller("homeCtrl", ['$scope', '$timeout', '$http', function ($scope, $timeout, $http) {

    $scope.labels = ["January", "February", "March", "April", "May", "June", "July", "June", "August", "September", "October", "November", "December"];
    $scope.series = [];
    $scope.data = [];
    $scope.onClick = function (points, evt) {
        console.log(points, evt);
    };

    $scope.getData = function (callbackFunc) {
        $http({
            method: 'GET',
            url: '/smsys/dwr/chart',
            params: 'limit=10',
            headers: {'Authorization': 'Token token=xxxxYYYYZzzz'}
        }).success(function (data) {
            // With the data succesfully returned, call our callback
            callbackFunc(data);
        }).error(function () {
            alert("error");
        });
    };

    $scope.getData(function (data) {
        angular.forEach(data, function (value, key) {
            var index = $scope.series.indexOf(value.type);
            if(index === -1) {
                $scope.series.push(value.type);
                $scope.data.push([]);
            }
            index = $scope.series.indexOf(value.type);
            console.info('index', index);
            $scope.data[index].push(value.value);
        });
    });

}]);
