app.controller("SemestreController", 
		function($scope, $http) {
			var urlb = 'http://localhost:8080/semestre';
			$scope.semestre = {};
			var novo = function() {
				$scope.semestre = {};
			}
			$scope.create = function() {
				var metodo = 'POST';
				if ($scope.semestre.id) {
					metodo = 'PUT';
				}
				$http({
					method : metodo,
					url : urlb + '/',
					data : $scope.semestre
				}).then(function successCallback(response) {
					alert("Sucesso");
					$scope.semestrelista();
					novo();

				}, function errorCallback(response) {
					alert("Erro");
					console.log(response);
				});
			};
			$scope.alterar = function(semestre) {
				$scope.semestre = semestre;
			};

		

			 function p() {
				$http({
					method : 'GET',
					url : urlb + '/listar',
				}).then(function successCallback(response) {
					$scope.semestres = response.data;
				}, function errorCallback(response) {
				});
			};
			p();
			
			 function disc() {
				$http({
					method : 'GET',
					url : urlb + '/listaDisciplina',
				}).then(function successCallback(response) {
					$scope.disciplinas = response.data;
				}, function errorCallback(response) {
				});
			};
			 disc();
		});