var app = angular.module("bancoo").factory("temposs", function () {
	return {
		request: function (config) {
			var url = config.url;
			if (url.indexOf('pages') > -1) return config;
			var timestampp = new Date().getTime();
			config.url = url + "?timestampp=" + timestampp;
			console.log(config.url);
			return config;
		}
	};
});