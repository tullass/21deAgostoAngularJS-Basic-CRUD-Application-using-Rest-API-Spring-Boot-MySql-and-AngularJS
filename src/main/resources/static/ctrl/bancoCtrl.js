app.controller("bancooController",
		function($scope, $routeParams, bancoService) {

			function novo() {
				$scope.banco = {};
			}
			$scope.create = function(banco) {
				bancoService.salvar(banco).then(alert("Sallvo com Sucesso"));

				novo();
			};
			var id = $routeParams.id;
			if (id) {
				bancoService.getBanco(id).then(function(response) {
					$scope.banco = response.data;
				});
			} else {
				$scope.banco = {};

			}
		});
