<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dict form</title>
</head>
<body>
<form method="post" action="/form">
    <label>English: </label>
    <input type="text" name="english" placeholder="input english..." value="${english}"><br>
    <br>
    <label>Vietnamese: </label>
    <input type="text" name="vietnamese" value="${vietnamese}" readonly><br>
    <br>
    <input type="submit" value="Translate">
    <p style="color: red">${msg}</p>
</form>
</body>
</html>
