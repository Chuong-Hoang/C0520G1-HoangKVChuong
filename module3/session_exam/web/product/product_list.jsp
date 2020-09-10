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
        <button class="btn btn-outline-info btn-sm"><a href="/home.jsp">Back to home</a></button>
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
        <th scope="col">${title_i}</th>
        <th scope="col">${title_j}</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
        <th scope="col">View</th>
        <!-- Task 3.10 - CLEAR ON SCREEN -->
        <th scope="col">Clear</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${eList}" var="el">
        <tr id="${el.id}"> <!-- $$$$$$$$$$$$ -->
            <td scope="col">${el.id}</td> <!-- $$$$$$$$$$$$ -->
            <td scope="col">${el.productCode}</td> <!-- $$$$$$$$$$$$ -->
            <td scope="col">${el.productName}</td> <!-- $$$$$$$$$$$$ -->
            <td scope="col">${el.productPrice}</td> <!-- $$$$$$$$$$$$ -->
            <td scope="col">${el.productQuantity}</td> <!-- $$$$$$$$$$$$ -->
            <td scope="col">${el.productProducer}</td> <!-- $$$$$$$$$$$$ -->

        <c:choose>
            <c:when test="${el.getClass().getSimpleName().compareTo('ImProduct') == 0}"> <!-- $$$$$$$$$$$$ -->
                <td scope="col">${el.importedPrice}</td> <!-- $$$$$$$$$$$$ -->
                <td scope="col">${el.importProvince}</td> <!-- $$$$$$$$$$$$ -->
                <td scope="col">${el.importTax}</td> <!-- $$$$$$$$$$$$ -->
                <td scope="col">${"-"}</td> <!-- $$$$$$$$$$$$ -->
                <td scope="col">${"-"}</td> <!-- $$$$$$$$$$$$ -->
            </c:when>
            <c:when test="${el.getClass().getSimpleName().compareTo('ExProduct') == 0}"> <!-- $$$$$$$$$$$$ -->
                <td scope="col">${"-"}</td> <!-- $$$$$$$$$$$$ -->
                <td scope="col">${"-"}</td> <!-- $$$$$$$$$$$$ -->
                <td scope="col">${"-"}</td> <!-- $$$$$$$$$$$$ -->
                <td scope="col">${el.exportedPrice}</td> <!-- $$$$$$$$$$$$ -->
                <td scope="col">${el.buyingCountry}</td> <!-- $$$$$$$$$$$$ -->
            </c:when>
            <c:otherwise>

            </c:otherwise>
        </c:choose>
            <td scope="col"><a href="${originalLink}?action=edit&id=${el.id}"> <!-- $$$$$$$$$$$$ -->
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

                                <h5>${element_name} name: ${el.productName}</h5> <!-- $$$$$$$$$$$$ -->
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                    Cancel
                                </button>
                                <a href="${originalLink}?action=delete&id=${el.id}"> <!-- $$$$$$$$$$$$ -->
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

            <td scope="col"><a href="${originalLink}?action=view&id=${el.id}"> <!-- $$$$$$$$$$$$ -->
                <button type="button" class="btn btn-outline-info btn-sm">View</button></a>
            </td>

            <!-- Task 3.10 - CLEAR ON SCREEN -->
            <td scope="col"> <!----------------------------------------------------------------------- $$$$$$$$$$$$ -->
                <button type="button" class="btn btn-outline-success btn-sm" onclick="displayHiddenElement('${el.id}')">CLEAR</button>
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
