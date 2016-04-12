<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="jumbotron">
            <div class="container">
                <h1>Customer registered successfully</h1>
            </div>
        </div>

        <div class="container">
            <a href="<spring:url value="/product/list/all"/> " class="btn btn-default">Products</a>
        </div>
    </div>
</div>

<%@include file="template/footer.jsp" %>