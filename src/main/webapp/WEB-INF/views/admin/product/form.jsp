<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

<div class="col-6 container px-0">
    <div class="px-4 p-3">
        <form:form action="/admin/product" method="post"
                   modelAttribute="product">
            <div class="card">
                <div class="card-header">
                    <h5 class="modal-title" id="staticBackdropLabel">Form product</h5>
                </div>
                <div class="card-body">
                    <div class="rowr">
                        <div class="<%--col-6--%>">
                            <c:if test="${not empty product.id}">
                                <div>
                                    <div class="row">
                                        <label class="col-3">Id</label>
                                        <div class="col-9 text-danger text-end"></div>
                                    </div>
                                    <form:input readonly="true" path="id" class="form-control" />
                                </div>
                            </c:if>
                            <div>
                                <div class="row">
                                    <label class="col-3">Name</label>
                                    <div class="col-9 text-danger text-end">
                                        <form:errors path="name" cssStyle="font-size: 12px"></form:errors></div>
                                </div>
                                <form:input path="name" class="form-control" />
                            </div>
                            <div>
                                <div class="row">
                                    <label class="col-3">Image</label>
                                    <div class="col-9 text-danger text-end">
                                        <form:errors path="image" cssStyle="font-size: 12px"></form:errors></div>
                                </div>
                                <form:input path="image" class="form-control" />
                            </div>
                            <div>
                                <div class="row">
                                    <label class="col-3">Price</label>
                                    <div class="col-9 text-danger text-end">
                                        <form:errors path="price" cssStyle="font-size: 12px"></form:errors></div>
                                </div>
                                <form:input type="number" path="price" class="form-control" />
                            </div>
                            <div>
                                <div class="row">
                                    <label class="col-3">Availble</label>
                                    <div class="col-9 text-danger text-end">
                                        <form:errors path="available" cssStyle="font-size: 12px"></form:errors></div>
                                </div>
                                <form:input type="number" path="available" class="form-control" />
                            </div>
                            <div>
<%--                                <label class="col-3">Category</label>--%>
                                <div class="row">
                                    <label class="col-3">Category</label>
                                    <div class="col-9 text-danger text-end">
                                        <form:errors path="category" cssStyle="font-size: 12px"></form:errors></div>
                                </div>
                                <form:select path="category.id" class="form-select">
                                    <option value="">--Choose Category--</option>
                                    <form:options items="${listCategory}" itemLabel="name" itemValue="id"></form:options>
                                </form:select>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card-footer mt-3">
                    <a href="/admin/product" class="btn btn-secondary">Back</a>
<%--                    <button type="submit" class="btn btn-primary">Add</button>--%>
                    <c:choose>
                        <c:when test = "${not empty product.id}">
                            <button formaction="/admin/product/update" class="btn btn-info">Update</button>
                        </c:when>
                        <c:otherwise>
                            <button formaction="/admin/product/save" class="btn btn-primary">Create</button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </form:form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>