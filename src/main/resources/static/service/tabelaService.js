app.service('tabelaService', function($http) {
	var urlb = 'http://localhost:8080/banco';

	this.listar = function() {
		return $http.get(urlb + '/listar');
	};

	this.getBanco = function(id) {
		return $http.get(urlb + '/a/' + id);
	};
});