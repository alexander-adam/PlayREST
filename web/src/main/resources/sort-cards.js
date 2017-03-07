(function() {
	var cardsApp = angular.module('cardsApp', []);

	cardsApp.controller('sortCardsCtrl', function($scope, $http) {
        $scope.orderByField = 'position';
        $scope.reverseSort = false;

  		$http.get('http://localhost:8080/rest/card').then(
            function successCallback(response) {
                $scope.cards = response.data.card;
            },
            function errorCallback(response) {
                alert("Error! " + response);
                $scope.errorMsg = response;
            }
		);
	});
})();
