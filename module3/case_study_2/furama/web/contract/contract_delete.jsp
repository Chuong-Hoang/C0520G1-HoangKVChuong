<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../style/css_style.css">

    <title>${delete_element}</title>
</head>
<body>
<center>
    <h2>${delete_element}</h2>
    <p><span>${msg_delete}</span></p>
    <form method="post" action="${originalLink}">
        <input type="hidden" name="action" value="delete">
        <input type="hidden" name="id" value="${el.contractId}">

        <fieldset>${element_name.toUpperCase()} INFORMATION
            <table>
                <tr>
                    <td>${title_id}</td>
                    <td>${el.contractId}</td>
                </tr>
                <tr>
                    <td>${title_a}</td>
                    <td>${el.contractStartDate}</td>
                </tr>
                <tr>
                    <td>${title_b}</td>
                    <td>${el.contractEndDate}</td>
                </tr>
                <tr>
                    <td>${title_c}</td>
                    <td>${el.contractDeposit}</td>
                </tr>
                <tr>
                    <td>${title_d}</td>
                    <td>${el.contractTotalMoney}</td>
                </tr>
                <tr>
                    <td>${title_e}</td>
                    <td>${el.contractEmployeeId}</td>
                </tr>
                <tr>
                    <td>${title_f}</td>
                    <td>${el.contractCustomerId}</td>
                </tr>
                <tr>
                    <td>${title_g}</td>
                    <td>${el.contractServiceId}</td>
                </tr>
                <tr>
                    <td><input type="submit" value="Delete ${element_name}"></td>
                    <td><button type="button"><a href=${originalLink}>Back to ${element_name} list</a></button></td>
                </tr>
            </table>
        </fieldset>
    </form>
</center>

<script src="http://code.jquery.com/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</body>
</html>
