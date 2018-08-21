app.controller("ServicosController", 
		function($scope, $http) {
			var urlb = 'http://localhost:8080/tipo';
			$scope.tipoDoc = {};
			var novo = function() {
				$scope.tipoDoc = {};
			}
			$scope.create = function() {
				var metodo = 'POST';
				if ($scope.tipoDoc.id) {
					metodo = 'PUT';
				}
				$http({
					method : metodo,
					url : urlb + '/',
					data : $scope.tipoDoc
				}).then(function successCallback(response) {
					alert("Sucesso");
					$scope.tipoDoclista();
					novo();

				}, function errorCallback(response) {
					alert("Erro");
					console.log(response);
				});
			};
			$scope.alterar = function(tipoDoc) {
				$scope.tipoDoc = tipoDoc;
			};

			$scope.deletar = function(tipoDoc) {
				$scope.tipoDoc = tipoDoc;

				$http({
					method : 'DELETE',
					url : urlb + '/delete/' + $scope.tipoDoc.id,
				}).then(function successCallback(response) {
					alert("deletado");
					$scope.tipoDoclista();
					novo();
				}, function errorCallback(response) {
					alert("Erro");
					console.log(response);
				});
			};
			$scope.tipoDoclista = function() {
				$http({
					method : 'GET',
					url : urlb + '/listar',
				}).then(function successCallback(response) {
					$scope.tipos = response.data;
				}, function errorCallback(response) {
				});
			};
			$scope.tipoDoclista();

		});