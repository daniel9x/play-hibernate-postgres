angular.module('myApp.services').factory('Person', function($resource){
  return $resource('/persons/:personId', {})
});