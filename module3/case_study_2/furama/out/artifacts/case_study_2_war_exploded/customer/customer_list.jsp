<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/common/head_link.jsp" %>
    <title>${element_name}</title>

</head>
<body>
<!-- Header -->
<%@ include file="/common/header.jsp"%>
<!-- end -->

<!-- Navigation -->
<%@ include file="/common/navigation.jsp"%>
<!-- end -->

<!-- Body page -->
<center>
<h2>${list_element.toUpperCase()}</h2>
<p>
    <form method="post" action="${originalLink}">
        <button class="btn btn-outline-info btn-sm"><a href="${originalLink}?action=create">${create_element}</a> </button>
        <span>&nbsp;</span>
        <button class="btn btn-outline-info btn-sm"><a href="/index.jsp">Back to home</a></button>
        <span>&nbsp;</span>
        <button class="btn btn-outline-info btn-sm"><a href="${originalLink}">Back to ${element_name} list</a></button>
        <span>&nbsp;</span>
        <button class="btn btn-outline-info btn-sm"><a href="${originalLink}?action=sort-by-name">Sort Name</a> </button>
        <span>&nbsp;</span>
        <input type="hidden" name="action" value="search">
        <input class="mr-sm-2" style="width: 200px" type="text" name="keywords" placeholder="search name">
        <button class="btn btn-primary" type="submit">Search</button>
    </form>
</p>

<table id="pagination" class="table table-striped table-hover">
    <thead class="thead">
    <tr class="table-info">
        <th scope="col">${title_id}</th>
        <th scope="col">${title_a}</th>
        <th scope="col">${title_b}</th>
        <th scope="col">${title_c}</th>
        <th scope="col">${title_d}</th>
        <th scope="col">${title_e}</th>
        <th scope="col">${title_f}</th>
        <th scope="col">${title_g}</th>
        <th scope="col">${title_h}</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
        <th scope="col">View</th>
    </tr>
    </thead>
<%--    private String customerId;--%>
<%--    private String customerName; //a--%>
<%--    private String customerBirthday;//b--%>
<%--    private String customerGender;//c--%>
<%--    private String customerIdCard;//d--%>
<%--    private String customerPhone;//e--%>
<%--    private String customerEmail;//f--%>
<%--    private String customerAddress;//g--%>
<%--    private int customerTypeId;//h--%>
    <tbody>
    <c:forEach items="${eList}" var="el">
        <tr>
            <td scope="col">${el.customerId}</td>
            <td scope="col">${el.customerName}</td>
            <td scope="col">${el.customerBirthday}</td>
            <td scope="col">${el.customerGender}</td>
            <td scope="col">${el.customerIdCard}</td>
            <td scope="col">${el.customerPhone}</td>
            <td scope="col">${el.customerEmail}</td>
            <td scope="col">${el.customerAddress}</td>
            <td scope="col">${el.customerTypeId}</td>
            <td scope="col"><a href="${originalLink}?action=edit&id=${el.customerId}">
                <button type="button" class="btn btn-outline-warning btn-sm">Edit</button></a>
            </td>

            <td scope="col">
                <button type="button" class="btn btn-outline-danger btn-sm" data-toggle="modal" data-target="#exampleModal">
                    Delete
                </button>
                <!-- Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Do you want to delete?</h5>
                                <!--<button type="button" class="close" data-dismiss="modal" aria-label="Close">-->
                                <!-- <span aria-hidden="true">&times</span>-->
                                <!--</button>-->
                            </div>
                            <div class="modal-body">

                                <h5>${element_name} name: ${el.customerName}</h5>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                    Cancel
                                </button>
                                <a href="${originalLink}?action=delete&id=${el.customerId}">
                                    <button type="button" class="btn btn-primary">
                                        Delete
                                    </button>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Modal -->
            </td>

            <td scope="col"><a href="${originalLink}?action=view&id=${el.customerId}">
                <button type="button" class="btn btn-outline-info btn-sm">View</button></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</center>
<!-- End body -->

<!-- Footer -->
<%@ include file="/common/foot_script.jsp"%>
<%@ include file="/common/footer.jsp"%>
<!-- end -->
</body>
</html>
