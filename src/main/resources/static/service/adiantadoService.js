app.service('adiantadoService', function($http) {
	var urlb = 'http://localhost:8080/fatura';

	this.salvar = function(banco) {
		if (banco.id) {
			return $http.put(urlb, banco);
		} else {
			return $http.post(urlb + '/a', banco);
		}
	};

	this.getFatura = function(id) {
		return $http.get(urlb + '/aa/' + id);
	};

	this.listarFaturas = function() {
		return $http.get(urlb + '/listarAtivos');
	};

	this.listarAlunoss = function() {
		return $http.get(urlb + '/listarAluno');
	};

	this.listarTiposs = function() {
		return $http.get(urlb + '/listarTipo');
	};

	this.listarBancoss = function() {
		return $http.get(urlb + '/listarBanco');
	};
	this.listarTurmasss = function() {
		return $http.get(urlb + '/turmas');
	};

});