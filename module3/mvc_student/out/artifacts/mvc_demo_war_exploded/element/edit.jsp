<%--
  Created by IntelliJ IDEA.
  User: User
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
                <td>Birthday:</td>
                <td><input type="text" name="b" id="b" value="${element.birthday}"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="c" id="c" value="${element.email}"></td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td><input type="text" name="d" id="d" value="${element.phone}"></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><input type="text" name="e" id="e" value="${element.address}"></td>
            </tr>
            <tr>
                <td>Class:</td>
                <td><input type="text" name="f" id="f" value="${element.className}"></td>
            </tr>
            <tr>
                <td>Division:</td>
                <td><input type="text" name="g" id="g" value="${element.division}"></td>
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
<!--
private String name;
private String birthday;
private String email;
private String phone;
private String address;
private String className;
private String division;
-->