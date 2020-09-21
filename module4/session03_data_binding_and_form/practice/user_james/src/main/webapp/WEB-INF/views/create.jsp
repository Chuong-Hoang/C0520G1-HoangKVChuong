<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create new</title>
</head>
<body>
<form:form modelAttribute="user" action="/user/create" method="post">
    ID: <form:input path="id"/><br><br>
    Name: <form:input path="name"/><br><br>
    Gender: <form:radiobuttons path="gender" items="${gendersArray}"/><br><br>
    Is admin: <form:checkbox path="admin"/><br><br>
    Hobbies: <form:checkboxes path="hobbies" items="${hobbiesArray}"/><br><br>
    Type: <form:select path="type" items="${typesArray}"/><br><br>
    Country: <form:select path="country" items="${countriesArray}"/><br><br>

    <button type="submit">Create user</button>
</form:form>
</body>
</html>
