<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit page</title>
</head>
<body>
<form method="post" action="/student/confirm-edit">
    <label>Id</label>
    <input type="text" name="id" value="${el.id}" readonly><br><br>

    <label>Name</label>
    <input type="text" name="name" value="${el.name}"><br><br>

    <label>Age</label>
    <input type="text" name="age" value="${el.age}"><br><br>

    <input type="submit" value="OK">
</form>
</body>
</html>
