<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 29/08/2020
  Time: 10:36 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${view_element}</title>
</head>
<body>
<form method="post">
    <table>
        <caption>Detailed Information</caption>
        <tr>
            <td>${title_a}</td>
            <td><input type="text" name="a" id="a" value="${user.name}"></td>
        </tr>
        <tr>
            <td>${title_b}</td>
            <td><input type="text" name="b" id="b" value="${user.email}"></td>
        </tr>
        <tr>
            <td>${title_c}</td>
            <td><input type="text" name="c" id="c" value="${user.country}"></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="button"><a href="/users">Back to ${element_name} list</a></button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
