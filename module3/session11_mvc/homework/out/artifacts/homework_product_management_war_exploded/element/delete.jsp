<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 28/08/2020
  Time: 11:07 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Element</title>
</head>
<body>
<h2>Delete Element</h2>
<p>
    <a href="/elements">Back to element list</a>
</p>
<form method="post">
    <h3>Do you really want to delete this element?</h3>
    <fieldset>
        <legend>Element Information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>${element.name}</td>
            </tr>
            <tr>
                <td>Price: </td>
                <td>${element.price}</td>
            </tr>
            <tr>
                <td>Description: </td>
                <td>${element.desc}</td>
            </tr>
            <tr>
                <td>Producer: </td>
                <td>${element.producer}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete Element"></td>
                <td><a href="/elements">Back to element list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
