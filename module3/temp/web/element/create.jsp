<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 28/08/2020
  Time: 8:28 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Element</title>
</head>
<body>
<h2>Create new Element</h2>
<p>
    <a href="/elements">Back to Element list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Element Information</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="a" id="a"></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" name="b" id="b"></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><input type="text" name="c" id="c"></td>
            </tr>
            <tr>
                <td>Producer:</td>
                <td><input type="text" name="d" id="d"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create Element"></td>
            </tr>
        </table>

    </fieldset>
</form>
</body>
</html>
