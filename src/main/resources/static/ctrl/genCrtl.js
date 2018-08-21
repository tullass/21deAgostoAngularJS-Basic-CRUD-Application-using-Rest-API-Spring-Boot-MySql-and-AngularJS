app.controller("genController", function($scope, $routeParams,$http, genService) {

	
	




	listar();
	function listar() {
		genService.listarA().then(function(resp) {
			$scope.al= resp.data;
		});
	}
	;
	listarTurm();
	function listarTurm() {
		genService.listarT().then(function(resp) {
			$scope.tu = resp.data;
		});
	};
	listarMa();
	function listarMa() {
		genService.listarM().then(function(resp) {
			$scope.ma = resp.data;
		});
	};
	
	

});
