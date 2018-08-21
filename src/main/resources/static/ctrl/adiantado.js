
app.controller("adiantadoController",
		function($scope, adiantadoService, $routeParams) {


			var items = [];
			$scope.t=true;

			$scope.prestacao = [ {
				nome : '2-Prestacoes',
				valuei : 2
			}, {
				nome : '3-Prestacoes',
				valuei : 3
			}, {
				nome : '5-Prestacoes',
				valuei : 5
			}, {
				nome : '6-Prestacoes',
				valuei : 6
			}, {
				nome : '7-Prestacoes',
				valuei : 7

			}, {
				nome : '8-Prestacoes',
				valuei : 8

			}, {
				nome : '9-Prestacoes',
				valuei : 9

			}, {
				nome : '10-Prestacoes',
				valuei : 7

			}, {
				nome : '10-Prestacoes',
				valuei : 7

			}, ];
			var id = $routeParams.id;
			if (id) {
				adiantadoService.getFatura(id).then(function(response) {
					$scope.fatura = response.data;
				});
			} else {
				$scope.fatura = {};

			}
			function novo() {
				$scope.fatura = {};
			}
			
			$scope.add = function(fatura) {
				adiantadoService.salvar(fatura).then(
						alert("Salvo com Sucesso"));

				novo();
			};
		
			$scope.time = new Date();
			$scope.fatura = {};
			var novo = function() {
				$scope.fatura = {};
			}

			listar();
			function listar() {
				adiantadoService.listarFaturas().then(function(resp) {
					$scope.faturas = resp.data;
				});
			}
			;
			listarAluno();

			function listarAluno() {
				adiantadoService.listarAlunoss().then(function(resp) {
					$scope.alunos = resp.data;
				});
			}
			;

			listarTipo();
			function listarTipo() {
				adiantadoService.listarTiposs().then(function(resp) {
					$scope.tipos = resp.data;
				});
			}
			;

			listarBanc();
			function listarBanc() {
				adiantadoService.listarBancoss().then(function(resp) {
					$scope.bancossss = resp.data;
				});
			}
			;
			listarBancos();
			function listarBancos() {
				adiantadoService.listarTurmasss().then(function(resp) {
					$scope.turmass = resp.data;
				});
			};
			

			$scope.alterar = function(aluno) {
				$scope.fatura.matricula = aluno;

			};
			$scope.refresh = function() {
				alert("Methodo ainda em construcao");
			};

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
						pdfMake.createPdf(docDefinition)
								.download("example.pdf");
					}
				});
			};

			$scope.cal = function() {
				$scope.banco.valor=0;
				$scope.fatura.multa = 0;

				var total = $scope.fatura.matricula.aluno.turma.nivel.valor * 5
				$scope.fatura.caixa = total;

				var banco = $scope.fatura.matricula.aluno.turma.nivel.valor * 1
						+ $scope.fatura.multa * 1;
				
				$scope.banco.valor=$scope.fatura.caixa  ;
			};
			$scope.calr = function() {
				$scope.banco.valor=0;
				$scope.fatura.multa = 0;

				var total = $scope.fatura.matricula.aluno.turma.nivel.valor * 1
						* $scope.fatura.prestacao * 1;
				$scope.fatura.caixa = total;

				var banco = $scope.fatura.matricula.aluno.turma.nivel.valor * 1
						+ $scope.fatura.multa * 1;
				
				$scope.banco.valor=$scope.fatura.caixa  ;
			};
		});