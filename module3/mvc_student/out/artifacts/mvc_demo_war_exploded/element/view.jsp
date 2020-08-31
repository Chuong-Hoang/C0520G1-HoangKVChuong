<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 29/08/2020
  Time: 12:30 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Element</title>
</head>
<body>
<h2>Element Detailed Information</h2>
<p>
    <a href="/elements">Back to element list</a>
</p>
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
</table>
</body>
</html>
