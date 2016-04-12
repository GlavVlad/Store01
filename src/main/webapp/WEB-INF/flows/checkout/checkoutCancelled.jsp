<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="jumbotron">
            <div class="container">
                <h1 class="alert alert-danger">Checkout canceled.</h1>

                <p>Your checkout process is cancelled.</p>
            </div>
        </div>

        <div class="container">
            <a href="<spring:url value="/product/list/all"/> " class="btn btn-default">Product</a>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp" %>