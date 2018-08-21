angular.module("JWTDemoApp").config(function ($httpProvider) {
	$httpProvider.interceptors.push("loadingInterceptor");
//	$httpProvider.interceptors.push("temposs");



});