<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 29/08/2020
  Time: 4:40 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${edit_element}</title>
</head>
<body>
<h2>${edit_element}</h2>
<p><span>${msg_edit}</span></p>
<form method="post">
<%--    <input type="hidden" name="id" value="${user.id}">--%>
<%--    <input type="hidden" name="action" value="edit">--%>
    <fieldset>EDIT ${element_name.toUpperCase()} INFORMATION:
        <table>
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
                <td><input type="submit" value="Update ${element_name}"></td>
                <td><button type="button"><a href="/users">Back to ${element_name} list</a></button></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
