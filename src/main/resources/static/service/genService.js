app.service('genService', function($http) {
	var urlb = 'http://localhost:8080/gen';
	    
	
	this.listarA = function() {
		return $http.get( urlb+ '/a');
	};
	
	this.listarT = function() {
		return $http.get(urlb + '/t');
	};

	this.listarM = function() {
		return $http.get(urlb + '/m');
	};

});