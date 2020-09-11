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
                <td scope="col">${el.employeeId}</td>
            </tr>
            <tr>
                <td scope="col">${title_a}</td>
                <td scope="col">${el.employeeName}</td>
            </tr>
            <tr>
                <td scope="col">${title_b}</td>
                <td scope="col">${el.employeeBirthday}</td>
            </tr>
            <tr>
                <td scope="col">${title_c}</td>
                <td scope="col">${el.employeeIdCard}</td>
            </tr>
            <tr>
                <td scope="col">${title_d}</td>
                <td scope="col">${el.employeeSalary}</td>
            </tr>
            <tr>
                <td scope="col">${title_e}</td>
                <td scope="col">${el.employeePhone}</td>
            </tr>
            <tr>
                <td scope="col">${title_f}</td>
                <td scope="col">${el.employeeEmail}</td>
            </tr>
            <tr>
                <td scope="col">${title_g}</td>
                <td scope="col">${el.employeeAddress}</td>
            </tr>
            <tr>
                <td scope="col">${title_h}</td>
                <td scope="col">${el.positionId}</td>
            </tr>
            <tr>
                <td scope="col">${title_i}</td>
                <td scope="col">${el.educationDegreeId}</td>
            </tr>
            <tr>
                <td scope="col">${title_j}</td>
                <td scope="col">${el.divisionId}</td>
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