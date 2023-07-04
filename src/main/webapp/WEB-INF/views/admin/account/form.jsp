<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

<div class="col-6 container px-0">
    <div class="px-4 p-3">
        <form:form action="/admin/account" method="post"
                   modelAttribute="account">
            <div class="card">
                <div class="card-header">
                    <h5 class="modal-title" id="staticBackdropLabel">Form account</h5>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="<%--col-6--%>">
                            <div>
                                <div class="row">
                                    <label class="col-3">Username</label>
                                    <div class="col-9 text-danger text-end">
                                        <form:errors path="username" cssStyle="font-size: 12px"></form:errors></div>
                                </div>
                                <form:input path="username" class="form-control" />
                            </div>
                            <div>
                                <div class="row">
                                    <label class="col-3">Password</label>
                                    <div class="col-9 text-danger text-end">
                                        <form:errors path="password" cssStyle="font-size: 12px"></form:errors></div>
                                </div>
                                <form:input path="password" class="form-control" />
                            </div>
                            <div>
                                <div class="row">
                                    <label class="col-3">Fullname</label>
                                    <div class="col-9 text-danger text-end">
                                        <form:errors path="fullname" cssStyle="font-size: 12px"></form:errors></div>
                                </div>
                                <form:input path="fullname" class="form-control" />
                            </div>
                            <div>
                                <div class="row">
                                    <label class="col-3">Email</label>
                                    <div class="col-9 text-danger text-end">
                                        <form:errors path="email" cssStyle="font-size: 12px"></form:errors></div>
                                </div>
                                <form:input path="email" class="form-control" />
                            </div>
                            <div>
                                    <%--                                <label class="col-3">Category</label>--%>
                                <div class="row">
                                    <label class="col-3">Admin</label>
                                    <div class="col-9 text-danger text-end">
                                        <form:errors path="admin" cssStyle="font-size: 12px"></form:errors></div>
                                </div>
                                <form:select path="admin" class="form-select">
                                    <option value="">--Choose Category--</option>
                                    <option value="0">Quản trị viên</option>
                                    <option value="1">Khách hàng</option>
                                </form:select>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card-footer mt-3">
                    <a href="/admin/account" class="btn btn-secondary">Back</a>
                    <c:choose>
                        <c:when test = "${not empty account.username}">
                            <button formaction="/admin/account/update" class="btn btn-info">Update</button>
                        </c:when>
                        <c:otherwise>
                            <button formaction="/admin/account/save" class="btn btn-primary">Create</button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </form:form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>