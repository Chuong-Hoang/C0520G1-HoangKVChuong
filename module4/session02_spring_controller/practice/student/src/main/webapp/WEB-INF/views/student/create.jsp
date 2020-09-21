<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create page</title>
</head>
<body>
<form method="post" action="/student/create">
    <label>Id</label>
    <input type="text" name="id"><br><br>

    <label>Name</label>
    <input type="text" name="name"><br><br>

    <label>Age</label>
    <input type="text" name="age"><br><br>

    <input type="submit" value="Save">
</form>
</body>
</html>
