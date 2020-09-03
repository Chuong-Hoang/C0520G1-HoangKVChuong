<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 29/08/2020
  Time: 3:23 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${element_list}</title>
    <style>
        table {
            border: 1px solid navy;
            border-collapse: collapse;
        }

        tr, th, td {
            border: 1px solid navy;
            padding: 5px 15px;
        }

        tr:nth-child(odd) {
            background: lightgray;
        }
        a {
            text-decoration: none;
            color: green;
            font-weight: bold;
        }

        button {
            background: lightgrey;
            padding: 5px;
            border: 1px solid lightgrey;
            border-radius: 3px;
        }
    </style>
</head>
<body>
<h2>${name_list.toUpperCase()}</h2>

<p>
<button><a href="/users?action=create">Create new ${element_name}</a></button>
</p>
<p><span>${msg}</span></p>
<table>
    <tr>
        <th>ID</th>
        <th>${title_a}</th>
        <th>${title_b}</th>
        <th>${title_c}</th>
        <th>Edit</th>
        <th>View Detailed</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.country}</td>
            <td><a href="/users?action=edit&id=${user.id}">Edit</a></td>
            <td><a href="/users?action=view&id=${user.id}">View</a></td>
            <td><a href="/users?action=delete&id=${user.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<p>&nbsp</p>
<form method="post" action="/users?action=search">
    <input type="text" name="name" placeholder="Enter some information">
    <input type="submit" value="Search">
    <button><a href="/users?">Back to ${element_name} list</a></button>
</form>
</body>
</html>
