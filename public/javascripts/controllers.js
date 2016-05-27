var app = angular.module('myApp', ['ngResource']);

app.controller('PersonsCtrl', function($scope, $http, Persons) {

	$scope.refresh = function() {
		console.log("Refresh!");
		$scope.persons = Persons.query();
	}
	
	$scope.refresh();

	$scope.register = function() {
		console.log("Register!");
		console.log($scope.person.name);
		$http.post("/",$scope.person.name);
	}
});

app.factory('Persons', function($resource){
	return $resource('/persons/:personId', {})
});