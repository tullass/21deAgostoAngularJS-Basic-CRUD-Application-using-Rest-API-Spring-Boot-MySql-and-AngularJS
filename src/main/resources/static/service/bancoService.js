app.service('bancoService', function($http) {
	var urlb = 'http://localhost:8080/banco';

	this.salvar = function(banco) {
		if (banco.id) {
			return $http.put(urlb, banco);
		} else {
			return $http.post(urlb + '/', banco);
		}
	};

	this.getBanco = function(id) {
		return $http.get(urlb + '/a/' + id);
	};
});