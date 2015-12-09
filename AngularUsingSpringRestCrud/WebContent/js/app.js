(function(){
	"use strict";
	// Main Module Creation
	angular.module("DemoApp", []);
	
	angular.module("DemoApp").controller("EmployeeCtrl", ['$scope', EmployeeCtrl]);
	
	function EmployeeCtrl($scope){
		$scope.name = "Pankaj";
		console.log("myname == "+$scope.name);
	}
	
	
}());
