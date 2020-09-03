<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 29/08/2020
  Time: 4:06 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${create_element}</title>
</head>
<body>
<h2>${create_element}</h2>
<p><span>${msg}</span></p>
<form method="post">
    <fieldset>${element_name.toUpperCase()} INFORMATION
    <table>
        <tr>
            <td>${title_a}</td>
            <td><input type="text" name="a" id="a"></td>
        </tr>
        <tr>
            <td>${title_b}</td>
            <td><input type="text" name="b" id="b"></td>
        </tr>
        <tr>
            <td>${title_c}</td>
            <td><input type="text" name="c" id="c"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Create ${element_name}"></td>
            <td><button type="button"><a href="/users">Back to ${element_name} list</a></button></td>
        </tr>
    </table>
    </fieldset>
</form>
</body>
</html>
