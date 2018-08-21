angular.module("ui",[]);
angular.module("ui").directive(
		"uiDate",
		function($filter) {
			return {
				require : "ngModel",
				link : function(scope, element, attrs, ctrl) {
					var _formatDate = function(date) {
						date = date.replace(/[^0-9]+/g, "");
						if (date.length > 3) {
							date = date.substring(0, 3) + "."
									+ date.substring(3);
						}
						if (date.length > 7) {
							date = date.substring(0, 7) + "."
									+ date.substring(7);
						}
						if (date.length > 11) {
							date = date.substring(0, 11) + "."
									+ date.substring(11);
						}
						if (date.length > 15) {
							date = date.substring(0, 15) + "."
									+ date.substring(15);
						}
						if (date.length > 20) {
							date = date.substring(0, 19) + "."
									+ date.substring(19);
						}
						if (date.length > 23) {
							date = date.substring(0, 23) + "."
									+ date.substring(23);
						}
						if (date.length > 27) {
							date = date.substring(0, 27) + "."
									+ date.substring(27, 30);
						}

						return date;
					};

					element.bind("keyup", function() {
						ctrl.$setViewValue(_formatDate(ctrl.$viewValue));
						ctrl.$render();
					});

				}
			};
		});