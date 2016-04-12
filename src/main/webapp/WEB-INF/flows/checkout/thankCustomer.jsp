<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="jumbotron">
            <div class="container">
                <h1>Thank your for your order!</h1>
            </div>
        </div>

        <div class="container">
            <a href="<spring:url value="/"/> " class="btn btn-default">Ok</a>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp" %>