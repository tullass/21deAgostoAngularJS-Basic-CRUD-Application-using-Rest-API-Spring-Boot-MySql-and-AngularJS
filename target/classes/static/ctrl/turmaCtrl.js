app.controller("turmaController", function($scope, turmaService) {

	function novo() {
		$scope.turma = {};
	}
	$scope.create = function(turma) {
		turmaService.salvar(turma).then(function(resp){		

			alert("Sucess");		novo();
			listar();
		},
			function errorCallback(response) {
			alert("Houve um erro ao cadastratar a turma "+response);
			console.log(response);
		});
	};
	listar();
	function listar() {
		turmaService.listar().then(function(resp) {
			$scope.turmas = resp.data;
		});
	}
	;
	listarClasses();
	function listarClasses() {
		turmaService.listarClasse().then(function(resp) {
			$scope.classes = resp.data;
		});
	}
	;
	$scope.alterar = function(turma) {
		$scope.turma = turma;
	};
	
});
