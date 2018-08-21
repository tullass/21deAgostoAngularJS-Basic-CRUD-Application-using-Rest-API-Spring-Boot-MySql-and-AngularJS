//angular.module("JWTDemoApp").factory("tokenn", function ($q, $rootScope, $timeout,$http) {
//	return {
//		
//		'request': function(config){
//			
//			$http.defaults.headers.common['Authorization'] = 'Bearer ' + res.token;
//		
//			return config;
//		},
//		
//		  'responseError': function (rejection){
//	    	
//	    	if(rejection.status==401){
//	    		$location.path("/login");
//	    	}
//	    	if(rejection.status==404){
//	    		$location.path("/");
//	    	}
//	    	if(rejection.status==500){
//	    		$location.path("/");
//	    	}
//	    	
//	    	
//
//	    	return $q.reject(rejection);
//	    }
//	
//	
//	};
//	
//});