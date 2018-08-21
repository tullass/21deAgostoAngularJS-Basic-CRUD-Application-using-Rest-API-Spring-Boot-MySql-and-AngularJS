(function(angular) {
  'use strict';
  app.controller("ReportFaController", 
			function($scope, $http) {
				var urlb = 'http://localhost:8080/fatura';
				var cont = 0; $scope.record=[];
				var formatStr = 'DD/MM/YYYY';
			    $scope.de = moment("2017-04-05").format(formatStr);
			  $scope.ate = moment("2019-04-29").format(formatStr);  
			  $scope.pageNumber=5;	
				$scope.prestacao = [ {
					nome : '5',
					pageNumber : 5
				}, {
					nome : '10',
					pageNumber : 10
				}, {
					nome : '20',
					pageNumber : 20
				}, {
					nome : '50',
					pageNumber : 50
				}, {
					nome : '100',
					pageNumber : 100
				}];
				
				function todos() {
					$http({
						method : 'GET',
						url : urlb + '/listarTodos',
					}).then(function successCallback(response) {
						$scope.record = response.data;
					}, function errorCallback(response) {
					});
				};
				todos();
				 function turma() {
					$http({
						method : 'GET',
						url : urlb + '/turmas',
					}).then(function successCallback(response) {
						$scope.turmass = response.data;
					}, function errorCallback(response) {
					});
				};
				turma();
				
				 $scope.getTotal = function(type) {
				        var total = 0;
				        angular.forEach($scope.record, function(el) {
				            total += el[type]*1;
				            console.log(total);
				        });
				        return total;
				    };
				
			
			 }).filter('dateRangerrr', function() {
			    var formatStr = 'DD/MM/YYYY';
			    return function(produceList, fromDate, toDate) {    
			      if(fromDate && toDate){
			        var filtered = [];
			        angular.forEach(produceList, function(items) {
			         			            if (items.datainicio > Date.parse(moment(fromDate, formatStr)) && items.datafim< Date.parse(moment(toDate, formatStr)))
			                filtered.push(items);
			        });
			        return filtered;
			      }
			      else
			        return produceList;
			}})
})(window.angular);