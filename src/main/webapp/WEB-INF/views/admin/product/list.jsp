<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

<div class="container px-0">
    <img src="">
    <div class="px-4 p-3">
        <div class="row">
            <div class="col-3">
                <a href="/admin/product/create" class="btn btn-info text-white">Add new</a>
            </div>
            <div class="table-responsive mt-3" style="overflow-x: auto">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Image</th>
                        <th>Price</th>
                        <th>Category</th>
                        <th>Create date</th>
                        <th>Availble</th>
                        <th colspan="2">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.content}" var="pro">
                        <tr>
                            <td>${ pro.id }</td>
                            <td>${ pro.name }</td>
                            <td>${ pro.image }</td>
<%--                            <td><img alt="${ pro.image }" src="${pro.image}"--%>
<%--                                     width="50" height="50"></td>--%>
                            <td>${ pro.price }</td>
                            <td>${ pro.category.name }</td>
                            <td>${ pro.createdate }</td>
                            <td>${ pro.available }</td>
                            <td>
                                <a class="btn btn-primary" href="/admin/product/edit/${pro.id}">
                                    <i class="fa-solid fa-pen-to-square"></i></a>
                            </td>
                            <td class="text-center">
                                <a class="btn btn-danger" onclick="return confirmComplete();" href="/admin/product/delete-product/${pro.id}">
                                    <i class="fa-solid fa-trash-can"></i></a>
                            </td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="row justify-content-center">
                    <nav aria-label="Page navigation example">
                        <ul class="pagination justify-content-center">
                            <li class="page-item"><a class="page-link" href="/admin/product?p=0">First</a></li>
                            <li class="page-item"><a class="page-link" href="/admin/product?p=${page.number-1 < 0 ? 0 : page.number-1}">Prev</a></li>
                            <li class="page-item"><a class="page-link text-secondary" href="">${page.number+1}/${page.totalPages}</a></li>
                            <li class="page-item"><a class="page-link" href="/admin/product?p=${page.number+1 > page.totalPages-1 ? page.totalPages-1 : page.number+1}">Next</a></li>
                            <li class="page-item"><a class="page-link" href="/admin/product?p=${page.totalPages-1}">Last</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>
<c:if test="${not empty message}">
    <div class="position-fixed top-0 end-0 p-2" style="z-index: 11">
        <div style="background-color: #2ecc71" id="liveToast"
             class="toast show align-items-center text-white border-0" data-bs-autohide="true" data-bs-delay="1000"
             role="alert" aria-live="assertive" aria-atomic="true">
            <div class="d-flex">
                <div class="toast-body">${message} !</div>
                <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast"
                        aria-label="Close"></button>
            </div>
        </div>
    </div>
</c:if>
<script>
    function confirmComplete() {
        var answer = confirm("Xác nhận xoá");
        if (answer == true) {
            return true;
        }else {
            return false;
        }
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>