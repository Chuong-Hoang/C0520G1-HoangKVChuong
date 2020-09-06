<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../style/css_style.css">

    <title>${view_element}</title>
</head>
<body>
<center>
    <h2>${view_element}</h2>
    <fieldset>${element_name.toUpperCase()} INFORMATION
        <table>
            <tr>
                <td>${title_id}</td>
                <td>${el.contractDetailId}</td>
            </tr>
            <tr>
                <td>${title_a}</td>
                <td>${el.contractId}</td>
            </tr>
            <tr>
                <td>${title_b}</td>
                <td>${el.attachServiceId}</td>
            </tr>
            <tr>
                <td>${title_c}</td>
                <td>${el.quantity}</td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button type="button"><a href=${originalLink}>Back to ${element_name} list</a></button>
                </td>
            </tr>
        </table>
    </fieldset>
</center>

<script src="http://code.jquery.com/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</body>
</html>
