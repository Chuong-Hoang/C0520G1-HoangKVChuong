<%--
  Created by IntelliJ IDEA.
  User: User
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
<!-- Element attribute defined in Model:

    ................................... -->
<form method="post">
    <fieldset>
        <legend>Element Information</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="a" id="a"></td>
            </tr>
            <tr>
                <td>Birthday:</td>
                <td><input type="text" name="b" id="b"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="c" id="c"></td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td><input type="text" name="d" id="d"></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><input type="text" name="e" id="e"></td>
            </tr>
            <tr>
                <td>Class:</td>
                <td><input type="text" name="f" id="f"></td>
            </tr>
            <tr>
                <td>Division:</td>
                <td><input type="text" name="g" id="g"></td>
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
<!--
private String name;
private String birthday;
private String email;
private String phone;
private String address;
private String className;
private String division;
-->