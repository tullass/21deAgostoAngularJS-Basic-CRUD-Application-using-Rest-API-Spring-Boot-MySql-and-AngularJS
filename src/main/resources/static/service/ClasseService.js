app.service('nivelService', function($http) {
	var urlb = 'http://localhost:8080/nivel';

	this.salvar = function(nivel) {
		if (nivel.id) {
			return $http.put(urlb, nivel);
		} else {
			return $http.post(urlb + '/', nivel);
		}
	};

	this.getClasse = function(id) {
		return $http.get(urlb + '/a/' + id);
	};
	this.listar = function() {
		return $http.get(urlb + '/listar');
	};

});