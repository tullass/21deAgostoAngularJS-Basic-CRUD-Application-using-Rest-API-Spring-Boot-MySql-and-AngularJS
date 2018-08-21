app.controller(
				"facturaController",
				function($scope, $http) {
					var urlBase = 'http://localhost:8080/fatura';
					var items = [];
					$scope.t = true;
					$scope.fatura ={};
					$scope.d=new Date();	
					$scope.fatura.pagou=true;
					$scope.avgs=0;
					$scope.t = new Date();
					alert('hpPPKKpkpppp');
					$scope.anos = [ {
						nome : '2017',
						valuei : 1
					}, {
						nome : '2018',
						valuei : 2
					}, {
						nome : '2019',
						valuei : 3
					}, {
						nome : '2020',
						valuei : 4
					}, ];
					$scope.bancos = [ {
						nome : 'Caixa',
						valuei : 1
					}, {
						nome : 'Numerario',
						valuei : 2
					}, {
						nome : 'Banco B',
						valuei : 3
					}, {
						nome : 'Check',
						valuei : 4
					}, ];
				
					$scope.items = [ {
						nome : '0%',
						valuei : 0.00
					}, {
						nome : '5%',
						valuei : 0.05
					}, {
						nome : '10%',
						valuei : 0.10
					}, {
						nome : '15%',
						valuei : 0.15
					}, {
						nome : '25%',
						valuei : 0.25
					}, {
						nome : '50%',
						valuei : 0.50
					}, {
						nome : '100%',
						valuei : 2
					}, ];

					$scope.meses = [ {
						id : 1,
						nome : 'Janeiro',
						pago : true

					}, {
						id : 2,
						nome : 'Fevereiro',
						pago : true

					}, {
						id : 3,
						nome : 'Marco',
						pago : true

					}, {
						id : 4,
						nome : 'Abril',
						pago : true

					}, {
						id : 5,
						nome : 'Maio',
						pago : true

					}, {
						id : 6,
						nome : 'Junho',
						pago : true

					}, {
						id : 7,
						nome : 'Julho',
						pago : true

					}, {
						id : 8,
						nome : 'Agosto',
						pago : true

					}, {
						id : 9,
						nome : 'Setembro',
						pago : true

					}, {
						id : 10,
						nome : 'Outubro',
						pago : true

					}, {
						id : 11,
						nome : 'Novembro',
						pago : true

					}, {
						id : 12,
						nome : 'Dezembro',
						pago : true

					} ];
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

					$scope.time = new Date();
					var totalfatur = 1000;
					$scope.fatura = {};
					var novo = function() {
						$scope.fatura = {};
					}
			
					$scope.add = function() {
						var metodo = 'POST';
						if ($scope.fatura.id) {
							metodo = 'PUT';
						}
						$http({
							method : metodo,
							url : urlBase + '/',
							data : $scope.fatura
						})
								.then(
										function successCallback(response) {
											novo();
											$scope.carrega();
																				alert("Pagamento efectuado com sucesso");

										},
										function errorCallback(response) {
											alert("Houve um ERRO, se este erro persister, contacte o Provedor do Sistema");
											console.log(response);
										});
					};
					$scope.addd = function() {
						var metodo = 'POST';
						if ($scope.fatura.id) {
							metodo = 'PUT';
						}
						$http({
							method : metodo,
							url : urlBase + '/',
							data : $scope.fatura
						})
								.then(
										function successCallback(response) {																				alert("Pagamento efectuado com sucesso");
										alert("Pagamento efectuado com sucesso");

											novo();
											$scope.listaAluno();

										},
										function errorCallback(response) {
											alert("Houve um ERRO, se este erro persister, contacte o Provedor do Sistema");
											console.log(response);
										});
					};
					$scope.listaAlunoa = function() {
						$http({
							method : 'GET',
							url : urlBase + '/listarTodos'
						}).then(function successCallback(response) {
							$scope.faturas = response.data;
							$scope.matricula = undefined;
							
						}, function errorCallback(response) {
						});
					};
					$scope.listaAlunoa();
					
					$scope.listaAlunoaa = function() {
						$http({
							method : 'GET',
							url : urlBase + '/prof'
						}).then(function successCallback(response) {
							$scope.profe = response.data;
							$scope.matricula = undefined;
							
						}, function errorCallback(response) {
						});
					};$scope.listaAlunoaa();

					
					
					var listaAluno = function() {
						$http({
							method : 'GET',
							url : urlBase + '/listarAluno'
						}).then(function successCallback(response) {
							$scope.matriculas = response.data;
							

						}, function errorCallback(response) {
						});
					};

					listaAluno();
					var listaProf= function() {
						$http({
							method : 'GET',
							url : urlBase + '/pagouu'
						}).then(function successCallback(response) {
							$scope.profepagos = response.data;
							

						}, function errorCallback(response) {
						});
					};

					listaProf();
					
					
					
					
					$scope.carrega = function() {
						$http({
							method : 'GET',
							url : urlBase + '/o'
						}).then(function successCallback(response) {
							$scope.carr = response.data;
							

						}, function errorCallback(response) {
						});
					};

					$scope.carrega();
					var listaAlunoz = function() {
						$http({
							method : 'GET',
							url : urlBase + '/avg'
						}).then(function successCallback(response) {
							$scope.avgs = response.data;
							$scope.fatura.s=$scope.avgs;

						}, function errorCallback(response) {
						});
					};

					listaAlunoz();

					var listatipo = function() {
						$http({
							method : 'GET',
							url : urlBase + '/listarTipo'
						}).then(function successCallback(response) {
							$scope.tipos = response.data;
						}, function errorCallback(response) {
						});
					};

					listatipo();

				


					var listatipo = function() {
						$http({
							method : 'GET',
							url : urlBase + '/turmas'
						}).then(function successCallback(response) {
							$scope.turmass = response.data;
						}, function errorCallback(response) {
						});
					};

					listatipo()
					var listatipoo = function() {
						$http({
							method : 'GET',
							url : urlBase + '/classes'
						}).then(function successCallback(response) {
							$scope.classess = response.data;
						}, function errorCallback(response) {
						});
					};
					listatipoo()
					$scope.alterar = function(matricula) {
						$scope.fatura.matricula = matricula;

					};
					
					$scope.altera = function(fatura) {
						$scope.fatura.professor = fatura;
				
					$scope.refresh = function() {
						console.log('clicked');					};

			
					
					$scope.calu = function() {
						alert('jkjjkh');
						$scope.fatura.mes.pago = true;

						var multa = $scope.fatura.matricula.turma.nivel.valor
								* $scope.fatura.desconto;
						$scope.fatura.multa = multa;

						var total = $scope.fatura.matricula.turma.nivel.valor
								* 1 + $scope.fatura.multa * 1;
						$scope.fatura.caixa = total;

						var banco = $scope.fatura.matricula.turma.nivel.valor
								* 1 + $scope.fatura.multa * 1;
						$scope.fatura.banco.valor = banco;
						$scope.turma = $scope.fatura.matricula.turma.descricao;
						$scope.banco.valor = total;

					};
					
					
					}
				});