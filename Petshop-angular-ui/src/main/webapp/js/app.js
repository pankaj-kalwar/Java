(function(){
	"use strict";
	// Main Module Creation
	angular.module("DemoApp", []);
	
	angular.module("DemoApp").controller("EmployeeCtrl", ['$scope', function EmployeeCtrl($scope){
		$scope.name = "Pankaj";
		console.log("myname == "+$scope.name);
	}]);
	
	angular.module("DemoApp2", []);
	
	angular.module("DemoApp2").controller("EmployeeCtrl1", ['$scope', 'EmployeeService', function EmployeeCtrl($scope, EmployeeService){
		$scope.name1 = "Pankaj1";
		$scope.dataFromService = EmployeeService();
		console.log("myname in EmployeeCtrl1 == "+$scope.name);
	}]);
	
	
	// Services
	angular.module("DemoApp2").factory("EmployeeService", function(){
		//var name = "abc";
		return function(){
			return "Value From Service";
		};
		
		var function1 = function(){
			return name;
		};
		return{
			function1 : function1
		};
	});
	
	/*angular.element(document).ready(function(){
		// Bootstrapping angular application
		angular.bootstrap(document, ["DemoApp", "DemoApp2"]);
	});*/
}());

