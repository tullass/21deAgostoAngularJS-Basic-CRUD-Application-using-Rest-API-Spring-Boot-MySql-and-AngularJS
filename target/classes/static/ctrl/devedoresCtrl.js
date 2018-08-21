app.controller(
				"devedorController",
		function($scope, $http, $filter) {
			var urlb = 'http://localhost:8080/fatura';
			$scope.contratolista = function() {
				$http({
					method : 'GET',
					url : urlb + '/todos',
				}).then(function successCallback(response) {
					$scope.estudantes = response.data;
				}, function errorCallback(response) {
				});
			};
			$scope.contratolista();
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
			$scope.delet = function() {
				$scope.estudantes = $scope.estudantes.filter(function(estudante) {
					let
					futureTime = new Date(Date.now() + 1000 * 60 * 60 * 24 * 33);
					let
					PassTime = new Date();

					if (estudante.calendar > PassTime
							&& estudante.calendar < futureTime) {
						
						return estudante;
					}				$scope.m=true;

				});
			};		
			var listatipo = function() {
				$http({
					method : 'GET',
					url : urlb + '/turmas'
				}).then(function successCallback(response) {
					$scope.turmass = response.data;
				}, function errorCallback(response) {
				});
			};

			listatipo()
			var listatipoo = function() {
				$http({
					method : 'GET',
					url : urlb + '/classes'
				}).then(function successCallback(response) {
					$scope.classess = response.data;
				}, function errorCallback(response) {
				});
			};listatipoo();
			$scope.CalDate = function(date1, date2) {

				var diff = Math.floor(date1.getTime() - date2.getTime());
				var secs = Math.floor(diff / 1000);
				var mins = Math.floor(secs / 60);
				var hours = Math.floor(mins / 60);
				var days = Math.floor(hours / 24);

				var months = Math.floor(days / 31);
				var years = Math.floor(months / 12);
				months = Math.floor(months % 12);
				days = Math.floor(days % 31);
				hours = Math.floor(hours % 24);
				mins = Math.floor(mins % 60);
				secs = Math.floor(secs % 60);
				var message = "";

				//MEU FOREACH
				angular.forEach($scope.estudantes, function(x, index) {

					if (years === 0 && months <= 2) {
						message = +months + ' meses ' + days + ' dias ';
					} else if (years < 0 && months < 0) {
						message = "passado";
					} else {
						message = "futuro";

					}
				});//FIM DO FOREACH

				return message;

			};

			$scope.prestacao = [ {
				nome : '2-Prestacoes',
				valuei : 20
			}, {
				nome : '3-Prestacoes',
				valuei : 40
			}, {
				nome : '5-Prestacoes',
				valuei : 95
			}, {
				nome : '6-Prestacoes',
				valuei : 34
			} ];
	$scope.fatura={};
	$scope.d=new Date('2016-04-28 22:00:00');

	$scope.dd=function(){

		
		
		$scope.mydate = new Date();
				var numeros = 100;

				$scope.nova = $scope.mydate.setDate($scope.d.getDate() * 1
						+ $scope.fatura * 1);
			}

			$scope.a = 3;
			$scope.resut = $scope.a * 1 + $scope.fatura * 1;

			$scope.getExp = function(date) {
				date = new Date($filter('date')(date, "yyyy/MM/dd"));
				var currdate = new Date($filter('date')(new Date(), "yyyy/MM/dd"));
				new Date().getFullYear()
				var exp = $scope.CalDate(date, currdate);

				return exp;
			}
		 }).filter('jsonDate', ['$filter', function ($filter) {
				return function (input, format) {
				    //return (input) ? $filter('date')(parseInt(input.substr(6)), format) : '';
				    return (input) ? $filter('date')(input, format) : '';
					};
				}]);