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
        <input type="hidden" name="id" value="${el.serviceId}">

        <fieldset>${element_name.toUpperCase()} INFORMATION
            <table>
                <tr>
                    <td>${title_id}</td>
                    <td><input type="text" name="idNew" id="idNew" value="${el.serviceId}"></td>
                </tr>
                <tr>
                    <td>${title_a}</td>
                    <td><input type="text" name="a" id="a" value="${el.serviceName}"></td>
                </tr>
                <tr>
                    <td>${title_b}</td>
                    <td><input type="text" name="b" id="b" value="${el.serviceArea}"></td>
                </tr>
                <tr>
                    <td>${title_c}</td>
                    <td><input type="text" name="c" id="c" value="${el.serviceCost}"></td>
                </tr>
                <tr>
                    <td>${title_d}</td>
                    <td><input type="text" name="d" id="d" value="${el.serviceMaxPeople}"></td>
                </tr>
                <tr>
                    <td>${title_e}</td>
                    <td><input type="text" name="e" id="e" value="${el.rentTypeId}"></td>
                </tr>
                <tr>
                    <td>${title_f}</td>
                    <td><input type="text" name="f" id="f" value="${el.serviceTypeId}"></td>
                </tr>
                <c:choose>
                    <c:when test="${el.getClass().getSimpleName().compareTo('Villa') == 0 ||
                    el.getClass().getSimpleName().compareTo('House') == 0}">
                        <tr>
                            <td>${title_g}</td>
                            <td><input type="text" name="g" id="g" value="${el.standardRoom}"></td>
                        </tr>
                        <tr>
                            <td>${title_h}</td>
                            <td><input type="text" name="h" id="h" value="${el.descriptionOtherConvenience}"></td>
                        </tr>
                        <tr>
                            <td>${title_j}</td>
                            <td><input type="text" name="j" id="j" value="${el.numberOfFloors}"></td>
                        </tr>
                        <c:if test="${el.getClass().getSimpleName().compareTo('Villa') == 0}">
                            <tr>
                                <td>${title_i}</td>
                                <td><input type="text" name="i" id="i" value="${el.poolArea}"></td>
                            </tr>
                        </c:if>
                    </c:when>
                </c:choose>
                <tr>
                    <td><input type="submit" value="Update ${element_name}"></td>
                    <td><button type="button"><a href=${originalLink}>Back to ${element_name} list</a></button></td>
                </tr>
            </table>
        </fieldset>
    </form>
</center>

<script src="../style/service_option.js"></script>
<script src="http://code.jquery.com/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</body>
</html>
