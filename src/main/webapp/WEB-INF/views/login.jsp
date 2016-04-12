<%@include file="template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div style="text-align: center">
            <h2>Login with Username and Password</h2>

            <c:if test="${not empty msg}">
                <div class="msg">${msg}</div>
            </c:if>

            <form name="loginForm" action="<c:url value="${pageContext.request.contextPath}/login" />" method="post">
                <c:if test="${not empty error}">
                    <div class="error" style="color: red">${error}</div>
                </c:if>
                <div class="form-group">
                    <label for="username">User: </label>
                    <input type="text" id="username" name="username" class="form-control" required/>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" class="form-control" required/>
                </div>

                <input type="submit" value="Login" class="btn btn-default">

                <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />--%>
            </form>
        </div>
    </div>
</div>

<%@include file="template/footer.jsp"%>