app.controller("tabelaController",
		function($scope, $routeParams, tabelaService) {

			var id = $routeParams.id;
			if (id) {
				bancoService.getBanco(id).then(function(res) {
					$scope.banco = res.data;
				});
			} else {
				$scope.banco = {};

			}
			listar();
			function listar() {
				tabelaService.listar().then(function(resp) {
					$scope.bancos = resp.data;
				});
			}
			;

			$scope.alterar = function(banco) {
				$scope.banco = banco;
			};

		});
		 
