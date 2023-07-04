<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

<div class="col-6 container px-0">
    <div class="px-4 p-3">
        <form:form action="/admin/category" method="post"
                   modelAttribute="category">
            <div class="card">
                <div class="card-header">
                    <h5 class="modal-title" id="staticBackdropLabel">Form category</h5>
                </div>
                <div class="card-body">
                    <div class="rowr">
                        <div class="<%--col-6--%>">
                            <div>
                                <div class="row">
                                    <label class="col-3">Id</label>
                                    <div class="col-9 text-danger text-end">
                                        <form:errors path="id" cssStyle="font-size: 12px"></form:errors></div>
                                </div>
                                <form:input path="id" readonly="${empty category.id ? 'false' : 'true'}" class="form-control" />
                            </div>
                            <div>
                                <div class="row">
                                    <label class="col-3">Name</label>
                                    <div class="col-9 text-danger text-end">
                                        <form:errors path="name" cssStyle="font-size: 12px"></form:errors></div>
                                </div>
                                <form:input path="name" class="form-control" />
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card-footer mt-3">
                    <a href="/admin/category" class="btn btn-secondary">Back</a>
                    <c:choose>
                        <c:when test = "${not empty category.id}">
                            <button formaction="/admin/category/update" class="btn btn-info">Update</button>
                        </c:when>
                        <c:otherwise>
                            <button formaction="/admin/category/save" class="btn btn-primary">Create</button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </form:form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>