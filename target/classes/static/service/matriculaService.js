app.service('matriculaService', function($http) {
	var urlb = 'http://localhost:8080/matricula';

	this.salvar = function(matricula) {
		if (matricula.id) {
			return $http.put(urlb, matricula);
		} else {
			return $http.post(urlb + '/', matricula);
		}
	};
	this.listarAlunoo = function() {
		return $http.get(urlb + '/listarAlunos');
	};
	this.getAluno = function(id) {
		return $http.get(urlb + '/a/' + id);
	};
	this.listar = function() {
		return $http.get(urlb + '/listar');
	};
	this.listarTurma = function() {
		return $http.get(urlb + '/listarTurmas');
	};
	this.listarpro = function() {
		return $http.get(urlb + '/listarProf');
	};
	
	this.listarSemese = function() {
		return $http.get(urlb + '/semestres');
	};
	this.listarProvincia = function() {
		return $http.get(urlb + '/userr/pronvicia');
	};

});