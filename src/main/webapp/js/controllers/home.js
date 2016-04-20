'use strict';


SMSys.app.controllers.controller("homeCtrl", ['$scope', '$timeout', '$http', function ($scope, $timeout, $http) {

    $scope.labels = ["January", "February", "March", "April", "May", "June", "July"];
    $scope.series = ['Series A', 'Series B'];
    $scope.data = [
        [65, 59, 80, 81, 56, 55, 40],
        [28, 48, 40, 19, 86, 27, 90]
    ];
    $scope.onClick = function (points, evt) {
        console.log(points, evt);
    };

    $scope.getData = function(callbackFunc) {
        $http({
            method: 'GET',
            url: '/smsys/dwr/chart',
            params: 'limit=10',
            headers: {'Authorization': 'Token token=xxxxYYYYZzzz'}
        }).success(function(data){
            // With the data succesfully returned, call our callback
            callbackFunc(data);
        }).error(function(){
            alert("error");
        });
    };

    $scope.getData(function(data) {
       console.info(data);
    });

}]);
