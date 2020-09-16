<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello list</title>
</head>
<body>
<table border="1px" style="border-collapse: collapse;">
    <tr>
    <th>Name</th>
    <th>Age</th>
    <th>Address</th>
    </tr>
    <c:forEach items="${eList}" var="el">
        <tr>
            <td>${el.name}</td>
            <td>${el.age}</td>
            <td>${el.address}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
