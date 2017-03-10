(function() {
	var cardsApp = angular.module('cardsApp', ['ngRepeatReorder']);

	cardsApp.controller('sortCardsCtrl', function($scope, $http) {
        $scope.orderByField = 'position';
        $scope.reverseSort = false;
        $scope.loading = false;

		$scope.loadCards = function() {
            $scope.loading = true;

            $http.get('http://localhost:8080/rest/card').then(
                function successCallback(response) {
                    $scope.cards = response.data.cards;
                    $scope.cardsData = response.data;
                    $scope.loading = false;
                },
                function errorCallback(response) {
                    alert("Error! " + response.statusText);
                    $scope.errorMsg = response.statusText;
                    $scope.loading = false;
                }
            );
		};

		$scope.saveCards = function() {
            var res = $http.post('http://localhost:8080/rest/card', $scope.cardsData).then(
                 function successCallback(response) {
//                     $scope.cards = response.data.cards;
//                     $scope.cardsData = response.data;
                 },
                 function errorCallback(response) {
                     alert("Error! " + response.statusText);
                     $scope.errorMsg = response.statusText;
                 }
            );
        };

        $scope.tempplayer = '';
        $scope.updateNames = function () {
            if($scope.tempplayer === "") return;
            $scope.cards.push({val: $scope.tempplayer});
            $scope.tempplayer = "";
        };
        $scope.checkForNameDelete = function($index) {
            if ($scope.cards[$index].val === '') {
                $scope.cards.splice($index, 1);
            }
        };
	});
})();
