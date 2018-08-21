app.controller("notaoController", function($scope,$http, $routeParams,
		avaliacoesService) {

	$scope.t = new Date()
	$scope.m = false;
	function novo() {
		$scope.avaliacoes = {};
	}
	$scope.create = function(avaliacoes) {
		avaliacoesService.salvar(avaliacoes).then(
				alert(" Avaliacao registrada com sucesso"), function(e) {
					alert("Erro ao Salvar");
					console.log(e);
				});
		listar();
		novo();
	};
	

	var id = $routeParams.id;
	if (id) {
		avaliacoesService.getAluno(id).then(function(response) {
			$scope.avaliacoes = response.data;
			if($scope.avaliacoes!=null){
				$scope.s=true;
			}
		});
	} else {
		$scope.avaliacoes = {};

	};
	 $scope.aa= function(a) {	       	

	       	$http.get('http://localhost:8080/avaliacao/pdf/'+a.matricula.id, {responseType: 'arraybuffer'}).success(function(data){
	       		var file=new Blob([data],{type: 'application/pdf'});
	       		var fileUrl=URL.createObjectURL(file);
	       		window.open(fileUrl, '_black')
	       	})
				};
	listar();
	function listar() {
		avaliacoesService.listar().then(function(resp) {
			$scope.avaliacoess = resp.data;
		});
	}
	;
	 $scope.listarAl=function() {
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
	}
	;
	listarPro();
	function listarPro() {
		avaliacoesService.listarpro().then(function(resp) {
			$scope.pross = resp.data;
		});
	}
	;
	listarSemes();
	function listarSemes() {
		avaliacoesService.listarSemese().then(function(resp) {
			$scope.semestress = resp.data;
		});
	}
	;

	$scope.alterar = function(avaliacoes) {

		$scope.avaliacoes.matricula = avaliacoes;
		alert('Avaliacao do <' + avaliacoes.matricula.aluno.nome
				+ '> pronta para edicao');
	};

});
