app.service('avaliacoesService', function($http) {
	var urlb = 'http://localhost:8080/avaliacao';

	this.salvar = function(avaliacoes) {
		if (avaliacoes.id) {
			return $http.put(urlb, avaliacoes);
		} else {
			return $http.post(urlb + '/', avaliacoes);
		}
	};
	
	this.listarTodos = function() {
		return $http.get(urlb + '/listaTodos');
	};
	
	this.getAluno = function(id) {
		return $http.get(urlb + '/a/' + id);
	};
	
	this.listar = function() {
		return $http.get(urlb + '/listar');
	};
	this.listarTurma = function() {
		return $http.get(urlb + '/listaTurma');
	};
	this.listarpro = function() {
		return $http.get(urlb + '/listaProf');
	};
	
	this.listarSemese = function() {
		return $http.get(urlb + '/listaTrimestre');
	};
	
});