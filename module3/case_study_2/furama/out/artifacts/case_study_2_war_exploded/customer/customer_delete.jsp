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
        <input type="hidden" name="id" value="${el.customerId}">

        <fieldset>${element_name.toUpperCase()} INFORMATION
            <table class="table table-striped table-hover" style="width: 25%">
                <tr>
                    <td scope="col">${title_id}</td>
                    <td scope="col">${el.customerId}</td>
                </tr>
                <tr>
                    <td scope="col">${title_a}</td>
                    <td scope="col">${el.customerName}</td>
                </tr>
                <tr>
                    <td scope="col">${title_b}</td>
                    <td scope="col">${el.customerBirthday}</td>
                </tr>
                <tr>
                    <td scope="col">${title_c}</td>
                    <td scope="col">${el.customerGender}</td>
                </tr>
                <tr>
                    <td scope="col">${title_d}</td>
                    <td scope="col">${el.customerIdCard}</td>
                </tr>
                <tr>
                    <td scope="col">${title_e}</td>
                    <td scope="col">${el.customerPhone}</td>
                </tr>
                <tr>
                    <td scope="col">${title_f}</td>
                    <td scope="col">${el.customerEmail}</td>
                </tr>
                <tr>
                    <td scope="col">${title_g}</td>
                    <td scope="col">${el.customerAddress}</td>
                </tr>
                <tr>
                    <td scope="col">${title_h}</td>
                    <td scope="col">${el.customerTypeId}</td>
                </tr>
                <tr>
                    <td scope="col"><button type="submit"  class="btn btn-outline-danger btn-sm">Delete ${element_name}</td>
                    <td scope="col"><button type="button" class="btn btn-outline-info btn-sm"><a href=${originalLink}>Back to ${element_name} list</a></button></td>
                </tr>
            </table>
        </fieldset>
    </form>
</center>
<!-- End body -->

<!-- Footer -->
<%@ include file="/common/foot_script.jsp"%>
<%@ include file="/common/footer.jsp"%>
<!-- end -->
</body>
</html>
