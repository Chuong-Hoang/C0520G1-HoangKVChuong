<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18/09/2020
  Time: 11:57 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete page</title>
</head>
<body>
<form method="post" action="/student/delete">
    <label style="color: red">Do you really want to delete this? </label><br><br>
    <label>Id</label>
    <input type="text" name="id" value="${el.id}" readonly><br><br>

    <label>Name</label>
    <input type="text" name="name" value="${el.name}" readonly><br><br>

    <label>Age</label>
    <input type="text" name="age" value="${el.age}" readonly><br><br>

    <input type="submit" value="Delete">
    <button type="button"><a href="/student">Cancel</a></button>
</form>
</body>
</html>
