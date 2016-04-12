<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add Product</h1>

            <p class="lead">Fill the information</p>
        </div>


        <form:form action="${pageContext.request.contextPath}/admin/product/add"
                   method="post" commandName="product" enctype="multipart/form-data">
        <div class="form-group">
            <label for="name">Name</label> <form:errors path="name" cssStyle="color: red"/>
            <form:input path="name" id="name" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="category">Category</label>
            <label class="checkbox-inline"><form:radiobutton path="category" id="category"
                                                             value="zaza"/>zaza</label>
            <label class="checkbox-inline"><form:radiobutton path="category" id="category"
                                                             value="test"/>test</label>
            <label class="checkbox-inline"><form:radiobutton path="category" id="category"
                                                             value="the best"/>the best</label>
        </div>

        <div class="form-group">
            <label for="description">Description</label>
            <form:textarea path="description" id="description" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="price">Price</label> <form:errors path="price" cssStyle="color: red"/>
            <form:input path="price" id="price" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="condition">Condition</label>
            <label class="checkbox-inline"><form:radiobutton path="condition" id="condition"
                                                             value="bad"/>bad</label>
            <label class="checkbox-inline"><form:radiobutton path="condition" id="condition"
                                                             value="ok"/>ok</label>
            <label class="checkbox-inline"><form:radiobutton path="condition" id="condition"
                                                             value="awesome"/>awesome</label>
        </div>

        <div class="form-group">
            <label for="status">Status</label>
            <label class="checkbox-inline"><form:radiobutton path="status" id="status"
                                                             value="active"/>Active</label>
            <label class="checkbox-inline"><form:radiobutton path="status" id="status"
                                                             value="inactive"/>Inactive</label>
        </div>

        <div class="form-group">
            <label for="unitInStock">Unit In Stock</label> <form:errors path="unitInStock" cssStyle="color: red"/>
            <form:input path="unitInStock" id="unitInStock" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="manufacturer">Manufacturer</label>
            <form:input path="manufacturer" id="manufacturer" class="form-Control"/>
        </div>

        <div class="form-group">
            <label class="control-label" for="image">Upload Image</label>
            <form:input path="image" id="image" type="file" class="form:inpug-large"/>
        </div>

        <br><br>
        <input type="submit" value="Submit" class="btn btn-default">
        <a href="<c:url value="/admin/product/list/all"/> " class="btn btn-default">Cancel</a>
        </form:form>

<%@include file="template/footer.jsp" %>