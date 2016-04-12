<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Register new Customer</h1>
        </div>

        <form:form action="${pageContext.request.contextPath}/register" method="post" commandName="customer">
            <div class="form-group">
                <label for="name">Name</label> <form:errors path="name" cssStyle="color: red"/>
                <form:input path="name" id="name" class="form-Control"/>
            </div>

            <div class="form-group">
                <label for="email">Email</label> <form:errors path="email" cssStyle="color: red"/>
                <span style="color: red;">${emailError}</span>
                <form:input path="email" id="email" class="form-Control"/>
            </div>

            <div class="form-group">
                <label for="phone">Phone</label>
                <form:input path="phone" id="phone" class="form-Control"/>
            </div>

            <div class="form-group">
                <label for="username">Username</label> <form:errors path="username" cssStyle="color: red"/>
                <span style="color: red;">${usernameError}</span>
                <form:input path="username" id="userName" class="form-Control"/>
            </div>

            <div class="form-group">
                <label for="password">Password</label> <form:errors path="password" cssStyle="color: red"/>
                <form:password path="password" id="password" class="form-Control"/>
            </div>

            <h3>Address</h3>

            <div class="form-group">
                <label for="country">Country</label>
                <form:input path="address.country" id="country" class="form-Control"/>
            </div>

            <div class="form-group">
                <label for="city">City</label>
                <form:input path="address.city" id="city" class="form-Control"/>
            </div>

            <div class="form-group">
                <label for="street">Street</label>
                <form:input path="address.street" id="street" class="form-Control"/>
            </div>

            <div class="form-group">
                <label for="zipcode">ZipCode</label>
                <form:input path="address.zipCode" id="zipcode" class="form-Control"/>
            </div>

            <br>
            <input type="submit" value="Register" class="btn btn-default">
            <a href="<c:url value="/" />" class="btn btn-default">Cancel</a>
        </form:form>
    </div>
</div>

<%@include file="template/footer.jsp" %>