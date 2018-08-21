app.controller("adiantadoTabelaController", function($scope, adiantadoService) {
	var items = [];

	$scope.time = new Date();

	listar();
	function listar() {
		adiantadoService.listarFaturas().then(function(resp) {
			$scope.faturas = resp.data;
		});
	}
	;

	$scope.exportToPdf = function() {
		html2canvas(document.getElementById('customers'), {
			onrendered : function(canvas) {
				var data = canvas.toDataURL();
				var docDefinition = {
					content : [ {
						image : data,
						width : 550,
					} ]
				};
				pdfMake.createPdf(docDefinition).download("example.pdf");
			}
		});
	}

});