app.controller("disciplinaControlle", function($scope,  $http
		) {
			var urlb = 'http://localhost:8080/disciplina';
			
			$scope.disciplina = {};
			var novo = function() {
				$scope.disciplina = {};
			}
			$scope.create = function() {
				var metodo = 'POST';
				if ($scope.disciplina.id) {
					metodo = 'PUT';
				}
				$http({
					method : metodo,
					url : urlb + '/',
					data : $scope.disciplina
				}).then(function successCallback(response) {
					alert("Sucesso");
					$scope.disciplinalista();
					novo();

				}, function errorCallback(response) {
					alert("Erro");
					console.log(response);
				});
			};
			$scope.alterar = function(disciplina) {
				$scope.disciplina = disciplina;
			};

			$scope.deletar = function(disciplina) {
				$scope.disciplina = disciplina;

				$http({
					method : 'DELETE',
					url : urlb + '/delete/' + $scope.disciplina.id,
				}).then(function successCallback(response) {
					alert("deletado");
					$scope.disciplinalista();
					novo();
				}, function errorCallback(response) {
					alert("Erro");
					console.log(response);
				});
			};
			$scope.disciplinalista = function() {
				$http({
					method : 'GET',
					url : urlb + '/listar',
				}).then(function successCallback(response) {
					$scope.disciplinas = response.data;
				}, function errorCallback(response) {
				});
			};
			$scope.disciplinalista();

		});