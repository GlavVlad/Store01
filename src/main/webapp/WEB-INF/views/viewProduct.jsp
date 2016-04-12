<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Detail</h1>

            <p class="lead">Here is the detail information of the product</p>
        </div>
    </div>

    <div class="container" ng-app="cartApp">
        <div class="row">
            <div class="col-md-5">
                <img src="<c:url value="/resources/images/${product.id}.png"/>" alt="image" style="width: 100%"/>
            </div>

            <div class="col-md-5">
                <h3>${product.name}</h3>
                <p>${product.description}</p>
                <p><strong>Manufacturer</strong> : ${product.manufacturer}</p>
                <p><strong>Category</strong> : ${product.category}</p>
                <p><strong>Condition</strong> : ${product.condition}</p>
                <h4>${product.price}</h4>

                <br>
                <c:set var="role" scope="page" value="${param.role}"/>
                <c:set var="url" scope="page" value="/product/list/all"/>
                <c:if test="${role=='admin'}">
                    <c:set var="url" scope="page" value="/admin/product/list/all"/>
                </c:if>

                <p ng-controller="cartCtrl">
                    <a href="<c:url value="${url}"/> " class="btn btn-default">Back</a>
                    <a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${product.id}')">
                        <span class="glyphicon glyphicon-shopping-cart"></span>Order Now</a>
                    <a href="<spring:url value="/customer/cart" /> " class="btn btn-default">
                        <span class="glyphicon glyphicon-hand-right"></span>View Cart</a>
                </p>
            </div>
        </div>

        <script src="<c:url value="/resources/js/controller.js"/> "></script>
<%@include file="template/footer.jsp" %>