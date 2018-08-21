app.controller("classeController", function($scope, nivelService) {

	function novo() {
		$scope.nivel = {};
	}
	$scope.create = function(nivel) {
		nivelService.salvar(nivel).then(alert("Classe SaLva com Sucesso"));

		novo();listar();
	};
	listar();
	function listar() {
		nivelService.listar().then(function(resp) {
			$scope.nivels = resp.data;
		});
	}
	;

	$scope.alterar = function(nivel ) {
		$scope.nivel = nivel;
	};
	
$scope.cal=function(){
var r=0;
var r=$scope.nivel.valor*9;
$scope.nivel.esperado=r;
};

});
