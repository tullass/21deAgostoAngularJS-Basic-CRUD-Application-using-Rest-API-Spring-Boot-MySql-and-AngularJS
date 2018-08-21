app.controller("professorController", function($scope, $routeParams, $http,
		professorService) {

	$scope.novo=function() {
		$scope.professor = {};
	}
	$scope.create = function(professor) {
		professorService.salvar(professor).then(
				alert("Professor "+ professor.nome+" salvo em nossa base de dados"),listar(), function(e) {
					alert("Erro ao Salvar");
					console.log(e);
				});
		listar();
	};

	var id = $routeParams.id;
	if (id) {
		professorService.getAluno(id).then(function(response) {
			$scope.professor = response.data;
		});
	} else {
		$scope.professor = {};

	}$scope.alterar = function(professor) {
		$scope.professor = professor;
	};

	listar();
	function listar() {
		professorService.listar().then(function(resp) {
			$scope.professores = resp.data;
		});
	};
	
	
	listarCr();
	function listarCr() {
		professorService.listarCar().then(function(resp) {
			$scope.cargoss = resp.data;
		});
	}
	
	
	listarDisc();
	function listarDisc() {
		professorService.listarDis().then(function(resp) {
			$scope.disciplinas = resp.data;
		});
	}
	;
	
	listarProo();
	function listarProo() {
		professorService.listarPro().then(function(resp) {
			$scope.provinciass = resp.data;
		});
	}
	listarTurm();
	function listarTurm() {
		professorService.listarTur().then(function(resp) {
			$scope.turmas = resp.data;
		});
	}
	;

	$scope.alterar = function(professor) {
		$scope.professor = professor;
	};

});
