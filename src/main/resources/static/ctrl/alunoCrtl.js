app.controller('alunoController',
    ['$scope', '$rootScope','docService','$http', function($scope, $rootScope, docService, $http, $timeout) {
    	var urlb= 'http://localhost:8080/doc';
    		 
        $scope.aluno = {};
$scope.seleted;
       $scope.upload=function(){
    	
    	   var formData = new FormData();

    	   formData.append('file', $scope.seleted);
    	   $http.post(urlb+'/upload', formData,{
    		      transformRequest : angular.identity,
                  headers : {
                      'Content-Type' : undefined
                  }}).success(function(){
                	  $scope.aluno.nome=$scope.seleted;

                  	alert('success')  ;

                  }).error(function(e){
                	alert('houve um erro')  ;
                	console.log(e);
                  });  		   
       };

       $scope.up=function(x){
    	   $scope.aluno=x;
       }
       $scope.uploadFiles = function (files) {
           alert(files);
              $scope.files = files;
              if (files && files.length) {
                  Upload.upload({
                      url: urlb+'/upload',
                      data: {
                          files: files
                      }
                  }).then(function (response) {
                      $timeout(function () {
                          $scope.result = response.data;
                      });
                  }, function (response) {
                      if (response.status > 0) {
                          $scope.errorMsg = response.status + ': ' + response.data;
                      }
                  }, function (evt) {
                      $scope.progress = 
                          Math.min(100, parseInt(100.0 * evt.loaded / evt.total));
                  });
              }
          };
          
           $scope.aa= function(a) {
        	$http.get(urlb+'/pdf/'+a.id, {responseType: 'arraybuffer'}).success(function(data){
        		var file=new Blob([data],{type: 'application/pdf'});
        		var fileUrl=URL.createObjectURL(file);
        		window.open(fileUrl, '_black')
        	})
			};
			
			  $scope.aaa= function() {
					$http({
						method : 'GET',
						url : urlb + '/listar'
					}).then(function successCallback(response) {
						$scope.profepagos = response.data;
						

					}, function errorCallback(response) {
					});
				};$scope.aaa();
        $scope.add = function() {
			var metodo = 'POST';
			if ($scope.aluno.id) {
				metodo = 'PUT';
			}
			$http({
				method : metodo,
				url : urlb + '/',
				data : $scope.aluno
			})
					.then(
							function successCallback(response) {
																		alert("Aluno salvo em nossa Base de dados");

							},
							function errorCallback(response) {
								alert("Houve um ERRO, se este erro persister, contacte o Provedor do Sistema");
								console.log(response);
							});
		};
    }
    ]);

app.constant('urls', {
    DOC_URL: 'http://localhost:8080/doc/'
});
app.directive('fileModel', [ '$parse', function($parse) {
    return {
        restrict : 'A',
        link : function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;

            element.bind('change', function() {
                scope.$apply(function() {
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
} 


]);

app.run(function($rootScope, $http) {
    $http.get("http://localhost:8080/doc/").success(
        function(response) {
            $rootScope.docList = response;
        });
});
