<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/common/head_link.jsp" %>
    <title>${view_element}</title>
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
    <h2>${view_element}</h2>
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
                <td scope="col"></td>
                <td scope="col">
                    <button type="button" class="btn btn-outline-info btn-sm"><a href=${originalLink}>Back to ${element_name} list</a></button>
                </td>
            </tr>
        </table>
    </fieldset>
</center>
<!-- End body -->

<!-- Footer -->
<%@ include file="/common/foot_script.jsp"%>
<%@ include file="/common/footer.jsp"%>
<!-- end -->
</body>
</html>
