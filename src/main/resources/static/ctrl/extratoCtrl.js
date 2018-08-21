app.controller("extratoController", 
		function($scope, $http) {
			var urlb = 'http://localhost:8080/extrato';
			
			

			 function p() {
				$http({
					method : 'GET',
					url : urlb + '/listar',
				}).then(function successCallback(response) {
					$scope.extratos = response.data;
				}, function errorCallback(response) {
				});
			};
			p();
			  $scope.aa= function(a) {
		        	$http.get(urlb+'/pdf/'+a.id, {responseType: 'arraybuffer'}).success(function(data){
		        		var file=new Blob([data],{type: 'application/pdf'});
		        		var fileUrl=URL.createObjectURL(file);
		        		window.open(fileUrl, '_black')
		        	})
					};
					
			
		});