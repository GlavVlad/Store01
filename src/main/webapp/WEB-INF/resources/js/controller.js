var cartApp = angular.module("cartApp", []);

cartApp.controller("cartCtrl", ['$scope', '$http', function ($scope, $http) {
    $scope.deleteFromCart = function (productId) {
        $http.delete('/customer/rest/cart/' + $scope.cartId + '/delete/' + productId).success(function (data) {
            $scope.refreshCart();
        });
    };

    $scope.clearCart = function () {
        $http.delete('/customer/rest/cart/' + $scope.cartId).success($scope.refreshCart);
    };

    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };

    $scope.refreshCart = function () {
        $http.get('/customer/rest/cart/' + $scope.cartId).success(function (data) {
            $scope.cart = data;
        });
    };

    $scope.addToCart = function (productId) {
        $http.put('/customer/rest/cart/add/' + productId).success(function () {
            alert("Product successfully added to the cart!")
        });
    };

    $scope.calculateGrandTotal = function () {
        var grandTotal = 0;

        for (var i = 0; i < $scope.cart.items.length; i++) {
            grandTotal += $scope.cart.items[i].totalPrice;
        }

        return grandTotal;
    };
}]);