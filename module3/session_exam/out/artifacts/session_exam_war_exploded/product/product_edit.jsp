<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/common/head_link.jsp" %>
    <title>${edit_element}</title>
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
    <h2>${edit_element}</h2>
    <p><span class="msg-info">${msg_edit}</span></p>
    <form method="post" action="${originalLink}">
        <input type="hidden" name="action" value="edit">

<%--        ******************************************************************** --%>
        <input type="hidden" name="id" value="${el.id}">

        <fieldset>${element_name.toUpperCase()} INFORMATION
            <table class="table table-striped table-hover" style="width: 35%">
                <tr>
                    <td scope="col">${title_id}</td>
                    <td scope="col"><input type="text" name="idNew" id="idNew" value="${el.id}">
                        <span class="msg-invalid">(*)</span><br>
                        <span class="msg-invalid">${msg_invalid_id}</span>
                    </td>
                </tr>
                <tr>
                    <td scope="col">${title_a}</td>
                    <td scope="col"><input type="text" name="a" id="a" value="${el.productCode}">
                        <span class="msg-invalid">(*)</span><br>
                        <span class="msg-invalid">${msg_invalid_a}</span>
                    </td>
                </tr>
                <tr>
                    <td scope="col">${title_b}</td>
                    <td scope="col"><input type="text" name="b" id="b" value="${el.productName}">
                        <span class="msg-invalid">(*)</span><br>
                        <span class="msg-invalid">${msg_invalid_b}</span>
                    </td>
                </tr>
                <tr>
                    <td scope="col">${title_c}</td>
                    <td scope="col"><input type="text" name="c" id="c" value="${el.productPrice}">
                        <span class="msg-invalid">(*)</span><br>
                        <span class="msg-invalid">${msg_invalid_c}</span>
                    </td>
                </tr>
                <tr>
                    <td scope="col">${title_d}</td>
                    <td scope="col"><input type="text" name="d" id="d" value="${el.productQuantity}">
                        <span class="msg-invalid">(*)</span><br>
                        <span class="msg-invalid">${msg_invalid_d}</span>
                    </td>
                </tr>
                <tr>
                    <td scope="col">${title_e}</td>
                    <td scope="col"><input type="text" name="e" id="e" value="${el.productProducer}">
                        <span class="msg-invalid">(*)</span><br>
                        <span class="msg-invalid">${msg_invalid_e}</span>
                    </td>
                </tr>

                <c:choose>
                    <c:when test="${el.getClass().getSimpleName().compareTo('ImProduct') == 0}">
                        <tr>
                            <td scope="col">${title_f}</td>
                            <td scope="col"><input type="text" name="f" id="f" value="${el.importedPrice}">
                                <span class="msg-invalid">(*)</span><br>
                                <span class="msg-invalid">${msg_invalid_f}</span>
                            </td>
                        </tr>
                        <tr>
                            <td scope="col">${title_g}</td>
                            <td scope="col"><input type="text" name="g" id="g" value="${el.importProvince}">
                                <span class="msg-invalid">(*)</span><br>
                                <span class="msg-invalid">${msg_invalid_g}</span>
                            </td>
                        </tr>
                        <tr>
                            <td scope="col">${title_h}</td>
                            <td scope="col"><input type="text" name="h" id="h" value="${el.importTax}">
                                <span class="msg-invalid">(*)</span><br>
                                <span class="msg-invalid">${msg_invalid_g}</span>
                            </td>
                        </tr>

                    </c:when>
                    <c:when test="${el.getClass().getSimpleName().compareTo('ExProduct') == 0}">
                            <tr>
                                <td scope="col">${title_i}</td>
                                <td scope="col"><input type="text" name="i" id="i" value="${el.exportedPrice}">
                                    <span class="msg-invalid">(*)</span><br>
                                    <span class="msg-invalid">${msg_invalid_i}</span>
                                </td>
                            </tr>
                            <tr>
                                <td scope="col">${title_j}</td>
                                <td scope="col"><input type="text" name="j" id="j" value="${el.buyingCountry}">
                                    <span class="msg-invalid">(*)</span><br>
                                    <span class="msg-invalid">${msg_invalid_j}</span>
                                </td>
                            </tr>

                    </c:when>
                    <c:otherwise></c:otherwise>
                </c:choose>
                <tr>
                    <td scope="col"><button type="submit"  class="btn btn-outline-danger btn-sm">
                        Update ${element_name}</button>
                    </td>
                    <td scope="col"><button type="button" class="btn btn-outline-info btn-sm">
                        <a href=${originalLink}>Back to ${element_name} list</a></button>
                    </td>
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
