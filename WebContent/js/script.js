// Code goes here

var app = angular.module('app', ['ngRoute']);

app.config(['$routeProvider', function($routeProvider){
  $routeProvider.when('/', {
    templateUrl : "view/conversion.html",
    controller : "homectrl"
  })
  .when('/conversion', {
    templateUrl : "view/conversion.html",
    controller : "homectrl"
  })
  .when('/studentservice', {
    templateUrl : "view/student.html",
    controller : "homectrl"
  })
}]);

app.controller('homectrl', function($scope, $http){
  $scope.feet = 1;
  $scope.inch = 12;
  var x2js = new X2JS();
  $scope.convertofeet = function(inch){
	  $http.get("/RestFulDemo/rest/ConversionService/InchToFeet/"+inch).success(function(response){
		  $scope.feet_result = JSON.stringify(x2js.xml_str2json(response));
	  });
  }
  $scope.convertoinch = function(feet){
	  $http.get("/RestFulDemo/rest/ConversionService/FeetToInch/"+feet).success(function(response){
		  $scope.inch_result = JSON.stringify(x2js.xml_str2json(response));
	  });
  }
});