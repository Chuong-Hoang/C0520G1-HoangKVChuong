<%@ page import="model.Customer" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27/08/2020
  Time: 2:46 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Customers</title>
    <style>
        table {
            border-collapse: collapse;
            background: white;
            border: 1px solid lightgray;
            mso-border-shadow: yes;
        }
        table, th, td {
            border: 1px solid #5a6268;
            text-align: center;
            padding: 5px 10px;
        }
    </style>
</head>
<body>

<table>
    <caption>New Customers List</caption>
    <tr>
        <th>Name</th>
        <th>Birthday</th>
        <th>Address</th>
        <th>Image</th>
    </tr>
    <c:forEach items="${customerListServlet}" var="e">
        <tr>
            <td><c:out value="${e.name}"/> </td>
            <td><c:out value="${e.birthday}"/></td>
            <td><c:out value="${e.address}"/></td>
            <td>${e.image}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
