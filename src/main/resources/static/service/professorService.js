app.service('professorService', function($http) {
	var urlb = 'http://localhost:8080/professor';

	this.salvar = function(professor) {
		if (professor.id) {
			return $http.put(urlb, professor);
		} else {
			return $http.post(urlb + '/', professor);
		}
	};

	
	this.listar = function() {
		return $http.get(urlb + '/listar');
	};
	

	this.listarDis = function() {
		return $http.get(urlb + '/listardisciplinas');
	};
	this.listarTur = function() {
		return $http.get(urlb + '/listarturmas');
	};
	
	this.listarCar= function() {
		return $http.get(urlb + '/cargoos');
	};
	this.listarPro = function() {
		return $http.get(urlb + '/pronvicias');
	};
	
	
});