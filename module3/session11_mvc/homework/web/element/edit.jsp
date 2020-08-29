<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 28/08/2020
  Time: 11:06 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Element</title>
</head>
<body>
<h2>Edit Element</h2>
<p>
    <a href="/elements">Back to Element List</a>
</p>
<form method="post">
    <fieldset>
        <legend>Element Information</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="a" id="a" value="${element.name}"></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" name="b" id="b" value="${element.price}"></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><input type="text" name="c" id="c" value="${element.desc}"></td>
            </tr>
            <tr>
                <td>Producer:</td>
                <td><input type="text" name="d" id="d" value="${element.producer}"></td>
            </tr>
            <tr>
                <td><span>Update?</span></td>
                <td><input type="submit" value="Update Element"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
