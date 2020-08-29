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
</table>
</body>
</html>
