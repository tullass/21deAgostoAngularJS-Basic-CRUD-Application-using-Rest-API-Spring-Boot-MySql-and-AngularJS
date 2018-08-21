app.controller("pagamentoController", function($scope, $routeParams,$http, pagamentoService) {

	
	function novo() {
		$scope.pagamento = {};
	}
	$scope.create = function(pagamento) {
		pagamentoService.salvar(pagamento).then(alert("Despesa <"+pagamento.descricao+"> Salvo com Sucesso"),function(e){
			alert("Erro ao Salvar");
			console.log(e);		listar();

		});
		listar();
		novo();
	};

	var id = $routeParams.id;
	if (id) {
		pagamentoService.getAluno(id).then(function(response) {
			$scope.pagamento = response.data;
		});
	} else {
		$scope.pagamento = {};

	}
	
	

	listar();
	function listar() {
		pagamentoService.listar().then(function(resp) {
			$scope.pagamentos = resp.data;
		});
	};
	
});
