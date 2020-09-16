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
<%--        <button class="btn btn-outline-info btn-sm"><a href="${originalLink}?action=sort-by-name">Sort Name</a> </button>--%>
        <span>&nbsp;</span>
        <input type="hidden" name="action" value="search">
        <input class="mr-sm-2" style="width: 200px" type="text" name="keywords" placeholder="search by name">
        <button class="btn btn-primary" type="submit">Search</button>
    </form>
</p>
<p class="msg-info">${msg_create}</p>
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

        <th scope="col">Edit</th>
        <th scope="col">&nbsp;</th>
        <th scope="col">Delete</th>
        <th scope="col">View</th>
        <!-- Task 3.10 - CLEAR ON SCREEN -->
        <th scope="col">Clear</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${eList}" var="el">
<%--        ROW FOR DISPLAY --%>
        <tr id="${el.productId}"><!-- $$$$$$$$$$$$ -->
            <td scope="col" name="id" id="id1" >${el.productId}</td><!-- $$$$$$$$$$$$ -->
            <td scope="col"><input type="hidden" name="id" id="id" value="${el.productId}"></td><!--/// $$$$$$$$$$$$ -->

            <td scope="col" name="a" id="a1" >${el.productName}</td><!-- $$$$$$$$$$$$ -->
            <td scope="col"><input type="hidden" name="a" id="a" value="${el.productName}"></td><!--/// $$$$$$$$$$$$ -->

            <td scope="col" name="b" id="b1" >${el.productPrice}</td><!-- $$$$$$$$$$$$ -->
            <td scope="col"><input type="hidden" name="b" id="b" value="${el.productPrice}"></td><!--/// $$$$$$$$$$$$ -->

            <td scope="col" name="c" id="c1" >${el.productQuantity}</td><!-- $$$$$$$$$$$$ -->
            <td scope="col"><input type="hidden" name="c" id="c" value="${el.productQuantity}"></td><!--/// $$$$$$$$$$$$ -->

            <td scope="col" name="d" id="d1" >${el.productColor}</td><!-- $$$$$$$$$$$$ -->
            <td scope="col"><input type="hidden" name="d" id="d" value="${el.productColor}"></td><!--/// $$$$$$$$$$$$ -->

            <td scope="col" name="e" id="e1" >${el.productDescription}</td><!-- $$$$$$$$$$$$ -->
            <td scope="col"><input type="hidden" name="e" id="e" value="${el.productDescription}"></td><!--/// $$$$$$$$$$$$ -->

            <td scope="col" name="f" id="f1" >${el.productCategory}</td><!-- $$$$$$$$$$$$ -->
            <td scope="col"><select type="hidden" name="f" id="f" value="${el.productCategory}">
                                <c:forEach items="${eList2}" var="ca">
                                    <option>${ca.categoryName}</option><!--/// $$$$$$$$$$$$ -->
                                </c:forEach>
                            </select>
            </td>

            <td scope="col" id="edit"><a href="${originalLink}?action=edit&id=${el.productId}"><!-- $$$$$$$$$$$$ -->
                <button type="button" class="btn btn-outline-warning btn-sm" onclick="setEdit();">Edit</button></a>
            </td>

            <form method="post" action="${originalLink}">
                <input type="hidden" name="action" value="edit">
                <input type="hidden" name="id" value="${el.productId}"> <!-- $$$$$$$$$$$$ -->
                <button type="submit" class="btn btn-outline-warning btn-sm" onclick="setList();" value="Save">Save</button>
            </form>

            <td scope="col">
                <button type="button" class="btn btn-outline-danger btn-sm" data-toggle="modal" data-target="#e${el.productId}">
                    Delete
                </button>
                <!-- Modal -->
                <div class="modal fade" id="e${el.productId}" tabindex="-1" aria-labelledby="exampleModalLabel1"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel1">Do you want to delete?</h5>
                                <!--<button type="button" class="close" data-dismiss="modal" aria-label="Close">-->
                                <!-- <span aria-hidden="true">&times</span>-->
                                <!--</button>-->
                            </div>
                            <div class="modal-body">
                                <h5>${element_name} name: ${el.productName}</h5><!-- $$$$$$$$$$$$ -->
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                    Cancel
                                </button>
                                <a href="${originalLink}?action=delete&id=${el.productId}"><!-- $$$$$$$$$$$$ -->
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

            <td scope="col"><a href="${originalLink}?action=view&id=${el.productId}"><!-- $$$$$$$$$$$$ -->
                <button type="button" class="btn btn-outline-info btn-sm">View</button></a>
            </td>

            <!-- CLEAR ON SCREEN -->
            <td scope="col">
                <button type="button" class="btn btn-outline-success btn-sm"
                        onclick="displayHiddenElement('${el.productId}')">CLEAR</button><!-- $$$$$$$$$$$$ -->
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</center>
<!-- End body -->

<!-- Footer -->
<script>
    function setEdit() {
        document.getElementById("id").setAttribute("type", "text");
        document.getElementById("a").setAttribute("type", "text");
        document.getElementById("b").setAttribute("type", "text");
        document.getElementById("c").setAttribute("type", "text");
        document.getElementById("d").setAttribute("type", "text");
        document.getElementById("e").setAttribute("type", "text");
        document.getElementById("f").setAttribute("type", "text");

        document.getElementById("id1").style.display = "none";
        document.getElementById("a1").style.display = "none";
        document.getElementById("b1").style.display = "none";
        document.getElementById("c1").style.display = "none";
        document.getElementById("d1").style.display = "none";
        document.getElementById("e1").style.display = "none";
        document.getElementById("f1").style.display = "none";

        document.getElementById("edit").style.display = "none";
        document.getElementById("list").style.display = "table-row";
    }
    function setList() {
        document.getElementById("id").setAttribute("type", "hidden");
        document.getElementById("a").setAttribute("type", "hidden");
        document.getElementById("b").setAttribute("type", "hidden");
        document.getElementById("c").setAttribute("type", "hidden");
        document.getElementById("d").setAttribute("type", "hidden");
        document.getElementById("e").setAttribute("type", "hidden");
        document.getElementById("f").setAttribute("type", "hidden");

        document.getElementById("id1").style.display = "table-row";
        document.getElementById("a1").style.display = "table-row";
        document.getElementById("b1").style.display = "table-row";
        document.getElementById("c1").style.display = "table-row";
        document.getElementById("d1").style.display = "table-row";
        document.getElementById("e1").style.display = "table-row";
        document.getElementById("f1").style.display = "table-row";

        document.getElementById("edit").style.display = "table-row";
        document.getElementById("list").style.display = "none";
    }
</script>
<%@ include file="/common/foot_script.jsp"%>
<%@ include file="/common/footer.jsp"%>
<!-- end -->
</body>
</html>
