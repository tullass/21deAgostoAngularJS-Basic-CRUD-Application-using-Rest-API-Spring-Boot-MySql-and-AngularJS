var app = angular.module('bancoo', [ 'ngRoute']);

app.config(function($routeProvider, $locationProvider) {

	$routeProvider.when('/bancoa/:id', {
		controller : 'bancooController',
		templateUrl : 'pages/bancoa.html'

	}).when('/bancoa', {
		controller : 'bancooController',
		templateUrl : 'pages/bancoa.html'
	}).when('/cargos', {
		controller : 'cargoController',
		templateUrl : 'pages/cargoss.html'

	}).when('/cad/matricula', {
		controller : 'matriculaController',
		templateUrl : 'pages/matricula.html'

	}).when('/caixaa', {
		controller : 'facturaController',
		templateUrl : 'pages/finan.html'
			
	}).when('/salarios', {
		controller : 'facturaController',
		templateUrl : 'pages/salario.html'
			
	}).when('/extratoPagamento', {
		controller : 'extratoController',
		templateUrl : 'pages/extratos.html'

	}).when('/despesas', {
		controller : 'pagamentoController',
		templateUrl : 'pages/pagamento.html'

	}).when('/tabela', {
		controller : 'tabelaController',
		templateUrl : 'pages/tabela.html'

	}).when('/devedor', {
		controller : 'devedorController',
		templateUrl : 'pages/devedore.html'

	}).when('/listar/salarios', {
		controller : 'facturaController',
		templateUrl : 'pages/listaSalaio.html'

	}).when('/fatura/data', {
		controller : 'datassController',
		templateUrl : 'pages/datasfatura.html'

	}).when('/notas/:id', {
		controller : 'notaoController',
		templateUrl : 'pages/notas.html'

	}).when('/notas', {
		controller : 'notaoController',
		templateUrl : 'pages/notas.html'

	}).when('/cad/avaliacao', {
		controller : 'avaliacoesController',
		templateUrl : 'pages/avaliaa.html'

	}).when('/cadastrar/professor', {
		controller : 'professorController',
		templateUrl : 'pages/professore.html'

	}).when('/professor/turmas', {
		controller : 'professorController',
		templateUrl : 'pages/profturma.html'

	}).when('/cad/disciplina', {
		controller : 'disciplinaControlle',
		templateUrl : 'pages/disciplina.html'

	}).when('/faturaa', {
		controller : 'facturaController',
		templateUrl : 'pages/fatura.html'

	}).when('/fatura/Report', {
		controller : 'ReportFaController',
		templateUrl : 'pages/datasadiantadofatura.html'

	}).when('/report/faturas', {
		controller : 'facturaController',
		templateUrl : 'pages/relatorios.html'

	}).when('/listaNota', {
		controller : 'notaoController',
		templateUrl : 'pages/notaLista.html'

	}).when('/adiantadoo', {
		controller : 'adiantadoController',
		templateUrl : 'pages/adiantado.html'

	}).when('/adiantadoo/:id', {
		controller : 'adiantadoController',
		templateUrl : 'pages/adiantado.html'

	}).when('/cad/classe', {
		controller : 'classeController',
		templateUrl : 'pages/classe.html'

	}).when('/cad/turma', {
		controller : 'turmaController',
		templateUrl : 'pages/turma.html'

	}).when('/cad/aluno', {
		controller : 'alunoController',
		templateUrl : 'pages/aluno3.html'

	}).when('/adiantadoReport', {
		controller : 'adiantadoTabelaController',
		templateUrl : 'pages/adiantadoRelatorios.html'

	}).when('/mes/pagos', {
		controller : 'facturaController',
		templateUrl : 'pages/meses.html'

	}).when('/cad/servicos', {
		controller : 'ServicosController',
		templateUrl : 'pages/servico.html'

	}).when('/cad/semestre', {
		controller : 'SemestreController',
		templateUrl : 'pages/semestree.html'

	}).when('/cad/semestre/disciplina', {
		controller : 'SemestreController',
		templateUrl : 'pages/semdisc.html'

	}).when('/dashboard', {
		controller : 'genController',

		templateUrl : 'pages/dash.html'

	}).otherwise('/dashboard');

});
