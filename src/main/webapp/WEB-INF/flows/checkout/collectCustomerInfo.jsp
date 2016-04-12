<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Customer</h1>
        </div>

        <form:form commandName="order" class="form-horizontal">
            <div class="form-group">
                <label for="name">Name</label>
                <form:input path="cart.customer.name" id="name" class="form-Control"/>
            </div>

            <div class="form-group">
                <label for="email">email</label>
                <form:input path="cart.customer.email" id="email" class="form-Control"/>
            </div>

            <div class="form-group">
                <label for="phone">Phone</label>
                <form:input path="cart.customer.phone" id="phone" class="form-Control"/>
            </div>

            <input type="hidden" name="_flowExecution"/>

            <br>
            <input type="submit" value="Next" class="btn btn-default" name="_eventId_customerInfoCollected"/>
            <button class="btn btn-default" name="_eventId_cancel">Cancel</button>
                    </form:form>
    </div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp" %>