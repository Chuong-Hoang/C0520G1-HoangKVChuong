<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/common/head_link.jsp" %>
    <title>${delete_element}</title>
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
    <h2>${delete_element}</h2>
    <p><span class="msg-info">${msg_delete}</span></p>
    <form method="post" action="${originalLink}">
        <input type="hidden" name="action" value="delete">
<%--        ********************************************************************--%>
        <input type="hidden" name="id" value="${el.id}">

        <fieldset>${element_name.toUpperCase()} INFORMATION
            <table class="table table-striped table-hover" style="width: 25%">
                <tr>
                    <td scope="col">${title_id}</td>
                    <td scope="col">${el.id}</td>
                </tr>
                <tr>
                    <td scope="col">${title_a}</td>
                    <td scope="col">${el.productCode}</td>
                </tr>
                <tr>
                    <td scope="col">${title_b}</td>
                    <td scope="col">${el.productName}</td>
                </tr>
                <tr>
                    <td>${title_c}</td>
                    <td>${el.productPrice}</td>
                </tr>
                <tr>
                    <td scope="col">${title_d}</td>
                    <td scope="col">${el.productQuantity}</td>
                </tr>
                <tr>
                    <td scope="col">${title_e}</td>
                    <td scope="col">${el.productProducer}</td>
                </tr>

                <c:choose>
                    <c:when test="${el.getClass().getSimpleName().compareTo('ImProduct') == 0}">
                        <tr>
                            <td scope="col">${title_f}</td>
                            <td scope="col">${el.importedPrice}</td>
                        </tr>
                        <tr>
                            <td scope="col">${title_g}</td>
                            <td scope="col">${el.importProvince}</td>
                        </tr>
                        <tr>
                            <td scope="col">${title_h}</td>
                            <td scope="col">${el.importTax}</td>
                        </tr>
                    </c:when>

                    <c:when test="${el.getClass().getSimpleName().compareTo('ExProduct') == 0}">
                        <tr>
                            <td scope="col">${title_i}</td>
                            <td scope="col">${el.exportedPrice}</td>
                        </tr>
                        <tr>
                            <td scope="col">${title_j}</td>
                            <td scope="col">${el.buyingCountry}</td>
                        </tr>
                    </c:when>
                    <c:otherwise>

                    </c:otherwise>
                </c:choose>
                <tr>
                    <td scope="col"><button type="submit"  class="btn btn-outline-danger btn-sm">Delete ${element_name}</button></td>
                    <td scope="col"><button type="button" class="btn btn-outline-info btn-sm"><a href=${originalLink}>Back to ${element_name} list</a></button></td>
                </tr>
            </table>
        </fieldset>
    </form>
</center>
<!-- End body -->

<!-- Footer -->
<script src="../all/style/service_option.js"></script>
<%@ include file="/common/foot_script.jsp"%>
<%@ include file="/common/footer.jsp"%>
<!-- end -->
</body>
</html>
