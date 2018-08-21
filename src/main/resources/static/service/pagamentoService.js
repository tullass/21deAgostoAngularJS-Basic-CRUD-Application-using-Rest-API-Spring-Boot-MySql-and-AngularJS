app.service('pagamentoService', function($http) {
	var urlb = 'http://localhost:8080/pagamento';

	this.salvar = function(pagamento) {
		if (pagamento.id) {
			return $http.put(urlb, pagamento);
		} else {
			return $http.post(urlb + '/', pagamento);
		}
	};

	this.getAluno = function(id) {
		return $http.get(urlb + '/a/' + id);
	};
	this.listar = function() {
		return $http.get(urlb + '/listar');
	};
	

});