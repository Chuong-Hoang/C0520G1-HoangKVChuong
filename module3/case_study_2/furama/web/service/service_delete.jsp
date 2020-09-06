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
        <input type="hidden" name="id" value="${el.serviceId}">

        <fieldset>${element_name.toUpperCase()} INFORMATION
            <table>
                <tr>
                    <td>${title_id}</td>
                    <td>${el.serviceId}</td>
                </tr>
                <tr>
                    <td>${title_a}</td>
                    <td>${el.serviceName}</td>
                </tr>
                <tr>
                    <td>${title_b}</td>
                    <td>${el.serviceArea}</td>
                </tr>
                <tr>
                    <td>${title_c}</td>
                    <td>${el.serviceCost}</td>
                </tr>
                <tr>
                    <td>${title_d}</td>
                    <td>${el.serviceMaxPeople}</td>
                </tr>
                <tr>
                    <td>${title_e}</td>
                    <td>${el.rentTypeId}</td>
                </tr>
                <tr>
                    <td>${title_f}</td>
                    <td>${el.serviceTypeId}</td>
                </tr>
                <c:choose>
                    <c:when test="${el.getClass().getSimpleName().compareTo('Villa') == 0 ||
                    el.getClass().getSimpleName().compareTo('House') == 0}">
                        <tr>
                            <td>${title_g}</td>
                            <td>${el.standardRoom}</td>
                        </tr>
                        <tr>
                            <td>${title_h}</td>
                            <td>${el.descriptionOtherConvenience}</td>
                        </tr>
                        <tr>
                            <td>${title_j}</td>
                            <td>${el.numberOfFloors}</td>
                        </tr>
                        <c:if test="${el.getClass().getSimpleName().compareTo('Villa') == 0}">
                            <tr>
                                <td>${title_i}</td>
                                <td>${el.poolArea}</td>
                            </tr>
                        </c:if>
                    </c:when>
                </c:choose>
                <tr>
                    <td><input type="submit" value="Delete ${element_name}"></td>
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
