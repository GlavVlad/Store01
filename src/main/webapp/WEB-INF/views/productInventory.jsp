<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="template/header.jsp"%>

<script>
    $(document).ready(function(){

        $('.table').DataTable({
            "lengthMenu": [[5,10,25,50,-1], [5,10,25,50,"All"]],
        });
    });
</script>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Inventory Page</h1>

            <p class="lead">This is inventory</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Photo</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Price</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><img src="<c:url value="/resources/images/${product.id}.png"/>" alt="image" style="width:100%"/>
                    <td>${product.name}</td>
                    <td>${product.category}</td>
                    <td>${product.condition}</td>
                    <td>${product.price} RUB</td>
                    <td><a href="<spring:url value="/product/view/${product.id}"/>">
                        <span class="glyphicon glyphicon-info-sign"></span></a>
                        <a href="<spring:url value="/admin/product/edit/${product.id}"/>">
                            <span class="glyphicon glyphicon-edit"></span></a>
                        <a href="<spring:url value="/admin/product/delete/${product.id}"/>">
                            <span class="glyphicon glyphicon-remove"></span></a></td>
                </tr>
            </c:forEach>
        </table>

        <a href="<spring:url value="/admin/product/add"/> " class="btn btn-primary"> Add Product </a>
<%@include file="template/footer.jsp"%>