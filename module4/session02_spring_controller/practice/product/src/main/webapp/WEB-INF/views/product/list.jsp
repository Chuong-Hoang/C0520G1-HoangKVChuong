<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list page</title>
</head>
<body>
<center>
    <h3>Product List</h3>
    <button type="button"><a href="/product/create">Add new</a></button>&nbsp;
    <button type="button"><a href="/product">Back to list</a></button><br><br>

    <form id="form-search" method="get" action="/product/search">
        <input type="text" name="search" placeholder="some text..." value="${search}">&nbsp;
        <button type="submit">Search</button>
    </form>
    <p style="color: red">${msg}</p>

    <form id="form" method="post" action="/product/create">
        <table border="1px" style="border-collapse: collapse;">
            <tr>
                <th>${id_tit}</th>
                <th>${a_tit}</th>
                <th>${b_tit}</th>
                <th>${c_tit}</th>
                <th>${d_tit}</th>
                <th>${e_tit}</th>
                <th>${f_tit}</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${eList}" var="el">
                <c:choose>
                    <%--  EDIT ON LIST_PAGE only  --%>
                    <c:when test="${edit_option == 1 && id == el.productId}">
                        <tr>
                            <td><input type="text" name="id" id="id" value="${el.productId}" readonly style="background-color: #d5d5d5"></td>
                            <td><input type="text" name="a" id="a" value="${el.productName}"></td>
                            <td><input type="text" name="b" id="b" value="${el.productPrice}"></td>
                            <td><input type="text" name="c" id="c" value="${el.productQuantity}"></td>
                            <td><input type="text" name="d" id="d" value="${el.productColor}"></td>
                            <td><input type="text" name="e" id="e" value="${el.productDescription}"></td>
                            <td><input type="text" name="f" id="f" value="${el.productCategory}"></td>

                            <td><button type="button" onclick="editAndSave();">Update</button></td>
                            <td><button type="button"><a href="/product">Cancel</a></button></td>
                        </tr>
                    </c:when>

                    <%--  DISPLAY only  --%>
                    <c:otherwise>
                        <tr>
                            <td>${el.productId}</td>
                            <td>${el.productName}</td>
                            <td>${el.productPrice}</td>
                            <td>${el.productQuantity}</td>
                            <td>${el.productColor}</td>
                            <td>${el.productDescription}</td>
                            <td>${el.productCategory}</td>

                            <td><a href="/product/edit/${el.productId}">Edit</a></td>
                            <td><a href="/product/delete/${el.productId}">Delete</a></td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <%--  CREATE ON LIST_PAGE  --%>
            <c:if test="${create_option == 1}">
                <tr>
                    <td><input type="text" name="id"></td>
                    <td><input type="text" name="a"></td>
                    <td><input type="text" name="b"></td>
                    <td><input type="text" name="c"></td>
                    <td><input type="text" name="d"></td>
                    <td><input type="text" name="e"></td>
                    <td><input type="text" name="f"></td>

                    <td><button type="button" onclick="document.getElementById('form').submit();">Save</button></td>
                    <td><button type="button"><a href="/product">Cancel</a></button></td>
                </tr>
            </c:if>
            <%-- CREATE ON LIST_PAGE ends --%>

        </table>
    </form>
</center>
<script>
    function editAndSave() {
        // document.getElementById('form').setAttribute("action", "/product/edit");
        document.getElementById('form').action = "/product/edit";
        document.getElementById('form').submit();
    }
</script>
</body>
</html>
