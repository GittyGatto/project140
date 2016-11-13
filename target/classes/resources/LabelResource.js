var LabelApp = angular.module('LabelApp');
		
LabelApp.factory('LabelResource', [ '$resource', function($resource) {
	return $resource('/label/:id', null, {
		'update' : {
			method : 'PUT'
		}
	});
} ]);
