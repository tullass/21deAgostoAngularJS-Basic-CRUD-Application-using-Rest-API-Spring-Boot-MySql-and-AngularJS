app.controller("avaliacoesController", function($scope, $routeParams,$http, avaliacoesService) {


	$scope.t=new Date()
	
	function novo() {
		$scope.avaliacoes = {};
	}
	$scope.create = function(avaliacoes) {
		avaliacoesService.salvar(avaliacoes).then(alert("Avaliacao registrada com sucesso"),function(e){
			alert("Erro ao Salvar");
			console.log(e);
		});
		listar();
		novo();
	};
	
	   $scope.testBool1 = true;	  
	   
	   $scope.testBool2 = false;

	  
			

	var id = $routeParams.id;
	if (id) {
		avaliacoesService.getAluno(id).then(function(response) {
			$scope.avaliacoes = response.data;
		});
	} else {
		$scope.avaliacoes = {};

	}
	

	listar();
	function listar() {
		avaliacoesService.listar().then(function(resp) {
			$scope.avaliacoess = resp.data;
		});
	}
	;
	listarAl();
	function listarAl() {
		avaliacoesService.listarTodos().then(function(resp) {
			$scope.alunos = resp.data;
		});
	}
	;
	listarTurm();
	function listarTurm() {
		avaliacoesService.listarTurma().then(function(resp) {
			$scope.turmas = resp.data;
		});
	};
	listarPro();
	function listarPro() {
		avaliacoesService.listarpro().then(function(resp) {
			$scope.pross = resp.data;
		});
	};
	listarSemes();
	function listarSemes() {
		avaliacoesService.listarSemese().then(function(resp) {
			$scope.semestress = resp.data;
		});
	};
	

	$scope.alterar = function(avaliacoes) {
		
		$scope.avaliacoes = avaliacoes;
		alert('Avaliacao do <'+avaliacoes.trimestre.descricao+'> pronta para edicao');
	};
	

	
});
