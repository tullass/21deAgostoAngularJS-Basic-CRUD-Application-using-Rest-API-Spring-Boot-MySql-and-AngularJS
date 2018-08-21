app.controller("notaListaController",
		function($scope, $routeParams, nListaService) {

			var id = $routeParams.id;
			if (id) {
				nListaService.getBanco(id).then(function(res) {
					$scope.professor = res.data;
				});
			} else {
				$scope.professor = {};

			};
			
			listar();
			function listar() {
				nListaService.listar().then(function(resp) {
					$scope.alunos = resp.data;
				});
			};
			$scope.limpar=function(){
					$scope.search={};		};
			listarSemd();
			function listarSemd() {
				nListaService.listarSemee().then(function(resp) {
					$scope.semestress = resp.data;
				});
			};
			
			listarTemd();
			function listarTemd() {
				nListaService.listarTurm().then(function(resp) {
					$scope.turmas = resp.data;
				});
			};

		});
		 
