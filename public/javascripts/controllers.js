var app = angular.module('myApp', ['ngResource']);

app.controller('PersonsCtrl', function($scope, $http, Persons) {
	
	$scope.selectedPersonId = null;

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
	
	$scope.setSelected = function (personId) {
    	$scope.selectedPersonId = personId;
    	$scope.successMessages = [ $scope.selectedPersonId ];
    }
	
});

app.factory('Persons', function($resource){
	return $resource('/persons/:personId', {})
});