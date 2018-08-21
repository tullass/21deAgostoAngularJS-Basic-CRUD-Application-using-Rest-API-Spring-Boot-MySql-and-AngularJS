angular.module('alunoService').service('datasContrato', function($http) {
	var urlb = 'http://localhost:8080/fatura';
	var pageNumber=0;
	    
	
	this.listarPage = function() {
		return $http.get( urlb+ '/listarB?page='+pageNumber);
	};
	
	this.listarFaturas = function() {
		return $http.get(urlb + '/listarAtivos');
	};

	this.prestacaoe = [ {
		nome : '5',
		pageNumber : 5
	}, {
		nome : '10',
		pageNumber : 10
	}, {
		nome : '20',
		pageNumber : 20
	}, {
		nome : '50',
		pageNumber : 50
	}, {
		nome : '100',
		pageNumber : 100
	}];
	
	this.exportPdf = function() {
		html2canvas(document.getElementById('customers'), {
			onrendered : function(canvas) {
				var data = canvas.toDataURL();
				var docDefinition = {
					content : [ {
						image : data,
						width : 500,
					} ]
				};
				pdfMake.createPdf(docDefinition)
						.download("datas_contrato_indeterminado.pdf");
			}
		});
	}
});