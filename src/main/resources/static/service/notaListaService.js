app.service('nListaService', function($http) {
	var urlb = 'http://localhost:8080/professor';

	this.listar = function() {
		return $http.get(urlb + '/listarAl');
	};

	this.listarSemee = function() {
		return $http.get(urlb + '/listarSems');
	};

	this.listarTurm = function() {
		return $http.get(urlb + '/listarTurmas');
	};

	this.getBanco = function(id) {
		return $http.get(urlb + '/a/' + id);
	};
});