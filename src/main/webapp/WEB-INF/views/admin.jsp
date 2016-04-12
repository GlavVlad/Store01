<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Admin page</h1>

        </div>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>Welcome: ${pageContext.request.userPrincipal.name}</h2>
        <form method="post" action="${pageContext.request.contextPath}/logout" id="form-logout">
            <input type="submit" value="Logout" class="btn btn-default">
            <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
        </form>
        </c:if>

        <h3>
            <a href="<c:url value="/admin/product/list/all"/>">Product Inventory</a>


            <a href="<c:url value="/admin/customers"/> ">All Customer</a>
        </h3>

        <p>Here you can view, check and modify the product inventory</p>
<%@include file="template/footer.jsp" %>