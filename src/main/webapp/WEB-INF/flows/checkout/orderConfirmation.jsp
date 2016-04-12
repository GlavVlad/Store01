<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<jsp:useBean id="now" class="java.util.Date" />


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Order confirmation</h1>
        </div>

        <div class="container">
            <div class="row">
                <form:form commandName="order" class="form-horizontal">
                    <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
                        <div class="text-center">
                            <h1>Receipt</h1>
                        </div>
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <address>
                                    <strong>Shipping Address</strong><br>
                                        ${order.cart.customer.address.country}<br>
                                        ${order.cart.customer.address.city}<br>
                                        ${order.cart.customer.address.street}<br>
                                        ${order.cart.customer.address.zipCode}<br>
                                </address>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                                <p>Shipping Date: <fmt:formatDate type="date" value="${now}"/></p>
                            </div>
                        </div>

                        <div class="row">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>Product</th>
                                    <th>#</th>
                                    <th class="text-center">Price</th>
                                    <th class="text-center">Total</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${order.cart.items}">
                                    <tr>
                                        <td class="col-md-9"><em>${item.product.name}</em></td>
                                        <td class="col-md-9 text-center"><em>${item.quantity}</em></td>
                                        <td class="col-md-9 text-center"><em>${item.product.price}</em></td>
                                        <td class="col-md-9 text-center"><em>${item.totalPrice}</em></td>
                                    </tr>
                                </c:forEach>

                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td class="text-right">
                                        <h4><strong>Grand Total: </strong></h4>
                                    </td>
                                    <td class="text-center text-danger">
                                        <h4><strong>${order.cart.grandTotal} RUB</strong></h4>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <input type="hidden" name="_flowExecution"/>

                        <br>
                        <button class="btn btn-default" name="_eventId_backToCollectAddress">Back</button>
                        <input type="submit" value="Submit Order" class="btn btn-default"
                               name="_eventId_orderConfirmed"/>
                        <button class="btn btn-default" name="_eventId_cancel">Cancel</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp" %>