app.controller("matriculaController", function($scope, $routeParams,$http, matriculaService) {


	$scope.t=new Date()
	
	function novo() {
		$scope.matricula = {};
	}
	$scope.create = function(matricula) {
		matriculaService.salvar(matricula).then(alert(matricula.aluno.nome+" matriculado com sucesso"),function(e){
			alert("Erro ao Salvar");
			console.log(e);
		});
		listar();
		novo();
	};
	
	

	var id = $routeParams.id;
	if (id) {
		matriculaService.getAluno(id).then(function(response) {
			$scope.matricula = response.data;
		});
	} else {
		$scope.matricula = {};

	}
	$scope.turnos = [ {
		nome : 'Matutuino',
		id : 1
	}, {
		nome : 'Verpestino',
		id : 2
	}, {
		nome : 'Nocturno',
		id : 3
	}, ];
	

	listar();
	function listar() {
		matriculaService.listar().then(function(resp) {
			$scope.matriculas = resp.data;
		});
	}
	;
	listarAl();
	function listarAl() {
		matriculaService.listarAlunoo().then(function(resp) {
			$scope.alunoss = resp.data;
		});
	}
	;
	listarTurm();
	function listarTurm() {
		matriculaService.listarTurma().then(function(resp) {
			$scope.turmas = resp.data;
		});
	};
	listarPro();
	function listarPro() {
		matriculaService.listarpro().then(function(resp) {
			$scope.pross = resp.data;
		});
	};
	listarSemes();
	function listarSemes() {
		matriculaService.listarSemese().then(function(resp) {
			$scope.semestress = resp.data;
		});
	};
	
	listarProv();
	function listarProv() {
		matriculaService.listarProvincia().then(function(resp) {
			$scope.pronvicias = resp.data;
		});
	};
	

	$scope.alterar = function(matricula) {
		$scope.matricula.aluno = matricula;
	};

	
});
