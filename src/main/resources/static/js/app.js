var app = angular.module('myApp', ['ngResource']);

app.controller('ActiveController', ['$scope', '$resource',function($scope,$resource) {
    
	 function fetchAllPersons(){
	        $scope.billable = $resource('http://localhost:8080/Billable'
	        ).query(function(data)
	        		{console.log(data);
	        		return data;});
	        $scope.buffer = $resource('http://localhost:8080/Buffer'
	        ).query(function(data)
	        		{console.log(data);
	        		return data;});
	        $scope.client = $resource('http://localhost:8080/Client'
	        ).query(function(data)
	        		{console.log(data);
	        		return data;});
	        
	    };
	    
	   
   
	    fetchAllPersons();
	    
	    $scope.refresh = function(){
	    	fetchAllPersons();
	    	
	    };
    
   
    
}]);

