<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27/08/2020
  Time: 10:14 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Departments and Employees</h2>
<!-- use for to traverse departments -->
<c:forEach items="${departments}" var="dept">
    <h3>${dept.deptName}</h3>
    <ul>
        <!-- use for to traverse all employees in the dept -->
        <c:forEach items="${dept.employees}" var="emp">
            <li>${emp.empName} - (${emp.job})</li>
        </c:forEach>
    </ul>
</c:forEach>
</body>
</html>
