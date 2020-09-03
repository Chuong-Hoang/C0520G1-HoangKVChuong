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
    <title>Display List</title>
    <style>
        table {
            border: 1px solid navy;
            border-collapse: collapse;
        }

        tr, th, td {
            border: 1px solid navy;
            padding: 5px 15px;
        }
        a {
            text-decoration: none;
            color: mediumvioletred;
        }

        button {
            background: dodgerblue;
            padding: 5px;
            border: 1px solid lightgrey;
            border-radius: 3px;
        }
    </style>
</head>
<body>
<h2>Contact List</h2>

<p>
<button><a href="/elements?action=create">Create New Element</a></button>
<button><a href="/elements?action=abcd">Action: abcd</a></button>
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
    <c:forEach items="${elements}" var="element">
        <tr>
            <td>${element.id}</td>
            <td>${element.prop_A}</td>
            <td>${element.prop_B}</td>
            <td>${element.prop_C}</td>
            <td><a href="/elements?action=edit&id=${element.id}">Edit</a></td>
            <td><a href="/elements?action=view&id=${element.id}">View</a></td>
            <td><a href="/elements?action=delete&id=${element.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<p>&nbsp</p>
<form method="post" action="/elements?action=search">
    <input type="text" name="name" placeholder="Enter some information">
    <input type="submit" value="Search">
    <button><a href="/elements?">Back To Home</a></button>
</form>
</body>
</html>
