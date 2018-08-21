app.service('notaService', function($http) {
	var urlb = 'http://localhost:8080/matricula';

	this.salvar = function(matricula) {
		if (matricula.id) {
			return $http.put(urlb, matricula);
		} else {
			return $http.post(urlb + '/', matricula);
		}
	};

	this.getBanco = function(id) {
		return $http.get(urlb + '/a/' + id);
	};
	
	this.listar = function() {
		return $http.get(urlb + '/semestres');
	};
	
	this.listarTurm = function() {
		return $http.get(urlb + '/listarProf');
	};
	this.listarr = function() {
		return $http.get(urlb + '/listar');
	};
});