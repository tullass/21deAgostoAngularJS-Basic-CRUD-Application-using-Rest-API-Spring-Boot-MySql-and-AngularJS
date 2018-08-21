app.controller("cargoController", 
		function($scope, $http) {
			var urlb = 'http://localhost:8080/cargo';
			$scope.cargos = {};
			var novo = function() {
				$scope.cargos = {};
			}
			$scope.create = function() {
				var metodo = 'POST';
				if ($scope.cargos.id) {
					metodo = 'PUT';
				}
				$http({
					method : metodo,
					url : urlb + '/',
					data : $scope.cargos
				}).then(function successCallback(response) {
					alert("Sucesso");
					$scope.cargoslista();
					novo();

				}, function errorCallback(response) {
					alert("Erro");
					console.log(response);
				});
			};
			$scope.alterar = function(cargos) {
				$scope.cargos = cargos;
			};

			
			$scope.cargoslista = function() {
				$http({
					method : 'GET',
					url : urlb + '/listar',
				}).then(function successCallback(response) {
					$scope.tipos = response.data;
				}, function errorCallback(response) {
				});
			};
			$scope.cargoslista();

		});