<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Customer</h1>
        </div>

        <form:form commandName="order" class="form-horizontal">
            <h3>Address</h3>

            <div class="form-group">
                <label for="country">Country</label>
                <form:input path="cart.customer.address.country" id="country" class="form-Control"/>
            </div>

            <div class="form-group">
                <label for="city">City</label>
                <form:input path="cart.customer.address.city" id="city" class="form-Control"/>
            </div>

            <div class="form-group">
                <label for="street">Street</label>
                <form:input path="cart.customer.address.street" id="street" class="form-Control"/>
            </div>

            <div class="form-group">
                <label for="zipcode">ZipCode</label>
                <form:input path="cart.customer.address.zipCode" id="zipcode" class="form-Control"/>
            </div>

            <input type="hidden" name="_flowExecution"/>

            <br>
            <button class="btn btn-default" name="_eventId_backToCollectCustomerInfo">Back</button>
            <input type="submit" value="Next" class="btn btn-default" name="_eventId_addressCollected"/>
            <button class="btn btn-default" name="_eventId_cancel">Cancel</button>
        </form:form>
    </div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp" %>