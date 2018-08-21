app.service('turmaService', function($http) {
	var urlb = 'http://localhost:8080/turma';

	this.salvar = function(turma) {
		if (turma.id) {
			return $http.put(urlb, turma);
		} else {
			return $http.post(urlb + '/', turma);
		}
	};

	this.getClasse = function(id) {
		return $http.get(urlb + '/a/' + id);
	};
	this.listar = function() {
		return $http.get(urlb + '/listar');
	};
	this.listarClasse = function() {
		return $http.get(urlb + '/listarClasses');
	};

});