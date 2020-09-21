<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list page</title>
</head>
<body>
<button type="button"><a href="/student/create">Add New</a></button>
<br><br>
<form method="post" action="/student/find">
    <input type="text" name="search" placeholder="some text here" value="${search}">
    <input type="submit" value="Search">
</form>
<br>
<p style="color: red">${msg}</p>

<form method="post" action="/student/confirm-edit">
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="el" items="${eList}">
            <c:choose>
                <c:when test="${edit == 1 && id == el.id}">
                    <tr>
                        <td><input type="text" name="id" value="${el.id}" readonly></td>
                        <td><input type="text" name="name" value="${el.name}"></td>
                        <td><input type="text" name="age" value="${el.age}"></td>
                        <td><button onclick="this.submit()">Save</button></td>
                        <td><a href="/student">Cancel</a></td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td>${el.id}</td>
                        <td>${el.name}</td>
                        <td>${el.age}</td>
                        <td><a href="/student/edit/${el.id}">Edit</a></td>
                        <td><a href="/student/delete/${el.id}">Delete</a></td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </table>
</form>

</body>
</html>
