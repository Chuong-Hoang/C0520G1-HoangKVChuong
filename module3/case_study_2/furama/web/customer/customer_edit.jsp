<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../style/css_style.css">

    <title>${edit_element}</title>
</head>
<body>
<center>
    <h2>${edit_element}</h2>
    <p><span>${msg_edit}</span></p>
    <form method="post" action="${originalLink}">
        <input type="hidden" name="action" value="edit">
        <input type="hidden" name="id" value="${el.customerId}">

        <fieldset>${element_name.toUpperCase()} INFORMATION
            <table>
                <tr>
                    <td>${title_id}</td>
                    <td><input type="text" name="idNew" id="idNew" value="${el.customerId}"></td>
                </tr>
                <tr>
                    <td>${title_a}</td>
                    <td><input type="text" name="a" id="a" value="${el.customerName}"></td>
                </tr>
                <tr>
                    <td>${title_b}</td>
                    <td><input type="text" name="b" id="b" value="${el.customerBirthday}"></td>
                </tr>
                <tr>
                    <td>${title_c}</td>
                    <td><input type="text" name="c" id="c" value="${el.customerGender}"></td>
                </tr>
                <tr>
                    <td>${title_d}</td>
                    <td><input type="text" name="d" id="d" value="${el.customerIdCard}"></td>
                </tr>
                <tr>
                    <td>${title_e}</td>
                    <td><input type="text" name="e" id="e" value="${el.customerPhone}"></td>
                </tr>
                <tr>
                    <td>${title_f}</td>
                    <td><input type="text" name="f" id="f" value="${el.customerEmail}"></td>
                </tr>
                <tr>
                    <td>${title_g}</td>
                    <td><input type="text" name="g" id="g" value="${el.customerAddress}"></td>
                </tr>
                <tr>
                    <td>${title_h}</td>
                    <td><input type="text" name="h" id="h" value="${el.customerTypeId}"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Update ${element_name}"></td>
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
