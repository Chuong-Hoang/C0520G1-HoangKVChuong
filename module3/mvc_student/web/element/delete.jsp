<%--
  Created by IntelliJ IDEA.
  User: User
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
                <td>Birthday: </td>
                <td>${element.birthday}</td>
            </tr>
            <tr>
                <td>Email: </td>
                <td>${element.email}</td>
            </tr>
            <tr>
                <td>Phone: </td>
                <td>${element.phone}</td>
            </tr>
            <tr>
                <td>Address: </td>
                <td>${element.address}</td>
            </tr>
            <tr>
                <td>Class: </td>
                <td>${element.className}</td>
            </tr>
            <tr>
                <td>Division: </td>
                <td>${element.division}</td>
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
<!--
private String name;
private String birthday;
private String email;
private String phone;
private String address;
private String className;
private String division;
-->