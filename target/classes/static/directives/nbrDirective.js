angular.module("nbr",[]);
angular.module("nbr").directive(
		"nbrDate",
		function($filter) {
			return {
				require : "ngModel",
				link : function(scope, element, attrs, ctrl) {
					var _formatDate = function(date) {
						date = date.replace(/[^0-9]+/g, "");
						
						if (date.length > 27) {
							date = date.substring(0, 27) 
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