<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list page</title>
</head>
<body>
<table border="1px solid blue" style="border-collapse: collapse">
    <tr>
        <th>Name</th>
        <th>Gender</th>
        <th>Is admin</th>
        <th>Hobbies</th>
        <th>Type</th>
        <th>Country</th>
        <th>Edit</th>
    </tr>
    <c:forEach items="${eList}" var="user">
        <tr>
            <td>${user.name}</td>
            <td>${user.gender}</td>
            <td>${user.admin}</td>
            <td>
                <ul>
                    <c:forEach items="${user.hobbies}" var="hobby">
                        <li>${hobby}</li>
                    </c:forEach>
                </ul>
            </td>
            <td>${user.type}</td>
            <td>${user.country}</td>
            <td><button type="submit"><a href="/user/edit/${user.id}">Edit</a></button></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
